package model;

import java.util.ArrayList;
import java.util.Comparator;

public class Club implements Comparable<Club>, Comparator<Club>{
	
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
	

	public boolean sameOwner(Owner e){
		boolean equal = false;
		for (int i = 0; i < owners.size() && !equal; i++) {
			if(owners.get(i).compareTo(e)==0) {
				equal = true;
			}
		}
		return equal;
	}
	
	public void addOwner(Owner e) {
		owners.add(e);
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
}
