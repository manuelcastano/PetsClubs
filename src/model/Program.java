package model;

import java.io.File;
import java.util.ArrayList;

public class Program {
	
	public static final String ARCHIVE_SERIALIZABLE = "\"C:\\Users\\mafes\\Documents\\LaboratoriosAPO\\PetsClubs\\OwnersAndPets.txt\"";
	public static final String ARCHIVE_PLANE = "\"C:\\Users\\mafes\\Documents\\LaboratoriosAPO\\PetsClubs\\Clubs.txt\"";
	
	private File archiveSerializable;
	private File archivePlane;
	private ArrayList<Club> clubs;

	public Program() {
		clubs = new ArrayList<Club>();
		archiveSerializable = new File(ARCHIVE_SERIALIZABLE);
		archivePlane = new File(ARCHIVE_PLANE);
	}

	public ArrayList<Club> getClubs() {
		return clubs;
	}

	public void setClubs(ArrayList<Club> clubs) {
		this.clubs = clubs;
	}
	
	public void addClub(Club e) {
		clubs.add(e);
	}
	
	public void addOwner(Owner e, String idClub) throws SameId{
		boolean equal = false;
		for(int i = 0; i < clubs.size() && !equal; i++) {
			if(clubs.get(i).sameOwner(e)) {
				equal = true;
			}
		}
		if(!equal) {
			boolean finded = false;
			for(int i = 0; i < clubs.size() && !finded; i++) {
				if(clubs.get(i).getId().equals(idClub)) {
					finded = true;
					clubs.get(i).addOwner(e);
				}
			}
		}
		else {
			throw new SameId();
		}
	}
	
	//By selection
	public void orderClubsByOwnersNumber() {
		for(int i = 0; i < clubs.size()-1; i++) {
			Club less = clubs.get(i);
			int aux= i;
			for(int j = i+1; j < clubs.size(); j++) {
				if(less.compareTo(clubs.get(j)) > 0) {
					less = clubs.get(j);
					aux = j;
				}
			}
			Club temp = clubs.get(i);
			clubs.set(i, less);
			clubs.set(aux, temp);
		}
	}
	
	//By selection
	public void orderClubsById() {
		for(int i = 0; i < clubs.size()-1; i++) {
			Club less = clubs.get(i);
			int aux= i;
			for(int j = i+1; j < clubs.size(); j++) {
				if(less.compare(less, clubs.get(j)) > 0) {
					less = clubs.get(j);
					aux = j;
				}
			}
			Club temp = clubs.get(i);
			clubs.set(i, less);
			clubs.set(aux, temp);
		}
	}
	
	//By selection
	public void orderClubsByName() {
		for(int i = 0; i < clubs.size()-1; i++) {
			Club less = clubs.get(i);
			int aux= i;
			for(int j = i+1; j < clubs.size(); j++) {
				if(less.compareByName(clubs.get(j)) > 0) {
					less = clubs.get(j);
					aux = j;
				}
			}
			Club temp = clubs.get(i);
			clubs.set(i, less);
			clubs.set(aux, temp);
		}
	}
	
	//By selection
	public void orderClubsByCreationDate() {
		for(int i = 0; i < clubs.size()-1; i++) {
			Club less = clubs.get(i);
			int aux= i;
			for(int j = i+1; j < clubs.size(); j++) {
				if(less.compareByCreationDate(clubs.get(j)) > 0) {
					less = clubs.get(j);
					aux = j;
				}
			}
			Club temp = clubs.get(i);
			clubs.set(i, less);
			clubs.set(aux, temp);
		}
	}
	
	//By selection
	public void orderClubsByPetsType() {
		for(int i = 0; i < clubs.size()-1; i++) {
			Club less = clubs.get(i);
			int aux= i;
			for(int j = i+1; j < clubs.size(); j++) {
				if(less.compareByPetsType(clubs.get(j)) > 0) {
					less = clubs.get(j);
					aux = j;
				}
			}
			Club temp = clubs.get(i);
			clubs.set(i, less);
			clubs.set(aux, temp);
		}
	}
	
	public Club findSequential(String id) throws NoExist{
		boolean finded = false;
		Club e = null;
		for(int i = 0; i < clubs.size() && !finded; i++) {
			if(clubs.get(i).getId().equals(id)) {
				finded = true;
				e = clubs.get(i);
			}
		}
		if(!finded) {
			throw new NoExist();
		}
		return e;
	}
}
