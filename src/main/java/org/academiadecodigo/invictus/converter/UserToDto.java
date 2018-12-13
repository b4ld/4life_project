package org.academiadecodigo.invictus.converter;

import org.academiadecodigo.invictus.dto.UserDto;
import org.academiadecodigo.invictus.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToDto implements Converter<User, UserDto> {



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
        userDto.setDescription(user.getDescription());

        return userDto;
    }
}
