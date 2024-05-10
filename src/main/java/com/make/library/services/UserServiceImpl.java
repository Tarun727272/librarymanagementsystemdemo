package com.make.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.make.library.entities.User;
import com.make.library.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository repo;
	
	@Override
	public String addUser(User user) {
		repo.save(user);
		return "user is created and saved";
	}

	@Override
	public boolean emailExists(String email) {
		if(repo.findByEmail(email)==null){
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean validateUser(String email, String password) {
		
		User user=repo.findByEmail(email);
		String db_password=user.getPassword();
		if(db_password.equals(password)) {
			return true;
		}
		else {
			return false;
		}
	}
    public String getRole(String email) {
		
    	return (repo.findByEmail(email).getRole());
		
		
		
	}

	@Override
	public User getUser(String email) {
		
		
		return repo.findByEmail(email);
	}

	@Override
	public void updateUser(User user) {
		repo.save(user);
		
	}
	

}
