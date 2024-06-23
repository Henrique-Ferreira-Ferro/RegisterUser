package com.cadastroUser.registerUser.services;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastroUser.registerUser.entities.UserEntity;
import com.cadastroUser.registerUser.exceptions.BadRequestException;
import com.cadastroUser.registerUser.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
		
	//create user
	
	//Nota sempre lembrar de colocar como public :(
	public UserEntity createUser(UserEntity user){
		
		
		if(user.getEmail() == null || user.getEmail().isBlank()) {
			throw new BadRequestException("Não deixe o email vaziu ");
		}
		
		Matcher match = checkMail(user);

		
		if(!match.matches()) {
			throw new BadRequestException("O Email não está cumprindo os requisitos!");
		}
		return repository.save(user);
	}
	
	// Find user by id
	
	public Optional<UserEntity> findUserById(Long id){
		Optional<UserEntity> user = repository.findById(id);
		if(!user.isPresent()) {
			throw new ObjectNotFoundException(id, UserEntity.class.getSimpleName());
		}
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
			if(user.getEmail() == null || user.getEmail().isBlank()) {
				throw new BadRequestException("Não deixe o email vaziu ");
			}
			Matcher match = checkMail(user);
			
			if(!match.matches()) {
				throw new BadRequestException("O Email não está cumprindo os requisitos!");
			}
			var userMod = userFind.get();
			userMod.setName(user.getName());
			userMod.setEmail(user.getEmail());
			return repository.save(userMod);
		}else {
			throw new ObjectNotFoundException(id,UserEntity.class.getSimpleName());
		}
	}

	
	
	//Delete an user on the aplication by id
	
	public String deleteUser(Long id) {
		Optional<UserEntity> userFind = repository.findById(id);
		if(userFind.isPresent()) {
			repository.deleteById(id);
			return "Usuario: " + userFind.get().getName() + ", apagado com sucesso do banco!";
		}else {
			throw new ObjectNotFoundException(id, UserEntity.class.getSimpleName());
		}
	}
	
	/*
	 * Logica: 
	 */
		
	private Matcher checkMail(UserEntity user) {
		String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		Matcher match = pattern.matcher(user.getEmail());
		return match;
	}
	
}
