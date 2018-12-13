package org.academiadecodigo.invictus.dao;

import org.academiadecodigo.invictus.model.Wishes;
import org.springframework.stereotype.Repository;

@Repository
public class JpaWishesDao extends GenericJpaDao<Wishes> implements WishesDao {

    public JpaWishesDao() {
        super(Wishes.class);
    }

}
