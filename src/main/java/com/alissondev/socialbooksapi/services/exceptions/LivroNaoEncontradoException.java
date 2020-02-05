package com.alissondev.socialbooksapi.services.exceptions;

public class LivroNaoEncontradoException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7868778995518841399L;

	public LivroNaoEncontradoException(String mensagem) {
		super(mensagem);	
	}
	
	public LivroNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
