package com.example.northwind.core.crud.abstracts;

import com.example.northwind.core.utilities.result.DataResult;

public interface Crud<T> {
	DataResult<T> getId();

}
