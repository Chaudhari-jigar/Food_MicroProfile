/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.Collection;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Category;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import token.GenerateToken;

/**
 *
 * @author admin
 */
@RegisterRestClient(baseUri = "http://localhost:8080/TestCategoryTemp/rest")
@ApplicationScoped
@Path("/category")
public interface CategoryClient {
    
    @GET
    @Path("getCategory")
    @ClientHeaderParam(name="authorization", value="{generateJWTToken}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Category> getAllCategorys();
    
    @POST
    @Path("addCategory")
    @ClientHeaderParam(name="authorization", value="{generateJWTToken}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addCategory(Category cat);
    
    @PUT
    @Path("updateCategory/{Categoryid}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void editCategoey(@PathParam("Categoryid") int CategoryID,Category c);
            
    @DELETE
    @Path("deleteCategory/{Categoryid}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteCategory(@PathParam("Categoryid") int CategoryID);
    
    @GET
    @Path("getCategoryOfID/{Categoryid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Category getCategoryOfID(@PathParam("Categoryid")int cat);
    
    default String generateJWTToken() {
        
        Config config = ConfigProvider.getConfig();
         String token ="Bearer "+ GenerateToken.generateJWT();
       System.out.println("Product Token = "+token);
        return token;
    }
}
