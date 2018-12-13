package org.academiadecodigo.invictus.model;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Wishes extends AbstractModel {


    private String wish;

    @ManyToOne
    private User user;


    public Wishes() {
    }


    public User getUserModel() {
        return user;
    }

    public void setUserModel(User userModel) {
        this.user = user;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }
}
