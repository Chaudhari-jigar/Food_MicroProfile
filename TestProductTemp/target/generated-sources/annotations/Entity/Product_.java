package Entity;

import Entity.Category;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-15T10:54:34")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, String> image;
    public static volatile SingularAttribute<Product, Integer> productID;
    public static volatile SingularAttribute<Product, Float> price;
    public static volatile SingularAttribute<Product, String> description;
    public static volatile SingularAttribute<Product, Integer> vendorID;
    public static volatile SingularAttribute<Product, String> productName;
    public static volatile SingularAttribute<Product, Category> categoryID;

}