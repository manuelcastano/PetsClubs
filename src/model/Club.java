package model;

import java.util.ArrayList;

public class Club implements Comparable<Club>{
	
	private String id;
	private String name;
	private String creationDate;
	private String petsType;
	private ArrayList<Owner> owners;
	
	public Club(String id, String name, String creationDate, String petsType) {
		this.id = id;
		this.name = name;
		this.creationDate = creationDate;
		this.petsType = petsType;
		owners = new ArrayList<Owner>();
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
	
	public void addOwner(Owner e) throws SameId{
		boolean equal = false;
		for (int i = 0; i < owners.size() && !equal; i++) {
			if(owners.get(i).getId().equals(e.getId())) {
				equal = true;
			}
		}
		if(!equal) {
			owners.add(e);
		}
		else {
			throw new SameId();
		}
	}
	
	public int compareById(Club e) {
		return id.compareTo(e.getId());
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
}
