package dev.java10x.user.service;

import dev.java10x.user.dto.UserRequest;
import dev.java10x.user.dto.UserResponse;
import dev.java10x.user.entity.User;
import dev.java10x.user.mapper.UserMapper;
import dev.java10x.user.producer.UserProducer;
import dev.java10x.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserProducer userProducer;

    public UserService(UserRepository userRepository, UserMapper userMapper, UserProducer userProducer) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userProducer = userProducer;
    }

    @Transactional // garante que essa acao aconteca se tivver algum erro o user nao vai ser salvo no db
    public UserResponse createUser(UserRequest request) {
        User user = userMapper.toEntity(request);
        userRepository.save(user);
        userProducer.send(request);
        return userMapper.toResponse(user);
    }

}
