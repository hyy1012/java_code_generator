package com.netintech.automation.utils;

import com.netintech.automation.bean.DbBean;

import java.util.HashMap;
import java.util.Map;

public class GenerateController {

    //控制器类
    public static  StringBuffer CONTROLLER_TEMPLATE = null;

    static{
        CONTROLLER_TEMPLATE = new StringBuffer();
        CONTROLLER_TEMPLATE.append("package [package].controller;\n\n");
        CONTROLLER_TEMPLATE.append("import java.util.List;\n");
        CONTROLLER_TEMPLATE.append("import java.util.Map;\n");
        CONTROLLER_TEMPLATE.append("import java.util.HashMap;\n");
        CONTROLLER_TEMPLATE.append("import javax.servlet.http.HttpServletRequest;\n");
        CONTROLLER_TEMPLATE.append("import javax.servlet.http.HttpServletResponse;\n");
        CONTROLLER_TEMPLATE.append("import org.springframework.beans.factory.annotation.Autowired;\n");
        CONTROLLER_TEMPLATE.append("import org.springframework.http.HttpStatus;\n");
        CONTROLLER_TEMPLATE.append("import org.springframework.http.MediaType;\n");
        CONTROLLER_TEMPLATE.append("import org.springframework.http.ResponseEntity;\n");
        CONTROLLER_TEMPLATE.append("import org.springframework.stereotype.Controller;\n");
        CONTROLLER_TEMPLATE.append("import org.springframework.web.bind.annotation.RequestBody;\n");
        CONTROLLER_TEMPLATE.append("import org.springframework.web.bind.annotation.RequestMapping;\n");
        CONTROLLER_TEMPLATE.append("import org.springframework.web.bind.annotation.RequestMethod;\n");
        CONTROLLER_TEMPLATE.append("import org.springframework.web.bind.annotation.ResponseBody;\n");
        CONTROLLER_TEMPLATE.append("import org.springframework.web.servlet.ModelAndView;\n");
        CONTROLLER_TEMPLATE.append("import com.netmarch.bean.Pager;\n");
        CONTROLLER_TEMPLATE.append("import com.netmarch.bean.RequestBean;\n");
        CONTROLLER_TEMPLATE.append("import [package].bean.[tablename];\n");
        CONTROLLER_TEMPLATE.append("import [package].service.[tablename]Service;\n\n");
        CONTROLLER_TEMPLATE.append("/**\n");
        CONTROLLER_TEMPLATE.append("*控制器\n");
        CONTROLLER_TEMPLATE.append("* @author AUTOMATION\n");
        CONTROLLER_TEMPLATE.append("*/\n");
        CONTROLLER_TEMPLATE.append("@Controller\n");
        CONTROLLER_TEMPLATE.append("public class [tablename]Controller {\n\n");
        CONTROLLER_TEMPLATE.append("\t@Autowired\n");
        CONTROLLER_TEMPLATE.append("\tprivate [tablename]Service [xtablename]Service;\n\n");
        CONTROLLER_TEMPLATE.append("\t//列表页面方法\n");
        CONTROLLER_TEMPLATE.append("\t@RequestMapping(\"/[xtablename]/list\")\n");
        CONTROLLER_TEMPLATE.append("\tpublic ModelAndView list(HttpServletRequest request,[tablename] bean, Pager pager) {\n");
        CONTROLLER_TEMPLATE.append("\t\tModelAndView mav = new ModelAndView();\n");
        CONTROLLER_TEMPLATE.append("\t\tif(pager.getRecordCount()==0){\n");
        CONTROLLER_TEMPLATE.append("\t\t\tpager.setRecordCount([xtablename]Service.get[tablename]AllCount());\n");
        CONTROLLER_TEMPLATE.append("\t\t}\n");
        CONTROLLER_TEMPLATE.append("\t\tList<[tablename]> list = [xtablename]Service.get[tablename]All(pager);\n");
        CONTROLLER_TEMPLATE.append("\t\tmav.addObject(\"list\",list);\n");
        CONTROLLER_TEMPLATE.append("\t\tmav.addObject(\"pager\",pager);\n");
        CONTROLLER_TEMPLATE.append("\t\tmav.setViewName(\"[xtablename]/list\");\n");
        CONTROLLER_TEMPLATE.append("\t\treturn mav;\n");
        CONTROLLER_TEMPLATE.append("\t}\n\n");
        CONTROLLER_TEMPLATE.append("\t//新增跳转页面方法\n");
        CONTROLLER_TEMPLATE.append("\t@RequestMapping(\"/[xtablename]/add\")\n");
        CONTROLLER_TEMPLATE.append("\tpublic ModelAndView add(HttpServletRequest request) {\n");
        CONTROLLER_TEMPLATE.append("\t\tModelAndView mav = new ModelAndView();\n");
        CONTROLLER_TEMPLATE.append("\t\tmav.setViewName(\"[xtablename]/add\");\n");
        CONTROLLER_TEMPLATE.append("\t\treturn mav;\n");
        CONTROLLER_TEMPLATE.append("\t}\n\n");
        CONTROLLER_TEMPLATE.append("\t//编辑跳转页面方法\n");
        CONTROLLER_TEMPLATE.append("\t@RequestMapping(\"/[xtablename]/edit\")\n");
        CONTROLLER_TEMPLATE.append("\tpublic ModelAndView edit(HttpServletRequest request,String id) {\n");
        CONTROLLER_TEMPLATE.append("\t\tModelAndView mav = new ModelAndView();\n");
        CONTROLLER_TEMPLATE.append("\t\t[tablename] bean = [xtablename]Service.get[tablename]ById(Integer.parseInt(id));\n");
        CONTROLLER_TEMPLATE.append("\t\tmav.addObject(\"bean\", bean);\n");
        CONTROLLER_TEMPLATE.append("\t\tmav.setViewName(\"[xtablename]/edit\");\n");
        CONTROLLER_TEMPLATE.append("\t\treturn mav;\n");
        CONTROLLER_TEMPLATE.append("\t}\n\n");
        CONTROLLER_TEMPLATE.append("\t//查看跳转页面方法\n");
        CONTROLLER_TEMPLATE.append("\t@RequestMapping(\"/[xtablename]/view\")\n");
        CONTROLLER_TEMPLATE.append("\tpublic ModelAndView view(HttpServletRequest request,String id) {\n");
        CONTROLLER_TEMPLATE.append("\t\tModelAndView mav = new ModelAndView();\n");
        CONTROLLER_TEMPLATE.append("\t\t[tablename] bean = [xtablename]Service.get[tablename]ById(Integer.parseInt(id));\n");
        CONTROLLER_TEMPLATE.append("\t\tmav.addObject(\"bean\", bean);\n");
        CONTROLLER_TEMPLATE.append("\t\tmav.setViewName(\"[xtablename]/view\");\n");
        CONTROLLER_TEMPLATE.append("\t\treturn mav;\n");
        CONTROLLER_TEMPLATE.append("\t}\n\n");
        CONTROLLER_TEMPLATE.append("\t//保存操作\n");
        CONTROLLER_TEMPLATE.append("\t@RequestMapping(value = \"/[xtablename]/save\",method = RequestMethod.POST)\n");
        CONTROLLER_TEMPLATE.append("\tpublic ResponseEntity<String> save([tablename] bean,HttpServletRequest request, HttpServletResponse response) {\n");
        CONTROLLER_TEMPLATE.append("\t\ttry{\n");
        CONTROLLER_TEMPLATE.append("\t\t\tint success = [xtablename]Service.create[tablename](bean);\n");
        CONTROLLER_TEMPLATE.append("\t\t\t\tif(success > 0){\n");
        CONTROLLER_TEMPLATE.append("\t\t\t\t\treturn new ResponseEntity<String>(\"SUCCESS\", RequestBean.reHe(), HttpStatus.OK);\n");
        CONTROLLER_TEMPLATE.append("\t\t\t\t}else{\n");
        CONTROLLER_TEMPLATE.append("\t\t\t\t\treturn new ResponseEntity<String>(\"ERROR\", RequestBean.reHe(), HttpStatus.OK);\n");
        CONTROLLER_TEMPLATE.append("\t\t\t\t}\n");
        CONTROLLER_TEMPLATE.append("\t\t}catch (Exception e){\n");
        CONTROLLER_TEMPLATE.append("\t\t\te.printStackTrace();\n");
        CONTROLLER_TEMPLATE.append("\t\t\treturn new ResponseEntity<String>(\"ERROR\", RequestBean.reHe(), HttpStatus.OK);\n");
        CONTROLLER_TEMPLATE.append("\t\t}\n");
        CONTROLLER_TEMPLATE.append("\t}\n\n");
        CONTROLLER_TEMPLATE.append("\t//更新操作\n");
        CONTROLLER_TEMPLATE.append("\t@RequestMapping(value = \"/[xtablename]/update\",method = RequestMethod.POST)\n");
        CONTROLLER_TEMPLATE.append("\tpublic ResponseEntity<String> update([tablename] bean,HttpServletRequest request, HttpServletResponse response) {\n");
        CONTROLLER_TEMPLATE.append("\t\ttry{\n");
        CONTROLLER_TEMPLATE.append("\t\t\tint success = [xtablename]Service.update[tablename](bean);\n");
        CONTROLLER_TEMPLATE.append("\t\t\t\tif(success > 0){\n");
        CONTROLLER_TEMPLATE.append("\t\t\t\t\treturn new ResponseEntity<String>(\"SUCCESS\", RequestBean.reHe(), HttpStatus.OK);\n");
        CONTROLLER_TEMPLATE.append("\t\t\t\t}else{\n");
        CONTROLLER_TEMPLATE.append("\t\t\t\t\treturn new ResponseEntity<String>(\"ERROR\", RequestBean.reHe(), HttpStatus.OK);\n");
        CONTROLLER_TEMPLATE.append("\t\t\t\t}\n");
        CONTROLLER_TEMPLATE.append("\t\t}catch (Exception e){\n");
        CONTROLLER_TEMPLATE.append("\t\t\te.printStackTrace();\n");
        CONTROLLER_TEMPLATE.append("\t\t\treturn new ResponseEntity<String>(\"ERROR\", RequestBean.reHe(), HttpStatus.OK);\n");
        CONTROLLER_TEMPLATE.append("\t\t}\n");
        CONTROLLER_TEMPLATE.append("\t}\n\n");
        CONTROLLER_TEMPLATE.append("\t//删除操作\n");
        CONTROLLER_TEMPLATE.append("\t@RequestMapping(value = \"/[xtablename]/del\",method = RequestMethod.POST)\n");
        CONTROLLER_TEMPLATE.append("\tpublic ResponseEntity<String> del(String id,HttpServletRequest request, HttpServletResponse response) {\n");
        CONTROLLER_TEMPLATE.append("\t\ttry{\n");
        CONTROLLER_TEMPLATE.append("\t\t\tint success = [xtablename]Service.del[tablename]ById(Integer.parseInt(id));\n");
        CONTROLLER_TEMPLATE.append("\t\t\t\tif(success > 0){\n");
        CONTROLLER_TEMPLATE.append("\t\t\t\t\treturn new ResponseEntity<String>(\"SUCCESS\", RequestBean.reHe(), HttpStatus.OK);\n");
        CONTROLLER_TEMPLATE.append("\t\t\t\t}else{\n");
        CONTROLLER_TEMPLATE.append("\t\t\t\t\treturn new ResponseEntity<String>(\"ERROR\", RequestBean.reHe(), HttpStatus.OK);\n");
        CONTROLLER_TEMPLATE.append("\t\t\t\t}\n");
        CONTROLLER_TEMPLATE.append("\t\t}catch (Exception e){\n");
        CONTROLLER_TEMPLATE.append("\t\t\te.printStackTrace();\n");
        CONTROLLER_TEMPLATE.append("\t\t\treturn new ResponseEntity<String>(\"ERROR\", RequestBean.reHe(), HttpStatus.OK);\n");
        CONTROLLER_TEMPLATE.append("\t\t}\n");
        CONTROLLER_TEMPLATE.append("\t}\n\n");
        CONTROLLER_TEMPLATE.append("}");
    }

    public static String get_controller(DbBean model){
        Map<String, String> data = new HashMap<String, String>();
        data.put("tablename", GenerateJava.captureName(model.getTablename()));
        data.put("xtablename", model.getTablename().toLowerCase());
        data.put("package", model.getCompages());
        return StringTemplateUtils.render(CONTROLLER_TEMPLATE.toString(),data);
    }
}
