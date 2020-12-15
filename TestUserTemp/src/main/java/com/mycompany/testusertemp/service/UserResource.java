package com.mycompany.testusertemp.service;

import Entity.User;
import java.util.Collection;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.UserService;

@Path("/user")
public class UserResource {

    @Inject UserService userService;
    
    @GET
    @Path("getUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @POST
    @Path("registerUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addUser(User u){
        userService.addUser(u.getUserName(),u.getMobileNo(),u.getEmailID(),u.getAddress(),u.getPassword(),u.getRestaurantName(),u.getCity(),u.getStatus(),u.getApproved(),u.getRoleID().getRoleID(),u.getImage(),u.getUserImage());
    }

}
