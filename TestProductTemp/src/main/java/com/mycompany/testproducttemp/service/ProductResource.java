package com.mycompany.testproducttemp.service;

import Entity.Product;
import java.util.Collection;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.ProductService;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/product")
@ApplicationScoped
public class ProductResource {
    
@Inject ProductService productService;
@Inject JsonWebToken token;

    @GET
    @Path("getProduct")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Product> getAllProducts() {
         System.out.println("Recieved Raw Token in Category "+ token.getRawToken());
        RawToken.setRtoken(token.getRawToken());
        return productService.getAllProducts();
    }
    
    @POST
    @Path("addProduct")
    @RolesAllowed("Vendor")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addProduct(Product p){
         System.out.println("Recieved Raw Token in Category "+ token.getRawToken());
        RawToken.setRtoken(token.getRawToken());
        productService.addProduct(p.getProductName(),p.getDescription(),p.getPrice(),p.getImage(),p.getCategoryID().getCategoryID(),p.getVendorID());
    }
    
    @PUT
    @Path("updateProduct/{Productid}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateProduct(@PathParam("Productid") int ProductID,Product p){
        productService.updateProduct(ProductID,p.getProductName(),p.getDescription(),p.getPrice(),p.getImage(),p.getCategoryID().getCategoryID(),p.getVendorID());
    }
    
    @DELETE
    @Path("removeProduct/{id}")
    public void removeProduct(@PathParam("id") int ProductID){
        productService.removeProduct(ProductID);
    }
    
    @GET
    @Path("getProductOfID/{Productid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProductOfID(@PathParam("Productid")int Productid){
       return productService.getProductOfID(Productid);
    }

}
