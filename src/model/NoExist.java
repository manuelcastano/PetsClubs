package model;

public class NoExist extends Exception{

	public NoExist() {
		super("The finded elements doesn't exist");
	}

}
