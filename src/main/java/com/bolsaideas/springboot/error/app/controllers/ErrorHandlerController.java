package com.bolsaideas.springboot.error.app.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bolsaideas.springboot.error.app.errors.UsuarioNoEncontradoException;

/**
 * @ControllerAdvice maneja los lanzamientos de excepciones para capturarlas y
 *                   tratarlas, mapeamos a una excepción.
 * @author Adrián
 *
 */
@ControllerAdvice
public class ErrorHandlerController {

	/**
	 * Podemos capturar varios tipos de excepciones con el mismo método
	 * 
	 * @param ex
	 * @param model
	 * @return
	 */
	@ExceptionHandler({ ArithmeticException.class })
	public String airtmeticaError(ArithmeticException ex, Model model) {
		model.addAttribute("error", "Error de aritmética");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
//		return "error/aritmetica";
		return "error/generica";
	}

	@ExceptionHandler({ NumberFormatException.class })
	public String numberFormatException(NumberFormatException ex, Model model) {
		model.addAttribute("error", "Error de formateo, formato número inválido");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/numero";
//		return "error/generica";
	}

	@ExceptionHandler({ UsuarioNoEncontradoException.class })
	public String usuarioNoEncontradoException(UsuarioNoEncontradoException ex, Model model) {
		model.addAttribute("error", "Error: Usuario no encontrado");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/generica";
	}
}
