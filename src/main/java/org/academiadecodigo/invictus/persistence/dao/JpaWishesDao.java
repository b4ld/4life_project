package org.academiadecodigo.invictus.persistence.dao;

import org.academiadecodigo.invictus.persistence.model.Wishes;
import org.springframework.stereotype.Repository;

@Repository
public class JpaWishesDao extends GenericJpaDao<Wishes> implements WishesDao {

    public JpaWishesDao() {
        super(Wishes.class);
    }

}
