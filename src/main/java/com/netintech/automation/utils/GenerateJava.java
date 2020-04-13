package com.netintech.automation.utils;

import com.netintech.automation.bean.DbBean;
import com.netintech.automation.bean.DbStatic;

import java.util.HashMap;
import java.util.Map;

/**
 * 生成java实体类
 */
public class GenerateJava {

    //实体类头部
    public static StringBuffer BEAN_TOP_TEMPLATE = null;
    //实体类属性
    public static StringBuffer BEAN_ATTRIBUTE_TEMPLATE = null;
    //实体类GET方法
    public static StringBuffer BEAN_GET_TEMPLATE = null;
    //实体类SET方法
    public static StringBuffer BEAN_SET_TEMPLATE = null;

    static{
        BEAN_TOP_TEMPLATE = new StringBuffer();
        BEAN_ATTRIBUTE_TEMPLATE = new StringBuffer();
        BEAN_GET_TEMPLATE = new StringBuffer();
        BEAN_SET_TEMPLATE = new StringBuffer();
    }
    /**
     * 生成java代码方法
     * @param model
     * @return
     */
    public static String GenerateJavaCode(DbBean model){
        StringBuffer str = new StringBuffer();
        str.append(get_filetop(model));
        str.append(get_fileattribute(model));
        str.append(get_fileGetMethon(model));
        str.append(get_fileSetMethon(model));
        return str.toString()+"\n}";
    }

    public static String get_fileSetMethon(DbBean model){
        BEAN_SET_TEMPLATE.setLength(0);
        String [] obj = model.getZdname().split(",");
        for (String value:obj){
            String [] svalue = value.split("--");
            String key = DbStatic.DB_BEAN_ODBC.get(svalue[1].toUpperCase()).toString();
            key = key.substring(key.indexOf(".",key.indexOf(".")+1)+1,key.length());
            String moth = svalue[0].toLowerCase();
            BEAN_SET_TEMPLATE.append("\tpublic void set" +captureName(moth)+"("+key+" "+moth+"){\n");
            BEAN_SET_TEMPLATE.append("\t\tthis."+moth +" = "+moth+";\n");
            BEAN_SET_TEMPLATE.append("\t}\n\n");
        }
        return BEAN_SET_TEMPLATE.toString();
    }

    public static String get_fileGetMethon(DbBean model){
        BEAN_GET_TEMPLATE.setLength(0);
        String [] obj = model.getZdname().split(",");
        for (String value:obj){
            String [] svalue = value.split("--");
            String key = DbStatic.DB_BEAN_ODBC.get(svalue[1].toUpperCase()).toString();
            key = key.substring(key.indexOf(".",key.indexOf(".")+1)+1,key.length());
            String moth = svalue[0].toLowerCase();
            BEAN_GET_TEMPLATE.append("\tpublic " +key+ " get" +captureName(moth) +"(){\n");
            BEAN_GET_TEMPLATE.append("\t\treturn "+moth +";\n");
            BEAN_GET_TEMPLATE.append("\t}\n\n");
        }
        return BEAN_GET_TEMPLATE.toString();
    }


    public static String get_fileattribute(DbBean model){
        BEAN_ATTRIBUTE_TEMPLATE.setLength(0);
        String [] obj = model.getZdname().split(",");
        for (String value:obj){
            String [] svalue = value.split("--");
            String key = DbStatic.DB_BEAN_ODBC.get(svalue[1].toUpperCase()).toString();
            key = key.substring(key.indexOf(".",key.indexOf(".")+1)+1,key.length());
            BEAN_ATTRIBUTE_TEMPLATE.append("\tprivate " +key+ " "+svalue[0].toLowerCase()+";\n");
        }
        return BEAN_ATTRIBUTE_TEMPLATE.toString();
    }

    public static String get_filetop(DbBean model){
        BEAN_TOP_TEMPLATE.setLength(0);
        BEAN_TOP_TEMPLATE.append("package "+model.getCompages()+".bean;\n\n");
        String [] obj = model.getZdname().split(",");
        Map<String,String> map = new HashMap<String,String>();
        for (String value:obj){
            String [] svalue = value.split("--");
            map.put(svalue[1].toUpperCase(),svalue[0]);
        }

        for (String key:map.keySet()){
            BEAN_TOP_TEMPLATE.append("import "+ DbStatic.DB_BEAN_ODBC.get(key)+";\n");
        }
        BEAN_TOP_TEMPLATE.append("/**\n");
        BEAN_TOP_TEMPLATE.append("*自动生成实体类\n");
        BEAN_TOP_TEMPLATE.append("* @author AUTOMATION\n");
        BEAN_TOP_TEMPLATE.append("*/\n");
        BEAN_TOP_TEMPLATE.append("public class "+captureName(model.getTablename())+" {\n\n");
        return BEAN_TOP_TEMPLATE.toString();
    }

    /**
     * 首字母大写
     * @param name
     * @return
     */
    public static String captureName(String name) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        return  name;

    }

}
