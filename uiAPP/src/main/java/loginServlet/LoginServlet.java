/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
public class LoginServlet extends HttpServlet {
    String message;
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
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            HttpSession session = request.getSession();
            /* TODO output your page here. You may use following sample code. */
           
             if(session.getAttribute("status")!=null){
            if(session.getAttribute("status").toString().equals("Login_Success"))
            {    
                session.setAttribute("role", "Dealer");
                session.setAttribute("user", "admin");
                session.setAttribute("pass", "admin");
                response.sendRedirect("/uiAPP/slidesigma.com/themes/html/costic/pages/dashboard/ViewCategory.jsf");
//                RequestDispatcher rd = request.getRequestDispatcher("/slidesigma.com/themes/html/costic/pages/dashboard/ViewCategory.jsf");
//                rd.forward(request, response);
            } 
            else if(session.getAttribute("status").toString().equals("Login_Failed"))
            {
                 message = session.getAttribute("statusmessage").toString();
            }
            }            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\" />\n" +
"  <link rel=\"stylesheet\" href=\"./slidesigma.com/themes/html/costic/vendors/iconic-fonts/flat-icons/flaticon.css\" />\n" +
"    <link href=\"./slidesigma.com/themes/html/costic/vendors/iconic-fonts/font-awesome/css/all.min.css\" rel=\"stylesheet\" />\n" +
"  <!-- Bootstrap core CSS -->\n" +
"  <link href=\"./slidesigma.com/themes/html/costic/assets/css/bootstrap.min.css\" rel=\"stylesheet\" />\n" +
"  <!-- jQuery UI -->\n" +
"  <link href=\"./slidesigma.com/themes/html/costic/assets/css/jquery-ui.min.css\" rel=\"stylesheet\" />\n" +
"  <!-- Costic styles -->\n" +
"  <link href=\"./slidesigma.com/themes/html/costic/assets/css/style.css\" rel=\"stylesheet\" />\n" +
"  <!-- Favicon -->\n" +
"  <link rel=\"icon\" type=\"image/png\" sizes=\"32x32\" href=\"http://slidesigma.com/themes/html/costic/favicon.ico\" />");
            
            out.println("<title>Servlet HomeServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("  <div class=\"ms-lock-screen-weather\">\n" +
"    <p>38&deg;</p>\n" +
"    <p>San Francisco, CA</p>\n" +
"  </div>\n" +
"\n" +
"  <ul class=\"ms-lock-screen-nav\">\n" +
"    <li class=\"ms-nav-item dropdown\">\n" +
"      <a href=\"#\" class=\"text-disabled ms-has-notification\" id=\"mailDropdown\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\"><i class=\"material-icons\">email</i></a>\n" +
"      \n" +
"    </li>\n" +
"  </ul>\n" +
"  <ul class=\"ms-lock-screen-nav\">\n" +
"    <li class=\"ms-nav-item dropdown\">\n" +
"      <a href=\"#\" class=\"text-disabled ms-has-notification\" id=\"notificationDropdown\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\"><i class=\"material-icons\">notifications</i></a>\n" +
"      <ul class=\"dropdown-menu dropdown-menu-right\" aria-labelledby=\"notificationDropdown\">\n" +
"        <li class=\"dropdown-menu-header\">\n" +
"          <h6 class=\"dropdown-header ms-inline m-0\"><span class=\"text-disabled\"> Only New Registration</span></h6><span class=\"badge badge-pill badge-info\">New</span>\n" +
"        </li>\n" +
"        <li class=\"dropdown-divider\"></li>\n" +
"        <li class=\"ms-scrollable ms-dropdown-list ps\">\n" +
"          <a class=\"media p-2\" href=\"https://localhost:8181/JWT/slidesigma.com/themes/html/costic/pages/dealer/Register.jsf\">\n" +
"            <div class=\"media-body\">\n" +
"                <span>Dealer Registration Form</span>\n" +
"              <p class=\"fs-10 my-1 text-disabled\"><span class=\"badge badge-pill badge-info\">New</span> 30 seconds ago</p>\n" +
"            </div>\n" +
"          </a>\n" +
"          <a class=\"media p-2\" href=\"https://localhost:8181/JWT/slidesigma.com/themes/html/costic/pages/Vendor/Register.jsf\">\n" +
"            <div class=\"media-body\">\n" +
"              <span>Vendor Registration Form</span>\n" +
"              <p class=\"fs-10 my-1 text-disabled\"><span class=\"badge badge-pill badge-info\">New</span> 45 minutes ago</p>\n" +
"            </div>\n" +
"          </a>\n" +
"          <a class=\"media p-2\" href=\"https://localhost:8181/JWT/codenpixel.com/demo/foodpicky/Register.jsf\">\n" +
"            <div class=\"media-body\">\n" +
"              <span>Customer Registration Form</span>\n" +
"              <p class=\"fs-10 my-1 text-disabled\"><span class=\"badge badge-pill badge-info\">New</span> 45 minutes ago</p>\n" +
"            </div>\n" +
"          </a>  \n" +
"        <div class=\"ps__rail-x\" style=\"left: 0px; bottom: 0px;\"><div class=\"ps__thumb-x\" tabindex=\"0\" style=\"left: 0px; width: 0px;\"></div></div><div class=\"ps__rail-y\" style=\"top: 0px; right: 0px;\"><div class=\"ps__thumb-y\" tabindex=\"0\" style=\"top: 0px; height: 0px;\"></div></div></li><li class=\"dropdown-divider\"></li>\n" +
"        <li class=\"dropdown-menu-footer text-center\">\n" +
"          <a href=\"#\">View all Notifications</a>\n" +
"        </li>\n" +
"      </ul>\n" +
"    </li>\n" +
"  </ul>\n" +
"\n" +
"  <!-- Main Content -->\n" +
"  <main class=\"body-content ms-lock-screen\">\n" +
"\n" +
"    <!-- Body Content Wrapper -->\n" +
"    <div class=\"ms-content-wrapper\" style=\"margin-top: 46px;\">\n" +
"      <img class=\"ms-user-img ms-img-round ms-lock-screen-user\" src=\"./slidesigma.com/themes/html/costic/assets/img/costic/customer-3.jpg\" alt=\"people\" />\n" +
"      <h3>Login </h3>\n" +
"      <div class=\"ms-panel ms-panel-fh\" style=\"border-bottom-left-radius: 78px;border-top-right-radius: 78px;\">\n" +
"            <div class=\"ms-panel-body\">\n" +
"<!--            if(session.getAttribute(\"status\")!=null){\n" +
"            if(session.getAttribute(\"status\").toString().equals(\"Login_Success\"))\n" +
"            {    \n" +
"                    RequestDispatcher rd = request.getRequestDispatcher(\"/CatServlet\");\n" +
"                    rd.forward(request, response);\n" +
"            } \n" +
"            else if(session.getAttribute(\"status\").toString().equals(\"Login_Failed\"))\n" +
"            {\n" +
"                 message = session.getAttribute(\"statusmessage\").toString();\n" +
"            }\n" +
"            }  -->\n" +
"              <form method=\"post\">\n" +
"                <div class=\"form-row\">\n" +
"                    <div class=\"col-md-12 mb-3\" style=\"margin-bottom: 0px!important;\">\n" +
"                    <label style=\"margin-left: -281px;\">Enter UserName</label>\n" +
"                    <div class=\"input-group\">\n" +
"                      <input name=\"username\" class=\"form-control\" />\n" +
"                      <div class=\"invalid-feedback\">\n" +
"                        Please provide a valid email.\n" +
"                      </div>\n" +
"                    </div>\n" +
"                  </div>\n" +
"                  <div class=\"col-md-12 mb-2\" style=\"margin-bottom: 0px!important;\">\n" +
"                    <label  style=\"margin-left: -281px;\">Enter Password</label>\n" +
"                    <div class=\"input-group\">\n" +
"                      <input name=\"password\" type=\"password\" class=\"form-control\"/>\n" +
"                      <div class=\"invalid-feedback\">\n" +
"                        Please provide a password.\n" +
"                      </div>\n" +
"                    </div>\n" +
"                  </div>\n" +
"                </div>\n" +
"                <div class=\"form-group\" style=\"margin-bottom: -1rem;\">\n" +
"                  <label class=\"ms-checkbox-wrap\" style=\"margin-left: -224px;\">\n" +
"                    <input class=\"form-check-input\" type=\"checkbox\" value=\"\"/>\n" +
"                    <i class=\"ms-checkbox-check\"></i>\n" +
"                  </label>\n" +
"                  <span style=\"\"> Remember Password </span>\n" +
"                </div>\n" +
"                  <button type=\"submit\" name=\"submit\" value=\"Login\" class=\"btn btn-primary mt-4 d-block w-100\">Login</button>\n" +
"              </form>\n" +
"            </div>\n" +
"          </div>\n" +
"      \n" +
"    </div>\n" +
"\n" +
"  </main>\n" +
"\n" +
"  <div class=\"ms-lock-screen-time\">\n" +
"    <p>04:25</p>\n" +
"    <p>Friday, January 9</p>\n" +
"  </div>\n" +
"\n" +
"  <!-- SCRIPTS -->\n" +
"  <!-- Global Required Scripts Start -->\n" +
"  <script src=\"./slidesigma.com/themes/html/costic/assets/js/jquery-3.3.1.min.js\"></script>\n" +
"  <script src=\"./slidesigma.com/themes/html/costic/assets/js/popper.min.js\"></script>\n" +
"  <script src=\"./slidesigma.com/themes/html/costic/assets/js/bootstrap.min.js\"></script>\n" +
"  <script src=\"./slidesigma.com/themes/html/costic/assets/js/perfect-scrollbar.js\"> </script>\n" +
"  <script src=\"./slidesigma.com/themes/html/costic/assets/js/jquery-ui.min.js\"> </script>\n" +
"  <!-- Global Required Scripts End -->\n" +
"\n" +
"  <!-- Costic core JavaScript -->\n" +
"  <script src=\"./slidesigma.com/themes/html/costic/assets/js/framework.js\"></script>\n" +
" <!-- Settings -->\n" +
"  <script src=\"./slidesigma.com/themes/html/costic/assets/js/settings.js\"></script>");
//            out.println(" <form method=\"POST\">\n" +
//"            <table>\n" +
//"                <tr>\n" +
//"                    <td colspan=\"2\">Login:</td>\n" +
//"                </tr>\n" +
//"                <tr>\n" +
//"                    <td>User Name:</td>\n" +
//"                    <td><input type=\"text\" name=\"username\"/></td>\n" +
//"                </tr>\n" +
//"\n" +
//"                <tr>\n" +
//"                    <td>Password:</td>\n" +
//"                    <td><input type=\"password\" name=\"password\"/></td>\n" +
//"                </tr>\n" +
//"                <tr>\n" +
//"                    <td><input type=\"submit\" name=\"submit\" value=\"submit\"/></td>\n" +
//"                    <td><input type=\"reset\"/></td>\n" +
//"                </tr>\n" +
//"            </table>\n" +
//"        </form>\n" +
//"        <br/>\n" +
//"        <a href='/uiAPP/RegisterUser'>User Registration</a> " +
//"        <a href='/uiAPP/RegisterVendor'>Vendor Registration</a> "+
//"        <a href='/uiAPP/RegisterDealer'>Dealer Registration</a> "+
//"        ");
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
