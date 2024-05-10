package com.make.library.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.make.library.entities.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	
	public User findByEmail(String email);

}

