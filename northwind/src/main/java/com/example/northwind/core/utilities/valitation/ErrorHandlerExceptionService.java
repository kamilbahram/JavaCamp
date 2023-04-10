package com.example.northwind.core.utilities.valitation;

import com.example.northwind.core.utilities.result.ErrorDataResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

public interface ErrorHandlerExceptionService {
    ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions);
}
