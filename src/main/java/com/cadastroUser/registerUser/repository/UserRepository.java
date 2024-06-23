package com.cadastroUser.registerUser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cadastroUser.registerUser.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

}
