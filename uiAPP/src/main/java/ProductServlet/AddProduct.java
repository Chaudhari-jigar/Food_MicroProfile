/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductServlet;

import client.CategoryClient;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 *
 * @author admin
 */
public class AddProduct extends HttpServlet {
@Inject @RestClient CategoryClient categoryclient;
Collection<Category> categorys;
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
            out.println("<title>Servlet AddProduct</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Add Product</h1>");
            categorys = categoryclient.getAllCategorys();
            out.println("<Form method='post' action='/uiAPP/ViewProduct'>"
                    + "ProductName:-<input type='text' name='ProductName' placeholder='Enter Name here ... '/></br></br>"
                    + "Description:-<input type='text' name='Description' placeholder='Enter Description here ... '/></br></br>"
                    + "Price:-<input type='number' name='Price' placeholder='Enter Price here ... '/></br></br>"
                    + "Image:-<input type='text' name='Image'/></br></br>"
                    + "CategoryName:-<select name='CategoryName'>");
            for(Category p : categorys)
            {   
                out.println("<option value = "+p.getCategoryID()+">"+p.getCategoryName()+"</option>");
            }
            out.println("</select></br></br>"+"Vendor:-<input type='number' name='UserName' value='2' placeholder='Enter UserName here ... '/></br></br>"
                    + "<input type='submit' name='submit' value='Add Product'/>"
                    + "</Form>");
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
