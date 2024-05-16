/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.CategoryDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ArrayList;
import model.Category;
import model.Product;

/**
 *
 * @author Acer Helios
 */
@WebServlet(name="HomeFilterServlet", urlPatterns={"/homeFilter"})
public class HomeFilterServlet extends HttpServlet {
   
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
            out.println("<title>Servlet HomeFilterServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomeFilterServlet at " + request.getContextPath () + "</h1>");
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
        String[] priceList = {"Dưới 50.000", 
            "50.000 đến 100.000",
            "100.000 đến 150.000",
            "150.000 đến 200.000",
            "Trên 200.000"
        };
        boolean[] price = new boolean[priceList.length +1];
        CategoryDAO cateDao = new CategoryDAO();
        ProductDAO productDao = new ProductDAO();
        List<Category> categories = cateDao.getAll();
        boolean[] chid = new boolean[categories.size() +1];
        List<Product> products = new ArrayList<>();
        String key = request.getParameter("key");
        if(key != null){
            products = productDao.searchBykey(key);
        }
        String cid_raw = request.getParameter("cid");
        String[] check_name_raw = request.getParameterValues("check-name");
        String[] price_raw = request.getParameterValues("price");
        int cid =0;
        int[] check_name = null;
        if(cid_raw != null){
            cid = Integer.parseInt(cid_raw);
            products = productDao.getProductByCid(cid);
            if(cid == 0){
                chid[0] =true;
            }
        }
        if (check_name_raw !=null){
            check_name = new int[check_name_raw.length];
            for (int i =0; i< check_name.length; i++){
                check_name[i] = Integer.parseInt(check_name_raw[i]);
            }
            products = productDao.searchByCheck(check_name);
        }
        if(price_raw != null) {
            double from = 0, to = 0;
            for (int i =0; i < price_raw.length; i++){
                List<Product> temp = new ArrayList<>();
                if(price_raw[i].equals("0")){
                    from = 0;
                    to = 1000000000;
                    products = productDao.searchByPrice(from, to);
                    price[0] = true;
                    break;
                }else {
                    if(price_raw[i].equals("1")){
                        from = 0;
                        to = 49999;
                        temp = productDao.searchByPrice(from, to);
                        products.addAll(temp);
                        price[1] = true;
                    }
                    if(price_raw[i].equals("2")){
                        from = 50000;
                        to = 99999;
                        temp = productDao.searchByPrice(from, to);
                        products.addAll(temp);
                        price[2] = true;
                    }
                    if(price_raw[i].equals("3")){
                        from = 100000;
                        to = 149999;
                        temp = productDao.searchByPrice(from, to);
                        products.addAll(temp);
                        price[3] = true;
                    }
                    if(price_raw[i].equals("4")){
                        from = 150000;
                        to = 199999;
                        temp = productDao.searchByPrice(from, to);
                        products.addAll(temp);
                        price[4] = true;
                    }
                    if(price_raw[i].equals("5")){
                        from = 200000;
                        to = 1000000000;
                        temp = productDao.searchByPrice(from, to);
                        products.addAll(temp);
                        price[5] = true;
                    }
                }
            }
        }
        if(price_raw == null){
            price[0] =true;
        }
        if(cid_raw == null){
            chid[0] = true; 
        }
        if((check_name_raw != null) && (check_name[0] != 0)){
            chid[0] = false;
            for (int i = 1; i < chid.length; i++){
                if(isCheck(categories.get(i - 1).getId(), check_name)){
                    chid[i] =true;
                }else {
                    chid[i] = false;
                }
            }
        }
        request.setAttribute("data",categories);
        request.setAttribute("products",products);
        request.setAttribute("price",price);
        request.setAttribute("priceList",priceList);
        request.setAttribute("key",key);
        request.setAttribute("cid",cid);
        request.setAttribute("chid",chid);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    } 
    
    private boolean isCheck(int d,int[] id){
        if(id==null){
            return false;
        }else {
            for(int i=0; i<id.length; i++){
                if(id[i]== d){
                    return true;
                }
            }
            return false;
        }
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
