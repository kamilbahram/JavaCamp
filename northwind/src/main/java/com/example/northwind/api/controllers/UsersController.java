package com.example.northwind.api.controllers;


import java.security.PublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.example.northwind.bussines.absracts.UserService;
import com.example.northwind.core.entities.User;
import com.example.northwind.core.utilities.result.DataResult;
import com.example.northwind.core.utilities.result.ErrorDataResult;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	private UserService userService;
	
	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/getByEmail")
	public User getEmail(@RequestParam String email) {
		return this.userService.getByEmail(email);
	}
	@GetMapping("/getAllUsers")
	public DataResult<List<User>> getAllUsers() {
		return this.userService.getByAll();
	}
	
	
	/*
	@PostMapping("/addUser")
	public Result add(@RequestBody User user) {	
		return this.userService.add(user);
	}
    */
	
	//ResponseEntity<> yapılan isteğe göre hangi hata türünün(http 201) geleceğini belirtir
	// ? işareti add() metotıunun sonucu istediğimiz gibi dönmeyebilir
	//global expection handler
	@PostMapping("/addUser")
	public ResponseEntity<?> add(@Valid @RequestBody User user) {	
		return ResponseEntity.ok(this.userService.add(user));
	}
	
	
	//Sınıflarımızda hata çıkınca cıkan hataları yakalamaya yarar cıkan hatanın hangi alandan ve hatanı ne olduğunu belirtir.
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException
		(MethodArgumentNotValidException exceptions){
			Map<String,String> validationErrors = new HashMap<String, String>();
			for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
				validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
			}			
			ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
			return errors;
	}
}
