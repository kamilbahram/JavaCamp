package com.example.northwind.bussines.cocnretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.northwind.bussines.absracts.UserService;
import com.example.northwind.core.dataAccess.UserDao;
import com.example.northwind.core.entities.User;
import com.example.northwind.core.utilities.result.DataResult;
import com.example.northwind.core.utilities.result.Result;
import com.example.northwind.core.utilities.result.SuccessDataResult;
import com.example.northwind.core.utilities.result.SuccessResult;


@Service
public class UserManager implements UserService{
	
	private UserDao userDao;
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {	
		this.userDao.save(user);
		return new SuccessResult( "User Eklendi");
	}

	@Override
	public User getByEmail(String email) {		
		return this.userDao.getByEmail(email);
	}

	@Override
	public DataResult<List<User>> getByAll() {
		return new SuccessDataResult<List<User>>
		(this.userDao.findAll() , "SuccessData deneniyor!!!");
	}

	@Override
	public DataResult<User> getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
