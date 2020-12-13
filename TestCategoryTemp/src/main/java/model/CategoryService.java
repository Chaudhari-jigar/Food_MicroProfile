/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Entity.Category;
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
public class CategoryService{
     EntityManager em;
    Collection<Category> categorys;
    Collection<Category> AllCategorys;

    public CategoryService() {
        em = Persistence.createEntityManagerFactory("MyPU").createEntityManager();
    }

    
    public Collection<Category> getCategorys() {
        return categorys;
    }

    public void setCategorys(Collection<Category> categorys) {
        this.categorys = categorys;
    }

    public Collection<Category> getAllCategorys() {
        em = Persistence.createEntityManagerFactory("MyPU").createEntityManager();
        return em.createNamedQuery("Category.findAll").getResultList();
    }

    public void setAllCategorys(Collection<Category> AllCategorys) {
        this.AllCategorys = AllCategorys;
    }

    public void addCategory(String cat1) {
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();
        Category c = new Category();
        c.setCategoryName(cat1);
        em.persist(c);
        em.getTransaction().commit();
    }
    
    public void removeCategory(int id){
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();
        Category c = (Category) em.find(Category.class, id);
        em.remove(c);
        em.getTransaction().commit();
    }
    
    public void updateCategory(int CategoryID, String CategoryName) {
         EntityTransaction entityTransaction = em.getTransaction();
         entityTransaction.begin();
         Category c = (Category)em.find(Category.class, CategoryID);
         c.setCategoryName(CategoryName);
         em.merge(c);
         em.getTransaction().commit();
    }

}

