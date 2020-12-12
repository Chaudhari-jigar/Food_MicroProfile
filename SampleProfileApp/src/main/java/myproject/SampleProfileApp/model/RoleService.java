/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject.SampleProfileApp.model;

import Entity.Role;
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
public class RoleService {
    EntityManager em;
    Collection<Role> Roles;
    
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    
    public RoleService() {
        em = Persistence.createEntityManagerFactory("MyPU1").createEntityManager();
    }

    public Collection<Role> getAllRoles() {
               
        return em.createNamedQuery("Role.findAll").getResultList();
    }

    public void setProducts(Collection<Role> roles) {
        
        this.Roles= roles;
    }
}
