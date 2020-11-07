package com.veiculos.demo.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
//classe para tratar as exeçoes.herda a classe ResponseEntityExceptionHandler
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Autowired //injeta dependencia de erros do folder criado ValidationMessages.properties em :src/main/resources.
	private MessageSource messageSource;
	

	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ResponseEntity<Object> HandleEntidadeNaoEncontrada(NegocioException ex, WebRequest request){
		var status = HttpStatus.NOT_FOUND;
		
		var problema = new Problema();
		problema.setStatus(status.value());;
		problema.setTitulo(ex.getMessage());
		problema.setDataHora(OffsetDateTime.now());
		
		return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
		
	}
	
	
	
	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<Object> HandleNegocio(NegocioException ex, WebRequest request){
		var status = HttpStatus.BAD_REQUEST;
		
		var problema = new Problema();
		problema.setStatus(status.value());;
		problema.setTitulo(ex.getMessage());
		problema.setDataHora(OffsetDateTime.now());
		
		return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
		
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		// recebe os parametros 
		var campos = new ArrayList<Problema.Campo>();
		
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			String nome = ((FieldError) error).getField();
			String mensagem = messageSource.getMessage(error,  LocaleContextHolder.getLocale());
			
			campos.add(new Problema.Campo(nome,mensagem));
		}
		
		var problema = new Problema();// classe problema criada para tratar os erros ee exeçoes.
		problema.setStatus(status.value());
		problema.setTitulo("Um ou mais campos estão inválidos."
				+"Faça o preenchimento correto e tente novamente");
		problema.setDataHora(OffsetDateTime.now());
		problema.setCampos(campos);
		return super.handleExceptionInternal(ex, problema, headers, status, request);
	}

}
