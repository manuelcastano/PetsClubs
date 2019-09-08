package model;

public class NoExist extends Exception{

	public NoExist() {
		super("The element doesn't exist");
	}

}
