package model;

public class PetName extends Exception {

	public PetName() {
		super("There is two pets with the same name");
	}
}
