package org.academiadecodigo.invictus.services;

import org.academiadecodigo.invictus.persistence.dao.JpaUserDao;
import org.academiadecodigo.invictus.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private JpaUserDao userDao;


    @Autowired
    public void setUserDao(JpaUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User get(Integer id) {
        return userDao.findById(id);
    }

    @Transactional
    @Override
    public User save(User user) {
        return userDao.saveOrUpdate(user);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        userDao.delete(id);

    }

    @Override
    public List<User> userList() {
        return userDao.findAll();
    }

    @Transactional
    @Override
    public void testMatch(Integer userId, Integer matchId) {

        User user1 = get(userId);


        for (User user : user1.getRequest()) {
            if (user.getId().equals(matchId)) {

                changeEmails(matchId);
                addToFriendList(userId, matchId);
                break;
            }

            addToRequestList(userId, matchId);
        }
    }
    @Transactional
    @Override
    public String changeEmails(Integer matchId) {

        User user2 = get(matchId);
        return user2.getEmail();

    }


    @Transactional
    @Override
    public void addToFriendList(Integer userId, Integer matchId) {

        User user1 = get(userId);
        User user2 = get(matchId);

        user1.getUserFriend().add(user2);
        user2.getUserFriend().add(user1);
    }

    @Transactional
    @Override
    public void addToRequestList(Integer userId, Integer matchId) {

        User user1 = get(userId);
        User user2 = get(matchId);

        user1.getRequest().add(user2);
        user2.getRequest().add(user1);

    }


    @Override
    public User findEmail(String email) {
        return userDao.findByEmail(email);
    }

}
