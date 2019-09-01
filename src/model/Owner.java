package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class Owner implements Serializable, Comparator<Owner>{
	
	private String id;
	private String names;
	private String lastNames;
	private String birthDate;
	private String petsType;
	private ArrayList<Pet> pets;
	
	public Owner(String id, String names, String lastNames, String birthDate, String petsType) {
		super();
		this.id = id;
		this.names = names;
		this.lastNames = lastNames;
		this.birthDate = birthDate;
		this.petsType = petsType;
		pets = new ArrayList<Pet>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getLastNames() {
		return lastNames;
	}

	public void setLastNames(String lastNames) {
		this.lastNames = lastNames;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getPetsType() {
		return petsType;
	}

	public void setPetsType(String petsType) {
		this.petsType = petsType;
	}

	public ArrayList<Pet> getPets() {
		return pets;
	}

	public void setPets(ArrayList<Pet> pets) {
		this.pets = pets;
	}

	@Override
	public int compare(Owner o1, Owner o2) {
		return o1.getPets().size()-o2.getPets().size();
	}
	
	public void addPets(Pet e) throws PetName{
		boolean equal = false;
		for (int i = 0; i < pets.size() && !equal; i++) {
			if(pets.get(i).getName().equals(e.getName())) {
				equal = true;
			}
		}
		if(!equal) {
			pets.add(e);
		}
		else {
			throw new PetName();
		}
	}
	
	public int compareById(Owner e) {
		return id.compareTo(e.getId());
	}
	
	public int compareByNames(Owner e) {
		return names.compareTo(e.getNames());
	}
	
	public int compareByLastNames(Owner e) {
		return lastNames.compareTo(e.getLastNames());
	}
	
	public int compareByBirthDate(Owner e) {
		return birthDate.compareTo(e.getBirthDate());
	}
	
	public int compareByPetsType(Owner e) {
		return petsType.compareTo(e.getPetsType());
	}
}
