package com.users.userservice.infrastructure.repositories.mysql;

import com.users.userservice.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {


}
