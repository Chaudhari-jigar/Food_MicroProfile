/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import client.UserClient;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import model.Role;
import model.User;
import org.eclipse.microprofile.rest.client.inject.RestClient;
//import javax.faces.context.ExternalContext;

/**
 *
 * @author dell
 */
@Named(value = "userManagedBean")
@RequestScoped
public class UserManagedBean {

    
    User us;
    User us1;
    Collection<User> userList;
    Collection<User> userListses;
    Collection<User> userVlive;
    Collection<User> userDLive;
    Collection<User> RestaurantList = new ArrayList<User>();
    static String temp="";
    private int count1;
    @Inject @RestClient UserClient client;
    HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    
    private int userID;
    @NotNull(message = "Name Is Required !!") 
    @Pattern(regexp = "^[A-Za-z_ ]+$",message = "Please Enter Correct Name !!")
    private String userName;
    @NotNull(message = "Mobile Is Required !!")  
    @Size(min = 10, max = 10, message = "Mobile must have 10 digits !!")
    private String mobileNo;
    @NotNull(message = "EmailID Is Required !!")
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",message = "Please Enter Corrent Email !!")
    private String emailID;
    @NotNull(message = "Address Is Required !!")  
    private String address;
    private String city;
    @NotNull(message = "Restaurant Is Required !!")  
    @Pattern(regexp = "^[A-Za-z_ ]+$",message = "Please Enter Correct Name !!")
    private String restaurantName;
    @NotNull(message = "Password Is Required !!")  
    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})",message = "Password is required 6 to 20 characters string with at least one digit one upper case letter one lower case letter and one special symbol !!")
    private String password;
    private int status;
    private int approved;
    private Role role;
    
    private String image,userImage;
    private String image1;
//    Pbkdf2PasswordHashImpl pbl;
   
    private int roleID;
    private static int on;
    private String roleName;
    HttpSession session = req.getSession();
    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public int getCount1() {
        return count1;
    }

    public void setCount1(int count1) {
        this.count1 = count1;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public UserManagedBean() {
        
        System.out.println("Hello CategoryManageBean Bean ");
//        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//       // String token="";
//
//       // token = request.getSession().getAttribute("token").toString();
//       //System.out.println("Token="+token);
//        
//        client = new NewJerseyClient();
        userList = new ArrayList<User>();
        userListses = new ArrayList<User>();
        userVlive = new ArrayList<User>();
        userDLive = new ArrayList<User>();
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public Collection<User> getUserList() {
        
        userList = (ArrayList<User>) client.getAllUsers();
        return userList;
    }

    public void setUserList(Collection<User> userList) {
        this.userList = userList;
    }

    public Collection<User> getUserListses() {
        int id = Integer.parseInt((String) session.getAttribute("id"));
        userListses = (Collection<User>) client.getUserOfID(id);
        return userListses;
    }

    public User getSingle() {
        int id = Integer.parseInt((String) session.getAttribute("id"));
        us1 = (User) client.getUserOfID(id);
        return us1;
    }
    public void setUserListses(Collection<User> userListses) {
        this.userListses = userListses;
    }

    public Collection<User> getUserVlive() {
        userVlive = (ArrayList<User>) client.getAllLiveVendor();
        return userVlive;
    }

    public void setUserVlive(Collection<User> userVlive) {
        this.userVlive = userVlive;
    }

    public Collection<User> getUserDLive() {
        userDLive = (ArrayList<User>) client.getAllLiveDealer();
        return userDLive;
    }

    public void setUserDLive(Collection<User> userDLive) {
        this.userDLive = userDLive;
    }

    
    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getApproved() {
        return approved;
    }

    public void setApproved(int approved) {
        this.approved = approved;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public int getOn() {
        return on;
    }

    public void setOn(int on) {
        this.on = on;
    }
    
    
    public String search() throws IOException 
    {
        System.err.println(session.getAttribute("id").toString()); 
        if(city.equals("Chosen")){
            return "index.jsf";
        }else{
        User u = new User();
        u.setCity(city);
        session.setAttribute("city", city);
//        setTemp(city);
        System.err.println("search called");
        ExternalContext context1 = FacesContext.getCurrentInstance().getExternalContext();
//        context1.redirect(context1.getRequestContextPath() + "/codenpixel.com/demo/foodpicky/restaurants.jsf?city="+u.getCity());
        context1.redirect(context1.getRequestContextPath() + "/codenpixel.com/demo/foodpicky/restaurants.jsf");
      
//        return "restaurants.jsf";
        }
        
        return null;
    }

    public Collection<User> getRestaurantList() {
        //        ExternalContext context1 = FacesContext.getCurrentInstance().getExternalContext();
//        context1.redirect(context1.getRequestContextPath() + "/codenpixel.com/demo/foodpicky/restaurants.jsf");
//        String param1 = req.getParameter("city");
        System.err.println(session.getAttribute("city").toString());
        User u = new User();
        u.setCity(session.getAttribute("city").toString());
        System.err.println(session.getAttribute("city").toString()+" 1 ses");
        client.getVendorCity(u.getCity());
        System.err.println(session.getAttribute("city").toString()+" 2 ses");    
//        Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
//        String as = params.get("city");
//        res = client.getVendorCity(Response.class,param1);
//        RestaurantList = (ArrayList<User>) res.readEntity(gUser);
        System.err.println(session.getAttribute("city").toString()+" 3 ses");
        return RestaurantList;
    }

    public void setRestaurantList(Collection<User> RestaurantList) {
        this.RestaurantList = RestaurantList;
    }
    String selectedVal;
    String inputTextVal;
    String inputTextVals;
    String inputNewTextVal;
    String inputNewTextVals;
    String NewPassword;
    String ConfirmPassword;
     
    public String getSelectedVal() {
        return selectedVal;
    }

    public void setSelectedVal(String selectedVal) {
        this.selectedVal = selectedVal;
    }

    public String getInputTextVal() {
        return inputTextVal;
    }

    public void setInputTextVal(String inputTextVal) {
        this.inputTextVal = inputTextVal;
    }

    public String getInputTextVals() {
        return inputTextVals;
    }

    public void setInputTextVals(String inputTextVals) {
        this.inputTextVals = inputTextVals;
    }

    public String getNewPassword() {
        return NewPassword;
    }

    public void setNewPassword(String NewPassword) {
        this.NewPassword = NewPassword;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public void setConfirmPassword(String ConfirmPassword) {
        this.ConfirmPassword = ConfirmPassword;
    }

    public String getInputNewTextVal() {
        return inputNewTextVal;
    }

    public void setInputNewTextVal(String inputNewTextVal) {
        this.inputNewTextVal = inputNewTextVal;
    }

    public String getInputNewTextVals() {
        return inputNewTextVals;
    }

    public void setInputNewTextVals(String inputNewTextVals) {
        this.inputNewTextVals = inputNewTextVals;
    }
    
    public void checkconfPassword()
    {
        String pa1= session.getAttribute("NewPass").toString();
        System.err.println(" confirmnew "+ConfirmPassword+" new "+pa1);
        session.setAttribute("ConfirmPass", ConfirmPassword);
//        if(pa1.equals(ConfirmPassword))
//        {
////            inputNewTextVals = "Password And Confirm Is Matched";
//            session.setAttribute("MyConfirmPassword", ConfirmPassword);
//        }
//        else
//        {
//            inputNewTextVal = "Password And Confirm Is Not Matched";
//        }
        passValidation();
    }
    public void passValidation()
    {   
        count1=1;
        if(session.getAttribute("ConfirmPass") != null && session.getAttribute("NewPass") != null)
        {
            System.err.println("Called ");
            String npa= session.getAttribute("NewPass").toString();
            String cpa= session.getAttribute("ConfirmPass").toString();
            if(npa.equals(cpa))
            {
                inputNewTextVals = "Password And Confirm Is Matched";
                
            }
            else
            {
                inputNewTextVal = "Password And Confirm Is Not Matched";   
            }
        }
    }
    public void checkPassword()
    {
        System.err.println(" new "+NewPassword);
        session.setAttribute("NewPass", NewPassword);
        passValidation();
    }
    public void checkOldPassword()
    {
//        Pbkdf2PasswordHashImpl pbl1 = new Pbkdf2PasswordHashImpl();
        int id = Integer.parseInt((String) session.getAttribute("id"));
        us = (User) client.getUserOfID(id);
        System.err.println(selectedVal+" ------------------- "+ us.getPassword());
//        Boolean v = pbl1.verify(selectedVal.toCharArray(), us.getPassword());
        if(us.getPassword().length() > 0)
        {
            inputTextVals = "Old Password Is Matched";

//            System.out.println("Matched");
        }
        else
        {
            inputTextVal = "Old Password Is Wrong";
            
//            System.out.println("Not Matched");   
        }
    }
    
    public String changeMyNewPassword()
    {
        System.err.println("asdsadsa "+session.getAttribute("id").toString());
        int id = Integer.parseInt((String) session.getAttribute("id"));
        us = (User) client.getUserOfID(id);

        this.setUserID(userID = us.getUserID());
        this.setUserName(userName = us.getUserName());
        this.setMobileNo(mobileNo = us.getMobileNo());
        this.setEmailID(emailID = us.getEmailID());
        this.setAddress(address = us.getAddress());
        this.setImage(image= us.getImage());
        this.setCity(city= us.getCity());
        this.setRestaurantName(restaurantName = us.getRestaurantName());
        this.setUserImage(userImage=us.getUserImage());

        //on=1;
        //pbl = new Pbkdf2PasswordHashImpl();
        this.setPassword(password = us.getPassword());
        this.setStatus(status = us.getStatus());
//            this.setOn(on=1);
        this.setApproved(approved = us.getApproved());
        this.setRoleID(us.getRoleID().getRoleID());

        User u = new User();
        u.setUserID(userID);
        u.setUserName(userName);
        u.setMobileNo(mobileNo);
        u.setEmailID(emailID);
        u.setCity(city);
        u.setRestaurantName(restaurantName);
        u.setImage(image);
        u.setUserImage(userImage);
        u.setAddress(address);
//        pbl = new Pbkdf2PasswordHashImpl();
//            String pass = pbl.generate(password.toCharArray());

//        String cnpass = pbl.generate(session.getAttribute("ConfirmPass").toString().toCharArray());
        u.setPassword(session.getAttribute("ConfirmPass").toString());
        u.setStatus(1);
        u.setApproved(approved);
        Role r = new Role();      
        r.setRoleID(roleID);
        u.setRoleID(r);
//            System.err.println("///  "+u.getPassword()+" /// "+cnpass+"  ///"+r.getRoleID()+status+userID+userName+mobileNo+emailID+city+" === "+restaurantName+image+userImage+" --- "+address+approved+session.getAttribute("ConfirmPass").toString());
        if(userID == 0) {
        } else {
            System.err.println("Id:-"+u.getUserID());
            client.UpdateUser(userID, u);
        }
        return "success";   
    }
    public String asd()
    {
        return "food_results.jsf";
    }
    public void submit() throws IOException {
        
        User u = new User();
//        pbl = new Pbkdf2PasswordHashImpl();
//        String pass = pbl.generate(password.toCharArray());
        u.setUserName(userName);
        u.setMobileNo(mobileNo);
        u.setCity(city);
        u.setRestaurantName(restaurantName);
        u.setEmailID(emailID);
        u.setAddress(address);
        u.setPassword(password);
        u.setStatus(0);
        u.setApproved(0);
        
        try(InputStream input = UploadedFile.getInputStream()){
            String FileName = UploadedFile.getSubmittedFileName();
//            long img = Files.copy(input, new File(folder,p.getProductName()+FileName).toPath());
            long img = Files.copy(input, new File(folder,userName+FileName).toPath());
            
            try{
            Thread.sleep(6000);
            }catch(Exception e)
            {
                e.printStackTrace();
            }
//            p.setImage(p.getProductName()+FileName);
            u.setImage(userName+FileName);
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        try(InputStream input = userPic.getInputStream()){
            String FileName = userPic.getSubmittedFileName();
//            long img = Files.copy(input, new File(folder,p.getProductName()+FileName).toPath());
            long img = Files.copy(input, new File(folder,userName+FileName).toPath());
            
            try{
            Thread.sleep(6000);
            }catch(Exception e)
            {
                e.printStackTrace();
            }
//            p.setImage(p.getProductName()+FileName);
            u.setUserImage(userName+FileName);
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        Role r = new Role();
        
        r.setRoleID(2);
        
        u.setRoleID(r);
            client.addUser(u);
//        return "ViewProduct";
            ExternalContext context1 = FacesContext.getCurrentInstance().getExternalContext();
            context1.redirect(context1.getRequestContextPath() + "/slidesigma.com/themes/html/costic/pages/LoginPage.jsf");
        
    }
    
    
    public void defaultUserLogin() throws IOException{
        ExternalContext context323 = FacesContext.getCurrentInstance().getExternalContext();
        context323.redirect(context323.getRequestContextPath() + "/codenpixel.com/demo/foodpicky/index.jsf");
    }
    
    public void dealersubmit() throws IOException {
        
        User u = new User();
        u.setUserName(userName);
        u.setMobileNo(mobileNo);
        u.setEmailID(emailID);
        u.setCity(city);
        u.setRestaurantName(restaurantName);
        //u.setImage("");
        //u.setUserName(userName);
//        pbl = new Pbkdf2PasswordHashImpl();
//        String pass = pbl.generate(password.toCharArray());
        //this.setPassword(pass);
        u.setAddress(address);
        u.setPassword(password);
        u.setStatus(status);
        u.setApproved(approved);
        
        try(InputStream input = userPic.getInputStream()){
            String FileName = userPic.getSubmittedFileName();
//            long img = Files.copy(input, new File(folder,p.getProductName()+FileName).toPath());
            long img = Files.copy(input, new File(folder,userName+FileName).toPath());
            
            try{
            Thread.sleep(6000);
            }catch(Exception e)
            {
                e.printStackTrace();
            }
//            p.setImage(p.getProductName()+FileName);
            u.setUserImage(userName+FileName);
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        Role r = new Role();      
        r.setRoleID(4);

        u.setRoleID(r);
        client.addUser(u);
        //ExternalContext
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect(context.getRequestContextPath() + "/slidesigma.com/themes/html/costic/pages/LoginPage.jsf");
        //return "./../dashboard/ViewCategory";
    }
    
    public void customersubmit() throws IOException {
        
        User u = new User();
   
        u.setUserName(userName);
        u.setMobileNo(mobileNo);
        u.setCity(city);
        u.setRestaurantName(restaurantName);
        u.setEmailID(emailID);
        u.setAddress(address);
        u.setImage("");
        try(InputStream input = userPic.getInputStream()){
            String FileName = userPic.getSubmittedFileName();
//            long img = Files.copy(input, new File(folder,p.getProductName()+FileName).toPath());
            long img = Files.copy(input, new File(folder,userName+FileName).toPath());
            
            try{
            Thread.sleep(6000);
            }catch(Exception e)
            {
                e.printStackTrace();
            }
//            p.setImage(p.getProductName()+FileName);
            u.setUserImage(userName+FileName);
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
//        pbl = new Pbkdf2PasswordHashImpl();
//        String pass = pbl.generate(password.toCharArray());
        u.setPassword(password);
        u.setStatus(0);
        u.setApproved(1);
        
        Role r = new Role();
        
        r.setRoleID(3);
        
        u.setRoleID(r);
            client.addUser(u);
//        return "ViewProduct";
            ExternalContext context1 = FacesContext.getCurrentInstance().getExternalContext();
            context1.redirect(context1.getRequestContextPath() + "/slidesigma.com/themes/html/costic/pages/LoginPage.jsf");
        
    }
    
    public String editUser() {
        int id = Integer.parseInt((String) session.getAttribute("id"));
        us = (User) client.getUserOfID(id);
        System.err.println("User "+session.getAttribute("id"));
        this.setUserID(userID = (int) session.getAttribute("id"));
//        this.setUserName(userName = us.getUserName());
        System.err.println("UserName "+us.getUserName());
//        this.setMobileNo(mobileNo = us.getMobileNo());
//        this.setEmailID(emailID = us.getEmailID());
//        this.setAddress(address = us.getAddress());
        this.setCity(city= us.getCity());
        this.setImage(image = us.getImage());
         this.setUserImage(userImage=us.getUserImage());
        this.setRestaurantName(restaurantName = us.getRestaurantName());
//        pbl = new Pbkdf2PasswordHashImpl();
//        String pass = pbl.generate(us.getPassword().toCharArray());
        this.setPassword(us.getPassword());
        this.setStatus(status = us.getStatus());
        this.setApproved(approved = us.getApproved());
        this.setRoleID(roleID = us.getRoleID().getRoleID());
        
        User u = new User();
        u.setUserID((int) session.getAttribute("id"));
        u.setUserName(userName);
//        System.err.println(userName+" = Name");
        u.setMobileNo(mobileNo);
        u.setEmailID(emailID);
        u.setImage(image);
        u.setUserImage(userImage);
        u.setCity(city);
        u.setRestaurantName(us.getRestaurantName());
        u.setAddress(address);
        u.setPassword(us.getPassword());
        u.setStatus(us.getStatus());
        u.setApproved(1);
        
        Role r = new Role();      
//        if(us.getRoleID().getRoleID()==2){
//            r.setRoleID(2);
//        }else if(us.getRoleID().getRoleID()==3){
//            r.setRoleID(3);
//        }else if(us.getRoleID().getRoleID()==4){
//            r.setRoleID(4);
//        }
        r.setRoleID(3);
        u.setRoleID(r);

//        if(userID == 0) {
//        } else {
//            System.err.println("error:-"+u.getUserID());
            client.UpdateUser(id, u);
//        }
      
//        ExternalContext context1 = FacesContext.getCurrentInstance().getExternalContext();
//        context1.redirect(context1.getRequestContextPath() + "/codenpixel.com/demo/foodpicky/profile.jsf");

        return null;
    
    }
    public String updateCartUser() {
        //session.getAttribute("id").toString()
        int id = Integer.parseInt((String) session.getAttribute("id"));
        System.err.println("Data ");
        
        us = (User) client.getUserOfID(id);
        System.err.println("CartUser "+session.getAttribute("id"));
//        this.setUserID(userID = (int) session.getAttribute("id"));
        this.setUserName(userName = us.getUserName());
        System.err.println("CartUserName "+us.getUserName());
        this.setMobileNo(mobileNo = us.getMobileNo());
        this.setEmailID(emailID = us.getEmailID());
        this.setAddress(address = us.getAddress());
        this.setImage(image = us.getImage());
        this.setUserImage(userImage=us.getUserImage());
        this.setCity(city= us.getCity());
        this.setRestaurantName(restaurantName = us.getRestaurantName());
//        pbl = new Pbkdf2PasswordHashImpl();
//        String pass = pbl.generate(us.getPassword().toCharArray());
        this.setPassword(us.getPassword());
        this.setStatus(status = us.getStatus());
        this.setApproved(approved = us.getApproved());
        this.setRoleID(roleID = us.getRoleID().getRoleID());
        
        return "checkout.jsf";
    }
    public String updateMyUser() {
        //session.getAttribute("id").toString()
        int id = Integer.parseInt((String) session.getAttribute("id"));
        System.err.println("Data ");
        us = (User) client.getUserOfID(id);
        System.err.println("User "+session.getAttribute("id"));
//        this.setUserID(userID = (int) session.getAttribute("id"));
        this.setUserName(userName = us.getUserName());
        System.err.println("UserName "+us.getUserName());
        this.setMobileNo(mobileNo = us.getMobileNo());
        this.setEmailID(emailID = us.getEmailID());
        this.setAddress(address = us.getAddress());
        this.setImage(image = us.getImage());
        this.setUserImage(userImage=us.getUserImage());
        this.setCity(city= us.getCity());
        this.setRestaurantName(restaurantName = us.getRestaurantName());
//        pbl = new Pbkdf2PasswordHashImpl();
//        String pass = pbl.generate(us.getPassword().toCharArray());
        this.setPassword(us.getPassword());
        this.setStatus(status = us.getStatus());
        this.setApproved(approved = us.getApproved());
        this.setRoleID(roleID = us.getRoleID().getRoleID());
        
        return "contact.jsf";
    }
    public String editCartUser() throws IOException {
        int id = Integer.parseInt((String) session.getAttribute("id"));
        
        us = (User) client.getUserOfID(id);
        System.err.println("CartUser "+session.getAttribute("id"));
        this.setUserID(userID = (int) session.getAttribute("id"));
        this.setUserName(userName = us.getUserName());
        System.err.println("CartUserName "+us.getUserName());
        this.setMobileNo(mobileNo = us.getMobileNo());
        this.setEmailID(emailID = us.getEmailID());
        this.setAddress(address = us.getAddress());
        this.setCity(city= us.getCity());
        this.setRestaurantName(restaurantName = us.getRestaurantName());
//        pbl = new Pbkdf2PasswordHashImpl();
//        String pass = pbl.generate(us.getPassword().toCharArray());
        this.setPassword(us.getPassword());
        this.setStatus(status = us.getStatus());
//        this.setAddress(address = us.getAddress());
        this.setApproved(approved = us.getApproved());
        this.setRoleID(roleID = us.getRoleID().getRoleID());
         this.setImage(image = us.getImage());
            this.setUserImage(userImage = us.getUserName());
        User u = new User();
        u.setUserID((int) session.getAttribute("id"));
        u.setUserName(userName);
        System.err.println(userName+" = Name");
        u.setMobileNo(mobileNo);
        u.setEmailID(emailID);
        u.setImage(image);
        u.setUserImage(userImage);
        u.setCity(us.getCity());
        u.setRestaurantName(us.getRestaurantName());
        u.setAddress(address);
        u.setPassword(us.getPassword());
        u.setStatus(us.getStatus());
        u.setApproved(1);
        
        Role r = new Role();      
//        if(us.getRoleID().getRoleID()==2){
//            r.setRoleID(2);
//        }else if(us.getRoleID().getRoleID()==3){
//            r.setRoleID(3);
//        }else if(us.getRoleID().getRoleID()==4){
//            r.setRoleID(4);
//        }
        r.setRoleID(3);
        u.setRoleID(r);

//        if(userID == 0) {
//        } else {
//            System.err.println("error:-"+u.getUserID());
            client.UpdateUser(id, u);
//        }
      
//        ExternalContext context1 = FacesContext.getCurrentInstance().getExternalContext();
//        context1.redirect(context1.getRequestContextPath() + "/codenpixel.com/demo/foodpicky/profile.jsf");

        return null;
    
    }
    public String deleteUser(int uid) {
        client.RemoveUser(uid);
        return "UserForm";
    }
    public String addUser() {
        return "UserForm";
    }
    
    public void calluser() throws IOException{
        ExternalContext context1 = FacesContext.getCurrentInstance().getExternalContext();
        context1.redirect(context1.getRequestContextPath() + "/codenpixel.com/demo/foodpicky/contact.jsf");
    }
    public Collection<User> getAllDealers(){
        userList = (ArrayList<User>) client.getUsersOfDealer();
        return userList;
    }
    
    public void setAllDealers(Collection<User> userList) {
        this.userList = userList;
    }
    
    public Collection<User> getAllVendors(){
        userList = (ArrayList<User>) client.getUsersOfVendor();
        return userList;
    }
    
    public void setAllVendors(Collection<User> userList) {
        this.userList = userList;
    }
    
    public Collection<User> getAllCustomers(){
        userList = (ArrayList<User>) client.getUsersOfCustomer();
        return userList;
    }
    
    public void setAllCustomers(Collection<User> userList) {
        this.userList = userList;
    }
    
     public String activeData(int uID) {
        us = (User) client.getUserOfID(uID);
        
        this.setUserID(userID = us.getUserID());
        this.setUserName(userName = us.getUserName());
        this.setMobileNo(mobileNo = us.getMobileNo());
        this.setEmailID(emailID = us.getEmailID());
        this.setAddress(address = us.getAddress());
        this.setImage(image= us.getImage());
        this.setUserImage(userImage=us.getUserImage());
        this.setCity(city= us.getCity());
        this.setRestaurantName(restaurantName = us.getRestaurantName());
        
        //pbl = new Pbkdf2PasswordHashImpl();
        this.setPassword(password = us.getPassword());
        this.setStatus(status = us.getStatus());
        this.setApproved(approved = us.getApproved());
        this.setRoleID(us.getRoleID().getRoleID());
        
        User u = new User();
        u.setUserID(userID);
        u.setUserName(userName);
        u.setMobileNo(mobileNo);
        u.setEmailID(emailID);
        u.setCity(city);
        u.setRestaurantName(restaurantName);
        u.setUserImage(userImage);
        u.setImage(image);
        u.setAddress(address);
        u.setPassword(password);
        u.setStatus(status);
        u.setApproved(1);
        
        Role r = new Role();      
        if(us.getRoleID().getRoleID()==2){
            r.setRoleID(2);
        }else if(us.getRoleID().getRoleID()==3){
            r.setRoleID(3);
        }else if(us.getRoleID().getRoleID()==4){
            r.setRoleID(4);
        }

        u.setRoleID(r);
        if(userID == 0) {
        } else {
            System.err.println("error:-"+u.getUserID());
            client.UpdateUser(userID, u);
        }
      
        if(us.getRoleID().getRoleID()==2){
            return "ViewVendor.jsf";
        }else if(us.getRoleID().getRoleID()==4){
            return "ViewDealer.jsf";
        }else if(us.getRoleID().getRoleID()==3){
            return "ViewCustomers.jsf";
        }
      return null;
     }
     
      public String blockData(int uID) {
        us = (User) client.getUserOfID(uID);
        
        this.setUserID(userID = us.getUserID());
        this.setUserName(userName = us.getUserName());
        this.setMobileNo(mobileNo = us.getMobileNo());
        this.setEmailID(emailID = us.getEmailID());
        this.setImage(image=us.getImage());
        this.setUserImage(userImage=us.getUserImage());
        //this.setUserPic(image1= us.getUserImage());
        this.setCity(city= us.getCity());
        this.setRestaurantName(restaurantName = us.getRestaurantName());
        this.setAddress(address = us.getAddress());
        //pbl = new Pbkdf2PasswordHashImpl();
        //String pass = us.getPassword();
        this.setPassword(password=us.getPassword());
        this.setStatus(status = us.getStatus());
        this.setApproved(approved = us.getApproved());
        this.setRoleID(us.getRoleID().getRoleID());
        
        User u = new User();
        u.setUserID(userID);
        u.setUserName(userName);
        u.setMobileNo(mobileNo);
        u.setEmailID(emailID);
        u.setCity(city);
        u.setImage(image);
        u.setUserImage(userImage);
        u.setRestaurantName(restaurantName);

        //pbl = new Pbkdf2PasswordHashImpl();
        //String pass2 = pbl.generate(password.toCharArray());
        //this.setPassword(pass);
        u.setAddress(address);
        u.setPassword(password);
        u.setStatus(status);
        u.setApproved(0);
        
        Role r = new Role(); 
        if(us.getRoleID().getRoleID()==2){
            r.setRoleID(2);
        }else if(us.getRoleID().getRoleID()==3){
            r.setRoleID(3);
        }else if(us.getRoleID().getRoleID()==4){
            r.setRoleID(4);
        }

        u.setRoleID(r);
        if(userID == 0) {
        } else {
            System.err.println("error:-"+u.getUserID());
            client.UpdateUser(userID, u);
        }
        if(us.getRoleID().getRoleID()==2){
            return "ViewVendor.jsf";
        }else if(us.getRoleID().getRoleID()==4){
            return "ViewDealer.jsf";
        }else if(us.getRoleID().getRoleID()==3){
            return "ViewCustomers.jsf";
        }      
            
      return null;
     }
    @NotNull(message = "Image Is Required!")    
    private Part UploadedFile;
    @NotNull(message = "Image Is Required!")    
    private Part userPic;
//   private String folder = "/home/jigar/Food Management System/Tep-13/JWT/web/slidesigma.com/themes/html/costic/pages/Image";
    String folder = "F:\\SEM 9\\Practical\\Food_Managment_System\\uiAPP\\src\\main\\webapp\\slidesigma.com\\themes\\html\\costic\\pages\\Image";
    
    public Part getUploadedFile()
    {
        return UploadedFile;
    }
    public void setUploadedFile(Part UploadedFile)
    {
        this.UploadedFile = UploadedFile;
    }

    public Part getUserPic() {
        return userPic;
    }

    public void setUserPic(Part userPic) {
        this.userPic = userPic;
    }
    
    
    //New 
    public String search123(String ss) throws IOException 
    {
        System.err.println(session.getAttribute("id").toString()); 
        if(ss.equals("Chosen")){
            return "index.jsf";
        }else{
        User u = new User();
        u.setCity(ss);
        session.setAttribute("city", ss);
//        setTemp(city);
        System.err.println("search called");
        ExternalContext context1 = FacesContext.getCurrentInstance().getExternalContext();
//        context1.redirect(context1.getRequestContextPath() + "/codenpixel.com/demo/foodpicky/restaurants.jsf?city="+u.getCity());
        context1.redirect(context1.getRequestContextPath() + "/codenpixel.com/demo/foodpicky/ViewRestaurants.jsf");
      
//        return "restaurants.jsf";
        }
        
        return null;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }
    
    public String activeStatus() throws IOException {
        //int on=1;
        //System.err.println("on/off:-"+on1);
//        if(on.booleanValue()==true){
            int id = Integer.parseInt((String) session.getAttribute("id"));
            us = (User) client.getUserOfID(id);

            this.setUserID(userID = us.getUserID());
            this.setUserName(userName = us.getUserName());
            this.setMobileNo(mobileNo = us.getMobileNo());
            this.setEmailID(emailID = us.getEmailID());
            this.setAddress(address = us.getAddress());
            this.setImage(image= us.getImage());
            this.setCity(city= us.getCity());
            this.setRestaurantName(restaurantName = us.getRestaurantName());
            this.setUserImage(userImage=us.getUserImage());
            
            //on=1;
            //pbl = new Pbkdf2PasswordHashImpl();
            this.setPassword(password = us.getPassword());
            this.setStatus(status = us.getStatus());
            this.setOn(on=1);
            this.setApproved(approved = us.getApproved());
            this.setRoleID(us.getRoleID().getRoleID());

            User u = new User();
            u.setUserID(userID);
            u.setUserName(userName);
            u.setMobileNo(mobileNo);
            u.setEmailID(emailID);
            u.setCity(city);
            u.setRestaurantName(restaurantName);
            u.setImage(image);
            u.setUserImage(userImage);
            u.setAddress(address);
            u.setPassword(password);
            u.setStatus(1);
            u.setApproved(approved);
            session.setAttribute("on", 1);
            Role r = new Role();      
            if(us.getRoleID().getRoleID()==2){
                r.setRoleID(2);
            }else if(us.getRoleID().getRoleID()==3){
                r.setRoleID(3);
            }else if(us.getRoleID().getRoleID()==4){
                r.setRoleID(4);
            }

            u.setRoleID(r);
            if(userID == 0) {
            } else {
                System.err.println("error:-"+u.getUserID());
                client.UpdateUser(userID, u);
            }
            return null;
//           ExternalContext context1 = FacesContext.getCurrentInstance().getExternalContext();
//           context1.redirect(context1.getRequestContextPath() + "/slidesigma.com/themes/html/costic/pages/Vendor/Dashboard.jsf");
    }
    public String deActiveStatus() throws IOException {
        System.err.println("UserID:-");    
            int id = Integer.parseInt((String) session.getAttribute("id"));
            us = (User) client.getUserOfID(id);
            
            this.setUserID(userID = us.getUserID());
            
            this.setUserName(userName = us.getUserName());
            this.setMobileNo(mobileNo = us.getMobileNo());
            this.setEmailID(emailID = us.getEmailID());
            this.setAddress(address = us.getAddress());
            this.setImage(image= us.getImage());
            this.setCity(city= us.getCity());
            this.setRestaurantName(restaurantName = us.getRestaurantName());
            this.setUserImage(userImage=us.getUserImage());
            //on=1;
            //pbl = new Pbkdf2PasswordHashImpl();
            this.setPassword(password = us.getPassword());
            this.setStatus(status = us.getStatus());
            this.setOn(on=0);
            this.setApproved(approved = us.getApproved());
            this.setRoleID(us.getRoleID().getRoleID());

            User u = new User();
            u.setUserID(userID);
            u.setUserName(userName);
            u.setMobileNo(mobileNo);
            u.setEmailID(emailID);
            u.setCity(city);
            u.setRestaurantName(restaurantName);
            u.setImage(image);
            u.setUserImage(userImage);
            u.setAddress(address);
            u.setPassword(password);
            u.setStatus(0);
            u.setApproved(approved);

            Role r = new Role();      
            if(us.getRoleID().getRoleID()==2){
                r.setRoleID(2);
            }else if(us.getRoleID().getRoleID()==3){
                r.setRoleID(3);
            }else if(us.getRoleID().getRoleID()==4){
                r.setRoleID(4);
            }

            u.setRoleID(r);
            if(userID == 0) {
            } else {
                System.err.println("error:-"+u.getUserID());
                client.UpdateUser(userID, u);
            }
            return null;
//           ExternalContext context1 = FacesContext.getCurrentInstance().getExternalContext();
//           context1.redirect(context1.getRequestContextPath() + "/slidesigma.com/themes/html/costic/pages/Vendor/Dashboard.jsf");
    }
}
