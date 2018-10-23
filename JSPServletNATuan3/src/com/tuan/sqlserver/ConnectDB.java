/**
 * 
 */
package com.tuan.sqlserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * @author User
 * @creatdate Oct 12, 2018
 * @modifieddate Oct 12, 2018
 * @content ...
 */
public class ConnectDB {
        private final String DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        private final String DRIVER_URL = "jdbc:sqlserver://localhost:1433;databaseName=FinalExamNATuan";
        private final String userName = "sa";
        private final String passWord = "1";
        

        public Connection getConnection() {
                Connection conn = null;
                try {
                        Class.forName(DRIVER_CLASS);
                        conn = DriverManager.getConnection(DRIVER_URL, userName, passWord);
                        System.out.println("tim duoc driver class");
                } catch (ClassNotFoundException e) {
                        //log.error("Khong tim thay driver class");
                        System.out.println("khong tim duoc driver class");
                } catch (SQLException e) {
                        System.out.println("khong the ket noi toi database");
                        //log.error("Khong the ket noi toi database");
                }
                return conn;
        }

}
