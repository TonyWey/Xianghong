package com.shxh.common;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {

    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    private static String hisDriver;
    private static String hisUrl;
    private static String hisUsername;
    private static String hisPassword;


    static {
        Properties p = new Properties();


        try{

           // InputStream in = (new FileInputStream("D:\\IDEAWorkspace\\PSIM_MIDDLE_MEDICAL\\src\\jdbc.properties"));
            InputStream in = ConnectionFactory.class.getResourceAsStream("jdbc.properties");
             p.load(in);
             driver = p.getProperty("driver");
            System.out.println(driver);
             url = p.getProperty("url");
             username = p.getProperty("username");
             password = p.getProperty("password");
             hisDriver = p.getProperty("hisDriver");
             hisUrl = p.getProperty("hisUrl");
             hisUsername = p.getProperty("hisUsername");
             hisPassword = p.getProperty("hisPassword");
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    /**
     * PSIM数据库连接
     * @return
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * his数据库的连接
     * @return
     */
    public static  Connection getHisConnection(){
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(hisUrl,hisUsername,hisPassword);
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }


    /**
     * 归还连接
     * @param conn
     */
    public static void close(Connection conn){
        if(conn != null){
           try{
               conn.close();
           }catch(Exception e){
               e.printStackTrace();
           }
        }
    }


}
