/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.CategoryDAO;
import dal.ProductDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Cart;
import model.Category;
import model.Item;
import model.Product;

/**
 *
 * @author Acer Helios
 */
@WebServlet(name="HomeServlet", urlPatterns={"/home"})
public class HomeServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        CategoryDAO cateDao = new CategoryDAO();
        ProductDAO productDao = new ProductDAO();
        List<Category> list = cateDao.getAll();
        List<Product> listP = productDao.getAll();
        Cookie[] arr = request.getCookies();
        String txt = "";
        if(arr != null){
            for(Cookie i:arr){
                if(i.getName().equals("cart")){
                    txt+=i.getValue();
                }
            }
        }
        Cart cart = new Cart(txt,listP);
        List<Item> listItem = cart.getItems();
        int n;
        if(listItem != null){
            n = listItem.size();
        }else
            n = 0;
        
        
       
        String[] priceList = {"Dưới 50.000", 
            "50.000 đến 100.000",
            "100.000 đến 150.000",
            "150.000 đến 200.000",
            "Trên 200.000"
        };
        boolean[] price = new boolean[priceList.length +1];
        price[0] = true;
        List<Product> news = productDao.getNewProducts();
        List<Product> olds = productDao.getOldProducts();
        boolean[] chid = new boolean[list.size()+1];
        chid[0] =true;
        request.setAttribute("size", n);
        request.setAttribute("data",list);
        request.setAttribute("news",news);
        request.setAttribute("olds",olds);
        request.setAttribute("price",price);
        request.setAttribute("priceList",priceList);
        request.setAttribute("cid",0);
        request.setAttribute("chid",chid);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
