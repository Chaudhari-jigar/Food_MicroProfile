package Entity;

import Entity.Role;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-15T10:54:33")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> image;
    public static volatile SingularAttribute<User, String> address;
    public static volatile SingularAttribute<User, String> city;
    public static volatile SingularAttribute<User, Role> roleID;
    public static volatile SingularAttribute<User, String> emailID;
    public static volatile SingularAttribute<User, String> mobileNo;
    public static volatile SingularAttribute<User, String> userName;
    public static volatile SingularAttribute<User, Integer> userID;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, Integer> approved;
    public static volatile SingularAttribute<User, String> userImage;
    public static volatile SingularAttribute<User, String> restaurantName;
    public static volatile SingularAttribute<User, Integer> status;

}