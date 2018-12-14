package org.academiadecodigo.invictus.persistence.dao;

import org.academiadecodigo.invictus.persistence.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class JpaUserDao extends GenericJpaDao<User> implements UserDao {

    public JpaUserDao() {
        super(User.class);
    }


    public User findbyEmail(String email){
      return em.find(model,email);

    }







}
