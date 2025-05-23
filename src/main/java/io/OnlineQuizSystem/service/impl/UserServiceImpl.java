package io.OnlineQuizSystem.service.impl;

import io.OnlineQuizSystem.entity.JwtRequest;
import io.OnlineQuizSystem.entity.User;
import io.OnlineQuizSystem.entity.UserRole;
import io.OnlineQuizSystem.repository.RoleRepository;
import io.OnlineQuizSystem.repository.UserRepository;
import io.OnlineQuizSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    private BCryptPasswordEncoder encoder =  new BCryptPasswordEncoder(12);


    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        user.setProfile("default.png");
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
            user.setPassword(encoder.encode(user.getPassword()));
            local=this.userRepository.save(user);
        }
        return local;
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public String verify(JwtRequest jwtRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(jwtRequest.getUsername()
                        ,jwtRequest.getPassword()));
        if(authentication.isAuthenticated())
            return jwtService.generateToken(jwtRequest.getUsername());
        else return "Fail";
    }
}
