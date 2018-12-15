package org.academiadecodigo.invictus.dto;

import org.academiadecodigo.invictus.persistence.model.Wishes;

import javax.validation.constraints.*;
import java.util.LinkedList;
import java.util.List;

public class UserDto {

    private Integer id;

    @NotBlank(message = "name is mandatory")
    @NotNull(message = "name is mandatory")
    private String name;

    @Email
    @NotBlank(message = "email is mandatory")
    @NotNull(message = "email is mandatory")
    private String email;

    private Integer lifePoint;
//this a commit

    //@Pattern(regexp = "^\\+?[0-9]*$", message = "age must be between 18 and 99.")
    private Integer age;

    @NotNull(message = "description is mandatory")
    @NotBlank(message = "description is mandatory")
    @Size(min = 20, max = 150)
    private String description;


    private String gender;
    private List<Wishes> bucketList = new LinkedList<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", lifePoint=" + lifePoint +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                //", bucketList=" + bucketList +
                '}';
    }


    public void thisCommitMethod(){
        System.out.println("I love you");
    }


}
