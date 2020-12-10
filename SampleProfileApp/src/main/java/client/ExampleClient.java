/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import Entity.Role;
import java.util.Collection;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 *
 * @author admin
 */
@RegisterRestClient(baseUri = "http://localhost:8080/SampleProfileApp/rest/example")
@ClientHeaderParam(name = "X-Application-Name",value = "Food-Manage-APP")
public interface ExampleClient {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    String get();
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    void addRole(String roleName);
//    void updateCategory(int CategoryID,String CategoryName);
//    void removeCategory(int CategoryID);
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Collection<Role> getAllRoles();
//    Category getCategoryOfID(int CategoryID);
}
