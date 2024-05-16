/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.time.LocalDate;
import model.Cart;
import model.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Item;
import model.Order;

/**
 *
 * @author Acer Helios
 */
public class OrderDAO extends DBContext {
    public void addOrder (Account customer, Cart cart){
        LocalDate currentDate = LocalDate.now();
        String date = currentDate.toString();
        try{
            //add order
            String sql = "insert into Orders values(?,?,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, date);
            st.setInt(2, customer.getId());
            st.setDouble(3, cart.getTotalMoney());
            st.executeUpdate();
            //get id orders
            String sql1 = "select top 1 id from Orders order by id desc";
            PreparedStatement st1 = connection.prepareStatement(sql1);
            ResultSet rs = st1.executeQuery();
            //add OrderDetail
            if(rs.next()){
                int orderId = rs.getInt("id");
                for(Item i:cart.getItems()){
                    String sql2 = "insert into OrdersDetail values(?,?,?,?)";
                    PreparedStatement st2 = connection.prepareStatement(sql2);
                    st2.setInt(1, orderId);
                    st2.setString(2, i.getProduct().getId());
                    st2.setInt(3, i.getQuantity());
                    st2.setDouble(4, i.getPrice());
                    st2.executeUpdate();
                }
            }
            // update quantity product
            String sql3 = "update Products set quantity =  quantity - ? where id = ?";
            PreparedStatement st3 = connection.prepareStatement(sql3);
            for(Item i:cart.getItems()){
                st3.setInt(1, i.getQuantity());
                st3.setString(2,i.getProduct().getId());
                st3.executeUpdate();
            }
            //update amount customer
            String sql4 = "update Customer set amount = amount - ? where id =?";
            PreparedStatement st4 = connection.prepareStatement(sql4);
            int total = 0;
            for(Item i:cart.getItems()){
                total += (i.getPrice())*(i.getQuantity());
            }
            st4.setDouble(1,total);
            st4.setInt(2, customer.getId());
            st4.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public List<Order> getAll(Account customer){
        List<Order> list = new ArrayList<>();
        String sql = "select * from Orders where customer_id =?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1,customer.getId());
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setDate(rs.getString("date"));
                order.setCustomer_id(rs.getInt("customer_id"));
                order.setTotal_money(rs.getDouble("total_money"));
                list.add(order);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    
    public List<Order> searchOrder(Account customer,Date from,Date to){
        List<Order> list = new ArrayList<>();
        String sql = "select * from Orders where customer_id = ?";
        if(from != null){
            sql += "and date >='" + from + "'";
        }
        if(to != null){
            sql += "and date <='" + to + "'";
        }
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1,customer.getId());
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setDate(rs.getString("date"));
                order.setCustomer_id(rs.getInt("customer_id"));
                order.setTotal_money(rs.getDouble("total_money"));
                list.add(order);
            }
        }catch(SQLException e){
            
        }
        return list;
    }
}
