package com.mycompany.sampleprofileapp.service;

import Entity.Role;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/example")
public class ExampleService {
//    @PersistenceContext(unitName = "MyPU1")
    EntityManager em;
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get(@HeaderParam("X-Application-Name") String Application) {
         return "Hello Micro Profile based Micro Service Application Kishan Modi "+Application;
//        return "Hello Micro Profile based Micro Service Application Kishan Modi "+ token.getName()+"Roles:- = "+token.getGroups();
    }
     
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Role> getAllRoles() {
        Collection<Role> r = em.createNamedQuery("Role.findAll").getResultList();
        return r;
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void addRole(String roleName) {
         Role c = new Role();
         c.setRoleName(roleName);
         em.persist(c);
    }

//    public void updateCategory(int CategoryID, String CategoryName) {
//         Category c = (Category)em.find(Category.class, CategoryID);
//         c.setCategoryName(CategoryName);
//         em.merge(c);
//    }
//
//
//    public void removeCategory(int CategoryID) {
//        Category c = (Category) em.find(Category.class, CategoryID);
//        em.remove(c);
//    }
//
//    public Collection<Category> getAllCategorys() {
//        return em.createNamedQuery("Category.findAll").getResultList();
//    }
//
//
//    public Category getCategoryOfID(int CategoryID) {
//        Category c =(Category)em.find(Category.class,CategoryID);
//        return c;
//    }    
}
