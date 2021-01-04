package com.hackerrank.restcontrolleradvice.exception;
import com.hackerrank.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hackerrank.restcontrolleradvice.dto.BuzzException;
import com.hackerrank.restcontrolleradvice.dto.FizzBuzzException;
import com.hackerrank.restcontrolleradvice.dto.FizzBuzzResponse;
import com.hackerrank.restcontrolleradvice.dto.FizzException;
import com.hackerrank.restcontrolleradvice.dto.GlobalError;

@RestControllerAdvice
public class FizzBuzzExceptionHandler extends ResponseEntityExceptionHandler {

  //TODO:: implement handler methods for FizzException, BuzzException and FizzBuzzException
	
	
	@ExceptionHandler(FizzException.class)
	public ResponseEntity<GlobalError> fizzException(FizzException fizzException) {
		
		GlobalError globalError=new GlobalError();
		globalError.setErrorReason("Internal Server Error");
		globalError.setMessage("Fizz Exception");
		return new ResponseEntity<GlobalError>(globalError,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	@ExceptionHandler(BuzzException.class)
	public ResponseEntity<GlobalError> buzzException(BuzzException buzzException) {
		
		GlobalError globalError=new GlobalError();
		globalError.setErrorReason("Bad Request");
		globalError.setMessage("Buzz Exception");
		return new ResponseEntity<GlobalError>(globalError,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(FizzBuzzException.class)
	public ResponseEntity<GlobalError> fizzBuzzException(FizzBuzzException fizzBuzzException) {
		
		GlobalError globalError=new GlobalError();
		globalError.setErrorReason("Insufficient Storage");
		globalError.setMessage("FizzBuzz Exception");
		return new ResponseEntity<GlobalError>(globalError,HttpStatus.INSUFFICIENT_STORAGE);
		
	}
}
