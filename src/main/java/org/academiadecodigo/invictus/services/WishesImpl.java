package org.academiadecodigo.invictus.services;

import org.academiadecodigo.invictus.persistence.dao.JpaWishesDao;
import org.academiadecodigo.invictus.persistence.model.Wishes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WishesImpl implements WishesService {

    private JpaWishesDao jpaWishesDao;

    @Autowired
    public void setJpaWishesDao(JpaWishesDao jpaWishesDao) {
        this.jpaWishesDao = jpaWishesDao;
    }

    @Override
    public Wishes get(Integer id) {
        return jpaWishesDao.findById(id);
    }

    @Transactional
    @Override
    public Wishes create(Wishes wishes) {
        return jpaWishesDao.saveOrUpdate(wishes);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        jpaWishesDao.delete(id);

    }

    @Override
    public List<Wishes> wishesList() {
        return jpaWishesDao.findAll();
    }
}
