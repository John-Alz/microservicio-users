package com.users.userservice.infrastructure.adapters.persistence;

import com.users.userservice.domain.model.UserModel;
import com.users.userservice.domain.ports.output.AuthPersistencePort;
import com.users.userservice.infrastructure.entities.UserEntity;
import com.users.userservice.infrastructure.mappers.UserEntityMapper;
import com.users.userservice.infrastructure.repositories.mysql.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthPersistenceAdapter implements AuthPersistencePort {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public UserModel userExist(String email) {
        System.out.println("Email adpater: " + email);
        UserEntity user = userRepository.findByEmail(email).orElse(null);
//        System.out.println(user.getEmail());
        return userEntityMapper.entityToModel(user);
    }
}
