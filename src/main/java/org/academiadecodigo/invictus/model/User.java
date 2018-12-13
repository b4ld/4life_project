package org.academiadecodigo.invictus.model;


import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "user")
public class User extends AbstractModel {

    private String name;
    private String email;
    private Integer lifePoint;
    private Integer age;
    private String gender;




    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "user",
            fetch = FetchType.EAGER
    )

    private List<Wishes> bucketList = new LinkedList<>();



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
