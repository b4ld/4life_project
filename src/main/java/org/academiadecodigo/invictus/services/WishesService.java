package org.academiadecodigo.invictus.services;

import org.academiadecodigo.invictus.persistence.model.Wishes;

import java.util.List;

public interface WishesService {

    Wishes get(Integer id);

    Wishes create(Wishes wishes);

    void delete(Integer id);

    List<Wishes> wishesList();


}
