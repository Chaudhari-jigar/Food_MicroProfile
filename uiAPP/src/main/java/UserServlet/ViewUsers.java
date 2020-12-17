/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserServlet;

import client.UserClient;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import model.Role;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 *
 * @author admin
 */
public class ViewUsers extends HttpServlet {
@Inject @RestClient UserClient userclient;
    Collection<User> users;
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
            out.println("<title>Servlet ViewUsers</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewUsers at " + request.getContextPath() + "</h1>");
            out.println("<table>");
                try {
                    if(request.getParameter("uUserName")!=null){
                        String username=request.getParameter("uUserName");
                        String email=request.getParameter("Email");
                        String contact=request.getParameter("Contact");
                        String address=request.getParameter("Address");
                        String userImage=request.getParameter("userImage");
                        String password=request.getParameter("password");
                        String city=request.getParameter("city");
                        String restaurantName=request.getParameter("RestaurantName");
                        String restaurantImage=request.getParameter("RestaurantImage");
                        String status=request.getParameter("Status");
                        String approved=request.getParameter("Approved");
                        String role=request.getParameter("Role");
                        
                        User u = new User();
                        u.setUserName(username);
                        u.setEmailID(email);
                        u.setMobileNo(contact);
                        u.setAddress(address);
                        u.setUserImage(userImage);
                        u.setPassword(password);
                        u.setCity(city);
                        u.setRestaurantName(restaurantName);
                        u.setImage(restaurantImage);
                        u.setStatus(Integer.parseInt(status));
                        u.setApproved(Integer.parseInt(approved));
                        
                        Role r = new Role();
                        r.setRoleID(3);
                        u.setRoleID(r);
                        System.err.println("////////   => "+ u.getCity() + "  " + u.getRoleID() + " <= //////////");
                        userclient.addUser(u);
                    }
                    if(request.getParameter("vUserName")!=null){
                        String username=request.getParameter("vUserName");
                        String email=request.getParameter("Email");
                        String contact=request.getParameter("Contact");
                        String address=request.getParameter("Address");
                        String userImage=request.getParameter("userImage");
                        String password=request.getParameter("password");
                        String city=request.getParameter("city");
                        String restaurantName=request.getParameter("RestaurantName");
                        String restaurantImage=request.getParameter("RestaurantImage");
                        String status=request.getParameter("Status");
                        String approved=request.getParameter("Approved");
                        String role=request.getParameter("Role");
                        
                        User u = new User();
                        u.setUserName(username);
                        u.setEmailID(email);
                        u.setMobileNo(contact);
                        u.setAddress(address);
                        u.setUserImage(userImage);
                        u.setPassword(password);
                        u.setCity(city);
                        u.setRestaurantName(restaurantName);
                        u.setImage(restaurantImage);
                        u.setStatus(Integer.parseInt(status));
                        u.setApproved(Integer.parseInt(approved));
                        Role r = new Role();
                        r.setRoleID(Integer.parseInt(role));
                        u.setRoleID(r);
                        
                        
                        userclient.addUser(u);                    
                    }
                    if(request.getParameter("dUserName")!=null){
                        String username=request.getParameter("dUserName");
                        String email=request.getParameter("Email");
                        String contact=request.getParameter("Contact");
                        String address=request.getParameter("Address");
                        String userImage=request.getParameter("userImage");
                        String password=request.getParameter("password");
                        String city=request.getParameter("city");
                        String restaurantName=request.getParameter("RestaurantName");
                        String restaurantImage=request.getParameter("RestaurantImage");
                        String status=request.getParameter("Status");
                        String approved=request.getParameter("Approved");
                        String role=request.getParameter("Role");
                        
                        User u = new User();
                        u.setUserName(username);
                        u.setEmailID(email);
                        u.setMobileNo(contact);
                        u.setAddress(address);
                        u.setUserImage(userImage);
                        u.setPassword(password);
                        u.setCity(city);
                        u.setRestaurantName(restaurantName);
                        u.setImage(restaurantImage);
                        u.setStatus(Integer.parseInt(status));
                        u.setApproved(Integer.parseInt(approved));
                        Role r = new Role();
                        r.setRoleID(Integer.parseInt(role));
                        u.setRoleID(r);
                        
                        userclient.addUser(u);                    
                    }
                } catch (Exception e) {
                }
                    out.println("<tr><td>---------------User List---------------</td></tr>");
                    users = userclient.getAllUsers();
                    out.println("<tr><th> Index </th><th>UserName</th><th>Email</th><th>Contact</th><th>Address</th><th>Role</th><th>Update</th><th>Delete</th></tr>");
                    int i = 0;
                    for(User u : users)
                    {
                        i++;
                        out.println("<tr><td>"+i+"</td><td>"
                                +u.getUserImage()+"</td><td>"
                                +u.getEmailID()+"</td><td>"
                                +u.getMobileNo()+"</td><td>"
                                +u.getAddress()+"</td><td>"
                                
                                + "<td><a href='/uiAPP/UpdateProduct?id="+u.getUserID()+"'>Update</a></td>"
                                + "<td><a href='/uiAPP/DeleteProduct?id="+u.getUserID()+"'>Delete</a></td>"
                                +"</td></tr>");   
                    }
//                    out.println("<a href='/uiAPP/AddProduct'>Add Product</a>");
                    
//                    productclient.updateProduct(20, prd);
//                    productclient.removeProduct(20);
//                    productclient.addProduct(prd);
                    
                    out.println("</table>"); 
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
