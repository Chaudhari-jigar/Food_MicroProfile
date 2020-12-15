/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Entity.Role;
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
public class UserService {
    EntityManager em;
    Collection<User> AllUsers;
    
    private int userID;
    private String userName;
    private String mobileNo;
    private String emailID;
    private String address;
    private String city;
    private String restaurantName;
    private String password;
    private int status;
    private int approved;
    private Role role;
    
    private String image,userImage;
    private String image1;
   
    private int roleID;
    private static int on;
    private String roleName;

    public UserService() {
        em = Persistence.createEntityManagerFactory("MyPU2").createEntityManager();
    }

    public Collection<User> getAllUsers() {
        return em.createNamedQuery("User.findAll").getResultList();
    }

    public void setAllUsers(Collection<User> AllUsers) {
        this.AllUsers = AllUsers;
    }
    
    public void addUser(String UserName,String MobileNo, String EmailID, String Address, String Password,String RestaurantName,String City, int Status, int Approved, int RoleID,String image,String userImage) {
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();
        Role r =(Role)em.find(Role.class, RoleID);
        User u = new User();
        u.setUserName(UserName);
        u.setMobileNo(MobileNo);
        u.setEmailID(EmailID);
        u.setAddress(Address);
        u.setPassword(Password);
        u.setRestaurantName(RestaurantName);
        u.setImage(image);
        u.setUserImage(userImage);
        u.setCity(City);
        u.setStatus(Status);
        u.setApproved(Approved);
        u.setRoleID(r);
        em.persist(u);
        em.getTransaction().commit();
    }
    
}
