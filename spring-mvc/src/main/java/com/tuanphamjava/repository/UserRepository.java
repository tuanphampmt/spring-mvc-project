package com.tuanphamjava.repository;

import com.tuanphamjava.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	UserEntity findOneByUserNameAndStatus(String name, int status);
}
