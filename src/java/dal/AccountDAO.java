/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Account;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer Helios
 */
public class AccountDAO extends DBContext{
    public Account login(String user,String pass){
        String sql = "select * from account where username = ? and [password] = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,user);
            st.setString(2,pass);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return new Account(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("amount"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("ismember"),
                        rs.getInt("isadmin"),
                        rs.getInt("islock"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    
    public Account checkAccountExit(String user){
        String query="select * from account where username = ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, user);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                return new Account(rs.getInt("id"), 
                        rs.getString("name"), 
                        rs.getDouble("amount"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("ismember"), 
                        rs.getInt("isadmin"),
                        rs.getInt("islock"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    
    public void signup(String name,String user,String pass){
        String sql = "insert into account (name,username,[password],ismember,isadmin,islock) values (?,?,?,1,0,0)";
        try{
        PreparedStatement st = connection.prepareStatement(sql);
        st.setString(1,name);
        st.setString(2,user);
        st.setString(3,pass);
        st.executeUpdate();
        }catch(SQLException e){
            System.out.println();
        }
        
    }
    
    public List<Account> getAllAccount(){
        String sql = "SELECT * FROM account";
        List<Account> list = new ArrayList<>();
        try {           
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                Account a = new Account(rs.getInt("id"), 
                        rs.getString("name"), 
                        rs.getDouble("amount"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("ismember"), 
                        rs.getInt("isadmin"),
                        rs.getInt("islock"));
                list.add(a);
            }
            
            
        } catch (SQLException e) {
            System.out.println();
        }
//        for(Account i:list){
//                System.out.println(i);
//            }
        return list;
    }
    
    public void updateLockAccount(String id,int status){
        String query ="update account set islock = ? where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, status);
            st.setString(2, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println();
        }
    }   
        
}
