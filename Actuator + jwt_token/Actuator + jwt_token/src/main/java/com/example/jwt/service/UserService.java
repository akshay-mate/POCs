package com.example.jwt.service;

import com.example.jwt.dao.RoleDao;
import com.example.jwt.dao.UserDao;
import com.example.jwt.entity.Role;
import com.example.jwt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
@Autowired
    private UserDao userDao;
@Autowired
private RoleDao roleDao;

@Autowired
 private PasswordEncoder passwordEncoder;

    public User registerNewUser(User user) {


        //register user manully to avoid hardcode
      Role role = roleDao.findById("User").get();
      Set<Role> roles = new HashSet<>();
      roles.add(role);
      user.setRoles(roles);
      user.setUserPassword( getEncodedPassword(user.getUserPassword()));


        return userDao.save(user);
    }

    /* for the everytime we restart app then all table delete and create again and again because of spring.jpa.hibernate.ddl-auto=create which in app.properties
    so here we create fresh 2  roles (Admin, User) and 1 user as name admin into table everytime
     */
    public void initRolesAndUser(){
        Role adminRole =new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);


        Role userRole =new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserName("admin123");
        adminUser.setUserPassword(getEncodedPassword("admin@pass"));
        Set<Role>adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRoles(adminRoles);
        userDao.save(adminUser);


//        User user = new User();
//        user.setUserFirstName("akshay");
//        user.setUserLastName("mate");
//        user.setUserName("akshay123");
//        user.setUserPassword(getEncodedPassword("akshay@pass"));
//        Set<Role>userRoles = new HashSet<>();
//        userRoles.add(userRole);
//        user.setRoles(userRoles);
//        userDao.save(user);
    }

    public String getEncodedPassword(String password) {
      return passwordEncoder.encode(password);
    }
}
