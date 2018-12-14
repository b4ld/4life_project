package org.academiadecodigo.invictus.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "wishes")
public class Wishes extends AbstractModel {


    private String wish;


    @ManyToMany(
            cascade = {CascadeType.ALL},
            mappedBy = "wishes",
            fetch = FetchType.LAZY
    )
    private List<User> userList;

    private void addUser(User user){
        userList.add(user);
    }

    private void remove(User user){
        userList.remove(user);
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }
}
