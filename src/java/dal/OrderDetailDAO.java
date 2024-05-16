/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.OrderDetail;
import model.Product;

/**
 *
 * @author Acer Helios
 */
public class OrderDetailDAO extends DBContext {
    public Category getCategoryById(int id){
        String sql = "select * from Categories where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                Category cate = new Category(rs.getInt("id"),rs.getString("name"),rs.getString("describe"));
                return cate;
            }
        }catch(SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public Product getProductById(String id){
        String sql = "select * from Products where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                Product p = new Product();
                p.setId(rs.getString("id"));
                p.setName(rs.getString("name"));
                p.setQuantity(rs.getInt("quantity"));
                p.setPrice(rs.getDouble("price"));
                p.setReleaseDate(rs.getDate("releaseDate"));
                p.setDescribe(rs.getString("describe"));
                p.setImage(rs.getString("image"));
                Category cate = getCategoryById(rs.getInt("cid"));
                p.setCategory(cate);
                return p;
            }
        }catch(SQLException e) {
            System.out.println(e);
        }
        return null;
    }
        public List<OrderDetail> getAll(int id){
        List<OrderDetail> list = new ArrayList<>();
        String sql = "select * from OrdersDetail where order_id =?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrder_id(rs.getInt("order_id"));  
                Product product = getProductById(rs.getString("product_id"));
                orderDetail.setProduct(product);
//              orderDetail.setProduct_id(rs.getInt("product_id"));
                orderDetail.setQuantity(rs.getInt("quantity"));
                orderDetail.setPrice(rs.getDouble("price"));
                list.add(orderDetail);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
}
