package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Club implements Comparable<Club>, Comparator<Club>{
	
	private String id;
	private String name;
	private String creationDate;
	private String petsType;
	private ArrayList<Owner> owners;
	
	public Club(String id, String name, String creationDate, String petsType) throws IOException, ClassNotFoundException {
		this.id = id;
		this.name = name;
		this.creationDate = creationDate;
		this.petsType = petsType;
		owners = new ArrayList<Owner>();
		if(!new File(id).exists()) {
			new File(id).createNewFile();
		}
		loadData();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getPetsType() {
		return petsType;
	}

	public void setPetsType(String petsType) {
		this.petsType = petsType;
	}

	public ArrayList<Owner> getOwners() {
		return owners;
	}

	public void setOwners(ArrayList<Owner> owners) {
		this.owners = owners;
	}

	@Override
	public int compareTo(Club o) {
		return owners.size()-o.getOwners().size();
	}
	
	@Override
	public int compare(Club o1, Club o2) {
		return o1.getId().compareTo(o2.getId());
	}
	
	public int compareByName(Club e) {
		return name.compareTo(e.getName());
	}
	
	public int compareByCreationDate(Club e) {
		return creationDate.compareTo(e.getCreationDate());
	}
	
	public int compareByPetsType(Club e) {
		return petsType.compareTo(e.getPetsType());
	}
	
	
	public void addOwner(Owner e) throws IOException {
		owners.add(e);
		saveData();
	}
	
	public void saveData() throws IOException {
		File f = new File(id);
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		bw.write("");
		bw.close();
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(f));
		for(int i = 0; i < owners.size(); i++) {
			o.writeObject(owners.get(i));
		}
		o.close();
	}
	
	//By insertion
	public void orderOwnersByPetsNumber() {
		for(int i = 1; i < owners.size(); i++) {
			for(int j = i; j >0; j--) {
				if(owners.get(j-1).compare(owners.get(j-1), owners.get(j)) > 0) {
					Owner aux = owners.get(j);
					owners.set(j, owners.get(j+1));
					owners.set(j+1, aux);
				}
			}
		}
	}
	
	//By insertion
	public void orderOwnersById() {
		for(int i = 1; i < owners.size(); i++) {
			for(int j = i; j >0; j--) {
				if(owners.get(j-1).compareTo(owners.get(j)) > 0) {
					Owner aux = owners.get(j);
					owners.set(j, owners.get(j+1));
					owners.set(j+1, aux);
				}
			}
		}
	}
	
	//By insertion
	public void orderOwnersByNames() {
		for(int i = 1; i < owners.size(); i++) {
			for(int j = i; j >0; j--) {
				if(owners.get(j-1).compareByNames(owners.get(j)) > 0) {
					Owner aux = owners.get(j);
					owners.set(j, owners.get(j+1));
					owners.set(j+1, aux);
				}
			}
		}
	}
	
	//By insertion
	public void orderOwnersByLastNames() {
		for(int i = 1; i < owners.size(); i++) {
			for(int j = i; j >0; j--) {
				if(owners.get(j-1).compareByLastNames(owners.get(j)) > 0) {
					Owner aux = owners.get(j);
					owners.set(j, owners.get(j+1));
					owners.set(j+1, aux);
				}
			}
		}
	}
	
	//By insertion
	public void orderOwnersByBirthDate() {
		for(int i = 1; i < owners.size(); i++) {
			for(int j = i; j >0; j--) {
				if(owners.get(j-1).compareByBirthDate(owners.get(j)) > 0) {
					Owner aux = owners.get(j);
					owners.set(j, owners.get(j+1));
					owners.set(j+1, aux);
				}
			}
		}
	}
	
	//By insertion
	public void orderOwnersByPetsType() {
		for(int i = 1; i < owners.size(); i++) {
			for(int j = i; j >0; j--) {
				if(owners.get(j-1).compareByPetsType(owners.get(j)) > 0) {
					Owner aux = owners.get(j);
					owners.set(j, owners.get(j+1));
					owners.set(j+1, aux);
				}
			}
		}
	}
	
	public String findSequentialOwnerById(String id){
		boolean finded = false;
		String msg = "The owner doesn't exist";
		for(int i = 0; i < owners.size() && !finded; i++) {
			if(owners.get(i).getId().equals(id)) {
				finded = true;
				msg = "The owner exist";
			}
		}
		return msg;
	}
	
	public String findBinaryOwnerById(String id){
		String msg = "The owner doesn't exist";
		boolean finded = false;
		int start = 0;
		int end = owners.size()-1;
		while(start <= end && !finded) {
			int middle = (start + end)/2;
			if(owners.get(middle).getId().equals(id)) {
				msg = "The owner exist";
				finded = true;
			}
			else if(owners.get(middle).getId().compareTo(id) > 0) {
				end = middle - 1;
			}
			else {
				start = middle +1;
			}
		}
		return msg;
	}
	
	public String findSequentialOwnerByNames(String names){
		boolean finded = false;
		String msg = "The owner doesn't exist";
		for(int i = 0; i < owners.size() && !finded; i++) {
			if(owners.get(i).getNames().equals(names)) {
				finded = true;
				msg = "The owner exist";
			}
		}
		return msg;
	}
	
	public String findBinaryOwnerByNames(String names){
		String msg = "The owner doesn't exist";
		boolean finded = false;
		int start = 0;
		int end = owners.size()-1;
		while(start <= end && !finded) {
			int middle = (start + end)/2;
			if(owners.get(middle).getNames().equals(names)) {
				msg = "The owner exist";
				finded = true;
			}
			else if(owners.get(middle).getNames().compareTo(names) > 0) {
				end = middle - 1;
			}
			else {
				start = middle +1;
			}
		}
		return msg;
	}
	
	public String findSequentialOwnerByLastNames(String lastNames){
		boolean finded = false;
		String msg = "The owner doesn't exist";
		for(int i = 0; i < owners.size() && !finded; i++) {
			if(owners.get(i).getLastNames().equals(lastNames)) {
				finded = true;
				msg = "The owner exist";
			}
		}
		return msg;
	}
	
	public String findBinaryOwnerByLastNames(String lastNames){
		String msg = "The owner doesn't exist";
		boolean finded = false;
		int start = 0;
		int end = owners.size()-1;
		while(start <= end && !finded) {
			int middle = (start + end)/2;
			if(owners.get(middle).getLastNames().equals(lastNames)) {
				msg = "The owner exist";
				finded = true;
			}
			else if(owners.get(middle).getLastNames().compareTo(lastNames) > 0) {
				end = middle - 1;
			}
			else {
				start = middle +1;
			}
		}
		return msg;
	}
	
	public String findSequentialOwnerByBirthDate(String birthDate){
		boolean finded = false;
		String msg = "The owner doesn't exist";
		for(int i = 0; i < owners.size() && !finded; i++) {
			if(owners.get(i).getBirthDate().equals(birthDate)) {
				finded = true;
				msg = "The owner exist";
			}
		}
		return msg;
	}
	
	public String findBinaryOwnerByBirthDate(String birthDate){
		String msg = "The owner doesn't exist";
		boolean finded = false;
		int start = 0;
		int end = owners.size()-1;
		while(start <= end && !finded) {
			int middle = (start + end)/2;
			if(owners.get(middle).getBirthDate().equals(birthDate)) {
				msg = "The owner exist";
				finded = true;
			}
			else if(owners.get(middle).getBirthDate().compareTo(birthDate) > 0) {
				end = middle - 1;
			}
			else {
				start = middle +1;
			}
		}
		return msg;
	}
	
	public String findSequentialOwnerByPetsType(String petsType){
		boolean finded = false;
		String msg = "The owner doesn't exist";
		for(int i = 0; i < owners.size() && !finded; i++) {
			if(owners.get(i).getPetsType().equals(petsType)) {
				finded = true;
				msg = "The owner exist";
			}
		}
		return msg;
	}
	
	public String findBinaryOwnerByPetsType(String petsType){
		String msg = "The owner doesn't exist";
		boolean finded = false;
		int start = 0;
		int end = owners.size()-1;
		while(start <= end && !finded) {
			int middle = (start + end)/2;
			if(owners.get(middle).getPetsType().equals(petsType)) {
				msg = "The owner exist";
				finded = true;
			}
			else if(owners.get(middle).getPetsType().compareTo(petsType) > 0) {
				end = middle - 1;
			}
			else {
				start = middle +1;
			}
		}
		return msg;
	}
	
	public String findSequentialPetById(String id) {
		String msg = "The pet doesn't exist";
		boolean finded = false;
		for(int i = 0; i < owners.size() && !finded; i++) {
			if(owners.get(i).findSequentialPetById(id).equals("The pet exist")) {
				finded = true;
				msg = "The pet exist";
			}
		}
		return msg;
	}
	
	public String findBinaryPetById(String id) {
		String msg = "The pet doesn't exist";
		boolean finded = false;
		for(int i = 0; i < owners.size() && !finded; i++) {
			if(owners.get(i).findBinaryPetById(id).equals("The pet exist")) {
				finded = true;
				msg = "The pet exist";
			}
		}
		return msg;
	}
	
	public String findSequentialPetByName(String name) {
		String msg = "The pet doesn't exist";
		boolean finded = false;
		for(int i = 0; i < owners.size() && !finded; i++) {
			if(owners.get(i).findSequentialPetByName(name).equals("The pet exist")) {
				finded = true;
				msg = "The pet exist";
			}
		}
		return msg;
	}
	
	public String findBinaryPetByName(String name) {
		String msg = "The pet doesn't exist";
		boolean finded = false;
		for(int i = 0; i < owners.size() && !finded; i++) {
			if(owners.get(i).findBinaryPetByName(name).equals("The pet exist")) {
				finded = true;
				msg = "The pet exist";
			}
		}
		return msg;
	}
	
	public String findSequentialPetByBirthDate(String birthDate) {
		String msg = "The pet doesn't exist";
		boolean finded = false;
		for(int i = 0; i < owners.size() && !finded; i++) {
			if(owners.get(i).findSequentialPetByBirthDate(birthDate).equals("The pet exist")) {
				finded = true;
				msg = "The pet exist";
			}
		}
		return msg;
	}
	
	public String findBinaryPetByBirthDate(String birthDate) {
		String msg = "The pet doesn't exist";
		boolean finded = false;
		for(int i = 0; i < owners.size() && !finded; i++) {
			if(owners.get(i).findBinaryPetByBirthDate(birthDate).equals("The pet exist")) {
				finded = true;
				msg = "The pet exist";
			}
		}
		return msg;
	}
	
	public String findSequentialPetByGender(int gender) {
		String msg = "The pet doesn't exist";
		boolean finded = false;
		for(int i = 0; i < owners.size() && !finded; i++) {
			if(owners.get(i).findSequentialPetByGender(gender).equals("The pet exist")) {
				finded = true;
				msg = "The pet exist";
			}
		}
		return msg;
	}
	
	public String findBinaryPetByGender(int gender) {
		String msg = "The pet doesn't exist";
		boolean finded = false;
		for(int i = 0; i < owners.size() && !finded; i++) {
			if(owners.get(i).findBinaryPetByGender(gender).equals("The pet exist")) {
				finded = true;
				msg = "The pet exist";
			}
		}
		return msg;
	}
	
	public String findSequentialPetByType(String type) {
		String msg = "The pet doesn't exist";
		boolean finded = false;
		for(int i = 0; i < owners.size() && !finded; i++) {
			if(owners.get(i).findSequentialPetByType(type).equals("The pet exist")) {
				finded = true;
				msg = "The pet exist";
			}
		}
		return msg;
	}
	
	public String findBinaryPetByType(String type) {
		String msg = "The pet doesn't exist";
		boolean finded = false;
		for(int i = 0; i < owners.size() && !finded; i++) {
			if(owners.get(i).findBinaryPetByType(type).equals("The pet exist")) {
				finded = true;
				msg = "The pet exist";
			}
		}
		return msg;
	}
	
	public boolean ownerExist(String id) {
		boolean finded = false;
		for(int i = 0; i < owners.size() && !finded; i++) {
			if(owners.get(i).getId().equals(id)) {
				finded = true;
			}
		}
		return finded;
	}
	
	public void addPet(Pet e, String idOwner) throws PetName, IOException {
		boolean finded = false;
		for(int i = 0; i < owners.size() && !finded; i++) {
			if(owners.get(i).getId().equals(idOwner)) {
				finded = true;
				owners.get(i).addPets(e);
				saveData();
			}
		}
	}
	
	public boolean eliminatePet(String msg) {
		boolean finded = false;
		for(int i = 0; i < owners.size(); i++) {
			finded = owners.get(i).eliminatePet(msg);
		}
		return finded;
	}
	
	public boolean eliminateOwner(String msg) throws IOException {
		boolean eliminated = false;
		for (int i = 0; i < owners.size(); i++) {
			if(owners.get(i).getNames().equals(msg) || owners.get(i).getId().equals(msg)) {
				eliminated = true;
				owners.remove(i);
				saveData();
			}
		}
		return eliminated;
	}

	@Override
	public String toString() {
		return id+","+name+","+creationDate+","+petsType;
	}
	
	public void loadData() {
		File f = new File(id);
		try {
			ObjectInputStream o = new ObjectInputStream(new FileInputStream(f));
			owners = (ArrayList<Owner>)o.readObject();
			o.close();
		}catch(Exception e) {
		
		}
	}
	
	public String thePets() {
		String msg = "";
		for(int i = 0; i < owners.size(); i++) {
			msg += owners.get(i).thePets();
		}
		return msg;
	}
	
	public String theOwners() {
		String msg = "";
		for(int i = 0; i < owners.size(); i++) {
			msg += owners.get(i)+"\n";
		}
		return msg;
	}
	
	public void orderPetsById() {
		for(int i = 0; i < owners.size(); i++) {
			owners.get(i).orderPetsById();
		}
	}
	
	public void orderPetsByName() {
		for(int i = 0; i < owners.size(); i++) {
			owners.get(i).orderPetsByName();
		}
	}
	
	public void orderPetsByBirthDate() {
		for(int i = 0; i < owners.size(); i++) {
			owners.get(i).orderPetsByBirthDate();
		}
	}
	
	public void orderPetsByGender() {
		for(int i = 0; i < owners.size(); i++) {
			owners.get(i).orderPetsByGender();
		}
	}
	
	public void orderPetsByType() {
		for(int i = 0; i < owners.size(); i++) {
			owners.get(i).orderPetsByType();
		}
	}
}
