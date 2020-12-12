package com.mycompany.sampleprofileapp.service;

import Entity.Role;
import java.util.Collection;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import myproject.SampleProfileApp.model.RoleService;

@Path("/example")
public class RoleResource {
    @Inject RoleService roles;
    @GET    
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Role> getAllRoles(){
        return roles.getAllRoles();
    }  
}
