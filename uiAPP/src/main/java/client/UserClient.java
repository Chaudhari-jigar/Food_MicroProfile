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
import model.User;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import token.GenerateToken;

/**
 *
 * @author admin
 */
@RegisterRestClient(baseUri = "http://localhost:8080/TestUserTemp/rest")
@ApplicationScoped
@Path("/user")
public interface UserClient {
    @GET
    @Path("getUser")
    @ClientHeaderParam(name="authorization", value="{generateJWTToken}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<User> getAllUsers();
    
    @POST
    @Path("registerUser")
    @ClientHeaderParam(name="authorization", value="{generateJWTToken}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addUser(User u);
    
    @PUT
    @Path("User/{Userid}")
    @ClientHeaderParam(name="authorization", value="{generateJWTToken}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void UpdateUser(@PathParam("Userid") int UserID,User u);
    
    @DELETE
    @Path("User/{Userid}")
    @ClientHeaderParam(name="authorization", value="{generateJWTToken}")
    public void RemoveUser(@PathParam("Userid") int UserID);
    
    @GET
    @Path("Users/{Userid}")
    @ClientHeaderParam(name="authorization", value="{generateJWTToken}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserOfID(@PathParam("Userid") int UserID);

    @GET
    @Path("Usersdsds/{user}")
    @ClientHeaderParam(name="authorization", value="{generateJWTToken}")
    @Produces(MediaType.APPLICATION_JSON)
    public User ReturnUserID(@PathParam("user") String user);
    
     @GET
    @Path("Users")
     @ClientHeaderParam(name="authorization", value="{generateJWTToken}")
    @Produces(MediaType.APPLICATION_JSON)
    public  Collection<User> getUsersOfCustomer();
    
    @GET
    @Path("Usersa")
    @ClientHeaderParam(name="authorization", value="{generateJWTToken}")
    @Produces(MediaType.APPLICATION_JSON)
    public  Collection<User> getUsersOfDealer();
    
    @GET
    @Path("Usersads")
    @ClientHeaderParam(name="authorization", value="{generateJWTToken}")
    @Produces(MediaType.APPLICATION_JSON)
    public  Collection<User> getUsersOfVendor();
    
    
    @GET
    @Path("userVlive")
    @ClientHeaderParam(name="authorization", value="{generateJWTToken}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<User> getAllLiveVendor();
    
    @GET
    @Path("userDlive")
    @ClientHeaderParam(name="authorization", value="{generateJWTToken}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<User> getAllLiveDealer();
    
    @GET
    @Path("CityVendor/{City}")
    @ClientHeaderParam(name="authorization", value="{generateJWTToken}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<User> getVendorCity(@PathParam("City") String City);
    
    default String generateJWTToken() {
        
        Config config = ConfigProvider.getConfig();
         String token ="Bearer "+ GenerateToken.generateJWT();
       System.out.println("Product Token = "+token);
        return token;
    }
}
