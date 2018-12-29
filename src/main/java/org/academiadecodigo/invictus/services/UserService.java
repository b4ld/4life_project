package org.academiadecodigo.invictus.services;

import org.academiadecodigo.invictus.persistence.model.User;

import java.util.List;

public interface UserService {


    User get(Integer id);

    User save(User user);

    void delete(Integer id);

    List<User> userList();

    void testMatch(Integer userId,Integer matchId);

    User findEmail(String email);

    String changeEmails(Integer matchId);

    void addToFriendList(Integer userId, Integer matchId);

    void addToRequestList(Integer userId, Integer matchId);

}
