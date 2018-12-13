package org.academiadecodigo.invictus.model;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "wishes")
public class Wishes extends AbstractModel {


    private String wish;

    @ManyToOne
    private User user;


    public Wishes() {
    }


    public User getUserModel() {
        return user;
    }

    public void setUserModel(User user) {
        this.user = user;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }
}
