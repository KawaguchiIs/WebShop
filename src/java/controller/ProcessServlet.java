/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Cart;
import model.Item;
import model.Product;

/**
 *
 * @author Acer Helios
 */
@WebServlet(name="ProcessServlet", urlPatterns={"/process"})
public class ProcessServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProcessServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProcessServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        ProductDAO productDao = new ProductDAO();
        List<Product> listP = productDao.getAll();
        Cookie[] arr = request.getCookies();
        String txt = "";
        if(arr != null){
            for(Cookie i:arr){
                if(i.getName().equals("cart")){
                    txt += i.getValue();
                    i.setMaxAge(0);
                    response.addCookie(i);
                }
            }
        }
        Cart cart = new Cart(txt,listP);
        String num_raw = request.getParameter("num");
        String id_raw = request.getParameter("id");
        int num=0;
        String id;
        try{
            id = String.valueOf(id_raw);
            Product p = productDao.getProductById(id);
            int numStore =p.getQuantity();
            num = Integer.parseInt(num_raw);
            if(num == -1 && (cart.getQuantityById(id)<=1)){
                cart.removeItem(id);
            }else{
                if(num == 1 && (cart.getQuantityById(id) >= numStore)){
                    num =0;
                }
                double price = p.getPrice();
                Item item = new Item(p,num,price);
                cart.addItem(item);
            }
        }catch(NumberFormatException e){
            
        }
        List<Item> items = cart.getItems();
        txt = "";
        if(!items.isEmpty()){
            txt = items.get(0).getProduct().getId()+"a"+
                    items.get(0).getQuantity();
            for(int i =1; i<items.size(); i++){
                txt +="b" + items.get(i).getProduct().getId()+"a"+
                    items.get(i).getQuantity();
            }
        }
        Cookie cookie = new Cookie("cart",txt);
        cookie.setMaxAge(24*60*60);
        response.addCookie(cookie);
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("myCart.jsp").forward(request, response);
        
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
        ProductDAO productDao = new ProductDAO();
        List<Product> listP = productDao.getAll();
        Cookie[] arr = request.getCookies();
        String txt = "";
        if(arr != null){
            for(Cookie i:arr){
                if(i.getName().equals("cart")){
                    txt += i.getValue();
                    i.setMaxAge(0);
                    response.addCookie(i);
                }
            }
        }
        String id = request.getParameter("id");
        String[] idList = txt.split("b");
        String out="";
        for(int i = 0; i < idList.length; i++){
            String[] s = idList[i].split("a");
            if(!s[0].equals(id)){
                if(out.isEmpty()){
                    out = idList[i];
                }else{
                    out += "b" + idList[i];
                }
            }
        }
        if(!out.isEmpty()){
            Cookie cookie = new Cookie("cart",out);
            cookie.setMaxAge(24*60*60);
            response.addCookie(cookie);
        }
        Cart cart = new Cart(out,listP);
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("myCart.jsp").forward(request, response);
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
