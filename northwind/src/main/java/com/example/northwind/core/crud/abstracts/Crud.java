package com.example.northwind.core.crud.abstracts;

import com.example.northwind.core.utilities.result.DataResult;

public interface Crud<T> {
	DataResult<T> getAll();
	T getByAll();
	T insert(T t);
	T update(T t);
	void delete(T t);
}
