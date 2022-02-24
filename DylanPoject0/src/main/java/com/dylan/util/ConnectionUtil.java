package com.dylan.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

    private static Connection conn;


    public static Connection getConnection() {
        try {
            FileInputStream propertiesInput = new FileInputStream("C:\\Users\\djmcf\\sql.properties");

            Properties props = new Properties();
            props.load(propertiesInput);

            String url = (String) props.get("url");
            String username = (String) props.get("username");
            String password = (String) props.get("password");

            if (conn == null) {
                try {
                    conn = DriverManager.getConnection(url, username, password);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return conn;
    }

}




//    String url ="jdbc:sqlserver://dylanrev.database.windows.net:1433;database=dylanrev;user=dylanrev@dylanrev;password=6lackJobs#98;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
//    String username ="dylanrev";
//    String password ="6lackJobs#98";


