/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class RegisterVendor extends HttpServlet {

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
            out.println("<title>Servlet RegisterVendor</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterVendor at " + request.getContextPath() + "</h1>");
            out.println("<Form method='post' action='/uiAPP/ViewUsers'>"
                    + "UserName:-<input type='text' name='vUserName' placeholder='Enter UserName here ... '/></br></br>"
                    + "Email:-<input type='email' name='Email' placeholder='Enter Email here ... '/></br></br>"
                    + "Mobile No:-<input type='number' name='Contact' placeholder='Enter Contact here ... '/></br></br>"
                    + "Address:-<textarea type='text' name='Address'></textarea></br></br>"
                    + "User Image:-<input type='text' name='userImage'/></br></br>"
                    + "Password:-<input type='password' name='password'/></br></br>"
                    + "Restaurant Name:-<input type='text' value='' name='RestaurantName' placeholder='Enter RestaurantName here ... '/></br></br>"
                    + "Restaurant Image:-<input type='text' value='' name='RestaurantImage'/></br></br>"
                    + "City:-<select name='city'/>"
                    + "<option value='Surat'>Surat</option>"
                    + "<option value='Navsari'>Navsari</option>"
                    + "<option value='Rajkot'>Rajkot</option>"
                    + "<option value='Ahemdabad'>Ahemdabad</option>"
                    + "<option value='Bharuch'>Bharuch</option>"
                    + "</select></br></br>"
                    + "<input type='submit' name='submit' value='Register'/>"
                    + "<input type='hidden' name='Status' value='0'/></br></br>"
                    + "<input type='hidden' name='Approved' value='1'/></br></br>"
                    + "<input type='hidden' name='Role' value='2'/></br></br>"
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
