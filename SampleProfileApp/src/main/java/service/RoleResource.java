/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Entity.Role;
import client.ExampleClient;
import java.util.Collection;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.rest.client.inject.RestClient;
/**
 *
 * @author admin
 */
@Path("/role")
public class RoleResource {
    
    @Inject Role role;
    
@Inject @RestClient ExampleClient exampleclient;
@Inject JsonWebToken token;


}
