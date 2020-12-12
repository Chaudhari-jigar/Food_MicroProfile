package com.mycompany.testcategorytemp.service;

import Entity.Category;
import java.util.Collection;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.CategoryService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Path("/category")
@ApplicationScoped
public class CategoryResource {

@Inject CategoryService categoryService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Category> getAllCategorys() {
        return categoryService.getAllCategorys();
    }

}
