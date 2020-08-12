package edu.cuit.loop.titlejudge.generate;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;

public class SQLGenerator {

    public static void execSqlFileByMysql(String ip, String port, String userName, String pwd, String sqlFilePath) throws Exception {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://"+ip+":"+port;

        Exception error = null;
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, userName, pwd);
            ScriptRunner runner = new ScriptRunner(conn);
            //下面配置不要随意更改，否则会出现各种问题
            runner.setAutoCommit(true);//自动提交
            runner.setFullLineDelimiter(false);
            runner.setDelimiter(";");////每条命令间的分隔符
            runner.setSendFullScript(false);
            runner.setStopOnError(false);
            //	runner.setLogWriter(null);//设置是否输出日志
            //如果又多个sql文件，可以写多个runner.runScript(xxx),
            runner.runScript(Resources.getResourceAsReader(sqlFilePath));
            close(conn);
        } catch (Exception e) {
            //LOG.error("执行sql文件进行数据库创建失败....",e);
            System.out.println("执行sql文件进行数据库创建失败....");
            error = e;
        }finally{
            close(conn);
        }
        if(error != null){
            throw error;
        }
    }


    public static void execSqlFileBySqlserver(String ip, String port, String userName,
                                              String pwd, String sqlFilePath, String dbName) throws Exception {
        String driver = "net.sourceforge.jtds.jdbc.Driver";
        String url = "jdbc:jtds:sqlserver://"+ip+":"+port;

        Exception error = null;
        Connection conn = null;
        try {
            //replaceAndCreate(f1,f2,oldDbName,newDbName);

            Class.forName(driver);
            conn = DriverManager.getConnection(url, userName, pwd);
            ScriptRunner runner = new ScriptRunner(conn);
            //下面的配置，不要随意更改，否则导致各种问题
            runner.setAutoCommit(true);//自动提交
            runner.setFullLineDelimiter(true);
            runner.setDelimiter("GO");//每条命令间的分隔符
            runner.setSendFullScript(false);
            runner.setStopOnError(false);
            //		runner.setLogWriter(null);//设置是否输出日志
            //如果又多个sql文件，可以写多个runner.runScript(xxx),
            runner.runScript(new InputStreamReader(new FileInputStream(sqlFilePath),"utf8"));

        } catch (Exception e) {
            //LOG.error("执行sql文件进行数据库创建失败....",e);
            System.out.println("执行sql文件进行数据库创建失败....");
            error = e;
        }finally{
            close(conn);
            //删除文件
            //deleteFile(f2);
        }

        if(error != null){
            throw error;
        }
    }

    private static void close(Connection conn){
        try {
            if(conn != null){
                conn.close();
            }
        } catch (Exception e) {
            if(conn != null){
                conn = null;
            }
        }
    }

    public static void main(String[] args) {
        try {
            execSqlFileByMysql("123.56.66.43",
                    "3306",
                    "root",
                    "990223wu",
                    "table/titlejudge.sql");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
