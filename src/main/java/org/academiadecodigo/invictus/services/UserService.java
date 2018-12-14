package org.academiadecodigo.invictus.services;

import org.academiadecodigo.invictus.model.User;

import java.util.List;

public interface UserService {


    User get(Integer id);

    User create(User user);

    void delete(Integer id);

    List<User> userList();

    boolean testMatch(Integer userId,Integer matchId);

    User findEmail(String email);

}
