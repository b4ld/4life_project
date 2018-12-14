package org.academiadecodigo.invictus.converter;

import org.academiadecodigo.invictus.dto.UserDto;
import org.academiadecodigo.invictus.persistence.model.User;
import org.academiadecodigo.invictus.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DtoToUser implements Converter<UserDto,User> {


    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User convert(UserDto userDto) {
        User user = (userDto.getId() !=null ? userService.get(userDto.getId()) : new User());

        user.setId(userDto.getId());
        user.setAge(userDto.getAge());
        user.setEmail(userDto.getEmail());
        //user.setBucketList(userDto.getBucketList());
        user.setGender(userDto.getGender());
        user.setLifePoint(userDto.getLifePoint());
        user.setName(userDto.getName());
        user.setDescription(userDto.getDescription());


        return user;
    }
}
