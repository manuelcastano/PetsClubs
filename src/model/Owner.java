package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class Owner implements Serializable, Comparable<Owner>, Comparator<Owner>{
	
	private String id;
	private String names;
	private String lastNames;
	private String birthDate;
	private String petsType;
	private ArrayList<Pet> pets;
	
	public Owner(String id, String names, String lastNames, String birthDate, String petsType) {
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
	
	@Override
	public int compareTo(Owner e) {
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
	
	//By bubble
	public void orderPetsById() {
		for(int i = 0; i < pets.size()-1; i++) {
			for(int j = 0; j < pets.size()-i-1; j++) {
				if(pets.get(j).compareTo(pets.get(j+1)) > 0) {
					Pet aux = pets.get(j);
					pets.set(j, pets.get(j+1));
					pets.set(j+1, aux);
				}
			}
		}
	}
	
	//By bubble
	public void orderPetsByName() {
		for(int i = 0; i < pets.size()-1; i++) {
			for(int j = 0; j < pets.size()-i-1; j++) {
				if(pets.get(j).compare(pets.get(j), pets.get(j+1)) > 0) {
					Pet aux = pets.get(j);
					pets.set(j, pets.get(j+1));
					pets.set(j+1, aux);
				}
			}
		}
	}
	
	//By bubble
	public void orderPetsByBirthDate() {
		for(int i = 0; i < pets.size()-1; i++) {
			for(int j = 0; j < pets.size()-i-1; j++) {
				if(pets.get(j).compareByBirthDate(pets.get(j+1)) > 0) {
					Pet aux = pets.get(j);
					pets.set(j, pets.get(j+1));
					pets.set(j+1, aux);
				}
			}
		}
	}
	
	//By bubble
	public void orderPetsByGender() {
		for(int i = 0; i < pets.size()-1; i++) {
			for(int j = 0; j < pets.size()-i-1; j++) {
				if(pets.get(j).compareByGender(pets.get(j+1)) > 0) {
					Pet aux = pets.get(j);
					pets.set(j, pets.get(j+1));
					pets.set(j+1, aux);
				}
			}
		}
	}
	
	//By bubble
	public void orderPetsByType() {
		for(int i = 0; i < pets.size()-1; i++) {
			for(int j = 0; j < pets.size()-i-1; j++) {
				if(pets.get(j).compareByType(pets.get(j+1)) > 0) {
					Pet aux = pets.get(j);
					pets.set(j, pets.get(j+1));
					pets.set(j+1, aux);
				}
			}
		}
	}
	
	public String findSequentialPetById(String id){
		boolean finded = false;
		String msg = "The pet doesn't exist";
		for(int i = 0; i < pets.size() && !finded; i++) {
			if(pets.get(i).getId().equals(id)) {
				finded = true;
				msg = "The pet exist";
			}
		}
		return msg;
	}
	
	public String findBinaryPetById(String id){
		String msg = "The pet doesn't exist";
		boolean finded = false;
		int start = 0;
		int end = pets.size()-1;
		while(start <= end && !finded) {
			int middle = (start + end)/2;
			if(pets.get(middle).getId().equals(id)) {
				msg = "The pet exist";
				finded = true;
			}
			else if(pets.get(middle).getId().compareTo(id) > 0) {
				end = middle - 1;
			}
			else {
				start = middle +1;
			}
		}
		return msg;
	}
	
	public String findSequentialPetByName(String name){
		boolean finded = false;
		String msg = "The pet doesn't exist";
		for(int i = 0; i < pets.size() && !finded; i++) {
			if(pets.get(i).getName().equals(name)) {
				finded = true;
				msg = "The pet exist";
			}
		}
		return msg;
	}
	
	public String findBinaryPetByName(String name){
		String msg = "The pet doesn't exist";
		boolean finded = false;
		int start = 0;
		int end = pets.size()-1;
		while(start <= end && !finded) {
			int middle = (start + end)/2;
			if(pets.get(middle).getName().equals(name)) {
				msg = "The pet exist";
				finded = true;
			}
			else if(pets.get(middle).getName().compareTo(name) > 0) {
				end = middle - 1;
			}
			else {
				start = middle +1;
			}
		}
		return msg;
	}
	
	public String findSequentialPetByBirthDate(String birthDate){
		boolean finded = false;
		String msg = "The pet doesn't exist";
		for(int i = 0; i < pets.size() && !finded; i++) {
			if(pets.get(i).getBirthDate().equals(birthDate)) {
				finded = true;
				msg = "The pet exist";
			}
		}
		return msg;
	}
	
	public String findBinaryPetByBirthDate(String birthDate){
		String msg = "The pet doesn't exist";
		boolean finded = false;
		int start = 0;
		int end = pets.size()-1;
		while(start <= end && !finded) {
			int middle = (start + end)/2;
			if(pets.get(middle).getBirthDate().equals(birthDate)) {
				msg = "The pet exist";
				finded = true;
			}
			else if(pets.get(middle).getBirthDate().compareTo(birthDate) > 0) {
				end = middle - 1;
			}
			else {
				start = middle +1;
			}
		}
		return msg;
	}
	
	public String findSequentialPetByGender(int gender){
		boolean finded = false;
		String msg = "The pet doesn't exist";
		for(int i = 0; i < pets.size() && !finded; i++) {
			if(pets.get(i).getGender() == gender){
				finded = true;
				msg = "The pet exist";
			}
		}
		return msg;
	}
	
	public String findBinaryPetByGender(int gender){
		String msg = "The pet doesn't exist";
		boolean finded = false;
		int start = 0;
		int end = pets.size()-1;
		while(start <= end && !finded) {
			int middle = (start + end)/2;
			if(pets.get(middle).getGender() == gender) {
				msg = "The pet exist";
				finded = true;
			}
			else if(pets.get(middle).getGender() - gender > 0) {
				end = middle - 1;
			}
			else {
				start = middle +1;
			}
		}
		return msg;
	}
	
	public String findSequentialPetByType(String type){
		boolean finded = false;
		String msg = "The pet doesn't exist";
		for(int i = 0; i < pets.size() && !finded; i++) {
			if(pets.get(i).getType().equals(type)) {
				finded = true;
				msg = "The pet exist";
			}
		}
		return msg;
	}
	
	public String findBinaryPetByType(String type){
		String msg = "The pet doesn't exist";
		boolean finded = false;
		int start = 0;
		int end = pets.size()-1;
		while(start <= end && !finded) {
			int middle = (start + end)/2;
			if(pets.get(middle).getType().equals(type)) {
				msg = "The pet exist";
				finded = true;
			}
			else if(pets.get(middle).getType().compareTo(type) > 0) {
				end = middle - 1;
			}
			else {
				start = middle +1;
			}
		}
		return msg;
	}
	
	public boolean eliminatePet(String msg) {
		boolean eliminated = false;
		for (int i = 0; i < pets.size(); i++) {
			if(pets.get(i).getName().equals(msg) || pets.get(i).getId().equals(msg)) {
				eliminated = true;
				pets.remove(i);
			}
		}
		return eliminated;
	}

	@Override
	public String toString() {
		return "id=" + id + ", names=" + names + ", lastNames=" + lastNames + ", birthDate=" + birthDate
				+ ", petsType=" + petsType+"\n";
	}
	
	public String thePets() {
		String msg = "";
		for(int i = 0; i < pets.size(); i++) {
			msg += pets.get(i)+"\n";
		}
		return msg;
	}
}
