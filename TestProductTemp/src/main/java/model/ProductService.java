/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Entity.Category;
import Entity.Product;
import Entity.User;
import java.util.Collection;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author admin
 */
@Named
@ApplicationScoped
public class ProductService {
    EntityManager em;
    Collection<Product> products;
    Collection<Product> AllProducts;
    
    private int ProductID;
    private String ProductName;
    private String Description;
    private float Price;
    private String Image;
    private Category Categorys;
    private Category CategoryIDs;
    private String ImageTemp;
    private int VendorID;

    private String Address;
        
    private int CategoryID;
    private String CategoryName;
    private String City;
    
    public ProductService() {
        em = Persistence.createEntityManagerFactory("MyPU1").createEntityManager();
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Category getCategoryIDs() {
        return CategoryIDs;
    }

    public void setCategoryIDs(Category CategoryIDs) {
        this.CategoryIDs = CategoryIDs;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public Category getCategorys() {
        return Categorys;
    }

    public void setCategorys(Category Categorys) {
        this.Categorys = Categorys;
    }

    public String getImageTemp() {
        return ImageTemp;
    }

    public void setImageTemp(String ImageTemp) {
        this.ImageTemp = ImageTemp;
    }

    public int getVendorID() {
        return VendorID;
    }

    public void setVendorID(int VendorID) {
        this.VendorID = VendorID;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int CategoryID) {
        this.CategoryID = CategoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    
    
    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    public Collection<Product> getAllProducts() {
        return em.createNamedQuery("Product.findAll").getResultList();
    }

    public void setAllProducts(Collection<Product> AllProducts) {
        this.AllProducts = AllProducts;
    }
    
    public void addProduct(String ProductName,String Description,Float Price,String Image,int CategoryID,int VendorID) {
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();
        Category c = (Category)em.find(Category.class, CategoryID);
        Product p = new Product();
        User u = (User) em.find(User.class, VendorID);
        p.setProductName(ProductName);
        p.setDescription(Description);
        p.setPrice(Price);
        p.setImage(Image);
        p.setCategoryID(c);
        p.setVendorID(u.getUserID());
        em.persist(p);
        em.getTransaction().commit();
    }
    

    public void updateProduct(int ProductID,String ProductName,String Description,Float Price,String Image,int CategoryID,int VendorID) {
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();
        Category c = (Category)em.find(Category.class, CategoryID);
        Product p = (Product)em.find(Product.class, ProductID);
        User u = (User) em.find(User.class, VendorID);
        p.setProductName(ProductName);
        p.setDescription(Description);
        p.setPrice(Price);
        p.setImage(Image);
        p.setCategoryID(c);
        p.setVendorID(u.getUserID());
        em.merge(p);   
        em.getTransaction().commit();
    }

    public void removeProduct(int ProductID) {
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();
        Product p = (Product)em.find(Product.class, ProductID);
        em.remove(p);
        em.getTransaction().commit();
    }
}
