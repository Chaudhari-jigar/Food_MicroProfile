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
import model.Product;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 *
 * @author admin
 */
@RegisterRestClient(baseUri = "http://localhost:8080/TestProductTemp/rest")
@ApplicationScoped
@Path("/product")
public interface ProductClient {
    @GET
    @Path("getProduct")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Product> getAllProducts();
    
    @POST
    @Path("addProduct")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addProduct(Product p);
    
    @PUT
    @Path("updateProduct/{Productid}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateProduct(@PathParam("Productid") int ProductID,Product p);
    
    @DELETE
    @Path("removeProduct/{id}")
    public void removeProduct(@PathParam("id") int ProductID);
    
    @GET
    @Path("getProductOfID/{Productid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProductOfID(@PathParam("Productid")int Productid);
}
