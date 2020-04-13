package com.netintech.automation.utils;

import com.netintech.automation.bean.DbBean;

import java.util.HashMap;
import java.util.Map;

public class GenerateService {
    //service层模板
    public static  StringBuffer SERVICE_TEMPLATE = null;

    static{
        SERVICE_TEMPLATE = new StringBuffer();
        SERVICE_TEMPLATE.append("package [package].service;\n\n");
        SERVICE_TEMPLATE.append("import java.util.List;\n");
        SERVICE_TEMPLATE.append("import java.util.Map;\n");
        SERVICE_TEMPLATE.append("import java.util.HashMap;\n");
        SERVICE_TEMPLATE.append("import org.springframework.beans.factory.annotation.Autowired;\n");
        SERVICE_TEMPLATE.append("import org.springframework.stereotype.Service;\n\n");
        SERVICE_TEMPLATE.append("import com.netmarch.bean.Pager;\n");
        SERVICE_TEMPLATE.append("import [package].bean.[tablename];\n");
        SERVICE_TEMPLATE.append("import [package].mapper.[tablename]Mapper;\n\n");
        SERVICE_TEMPLATE.append("/**\n");
        SERVICE_TEMPLATE.append("*业务层接口实现类\n");
        SERVICE_TEMPLATE.append("* @author AUTOMATION\n");
        SERVICE_TEMPLATE.append("*/\n");
        SERVICE_TEMPLATE.append("@Service\n");
        SERVICE_TEMPLATE.append("public class [tablename]Service {\n\n");
        SERVICE_TEMPLATE.append("\t@Autowired\n");
        SERVICE_TEMPLATE.append("\tprivate [tablename]Mapper [xtablename]Mapper;\n\n");
        SERVICE_TEMPLATE.append("\t//查询所有分页\n");
        SERVICE_TEMPLATE.append("\tpublic List<[tablename]> get[tablename]All(Pager pager){\n");
        SERVICE_TEMPLATE.append("\t\tMap map = new HashMap();\n");
        SERVICE_TEMPLATE.append("\t\tmap.put(\"startPos\", pager.getStartPos());\n");
        SERVICE_TEMPLATE.append("\t\tmap.put(\"endPos\", pager.getEndPos());\n");
        SERVICE_TEMPLATE.append("\t\tmap.put(\"pageSize\", pager.getPageSize());\n");
        SERVICE_TEMPLATE.append("\t\treturn [xtablename]Mapper.get[tablename]All(map);\n");
        SERVICE_TEMPLATE.append("\t}\n\n");
        SERVICE_TEMPLATE.append("\t//查询所有数量\n");
        SERVICE_TEMPLATE.append("\tpublic int get[tablename]AllCount(){\n");
        SERVICE_TEMPLATE.append("\t\tMap map = new HashMap();\n");
        SERVICE_TEMPLATE.append("\t\treturn [xtablename]Mapper.get[tablename]AllCount(map);\n");
        SERVICE_TEMPLATE.append("\t}\n\n");
        SERVICE_TEMPLATE.append("\t//新增方法\n");
        SERVICE_TEMPLATE.append("\tpublic int create[tablename]([tablename] bean){\n");
        SERVICE_TEMPLATE.append("\t\treturn [xtablename]Mapper.create[tablename](bean);\n");
        SERVICE_TEMPLATE.append("\t}\n\n");
        SERVICE_TEMPLATE.append("\t//修改方法\n");
        SERVICE_TEMPLATE.append("\tpublic int update[tablename]([tablename] bean){\n");
        SERVICE_TEMPLATE.append("\t\treturn [xtablename]Mapper.update[tablename](bean);\n");
        SERVICE_TEMPLATE.append("\t}\n\n");
        SERVICE_TEMPLATE.append("\t//删除方法\n");
        SERVICE_TEMPLATE.append("\tpublic int del[tablename]ById(int id){\n");
        SERVICE_TEMPLATE.append("\t\treturn [xtablename]Mapper.del[tablename]ById(id);\n");
        SERVICE_TEMPLATE.append("\t}\n\n");
        SERVICE_TEMPLATE.append("\t//根据ID查询对象的方法\n");
        SERVICE_TEMPLATE.append("\tpublic [tablename] get[tablename]ById(int id){\n");
        SERVICE_TEMPLATE.append("\t\treturn [xtablename]Mapper.get[tablename]ById(id);\n");
        SERVICE_TEMPLATE.append("\t}\n\n");
        SERVICE_TEMPLATE.append("}\n");

        }

        public static String get_Service(DbBean model){
            Map<String, String> data = new HashMap<String, String>();
            data.put("tablename", GenerateJava.captureName(model.getTablename()));
            data.put("xtablename", model.getTablename().toLowerCase());
            data.put("package", model.getCompages());
            return StringTemplateUtils.render(SERVICE_TEMPLATE.toString(),data);
        }

}
