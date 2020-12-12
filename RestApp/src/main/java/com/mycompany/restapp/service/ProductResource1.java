package com.mycompany.restapp.service;

import com.mycompany.restapp.entity.Product;
import com.mycompany.restapp.model.ProductService1;
import java.util.Collection;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/product")
public class ProductResource1 {
    
@Inject ProductService1 product;
    
//@Inject @RestClient StockClient stockclient;
@Inject JsonWebToken token;

    @GET
    @RolesAllowed("Admin")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Product> getProducts() {
        System.out.println("Recieved Raw Token in Product "+ token.getRawToken());
//        RawToken.setRtoken(token.getRawToken());
        System.out.println("Entered in product Resource..");
//        Collection<Integer> allids = stockclient.getAvailableProductIds();
        return product.getProducts();
    }
}
