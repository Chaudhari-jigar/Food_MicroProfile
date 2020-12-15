/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductServlet;

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
public class ViewProduct extends HttpServlet {
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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ViewProduct</title>");            
            out.println("</head>");
            out.println("<body>");
            try{
                 if(request.getParameter("ProductName")!=null){
                    Product prd = new Product(); 
                    response.setContentType("text/html");  
                    String folder = "F:\\SEM 9\\Practical\\Assigment\\uiAPP\\src\\main\\webapp\\image";
                    
                    String prdName=request.getParameter("ProductName");
                    String desc=request.getParameter("Description");
                    String image=request.getParameter("Image");
                    String price=request.getParameter("Price");
                    String categoryName=request.getParameter("CategoryName");
                    String vendor=request.getParameter("UserName");

                            prd.setProductName(prdName);
                            prd.setDescription(desc);
                            prd.setImage(image);
                            prd.setPrice(Float.valueOf(price));

                            User u = new User();
                            u.setUserID(Integer.parseInt(vendor));
                            prd.setVendorID(u.getUserID());

                            Category ca=new Category();
                            ca.setCategoryID(Integer.parseInt(categoryName));
                            prd.setCategoryID(ca);                    

                            productclient.addProduct(prd);
                }
                if(request.getParameter("uProductName")!=null){
                    
                    String prdName=request.getParameter("uProductName");
                    String desc=request.getParameter("uDescription");
                    String image=request.getParameter("uImage");
                    String price=request.getParameter("uPrice");
                    String categoryName=request.getParameter("uCategoryName");
                    String vendor=request.getParameter("uUserName");
                    Product prd = new Product();
                    prd.setProductName(prdName);
                    prd.setDescription(desc);
                    prd.setImage(image);
                    prd.setPrice(Float.valueOf(price));
                    
                    User u = new User();
                    u.setUserID(Integer.parseInt(vendor));
                    prd.setVendorID(u.getUserID());
                    
                    Category ca=new Category();
                    ca.setCategoryID(Integer.parseInt(categoryName));
                    prd.setCategoryID(ca);                    
                    
                    productclient.updateProduct(Integer.parseInt(request.getParameter("uProductID")), prd);
                }
                    out.println("<table>");
                    
                    out.println("<tr><td>---------------Product List---------------</td></tr>");
                    products = productclient.getAllProducts();
                    out.println("<tr><th> Index </th><th>Product Name</th><th>Price</th><th>Description</th><th>Category</th><th>Image</th><th>Update</th><th>Delete</th></tr>");
                    int i = 0;
                    for(Product p : products)
                    {
                        i++;
                        out.println("<tr><td>"+i+"</td><td>"
                                +p.getProductName()+"</td><td>"
                                +p.getPrice()+"</td><td>"
                                +p.getDescription()+"</td><td>"
                                +p.getCategoryID().getCategoryName()+"</td><td>"
                                +p.getImage()
                                + "<td><a href='/uiAPP/UpdateProduct?id="+p.getProductID()+"'>Update</a></td>"
                                + "<td><a href='/uiAPP/DeleteProduct?id="+p.getProductID()+"'>Delete</a></td>"
                                +"</td></tr>");   
                    }
                    out.println("<a href='/uiAPP/AddProduct'>Add Product</a>");
                    
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
