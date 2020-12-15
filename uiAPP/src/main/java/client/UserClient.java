/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.Collection;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.User;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
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
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<User> getAllUsers();
    
    @POST
    @Path("registerUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addUser(User u);
    
}
