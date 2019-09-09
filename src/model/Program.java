package model;

import java.io.*;
import java.util.ArrayList;

public class Program {
	
	public static final String ARCHIVE_PLANE = "Clubs.csv";
	
	private ArrayList<Club> clubs;

	public Program() throws ClassNotFoundException, IOException {
		clubs = new ArrayList<Club>();
		loadData();
	}

	public ArrayList<Club> getClubs() {
		return clubs;
	}

	public void setClubs(ArrayList<Club> clubs) {
		this.clubs = clubs;
	}
	
	public void addClub(Club e) throws IOException {
		clubs.add(e);
		File f = new File(ARCHIVE_PLANE);
		FileWriter fw = new FileWriter(f.getAbsoluteFile(), true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(e.toString()+"\n");
		bw.close();
	}
	
	public void addOwner(Owner e, String idClub) throws SameId, IOException, NoExist{
		boolean equal = false;
		for(int i = 0; i < clubs.size() && !equal; i++) {
			if(clubs.get(i).ownerExist(e.getId())) {
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
			if(!finded) {
				throw new NoExist();
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
	
	public String findSequentialClubById(String id){
		boolean finded = false;
		String msg = "The club doesn't exist";
		for(int i = 0; i < clubs.size() && !finded; i++) {
			if(clubs.get(i).getId().equals(id)) {
				finded = true;
				msg = "The club exist";
			}
		}
		return msg;
	}
	
	public String findBinaryClubById(String id){
		String msg = "The club doesn't exist";
		boolean finded = false;
		int start = 0;
		int end = clubs.size()-1;
		while(start <= end && !finded) {
			int middle = (start + end)/2;
			if(clubs.get(middle).getId().equals(id)) {
				msg = "The club exist";
				finded = true;
			}
			else if(clubs.get(middle).getId().compareTo(id) > 0) {
				end = middle - 1;
			}
			else {
				start = middle +1;
			}
		}
		return msg;
	}
	
	public String findSequentialClubByName(String name){
		boolean finded = false;
		String msg = "The club doesn't exist";
		for(int i = 0; i < clubs.size() && !finded; i++) {
			if(clubs.get(i).getName().equals(name)) {
				finded = true;
				msg = "The club exist";
			}
		}
		return msg;
	}
	
	public String findBinaryClubByName(String name){
		String msg = "The club doesn't exist";
		boolean finded = false;
		int start = 0;
		int end = clubs.size()-1;
		while(start <= end && !finded) {
			int middle = (start + end)/2;
			if(clubs.get(middle).getName().equals(name)) {
				msg = "The club exist";
				finded = true;
			}
			else if(clubs.get(middle).getName().compareTo(name) > 0) {
				end = middle - 1;
			}
			else {
				start = middle +1;
			}
		}
		return msg;
	}
	
	public String findSequentialClubByCreationDate(String creationDate){
		boolean finded = false;
		String msg = "The club doesn't exist";
		for(int i = 0; i < clubs.size() && !finded; i++) {
			if(clubs.get(i).getCreationDate().equals(creationDate)) {
				finded = true;
				msg = "The club exist";
			}
		}
		return msg;
	}
	
	public String findBinaryClubByCreationDate(String creationDate){
		String msg = "The club doesn't exist";
		boolean finded = false;
		int start = 0;
		int end = clubs.size()-1;
		while(start <= end && !finded) {
			int middle = (start + end)/2;
			if(clubs.get(middle).getCreationDate().equals(creationDate)) {
				msg = "The club exist";
				finded = true;
			}
			else if(clubs.get(middle).getCreationDate().compareTo(creationDate) > 0) {
				end = middle - 1;
			}
			else {
				start = middle +1;
			}
		}
		return msg;
	}
	
	public String findSequentialClubByPetsType(String petsType){
		boolean finded = false;
		String msg = "The club doesn't exist";
		for(int i = 0; i < clubs.size() && !finded; i++) {
			if(clubs.get(i).getPetsType().equals(petsType)) {
				finded = true;
				msg = "The club exist";
			}
		}
		return msg;
	}
	
	public String findBinaryClubByPetsType(String petsType){
		String msg = "The club doesn't exist";
		boolean finded = false;
		int start = 0;
		int end = clubs.size()-1;
		while(start <= end && !finded) {
			int middle = (start + end)/2;
			if(clubs.get(middle).getPetsType().equals(petsType)) {
				msg = "The club exist";
				finded = true;
			}
			else if(clubs.get(middle).getPetsType().compareTo(petsType) > 0) {
				end = middle - 1;
			}
			else {
				start = middle +1;
			}
		}
		return msg;
	}
	
	public String findSequentialOwnerById(String id) {
		String msg = "The owner doesn't exist";
		boolean finded = false;
		for(int i = 0; i < clubs.size() && !finded; i++) {
			if(clubs.get(i).findSequentialOwnerById(id).equals("The owner exist")) {
				finded = true;
				msg = "The owner exist";
			}
		}
		return msg;
	}
	
	public String findBinaryOwnerById(String id) {
		String msg = "The owner doesn't exist";
		boolean finded = false;
		for(int i = 0; i < clubs.size() && !finded; i++) {
			if(clubs.get(i).findBinaryOwnerById(id).equals("The owner exist")) {
				finded = true;
				msg = "The owner exist";
			}
		}
		return msg;
	}
	
	public String findSequentialOwnerByNames(String names) {
		String msg = "The owner doesn't exist";
		boolean finded = false;
		for(int i = 0; i < clubs.size() && !finded; i++) {
			if(clubs.get(i).findSequentialOwnerByNames(names).equals("The owner exist")) {
				finded = true;
				msg = "The owner exist";
			}
		}
		return msg;
	}
	
	public String findBinaryOwnerByNames(String names) {
		String msg = "The owner doesn't exist";
		boolean finded = false;
		for(int i = 0; i < clubs.size() && !finded; i++) {
			if(clubs.get(i).findBinaryOwnerByNames(names).equals("The owner exist")) {
				finded = true;
				msg = "The owner exist";
			}
		}
		return msg;
	}
	
	public String findSequentialOwnerByLastNames(String lastNames) {
		String msg = "The owner doesn't exist";
		boolean finded = false;
		for(int i = 0; i < clubs.size() && !finded; i++) {
			if(clubs.get(i).findSequentialOwnerByLastNames(lastNames).equals("The owner exist")) {
				finded = true;
				msg = "The owner exist";
			}
		}
		return msg;
	}
	
	public String findBinaryOwnerByLastNames(String lastNames) {
		String msg = "The owner doesn't exist";
		boolean finded = false;
		for(int i = 0; i < clubs.size() && !finded; i++) {
			if(clubs.get(i).findBinaryOwnerByLastNames(lastNames).equals("The owner exist")) {
				finded = true;
				msg = "The owner exist";
			}
		}
		return msg;
	}
	
	public String findSequentialOwnerByBirthDate(String birthDate) {
		String msg = "The owner doesn't exist";
		boolean finded = false;
		for(int i = 0; i < clubs.size() && !finded; i++) {
			if(clubs.get(i).findSequentialOwnerByBirthDate(birthDate).equals("The owner exist")) {
				finded = true;
				msg = "The owner exist";
			}
		}
		return msg;
	}
	
	public String findBinaryOwnerByBirthDate(String birthDate) {
		String msg = "The owner doesn't exist";
		boolean finded = false;
		for(int i = 0; i < clubs.size() && !finded; i++) {
			if(clubs.get(i).findBinaryOwnerByBirthDate(birthDate).equals("The owner exist")) {
				finded = true;
				msg = "The owner exist";
			}
		}
		return msg;
	}
	
	public String findSequentialOwnerByPetsType(String petsType) {
		String msg = "The owner doesn't exist";
		boolean finded = false;
		for(int i = 0; i < clubs.size() && !finded; i++) {
			if(clubs.get(i).findSequentialOwnerByPetsType(petsType).equals("The owner exist")) {
				finded = true;
				msg = "The owner exist";
			}
		}
		return msg;
	}
	
	public String findBinaryOwnerByPetsType(String petsType) {
		String msg = "The owner doesn't exist";
		boolean finded = false;
		for(int i = 0; i < clubs.size() && !finded; i++) {
			if(clubs.get(i).findBinaryOwnerByPetsType(petsType).equals("The owner exist")) {
				finded = true;
				msg = "The owner exist";
			}
		}
		return msg;
	}
	
	public String findSequentialPetById(String id) {
		String msg = "The pet doesn't exist";
		boolean finded = false;
		for(int i = 0; i < clubs.size() && !finded; i++) {
			if(clubs.get(i).findSequentialPetById(id).equals("The pet exist")) {
				finded = true;
				msg = "The pet exist";
			}
		}
		return msg;
	}
	
	public String findBinaryPetById(String id) {
		String msg = "The pet doesn't exist";
		boolean finded = false;
		for(int i = 0; i < clubs.size() && !finded; i++) {
			if(clubs.get(i).findBinaryPetById(id).equals("The pet exist")) {
				finded = true;
				msg = "The pet exist";
			}
		}
		return msg;
	}
	
	public String findSequentialPetByName(String name) {
		String msg = "The pet doesn't exist";
		boolean finded = false;
		for(int i = 0; i < clubs.size() && !finded; i++) {
			if(clubs.get(i).findSequentialPetByName(name).equals("The pet exist")) {
				finded = true;
				msg = "The pet exist";
			}
		}
		return msg;
	}
	
	public String findBinaryPetByName(String name) {
		String msg = "The pet doesn't exist";
		boolean finded = false;
		for(int i = 0; i < clubs.size() && !finded; i++) {
			if(clubs.get(i).findBinaryPetByName(name).equals("The pet exist")) {
				finded = true;
				msg = "The pet exist";
			}
		}
		return msg;
	}
	
	public String findSequentialPetByBirthDate(String birthDate) {
		String msg = "The pet doesn't exist";
		boolean finded = false;
		for(int i = 0; i < clubs.size() && !finded; i++) {
			if(clubs.get(i).findSequentialPetByBirthDate(birthDate).equals("The pet exist")) {
				finded = true;
				msg = "The pet exist";
			}
		}
		return msg;
	}
	
	public String findBinaryPetByBirthDate(String birthDate) {
		String msg = "The pet doesn't exist";
		boolean finded = false;
		for(int i = 0; i < clubs.size() && !finded; i++) {
			if(clubs.get(i).findBinaryPetByBirthDate(birthDate).equals("The pet exist")) {
				finded = true;
				msg = "The pet exist";
			}
		}
		return msg;
	}
	
	public String findSequentialPetByGender(int gender) {
		String msg = "The pet doesn't exist";
		boolean finded = false;
		for(int i = 0; i < clubs.size() && !finded; i++) {
			if(clubs.get(i).findSequentialPetByGender(gender).equals("The pet exist")) {
				finded = true;
				msg = "The pet exist";
			}
		}
		return msg;
	}
	
	public String findBinaryPetByGender(int gender) {
		String msg = "The pet doesn't exist";
		boolean finded = false;
		for(int i = 0; i < clubs.size() && !finded; i++) {
			if(clubs.get(i).findBinaryPetByGender(gender).equals("The pet exist")) {
				finded = true;
				msg = "The pet exist";
			}
		}
		return msg;
	}
	
	public String findSequentialPetByType(String type) {
		String msg = "The pet doesn't exist";
		boolean finded = false;
		for(int i = 0; i < clubs.size() && !finded; i++) {
			if(clubs.get(i).findSequentialPetByType(type).equals("The pet exist")) {
				finded = true;
				msg = "The pet exist";
			}
		}
		return msg;
	}
	
	public String findBinaryPetByType(String type) {
		String msg = "The pet doesn't exist";
		boolean finded = false;
		for(int i = 0; i < clubs.size() && !finded; i++) {
			if(clubs.get(i).findBinaryPetByType(type).equals("The pet exist")) {
				finded = true;
				msg = "The pet exist";
			}
		}
		return msg;
	}
	
	public String addPet(String idOwner, Pet e) throws PetName, IOException {
		boolean finded = false;
		String msg = "The owner doesn't exist";
		for(int i = 0; i < clubs.size() && !finded; i++) {
			if(clubs.get(i).ownerExist(idOwner)) {
				finded = true;
				clubs.get(i).addPet(e, idOwner);
				msg = "The pet was added successfuly";
			}
		}
		return msg;
	}
	
	public void eliminatePet(String msg) throws NoExist{
		boolean finded = false;
		for(int i = 0; i < clubs.size(); i++) {
			finded = clubs.get(i).eliminatePet(msg);
		}
		if(!finded) {
			throw new NoExist();
		}
	}
	
	public void eliminateOwner(String msg) throws NoExist, IOException{
		boolean finded = false;
		for(int i = 0; i < clubs.size(); i++) {
			finded = clubs.get(i).eliminateOwner(msg);
		}
		if(!finded) {
			throw new NoExist();
		}
	}
	
	public void eliminateClub(String msg) throws NoExist, ClassNotFoundException, IOException{
		boolean eliminated = false;
		for (int i = 0; i < clubs.size(); i++) {
			if(clubs.get(i).getName().equals(msg) || clubs.get(i).getId().equals(msg)) {
				eliminated = true;
				System.out.println(new File(clubs.get(i).getId()).delete());
				File f = new File(ARCHIVE_PLANE);
				File tempFile = new File(f.getAbsolutePath()+".csv");
				BufferedReader br = new BufferedReader(new FileReader(f));
		        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
		        String line = null;
		        while ((line = br.readLine()) != null) {
		            if (!line.trim().equals(clubs.get(i).toString())) {
		                pw.println(line);
		                pw.flush();
		            }
		        }
		        pw.close();
		        br.close();
		        f.delete();
		        tempFile.renameTo(f);
		     }
		}
		if(!eliminated) {
			throw new NoExist();
		}
	}
	
	public void loadData() throws IOException, ClassNotFoundException {
		File f = new File(ARCHIVE_PLANE);
		BufferedReader br = new BufferedReader(new FileReader(f));
		String line;
		while((line= br.readLine())!=null) {
        	if(!line.equals("id,name,creationdate,mascotsType")) {
        		try {
        			String[] s = line.split(",");
                	Club e = new Club(s[0], s[1], s[2], s[3]);
                	clubs.add(e);
        		}catch(Exception e) {
        			
        		}
            }
        }
        br.close();
	}
	
	public String thePets() {
		String msg = "";
		for(int i = 0; i < clubs.size(); i++) {
			msg += clubs.get(i).thePets();
		}
		return msg;
	}
	
	public String theOwners() {
		String msg = "";
		for(int i = 0; i < clubs.size(); i++) {
			msg += clubs.get(i).theOwners();
		}
		return msg;
	}
	
	public String theClubs() {
		String msg = "";
		for(int i = 0; i < clubs.size(); i++) {
			msg += clubs.get(i);
		}
		return msg;
	}
	
	public void orderPetsById() {
		for(int i = 0; i < clubs.size(); i++) {
			clubs.get(i).orderPetsById();
		}
	}
	
	public void orderPetsByName() {
		for(int i = 0; i < clubs.size(); i++) {
			clubs.get(i).orderPetsByName();
		}
	}
	
	public void orderPetsByBirthDate() {
		for(int i = 0; i < clubs.size(); i++) {
			clubs.get(i).orderPetsByBirthDate();
		}
	}
	
	public void orderPetsByGender() {
		for(int i = 0; i < clubs.size(); i++) {
			clubs.get(i).orderPetsByGender();
		}
	}
	
	public void orderPetsByType() {
		for(int i = 0; i < clubs.size(); i++) {
			clubs.get(i).orderPetsByType();
		}
	}
	
	public void orderOwnersById() {
		for(int i = 0; i < clubs.size(); i++) {
			clubs.get(i).orderOwnersById();
		}
	}
	
	public void orderOwnersByNames() {
		for(int i = 0; i < clubs.size(); i++) {
			clubs.get(i).orderOwnersByNames();
		}
	}
	
	public void orderOwnersByLastNames() {
		for(int i = 0; i < clubs.size(); i++) {
			clubs.get(i).orderOwnersByLastNames();
		}
	}
	
	public void orderOwnersByBirthDate() {
		for(int i = 0; i < clubs.size(); i++) {
			clubs.get(i).orderOwnersByBirthDate();
		}
	}
	
	public void orderOwnersByPetsType() {
		for(int i = 0; i < clubs.size(); i++) {
			clubs.get(i).orderOwnersByPetsType();
		}
	}
	
	public void orderOwnersByPetsNumber() {
		for(int i = 0; i < clubs.size(); i++) {
			clubs.get(i).orderOwnersByPetsNumber();
		}
	}
}
