/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import client.ProductClient;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.Product;
import model.User;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 *
 * @author admin
 */
public class ProdServlet extends HttpServlet {
    @Inject @RestClient ProductClient productclient;
    Collection<Product> products;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
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
            out.println("<title>Servlet ProdServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProdServlet at " + request.getContextPath() + "</h1>");
             try{
                    out.println("<table>");
                    
                    out.println("<tr><td>---------------Product List---------------</td></tr>");
                    products = productclient.getAllProducts();
                    for(Product p : products)
                    {
                        out.println("<tr><td>"+p.getProductID()+"</td><td>"+p.getProductName()+"</td><td>"+p.getDescription()+"</td></tr>");   
                    }
                    
                    Product prd = new Product();
                    prd.setProductName("New1");
                    prd.setDescription("asdsd");
                    prd.setImage("imgs");
                    prd.setPrice(7897);
                    Category crd = new Category();
                    User u = new User();
                    u.setUserID(2);
                    crd.setCategoryID(1);
                    prd.setCategoryID(crd);
                    prd.setVendorID(u.getUserID());
//                    productclient.updateProduct(20, prd);
//                    productclient.removeProduct(20);
//                    productclient.addProduct(prd);
                    
                    out.println("</table>");                    
            }
           catch(Exception e)
           {
               out.println("<tr><td colspan='3'> You are not Authorized to view the Shop</td><tr>"+e.getMessage());
           }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
