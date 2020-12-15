/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author admin
 */
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "jdbc/mysql",
        callerQuery = "select password from user where username = ?",
        groupsQuery = "select RoleName from user u,role r where u.RoleID=r.RoleID and UserName = ?",
        hashAlgorithm = Pbkdf2PasswordHash.class,
        priority = 30)
@ApplicationScoped
public class Project {
    public Project() {
        System.out.println("Project Config Initialized");
    }
    
}
