package org.academiadecodigo.invictus.persistence.model;


import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "user")
public class User extends AbstractModel {

    private String name;
    @Column(unique = true)
    private String email;

    private Integer lifePoint;
    private Integer age;
    private String gender;
    private String description;

    @ManyToMany(
            cascade = {CascadeType.ALL},
            mappedBy = "userList",
            fetch = FetchType.EAGER
    )
    private List<Wishes> bucketList = new LinkedList<>();

    @OneToMany
    private List<User> userFriend = new LinkedList<>();

    @OneToMany
    private List<User> request = new LinkedList<>();



    public void addWish(Wishes wishes){
        bucketList.add(wishes);
    }

    public void removeWish(Wishes wishes){
        bucketList.remove(wishes);
    }

    public List<User> getUserFriend() {
        return userFriend;
    }

    public void setUserFriend(List<User> userFriend) {
        this.userFriend = userFriend;
    }

    public List<User> getRequest() {
        return request;
    }

    public void setRequest(List<User> request) {
        this.request = request;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getLifePoint() {
        return lifePoint;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLifePoint(Integer lifePoint) {
        this.lifePoint = lifePoint;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Wishes> getBucketList() {
        return bucketList;
    }

    public void setBucketList(List<Wishes> bucketList) {
        this.bucketList = bucketList;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", lifePoint=" + lifePoint +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", bucketList=" + bucketList +
                '}';
    }
}
