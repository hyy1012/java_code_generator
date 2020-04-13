package com.netintech.automation.utils;

import com.netintech.automation.bean.DataBaseBean;
import com.netintech.automation.bean.DataBaseTableBean;
import com.netintech.automation.bean.Db;
import com.netintech.automation.bean.DbStatic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static sun.net.ftp.FtpDirEntry.Permission.USER;

/**
 * 登录数据库
 */
public class LoginDb {

    private final static Logger logger = LoggerFactory.getLogger(LoginDb.class);

    public static Connection conn = null;
    public static Statement stmt = null;
    public static ResultSet rs = null;

    static {

    }

    public static List<DataBaseTableBean> login_DB_mysql_Table_TYPE(Db bean) throws Exception{
        List<DataBaseTableBean> list = new ArrayList<>();
        String sql = "select TABLE_NAME,COLUMN_NAME,IS_NULLABLE,DATA_TYPE,COLUMN_TYPE,COLUMN_COMMENT,COLUMN_KEY from information_schema.columns where table_name='"+bean.getTablename()+"'  and TABLE_SCHEMA = '"+bean.getDbname()+"' order by ORDINAL_POSITION ";
        rs = loginDb_init(bean,sql);
        // 展开结果集数据库
        while(rs.next()){
            DataBaseTableBean obj = new DataBaseTableBean();
            // 通过字段检索
            String TABLE_NAME  = rs.getString("TABLE_NAME");
            String COLUMN_NAME  = rs.getString("COLUMN_NAME");
            String IS_NULLABLE  = rs.getString("IS_NULLABLE");
            String COLUMN_TYPE  = rs.getString("COLUMN_TYPE");
            String COLUMN_COMMENT  = rs.getString("COLUMN_COMMENT");
            String DATA_TYPE  = rs.getString("DATA_TYPE");
            String COLUMN_KEY  = rs.getString("COLUMN_KEY");
            obj.setKey(COLUMN_KEY);
            obj.setName(FliterUtils.filter(COLUMN_NAME));
            obj.setType(DATA_TYPE);
            obj.setQtype(COLUMN_TYPE);
            obj.setBz(FliterUtils.filter(COLUMN_COMMENT));
            obj.setIsnull(IS_NULLABLE);
            list.add(obj);
        }
        return list;
    }

    /**
     * 链接数据库获取所有表名
     * @param bean 数据库链接类
     * @return 返回数据库表名集合
     */
    public static List<DataBaseBean> login_DB_Mysql_TABLE(Db bean) throws Exception{
        List<DataBaseBean> list = new ArrayList<>();
        String SQL = "select table_name,TABLE_COMMENT  from information_schema.tables where table_schema='"+bean.getDbname()+"' and table_type='base table';";
        rs = loginDb_init(bean,SQL);
        // 展开结果集数据库
        while(rs.next()){
            DataBaseBean obj = new DataBaseBean();
            // 通过字段检索
            String table_name  = rs.getString("table_name");
            String TABLE_COMMENT  = rs.getString("TABLE_COMMENT");
            obj.setCtablename(StringUtils.isEmpty(TABLE_COMMENT) ? "无" : TABLE_COMMENT);
            obj.setTablename(table_name);
            list.add(obj);
        }
        return list;
    }

    public static ResultSet loginDb_init(Db bean,String SQL) throws Exception{

            // 注册 JDBC 驱动
            Class.forName(DbStatic.DB_DRIVE.get(bean.getDbtype()).toString());
            String url= "jdbc:mysql://" + bean.getDbip() + ":" + bean.getDbport() +"/" + bean.getDbname();
            // 打开链接
            logger.info("连接数据库...");
            conn = DriverManager.getConnection(url,bean.getDbusername(),bean.getDbpassword());

            // 执行查询
            logger.info(" 实例化Statement对象...");
            stmt = conn.createStatement();

            return stmt.executeQuery(SQL);




    }

    public static void colseDb(){
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn !=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
