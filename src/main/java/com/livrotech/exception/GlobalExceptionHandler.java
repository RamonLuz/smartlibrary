package com.livrotech.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> tratarValidacoes(MethodArgumentNotValidException ex) {

		Map<String, String> erros = new HashMap<>();

		ex.getBindingResult().getFieldErrors().forEach(erro -> {
			erros.put(erro.getField(), erro.getDefaultMessage());
		});

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
	}

	@ExceptionHandler({ HttpMessageNotReadableException.class, IllegalArgumentException.class, MethodArgumentTypeMismatchException.class})
	public ResponseEntity<Map<String, String>> tratarJsonInvalido(Exception ex) {

		Map<String, String> erro = new HashMap<>();

		erro.put("message", ex.getMessage());

		return ResponseEntity.badRequest().body(erro);
	}
}