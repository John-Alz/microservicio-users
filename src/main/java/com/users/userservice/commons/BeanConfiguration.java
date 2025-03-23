package com.users.userservice.commons;

import com.users.userservice.domain.ports.input.RoleServicePort;
import com.users.userservice.domain.ports.input.UserServicePort;
import com.users.userservice.domain.ports.output.RolePersistencePort;
import com.users.userservice.domain.ports.output.UserPersistencePort;
import com.users.userservice.domain.usecases.RoleUseCase;
import com.users.userservice.domain.usecases.UserUseCase;
import com.users.userservice.infrastructure.adapters.persistence.RolePersistenceAdapter;
import com.users.userservice.infrastructure.adapters.persistence.UserPersistenceAdapter;
import com.users.userservice.infrastructure.mappers.RoleEntityMapper;
import com.users.userservice.infrastructure.mappers.UserEntityMapper;
import com.users.userservice.infrastructure.repositories.mysql.RoleRepository;
import com.users.userservice.infrastructure.repositories.mysql.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    private final RoleRepository roleRepository;
    private final RoleEntityMapper roleEntityMapper;

    @Bean
    public UserServicePort userServicePort(UserPersistencePort userPersistencePort) {
        return new UserUseCase(userPersistencePort());
    }

    @Bean
    public UserPersistencePort userPersistencePort() {
        return new UserPersistenceAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public RoleServicePort roleServicePort(RolePersistencePort rolePersistencePort) {
        return new RoleUseCase(rolePersistencePort());
    }

    @Bean
    public RolePersistencePort rolePersistencePort() {
        return new RolePersistenceAdapter(roleRepository, roleEntityMapper);
    }


}
