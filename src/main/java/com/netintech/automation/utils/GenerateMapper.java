package com.netintech.automation.utils;

import com.netintech.automation.bean.DbBean;

import java.util.HashMap;
import java.util.Map;

/**
 * 生成接口mapper
 */
public class GenerateMapper {

    //mapper文件
    public static StringBuffer MAPPER_TEMPLATE = null;

    //mapperxml文件
    public static StringBuffer MAPPER_XML_TEMPLATE = null;


    static{
        MAPPER_TEMPLATE = new StringBuffer();
        MAPPER_TEMPLATE.append("package [package].mapper;\n\n");
        MAPPER_TEMPLATE.append("import java.util.List;\n");
        MAPPER_TEMPLATE.append("import java.util.Map;\n\n");
        MAPPER_TEMPLATE.append("import [package].bean.[tablename];\n\n");
        MAPPER_TEMPLATE.append("/**\n");
        MAPPER_TEMPLATE.append("*持久化接口\n");
        MAPPER_TEMPLATE.append("* @author AUTOMATION\n");
        MAPPER_TEMPLATE.append("*/\n");
        MAPPER_TEMPLATE.append("public interface [tablename]Mapper {\n");
        MAPPER_TEMPLATE.append("\t//查询所有分页\n");
        MAPPER_TEMPLATE.append("\tpublic List<[tablename]> get[tablename]All(Map map);\n");
        MAPPER_TEMPLATE.append("\t//查询所有数量\n");
        MAPPER_TEMPLATE.append("\tpublic int get[tablename]AllCount(Map map);\n");
        MAPPER_TEMPLATE.append("\t//新增方法\n");
        MAPPER_TEMPLATE.append("\tpublic int create[tablename]([tablename] bean);\n");
        MAPPER_TEMPLATE.append("\t//修改方法\n");
        MAPPER_TEMPLATE.append("\tpublic int update[tablename]([tablename] bean);\n");
        MAPPER_TEMPLATE.append("\t//删除方法\n");
        MAPPER_TEMPLATE.append("\tpublic int del[tablename]ById(int id);\n");
        MAPPER_TEMPLATE.append("\t//根据ID查询对象的方法\n");
        MAPPER_TEMPLATE.append("\tpublic [tablename] get[tablename]ById(int id);\n\n\n");
        MAPPER_TEMPLATE.append("}\n");

        MAPPER_XML_TEMPLATE = new StringBuffer();
        MAPPER_XML_TEMPLATE.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        MAPPER_XML_TEMPLATE.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\"\n");
        MAPPER_XML_TEMPLATE.append("\"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n");
        MAPPER_XML_TEMPLATE.append("<mapper namespace=\"[package].mapper.[tablename]Mapper\">\n\n");
        MAPPER_XML_TEMPLATE.append("\t<select id=\"get[tablename]All\" parameterType=\"Map\" resultType=\"[package].bean.[tablename]\">\n");
        MAPPER_XML_TEMPLATE.append("        select [le] from [tablename] \n");
        MAPPER_XML_TEMPLATE.append("        limit #{startPos},#{pageSize}\n");
        MAPPER_XML_TEMPLATE.append("\t</select>\n\n");
        MAPPER_XML_TEMPLATE.append("\t<select id=\"get[tablename]AllCount\" parameterType=\"Map\" resultType=\"int\">\n");
        MAPPER_XML_TEMPLATE.append("        select count(1) from [tablename] \n");
        MAPPER_XML_TEMPLATE.append("\t</select>\n\n");
        MAPPER_XML_TEMPLATE.append("\t<insert id=\"create[tablename]\" parameterType=\"[package].bean.[tablename]\">\n");
        MAPPER_XML_TEMPLATE.append("        insert into [tablename]([le]) \n");
        MAPPER_XML_TEMPLATE.append("        values([ile])\n");
        MAPPER_XML_TEMPLATE.append("\t</insert>\n\n");
        MAPPER_XML_TEMPLATE.append("\t<update id=\"update[tablename]\" parameterType=\"[package].bean.[tablename]\">\n");
        MAPPER_XML_TEMPLATE.append("        update [tablename] \n");
        MAPPER_XML_TEMPLATE.append("        set [ule]\n");
        MAPPER_XML_TEMPLATE.append("        where id = #{id}\n");
        MAPPER_XML_TEMPLATE.append("\t</update>\n\n");
        MAPPER_XML_TEMPLATE.append("\t<delete id=\"del[tablename]ById\" parameterType=\"int\">\n");
        MAPPER_XML_TEMPLATE.append("        delete from [tablename] where id=#{value}\n");
        MAPPER_XML_TEMPLATE.append("\t</delete>\n\n");
        MAPPER_XML_TEMPLATE.append("\t<select id=\"get[tablename]ById\"  parameterType=\"Integer\" resultType=\"[package].bean.[tablename]\" >\n");
        MAPPER_XML_TEMPLATE.append("        select [le] from [tablename] where id=#{value} \n");
        MAPPER_XML_TEMPLATE.append("\t</select>\n\n");
        MAPPER_XML_TEMPLATE.append("</mapper>\n");
    }

    public static String get_mapper(DbBean model){
        Map<String, String> data = new HashMap<String, String>();
        data.put("tablename", GenerateJava.captureName(model.getTablename()));
        data.put("package", model.getCompages());
        return StringTemplateUtils.render(MAPPER_TEMPLATE.toString(),data);
    }

    public static String get_mapperXml(DbBean model){
        Map<String, String> data = new HashMap<String, String>();
        data.put("tablename", GenerateJava.captureName(model.getTablename()));
        data.put("package", model.getCompages());
        String le = "",ile = "",ule = "";
        String [] obj = model.getZdname().split(",");
        for (String value:obj){
            String [] svalue = value.split("--");
            le += svalue[0].toLowerCase() +",";
            ile += "#{"+svalue[0].toLowerCase()+"},";
            if(!"id".equals(svalue[0].toLowerCase())){
                ule += svalue[0].toLowerCase() + "=#{"+svalue[0].toLowerCase()+"},";
            }
        }
        le = le.substring(0,le.length() - 1);
        ile = ile.substring(0,ile.length() - 1);
        ule = ule.substring(0,ule.length() - 1);
        data.put("le", le);
        data.put("ile", ile);
        data.put("ule", ule);
        return StringTemplateUtils.render(MAPPER_XML_TEMPLATE.toString(),data);
    }
}
