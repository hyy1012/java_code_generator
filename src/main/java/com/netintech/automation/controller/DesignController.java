package com.netintech.automation.controller;

import com.netintech.automation.bean.DataBaseBean;
import com.netintech.automation.bean.DbBean;
import com.netintech.automation.bean.RequestData;
import com.netintech.automation.bean.logs;
import com.netintech.automation.mapper.LogsMapper;
import com.netintech.automation.mapper.LogsRepository;
import com.netintech.automation.utils.CheckedSession;
import com.netintech.automation.utils.IpUtil;
import com.netintech.automation.utils.LoginDb;
import com.netintech.automation.utils.WordUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 数据库设计导出及页面跳转
 */
@Controller
public class DesignController {

    private final static Logger logger = LoggerFactory.getLogger(DesignController.class);

    @Value("${file.url}")
    private String url;

    @Autowired
    private LogsMapper logsMapper;
    @Autowired
    private LogsRepository logsRepository;

    @GetMapping("design/index")
    public String admin(Model model, Pageable pageable){
        return "design/index";
    }

    @GetMapping("design/exprot")
    @ResponseBody
    public RequestData index( HttpServletRequest request,DbBean model)  {
        RequestData r = new RequestData();
        String key = CheckedSession.check(request);
        if(StringUtils.isEmpty(model.getZdname())){
            r.setCode("ERROR");
            r.setMsg("请检查是否正确读取数据库信息！");
            return r;
        }
        //获取表信息
        String [] tables = model.getZdname().split(",");
        List<DataBaseBean> list = new ArrayList<DataBaseBean>();
        for(String tabkey:tables){
            String[] akey = tabkey.split("@");
            model.setTablename(akey[0]);
            DataBaseBean bean = new DataBaseBean();
            bean.setTablename(akey[0]);
            bean.setCtablename(akey[1]);
            try {
                bean.setList(LoginDb.login_DB_mysql_Table_TYPE(model));
                LoginDb.colseDb();
            } catch (Exception e) {
                LoginDb.colseDb();
                r.setCode("ERROR");
                r.setMsg("连接数据库异常："+e.getMessage());
                return r;
            }

            list.add(bean);
        }

        //填充数据
        Map<String, Object> dataMap = new HashMap<String, Object>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        dataMap.put("date", sdf.format(new Date()));
        dataMap.put("model", model);
        dataMap.put("tab", list);

        String keys =key+"("+model.getDbname()+")";

        try {
            //生成word
            WordUtil.createWord(dataMap, "sjksj.ftl", url, keys+".doc");
        } catch (Exception e) {
            r.setCode("ERROR");
            r.setMsg("生成WORD异常："+e.getMessage());
            return r;
        }
        try {
            r.setKey(keys);
            r.setCode("SUCCESS");
            r.setMsg("导出成功！");
        } catch (Exception e) {
            r.setCode("ERROR");
            r.setMsg("异常："+e.getMessage());
            return r;
        }
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
        log.setDownurl(keys+".doc");
        logsRepository.save(log);
        return r;
    }

    @GetMapping("design/download")
    public void download(String key, HttpServletResponse response) {
        try {
            WordUtil.downLoad(key+".doc",url+"/"+key+".doc",response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
