package model;

import java.io.File;
import java.util.ArrayList;

public class Program {
	
	public static final String ARCHIVE_SERIALIZABLE = "\"C:\\Users\\mafes\\Documents\\LaboratoriosAPO\\PetsClubs\\OwnersAndPets.txt\"";
	public static final String ARCHIVE_PLANO = "\"C:\\Users\\mafes\\Documents\\LaboratoriosAPO\\PetsClubs\\Clubs.txt\"";
	
	private File archiveSerializable;
	private File archivePlane;
	private ArrayList<Club> clubs;

	public Program() {
		clubs = new ArrayList<Club>();
		archiveSerializable = new File(ARCHIVE_SERIALIZABLE);
		archivePlane = new File(ARCHIVE_PLANO);
	}

	public ArrayList<Club> getClubs() {
		return clubs;
	}

	public void setClubs(ArrayList<Club> clubs) {
		this.clubs = clubs;
	}

}
