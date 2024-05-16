/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Acer Helios
 */
public class DBContext {
        protected Connection connection;
        public DBContext(){
            try {
                String url = "jdbc:sqlserver://localhost:1433;databaseName=bookShop;encrypt=true;trustServerCertificate=true"; // tên database là Trading
                String username = "sa"; // tên user để đăng nhập vào DB
                String password = "123456"; // password để đăng nhập vào DB
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                connection = DriverManager.getConnection(url,username,password);
            } catch (ClassNotFoundException | SQLException ex){
                System.out.println(ex);
            }
        }
}

