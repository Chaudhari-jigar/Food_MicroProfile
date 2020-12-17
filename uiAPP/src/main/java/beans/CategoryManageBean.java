/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import client.CategoryClient;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import model.Category;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 *
 * @author dell
 */
@Named(value = "categoryManageBean")
@RequestScoped
public class CategoryManageBean implements Serializable{

    Category cat;
    Collection<Category> categoryList;
    @Inject @RestClient CategoryClient categoryclient;
    private int categoryID;
    @NotNull(message = "Name Is Required!") 
    @Pattern(regexp = "^[A-Za-z_ ]+$",message = "Please Enter Correct Name")
    private String categoryName;
//    
//    HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//
//   HttpSession session = req.getSession();
//   String username = (String)session.getAttribute("username");
//   String password = (String)session.getAttribute("password");
//        
    public CategoryManageBean() {
//        System.out.println("Hello CategoryManageBean Bean ");
//        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//        String token="";
//
//        token = request.getSession().getAttribute("token").toString();
//       System.out.println("Token="+token);
//        
        categoryList = new ArrayList<Category>();
    }
    public void defaultLogin() throws IOException{
        ExternalContext context32 = FacesContext.getCurrentInstance().getExternalContext();
        context32.redirect(context32.getRequestContextPath() + "/slidesigma.com/themes/html/costic/pages/LoginPage.jsf");
    }
    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category getSingle(int cid) {
        cat = (Category) categoryclient.getCategoryOfID(cid);
        return cat;
    }
    
    public Collection<Category> getCategoryList() {
        categoryList = (ArrayList<Category>) categoryclient.getAllCategorys();
        return categoryList;
    }

    public void setCategoryList(Collection<Category> categoryList) {
        this.categoryList = categoryList;
    }
    
    public String submit() {
        System.out.println("hellow world"+categoryName);
        Category c = new Category();
        
        c.setCategoryName(categoryName);
        System.out.println(c.getCategoryName());
        if(categoryID == 0) {
            categoryclient.addCategory(c);
            System.out.println(c);
//            
        } else {
            categoryclient.editCategoey(categoryID, c);
        }
        return "ViewCategory";
    }
    public String editCategory(int cid) {   
        cat = (Category) categoryclient.getCategoryOfID(cid);
        this.setCategoryID(categoryID = cat.getCategoryID());
        this.setCategoryName(categoryName = cat.getCategoryName());   
        return "UpdateCategory";
    }
    public String deleteCategory(int did) {
        categoryclient.deleteCategory(did);
        return "ViewCategory";
    }
    public String addCategory() {
        return "Category";
    }
    
    public void logOutsd() throws IOException {
        FacesContext context34 = FacesContext.getCurrentInstance();
        
        HttpServletRequest req1 = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session12 = req1.getSession();
        session12.removeAttribute("role");
        session12.removeAttribute("user");
        session12.removeAttribute("pass");
        session12.removeAttribute("Category");
        session12.removeAttribute("Vendor");
        session12.removeAttribute("cnt");
        session12.removeAttribute("on");
        req1.getSession().invalidate();
        
        ExternalContext context2 = FacesContext.getCurrentInstance().getExternalContext();
        context2.redirect(context2.getRequestContextPath() + "/slidesigma.com/themes/html/costic/pages/LoginPage.jsf");
    }
}
