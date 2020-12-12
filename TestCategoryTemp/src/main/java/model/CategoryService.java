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

    public CategoryService(EntityManager em) {
        em = Persistence.createEntityManagerFactory("categorypu").createEntityManager();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Collection<Category> getCategorys() {
        return categorys;
    }

    public void setCategorys(Collection<Category> categorys) {
        this.categorys = categorys;
    }

    public Collection<Category> getAllCategorys() {
        return em.createNamedQuery("Category.findAll").getResultList();
    }

    public void setAllCategorys(Collection<Category> AllCategorys) {
        this.AllCategorys = AllCategorys;
    }
    

}

