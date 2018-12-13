package org.academiadecodigo.invictus.model;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Wishes extends AbstractModel {


    private String wish;

    @ManyToOne
    private User userModel;


    public Wishes() {
    }


    public User getUserModel() {
        return userModel;
    }

    public void setUserModel(User userModel) {
        this.userModel = userModel;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }
}
