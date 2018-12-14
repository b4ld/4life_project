package org.academiadecodigo.invictus.persistence.dao;

import org.academiadecodigo.invictus.persistence.model.Model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class GenericJpaDao<T extends Model> implements Dao<T> {

    protected Class<T> model;

    @PersistenceContext
    protected EntityManager em;

    public GenericJpaDao(Class<T> model) {
        this.model = model;
    }

    @Override
    public List<T> findAll() {
        return em.createQuery("from " + model.getSimpleName(), model).getResultList();
    }

    @Override
    public T findById(Integer id) {
        return em.find(model, id);
    }

    @Override
    public T createOrUpdate(T model) {
        return em.merge(model);
    }

    @Override
    public void delete(Integer id) {
        em.remove(em.find(model, id));
    }

    public Class<T> getModel() {
        return model;
    }

    public void setModel(Class<T> model) {
        this.model = model;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
