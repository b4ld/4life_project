package org.academiadecodigo.invictus.dao;

import org.academiadecodigo.invictus.model.Wishes;
import org.springframework.stereotype.Repository;

@Repository
public class JpaWishDao extends GenericJpaDao<Wishes> implements WishesDao {

    public JpaWishDao() {
        super(Wishes.class);
    }

}
