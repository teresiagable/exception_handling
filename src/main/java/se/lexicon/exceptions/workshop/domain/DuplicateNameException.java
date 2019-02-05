package se.lexicon.exceptions.workshop.domain;

public class DuplicateNameException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	public DuplicateNameException(String name) {
		this.name = name;	}


	public String getName(){
		return this.name;
	}
	
}
