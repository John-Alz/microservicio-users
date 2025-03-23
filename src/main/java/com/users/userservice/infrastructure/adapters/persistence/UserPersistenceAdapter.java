package com.users.userservice.infrastructure.adapters.persistence;

import com.users.userservice.domain.model.UserModel;
import com.users.userservice.domain.ports.output.UserPersistencePort;
import com.users.userservice.infrastructure.mappers.UserEntityMapper;
import com.users.userservice.infrastructure.repositories.mysql.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public void save(UserModel user) {
        userRepository.save(userEntityMapper.modelToEntity(user));
    }
}
