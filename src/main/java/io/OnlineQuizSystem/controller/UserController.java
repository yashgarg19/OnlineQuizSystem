package io.OnlineQuizSystem.controller;

import io.OnlineQuizSystem.entity.JwtRequest;
import io.OnlineQuizSystem.entity.Role;
import io.OnlineQuizSystem.entity.User;
import io.OnlineQuizSystem.entity.UserRole;
import io.OnlineQuizSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {


        @Autowired
        private UserService userService;

        // Registering the user into the database

        @PostMapping("/")
        public User createUser(@RequestBody User user) throws Exception {
            Set<UserRole> roles = new HashSet<>();

            Role role = new Role();
            role.setRoleId(45L);
            role.setRoleName("NORMAL");
            UserRole userRole = new UserRole();
            userRole.setUser(user);
            userRole.setRole(role);
            roles.add(userRole);
            return this.userService.createUser(user,roles);
        }
//        fetch the detail of all users
        @GetMapping("/{username}")
        public User getUser(@PathVariable ("username") String username){
           return this.userService.getUser(username);
        }

     //       Delete the user from database
        @DeleteMapping("/{userId}")
       public void deleteUser(@PathVariable("userId") Long userId){
            this.userService.deleteUser(userId);
        }

        @PostMapping("/login")
    public String login(@RequestBody JwtRequest jwtRequest){
            return userService.verify(jwtRequest);
        }
}
