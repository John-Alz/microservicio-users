package com.users.userservice.commons;

import com.users.userservice.domain.ports.input.RoleServicePort;
import com.users.userservice.domain.ports.input.UserServicePort;
import com.users.userservice.domain.ports.output.RolePersistencePort;
import com.users.userservice.domain.ports.output.UserPersistencePort;
import com.users.userservice.domain.usecases.RoleUseCase;
import com.users.userservice.domain.usecases.UserUseCase;
import com.users.userservice.domain.usecases.UserValidatorUseCase;
import com.users.userservice.infrastructure.adapters.persistence.RolePersistenceAdapter;
import com.users.userservice.infrastructure.adapters.persistence.UserPersistenceAdapter;
import com.users.userservice.infrastructure.mappers.RoleEntityMapper;
import com.users.userservice.infrastructure.mappers.UserEntityMapper;
import com.users.userservice.infrastructure.repositories.mysql.RoleRepository;
import com.users.userservice.infrastructure.repositories.mysql.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    private final RoleRepository roleRepository;
    private final RoleEntityMapper roleEntityMapper;

    @Bean
    public UserServicePort userServicePort(UserPersistencePort userPersistencePort, UserValidatorUseCase userValidatorUseCase) {
        return new UserUseCase(userPersistencePort, userValidatorUseCase);
    }

    @Bean
    public UserPersistencePort userPersistencePort(PasswordEncoder passwordEncoder) {
        return new UserPersistenceAdapter(userRepository, userEntityMapper, passwordEncoder);
    }


    @Bean
    public UserValidatorUseCase userValidatorUseCase() {
        return new UserValidatorUseCase();
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
