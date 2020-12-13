/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

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
public class CatServlet extends HttpServlet {
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
            out.println("<title>Servlet CatServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CatServlet at " + request.getContextPath() + "</h1>");
            
            try{
                
                if(request.getParameter("CategoryName")!=null){
                    String te=request.getParameter("CategoryName");
                    Category ca=new Category();
                    ca.setCategoryName(te);
                    categoryclient.addCategory(ca);
                }
                if(request.getParameter("upCategoryName")!=null){
                    Category ca=new Category();
                    String temp1=request.getParameter("upCategoryId");
                    ca.setCategoryName(request.getParameter("upCategoryName"));
                    ca.setCategoryID(Integer.parseInt(temp1));
                    categoryclient.editCategoey(Integer.parseInt(temp1), ca);
                }
//                    categoryclient.deleteCategory(9);
                    categorys = categoryclient.getAllCategorys();
                    out.println("<table>");
                    for(Category p : categorys)
                    {
                        out.println("<tr>"
                                + "<td>"+p.getCategoryID()+"</td>"
                                + "<td>"+p.getCategoryName()+"</td>"
                                + "<td><a href='/uiAPP/UpdateServlet?id="+p.getCategoryID()+"'>Update</a></td>"
                                + "<td><a href='/uiAPP/DeleteServlet?id="+p.getCategoryID()+"'>Delete</a></td>"
                                + "</tr>");   
                    }
                    out.println("</table>");
                    out.println("<a href='/uiAPP/AddServlet'>Add Category</a>");
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
