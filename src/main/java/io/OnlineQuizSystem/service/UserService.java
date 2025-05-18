package io.OnlineQuizSystem.service;

import io.OnlineQuizSystem.entity.JwtRequest;
import io.OnlineQuizSystem.entity.User;
import io.OnlineQuizSystem.entity.UserRole;

import java.util.Set;

public interface UserService {

    public User createUser(User user, Set<UserRole>userRoles) throws Exception;

    public User getUser(String username);

    public void deleteUser(long userId);

    public String verify(JwtRequest jwtRequest);

}
