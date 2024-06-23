package com.cadastroUser.registerUser.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastroUser.registerUser.entities.UserEntity;
import com.cadastroUser.registerUser.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
		
	@PostMapping("/create")
	public UserEntity createUser(UserEntity user) {
		return service.createUser(user);
	}
	
	@GetMapping("/{id}")
	public Optional<UserEntity> findUserById(@PathVariable Long id){
		return service.findUserById(id);
	}
	
	@GetMapping
	public List<UserEntity> findAllUsers(){
		return service.findAllUsers();
	}
	
	@PutMapping("/update/{id}")
	public UserEntity updateUserById(@RequestBody UserEntity user, @PathVariable Long id){
		return service.updateUser(user, id);
	}
	
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id) {
		return service.deleteUser(id);
	}
	

}
