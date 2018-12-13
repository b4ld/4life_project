package org.academiadecodigo.invictus.converter;

import org.academiadecodigo.invictus.dto.UserDto;
import org.academiadecodigo.invictus.model.User;
import org.springframework.core.convert.converter.Converter;

public class UsertoDto implements Converter<User, UserDto> {



    @Override
    public UserDto convert(User user) {
        UserDto userDto = new UserDto();

        userDto.setAge(user.getAge());
        userDto.setBucketList(user.getBucketList());
        userDto.setEmail(user.getEmail());
        userDto.setGender(user.getGender());
        userDto.setName(user.getName());
        userDto.setLifePoint(user.getLifePoint());
        userDto.setId(user.getId());

        return userDto;
    }
}
