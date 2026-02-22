package com.alexdev.mappers;

import com.alexdev.dtos.response.UserDTO;
import com.alexdev.entities.User;

public class UserMapper {

    public static UserDTO entityToDTO(User user) {

        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getBirthDate(),
                user.getGender()
        );
    }
}
