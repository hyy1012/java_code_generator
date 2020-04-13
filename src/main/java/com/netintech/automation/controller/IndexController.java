package com.netintech.automation.controller;


import com.netintech.automation.AutomationApplication;
import com.netintech.automation.bean.Db;
import com.netintech.automation.bean.DbBean;
import com.netintech.automation.bean.RequestData;
import com.netintech.automation.bean.logs;
import com.netintech.automation.mapper.LogsMapper;
import com.netintech.automation.mapper.LogsRepository;
import com.netintech.automation.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Controller
public class IndexController {

    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Value("${file.url}")
    private String url;

    @Autowired
    private LogsMapper logsMapper;
    @Autowired
    private LogsRepository logsRepository;

    @GetMapping("index")
    public String index(HttpServletRequest request, Model model, @PageableDefault Pageable pageable){
        model.addAttribute("logs",logsRepository.findAll(pageable));
        model.addAttribute("pag",pageable.getPageNumber());
        model.addAttribute("pags",pageable.getPageSize());
        return "logs/index";
    }

    @GetMapping("admin/index")
    public String admin( Model model,Pageable pageable){
        return "administrator/index";
    }

    @GetMapping("admin/loginDB")
    @ResponseBody
    public RequestData loginDB(Db bean) {
        RequestData r = new RequestData();
        try {
            r.setCode("SUCCESS");
            r.setListData(LoginDb.login_DB_Mysql_TABLE(bean));
            r.setMsg("读取表成功！");
        } catch (Exception e) {
            r.setCode("ERROR");
            r.setMsg("数据库链接异常："+e.getMessage());
            LoginDb.colseDb();
            return r;
        }
        return r;
    }


    @GetMapping("admin/loginDBBytable")
    @ResponseBody
    public RequestData loginDBBytable(Db bean) {
        RequestData r = new RequestData();
        try {
            r.setCode("SUCCESS");
            r.setListData(LoginDb.login_DB_mysql_Table_TYPE(bean));
            r.setMsg("表属性查询读取成功！");
        } catch (Exception e) {
            r.setCode("ERROR");
            r.setMsg("数据库链接异常："+e.getMessage());
            LoginDb.colseDb();
            return r;
        }
        return r;
    }

    @GetMapping("admin/downloadZip")
    public void loginDBBytable(String key, HttpServletResponse response) {
        try {
            ZipUtils.downLoadZip(key+".zip",url+"/zip"+key+"/"+key+".zip",response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @GetMapping("admin/exprot")
    @ResponseBody
    public RequestData index( HttpServletRequest request,DbBean model)  {
        RequestData r = new RequestData();
        r.setCode("SUCCESS");
        String key = CheckedSession.check(request);
        Map<String,String> map = new HashMap<>();
        try {
            map = GenerateFile.initDir(url,key,model.getMk(),GenerateJava.captureName(model.getTablename()));
        } catch (IOException e) {
            r.setCode("ERROR");
            r.setMsg("文件生成错误："+e.getMessage());
            return r;
        }

        try {
            //写bean文件内容
            GenerateFile.writeTxtFile(GenerateJava.GenerateJavaCode(model),new File(map.get("bean")));
            //写mapper接口文件
            GenerateFile.writeTxtFile(GenerateMapper.get_mapper(model),new File(map.get("mapper")));
            //写mapperxml文件
            GenerateFile.writeTxtFile(GenerateMapper.get_mapperXml(model),new File(map.get("mapperxml")));
            //写service实现文件
            GenerateFile.writeTxtFile(GenerateService.get_Service(model),new File(map.get("service")));
            //写controller文件
            GenerateFile.writeTxtFile(GenerateController.get_controller(model),new File(map.get("controller")));
        } catch (Exception e) {
            r.setCode("ERROR");
            r.setMsg("文件写入错误："+e.getMessage());
            return r;
        }
        //压缩文件
        try {
            DelFile.delAllFile(url+"/zip"+key);
            ZipUtils.toZip(url+"/"+key, new FileOutputStream(new File(url+"/zip"+key+"/"+key+".zip")),true);
        } catch (Exception e) {
            r.setCode("ERROR");
            r.setMsg("文件打包zip错误："+e.getMessage());
            return r;
        }
        //删除文件夹
        DelFile.delFolder(url+"/"+key);
        //写入日志
        logs log = new logs();
        log.setIp(IpUtil.getIpAddr(request));
        log.setDb(model.getDbtype());
        log.setPageurl(model.getCompages());
        log.setDbip(model.getDbip());
        log.setDbname(model.getDbname());
        log.setDbpassword(model.getDbpassword());
        log.setDbusername(model.getDbusername());
        log.setTablename(model.getTablename());
        log.setDownurl(key+".zip");
        logsRepository.save(log);
        r.setMsg("文件生成成功！请在提交按钮下进行下载！");
        r.setKey(key);

        return r;
    }




}
