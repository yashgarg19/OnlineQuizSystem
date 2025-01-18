package io.OnlineQuizSystem.service.impl;

import io.OnlineQuizSystem.entity.User;
import io.OnlineQuizSystem.entity.UserRole;
import io.OnlineQuizSystem.repository.RoleRepository;
import io.OnlineQuizSystem.repository.UserRepository;
import io.OnlineQuizSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User local = this.userRepository.findByUsername(user.getUsername());
        if(local!=null){
            System.out.println("User is already there");
            throw new Exception("User already present");
        }
        else{
            for(UserRole ur:userRoles){
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local=this.userRepository.save(user);
        }
        return local;
    }
}
