package com.mycompany.sampleprofileapp.service;

import Entity.Role;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/example")
public class ExampleService {
//    @Inject 
    EntityManager em;
    @GET    
    @Path("Test")
    @Produces(MediaType.TEXT_PLAIN)
    public String get(@HeaderParam("X-Application-Name") String Application) {
         return "Hello Micro Profile based Micro Service Application Kishan Modi "+Application;
//        return "Hello Micro Profile based Micro Service Application Kishan Modi "+ token.getName()+"Roles:- = "+token.getGroups();
    }  
}
