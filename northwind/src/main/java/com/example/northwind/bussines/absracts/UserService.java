package com.example.northwind.bussines.absracts;

import java.util.List;

import com.example.northwind.core.crud.abstracts.Crud;
import com.example.northwind.core.entities.User;
import com.example.northwind.core.utilities.result.DataResult;
import com.example.northwind.core.utilities.result.Result;

public interface UserService extends Crud<User>{
	Result add(User user);
	User getByEmail(String email);
	DataResult<List<User>> getByAll();
}
