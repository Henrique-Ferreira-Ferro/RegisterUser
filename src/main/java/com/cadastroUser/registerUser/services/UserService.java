package com.cadastroUser.registerUser.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastroUser.registerUser.entities.UserEntity;
import com.cadastroUser.registerUser.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
		
	//create user
	
	//Nota sempre lembrar de colocar como public :(
	public UserEntity createUser(UserEntity user){
		return repository.save(user);
	}
	
	// Find user by id
	
	public Optional<UserEntity> findUserById(Long id){
		return repository.findById(id);
	}
	
	//Find all users in the application
	
	public List<UserEntity> findAllUsers(){
		return repository.findAll();
	}
	
	//Update an existing user on system
	
	public UserEntity updateUser(UserEntity user, Long id) {
		Optional<UserEntity> userFind = repository.findById(id);
		if(userFind.isPresent()) {
			return repository.save(user);
		}else {
			throw new RuntimeException("Usuario não encontrado");
		}
	}
	
	//Delete an user on the aplication by id
	
	public String deleteUser(Long id) {
		Optional<UserEntity> userFind = repository.findById(id);
		if(userFind.isPresent()) {
			repository.deleteById(id);
			return "Usuario: " + userFind.get().getName() + ", apagado com sucesso do banco!";
		}else {
			throw new RuntimeException("Usuario não encontrado");
		}
	}
	
	
}
