package dev.java10x.user.mapper;


import dev.java10x.user.dto.UserRequest;
import dev.java10x.user.dto.UserResponse;
import dev.java10x.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    public User toEntity(UserRequest userRequest) {
        User newUser = new User();
        newUser.setName(userRequest.getName());
        newUser.setEmail(userRequest.getEmail());
        return newUser;
    }


    public UserResponse toResponse(User user) {
        if (user == null) {
            return null;
        }
        UserResponse newUserResponse = new UserResponse();
        newUserResponse.setName(user.getName());
        newUserResponse.setEmail(user.getEmail());
        return newUserResponse;
    }
}
