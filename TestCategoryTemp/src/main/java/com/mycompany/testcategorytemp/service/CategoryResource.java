package com.mycompany.testcategorytemp.service;

import Entity.Category;
import java.util.Collection;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.CategoryService;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/category")
@ApplicationScoped
public class CategoryResource {
    
@Inject CategoryService categoryService;
    @Inject JsonWebToken token;
    
    @GET
    @Path("getCategory")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Category> getAllCategorys() {
        System.out.println("Recieved Raw Token in Category "+ token.getRawToken());
        RawToken.setRtoken(token.getRawToken());
        System.out.println("Entered in Category Resource..");
        return categoryService.getAllCategorys();
    }
    
    @POST
    @RolesAllowed("Admin")
    @Path("addCategory")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addCategory(Category cat){
        System.out.println("Recieved Raw Token in Category "+ token.getRawToken());
        RawToken.setRtoken(token.getRawToken());
        System.out.println("Entered in Category Resource..");
        categoryService.addCategory(cat.getCategoryName());
    }
    
    @PUT
    @Path("updateCategory/{Categoryid}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void editCategoey(@PathParam("Categoryid") int CategoryID,Category c){
        categoryService.updateCategory(CategoryID, c.getCategoryName());
    }
    
    @DELETE
    @Path("deleteCategory/{Categoryid}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteCategory(@PathParam("Categoryid") int CategoryID){
        categoryService.removeCategory(CategoryID);
    }
    //wait
    @GET
    @Path("getCategoryOfID/{Categoryid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Category getCategoryOfID(@PathParam("Categoryid")int cat) {
        return categoryService.getCategoryOfID(cat);
    }
}
