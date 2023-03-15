package com.jpa.test.controller;

import java.util.List;

import com.jpa.test.logging.LogExecutionTime;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.test.entities.User;
import com.jpa.test.exception.ResourceNotFoundException;
import com.jpa.test.jparepository.UserRepository;

@RestController
@Tag(name="User")
@RequestMapping("/api/users")

public class UserController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
@Autowired
private UserRepository userRepository;

//-----------  http://localhost:8080/swagger-ui/index.html#/   ----------for swagger ui
//get all users
@GetMapping
@Operation(summary = "Get ALL User", responses = {
		@ApiResponse(description = "Get ALL user SUCCESS", responseCode = "200",
				content = @Content(mediaType = "application/json"))})

public List<User> getAllUsers()
{
	logger.info("get all user executed");
	return this.userRepository.findAll();
	}

//get user by id
@GetMapping("/{id}")
@Operation(summary = "get user by id", responses = {
		@ApiResponse(description = "get user by id SUCCESS", responseCode = "200",
				content = @Content(mediaType = "application/json"))})
@LogExecutionTime
public User getUserById(@PathVariable (value = "id") int userId)
{
	logger.info("get user by id executed");
	return this.userRepository.findById(userId)
		.orElseThrow(() -> new ResourceNotFoundException("User not found with id :"+userId));
}


//create user 
@PostMapping
@Operation(summary = "create user ", responses = {
		@ApiResponse(description = "create user SUCCESS", responseCode = "200",
				content = @Content(mediaType = "application/json"))})
@LogExecutionTime
public User createUser(@RequestBody User user)
{
	logger.info("create user executed");
	return this.userRepository.save(user) ;
	}


//update user
@PutMapping("/{id}")
@Operation(summary = "update user by id", responses = {
		@ApiResponse(description = "update user by id SUCCESS", responseCode = "200",
				content = @Content(mediaType = "application/json"))})
@LogExecutionTime
public User updateUser(@RequestBody User user,@PathVariable ("id") int userId)
{
	logger.info("update user executed");

	User existingUser =  this.userRepository.findById(userId)
		.orElseThrow(() -> new ResourceNotFoundException("User not found with id :"+userId));
       existingUser.setId(user.getId());
       existingUser.setName(user.getName());
       existingUser.setCity(user.getCity());
       existingUser.setStatus(user.getStatus());
      return this.userRepository.save(existingUser);
	}

//delete user by id 
@DeleteMapping ("/{id}")
@Operation(summary = "delete user by id ", responses = {
		@ApiResponse(description = "delete user by id SUCCESS", responseCode = "200",
				content = @Content(mediaType = "application/json"))})
@LogExecutionTime
public ResponseEntity<User> deleteUser(@PathVariable ("id") int userId)
{
	logger.info("delete user by id executed");

	User existingUser =  this.userRepository.findById(userId)
		.orElseThrow(() -> new ResourceNotFoundException("User not found with id :"+userId));
         this.userRepository.delete(existingUser);
         return ResponseEntity.ok().build();
	}


	
	
}
