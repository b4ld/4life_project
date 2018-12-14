package org.academiadecodigo.invictus.services;

import org.academiadecodigo.invictus.dao.JpaUserDao;
import org.academiadecodigo.invictus.dao.UserDao;
import org.academiadecodigo.invictus.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public User create(User user) {
        return userDao.createOrUpdate(user);
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);

    }

    @Override
    public List<User> userList() {
        return userDao.findAll();
    }

    @Override
    public boolean testMatch(Integer userId,Integer matchId) {

        //for(User user : userDao.)

        return true;
    }
}
