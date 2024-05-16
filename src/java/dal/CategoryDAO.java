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
/**
 *
 * @author Acer Helios
 */
public class CategoryDAO extends DBContext {
    public List<Category> getAll(){
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
    
    public void deleteCategory(String id){
        
        String sql ="DELETE FROM Categories WHERE Id = ?";
        try {
            updateProductIdBeforDeleteCategory(id);      
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println();
        }
    }
    
    public void updateProductIdBeforDeleteCategory(String id){
        String sql ="UPDATE Products SET cid = 0 WHERE cid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println();
        }
    }
    
    public void insertCategory(int id, String name, String describe){
       String sql = "INSERT INTO Categories (Id, Name, Describe) VALUES (?, ?, ?)";
       try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.setString(2, name);
            st.setString(3, describe);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println();
        }
    }
    
    public void updateCategory(String id,String name, String describe){
        String sql = "update Categories set Name = ?, Describe = ? where Id = ?";
        try {  
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, describe);
            st.setString(3, id);
            st.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println();
        }
    }
}
