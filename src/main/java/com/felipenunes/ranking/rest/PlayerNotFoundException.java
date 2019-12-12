package com.felipenunes.ranking.rest;

public class PlayerNotFoundException extends RuntimeException {

	public PlayerNotFoundException() {
	
	}

	public PlayerNotFoundException(String arg0) {
		super(arg0);
		
	}

	public PlayerNotFoundException(Throwable arg0) {
		super(arg0);

	}

	public PlayerNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}

	public PlayerNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		
	}

}
