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
import model.Product;
import dal.CategoryDAO;
/*
 *
 * @author Acer Helios
 */
public class ProductDAO extends DBContext{
    
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
    
    public List<Product> getAll(){
        List<Product> list = new ArrayList<>();
        String sql = "select * from products";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
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
                list.add(p);
            }
        }catch(SQLException e) {
            System.out.println(e);
        }
        return list;
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
    
    public List<Product> getProductByCid(int cid){
        List<Product> list = new ArrayList<>();
        String sql = "select * from products where 1=1 ";
        if(cid != 0){
            sql+="and cid =" + cid;
        }
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
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
                list.add(p);
            }
        }catch(SQLException e){
            
        }
        return list;
    }
    
    public List<Product> getNewProducts(){
        List<Product> list= new ArrayList<>();
        String sql = "select top 3 * from products order by releaseDate desc";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
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
                list.add(p);
            }
        }catch(SQLException e){
            
        }
        return list;
    }
    
     public List<Product> getOldProducts(){
        List<Product> list= new ArrayList<>();
        String sql = "select top 3 * from products order by releaseDate";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
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
                list.add(p);
            }
        }catch(SQLException e){
            
        }
        return list;
    }
    public List<Product> searchBykey(String key){
        List<Product> list = new ArrayList<>();
        String sql = "select * from products where name like ? or describe like ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,"%" + key + "%");
            st.setString(2,"%" + key + "%");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
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
                list.add(p);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    
    public List<Product> searchByCheck(int[] cid) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from products where 1=1 ";
        if(cid != null && cid[0] != 0) {
            sql += "and cid in (";
            for (int i =0; i < cid.length; i++){
                sql +=  cid[i] + ",";
            }
            if(sql.endsWith(",")){
                sql = sql.substring(0,sql.length() -1);
            }
            sql +=")";
        }
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
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
                list.add(p);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    
    public List<Product> searchByPrice(double from, double to){
        List<Product> list = new ArrayList<>();
        String sql = "select * from products where price between ? and ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setDouble(1, from);
            st.setDouble(2, to);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
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
                list.add(p);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    
        public void deleteProduct(String id){
        String sql ="DELETE FROM Products WHERE Id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public void updateProduct(String id,String name, int quantity, double price, String releaseDate, String describe, String image, Category category){
        String sql = "update Products set Name = ?, Quantity = ?, Price = ?, ReleaseDate =?, Describe=?,Image=?,cid=? where Id=?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setInt(2, quantity);
            st.setDouble(3, price);
            st.setString(4,releaseDate);
            st.setString(5, describe);
            st.setString(6, image);
            st.setInt(7, category.getId());
            st.setString(8, id);
            st.executeUpdate(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Category> getAllCate(){
        List<Category> list = new ArrayList<>();
        String sql = "select * from Categories";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Category cate = new Category(rs.getInt("id"),rs.getString("name"),rs.getString("describe"));
                list.add(cate);
            }
        }catch(SQLException e) {
            System.out.println(e);
        }
        return list;
    }
}
