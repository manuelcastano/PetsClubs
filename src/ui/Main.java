package ui;
import java.io.IOException;
import java.util.*;
import model.*;

public class Main {
	
	private Program information;
	private Scanner reader;
	
	public Main() throws ClassNotFoundException, IOException, NumberFormatException, PetName {
		System.out.println("Loading data... please wait a minute");
		information = new Program();
		reader = new Scanner(System.in);
		System.out.println("The data were loaded successfuly");
		menu();
	}
	
	public void menu() {
		int option = -1;
		while(option != 0) {
			System.out.println("0. Exit");
			System.out.println("1. Generate ordered lists");
			System.out.println("2. Find");
			System.out.println("3. Add pet");
			System.out.println("4. Add owner");
			System.out.println("5. Add Club");
			System.out.println("6. Eliminate");
			try {
				option = reader.nextInt();
				reader.nextLine();
				switch(option) {
				case 0:
					System.out.println("See you later");
					break;
				case 1:
					orderedList();
					break;
				case 2:
					find();
					break;
				case 3:
					addPet();
					break;
				case 4:
					addOwner();
					break;
				case 5:
					try {
						try {
							addClub();
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (PetName e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (ClassNotFoundException | IOException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 6:
					eliminate();
					break;
				default:
					System.out.println("Please select a correct option");
					break;
				}
			}catch(InputMismatchException e) {
				reader.nextLine();
				System.out.println("Please select a correct option");
			}
		}
	}
	
	public void orderedList() {
		int option = -1;
		System.out.println("What do you want to ordered?");
		System.out.println("1. Clubs");
		System.out.println("2. Owners");
		System.out.println("3. Pets");
		try {
			option = reader.nextInt();
			reader.nextLine();
			switch(option) {
			case 1:
				System.out.println("How do you want to ordered?");
				System.out.println("1. Id");
				System.out.println("2. Name");
				System.out.println("3. Creation date");
				System.out.println("4. Pets type");
				System.out.println("5. Owner's number");
				int optionC = 0;
				try {
					optionC = reader.nextInt();
					reader.nextLine();
					switch(optionC) {
					case 1:
						information.orderClubsById();
						System.out.println(information.theClubs());
						break;
					case 2:
						information.orderClubsByName();
						System.out.println(information.theClubs());
						break;
					case 3:
						information.orderClubsByCreationDate();
						System.out.println(information.theClubs());
						break;
					case 4:
						information.orderClubsByPetsType();
						System.out.println(information.theClubs());
						break;
					case 5:
						information.orderClubsByOwnersNumber();
						System.out.println(information.theClubs());
						break;	
					default:
						System.out.println("Please select a correct option");
						break;
					}
				}
				catch(InputMismatchException e) {
					reader.nextLine();
					System.out.println("Please select a correct option");
				}
				break;
			case 2:
				System.out.println("How do you want to ordered?");
				System.out.println("1. Id");
				System.out.println("2. Names");
				System.out.println("3. Last names");
				System.out.println("4. Birth date");
				System.out.println("5. Pets type");
				System.out.println("6. Pet's number");
				int optionO = 0;
				try {
					optionO = reader.nextInt();
					reader.nextLine();
					switch(optionO) {
					case 1:
						information.orderOwnersById();
						System.out.println(information.theOwners());
						break;
					case 2:
						information.orderOwnersByNames();
						System.out.println(information.theOwners());
						break;
					case 3:
						information.orderOwnersByLastNames();
						System.out.println(information.theOwners());
						break;
					case 4:
						information.orderOwnersByBirthDate();
						System.out.println(information.theOwners());
						break;
					case 5:
						information.orderOwnersByPetsType();
						System.out.println(information.theOwners());
						break;
					case 6:
						information.orderOwnersByPetsNumber();
						System.out.println(information.theOwners());
						break;
					default:
						System.out.println("Please select a correct option");
						break;
					}
				}
				catch(InputMismatchException e) {
					reader.nextLine();
					System.out.println("Please select a correct option");
				}
				break;
			case 3:
				System.out.println("How do you want to ordered?");
				System.out.println("1. Id");
				System.out.println("2. Name");
				System.out.println("3. Birth date");
				System.out.println("4. Gender");
				System.out.println("5. Type");
				int optionP = 0;
				try {
					optionP = reader.nextInt();
					reader.nextLine();
					switch(optionP) {
					case 1:
						information.orderPetsById();
						System.out.println(information.thePets());
						break;
					case 2:
						information.orderPetsByName();
						System.out.println(information.thePets());
						break;
					case 3:
						information.orderPetsByBirthDate();
						System.out.println(information.thePets());
						break;
					case 4:
						information.orderPetsByGender();
						System.out.println(information.thePets());
						break;
					case 5:
						information.orderPetsByType();
						System.out.println(information.thePets());
						break;	
					default:
						System.out.println("Please select a correct option");
						break;
					}
				}
				catch(InputMismatchException e) {
					reader.nextLine();
					System.out.println("Please select a correct option");
				}
				switch(optionP) {
				case 1:
					information.orderPetsById();
					break;
				case 2:
					information.orderPetsByName();
					break;
				case 3:
					information.orderPetsByBirthDate();
					break;
				case 4:
					information.orderPetsByGender();
					break;
				case 5:
					information.orderPetsByType();
					break;	
				default:
					System.out.println("Please select a correct option");
					break;
				}
				information.thePets();
				break;
			default: 
				System.out.println("Please select a correct option");
				break;
			}
		}
		catch(InputMismatchException e) {
			reader.nextLine();
			System.out.println("Please select a correct option");
		}	
	}
	
	public void find() {
		int option = 0;
		System.out.println("What do you want to find?");
		System.out.println("1. Clubs");
		System.out.println("2. Owners");
		System.out.println("3. Pets");
		try {
			option = reader.nextInt();
			reader.nextLine();
			switch(option) {
			case 1:
				System.out.println("How do you want to find?");
				System.out.println("1. By id");
				System.out.println("2. By name");
				System.out.println("3. By creation date");
				System.out.println("4. By pets type");
				option = reader.nextInt();
				reader.nextLine();
				switch(option) {
				case 1:
					System.out.println("Ordering the clubs by id...");
					information.orderClubsById();
					System.out.println("Id of the club: ");
					String id = reader.nextLine();
					long t1 = System.currentTimeMillis();
					System.out.println(information.findSequentialClubById(id));
					long t2 = System.currentTimeMillis();
					System.out.println("Time with sequential search "+(t2-t1));
					t1 = System.currentTimeMillis();
					System.out.println(information.findBinaryClubById(id));
					t2 = System.currentTimeMillis();
					System.out.println("Time with binary search "+(t2-t1));
					break;
				case 2:
					System.out.println("Ordering the clubs by name...");
					information.orderClubsByName();
					System.out.println("Name of the club: ");
					String name = reader.nextLine();
					t1 = System.currentTimeMillis();
					System.out.println(information.findSequentialClubByName(name));
					t2 = System.currentTimeMillis();
					System.out.println("Time with sequential search "+(t2-t1));
					t1 = System.currentTimeMillis();
					System.out.println(information.findBinaryClubByName(name));
					t2 = System.currentTimeMillis();
					System.out.println("Time with binary search "+(t2-t1));
					break;
				case 3:
					System.out.println("Ordering the clubs by creation date...");
					information.orderClubsByCreationDate();
					System.out.println("Creation date of the club: ");
					String creationDate = reader.nextLine();
					t1 = System.currentTimeMillis();
					System.out.println(information.findSequentialClubByCreationDate(creationDate));
					t2 = System.currentTimeMillis();
					System.out.println("Time with sequential search "+(t2-t1));
					t1 = System.currentTimeMillis();
					System.out.println(information.findBinaryClubByCreationDate(creationDate));
					t2 = System.currentTimeMillis();
					System.out.println("Time with binary search "+(t2-t1));
					break;
				case 4:
					System.out.println("Ordering the clubs by pets type...");
					information.orderClubsByPetsType();
					System.out.println("Pets type of the club: ");
					String petsType = reader.nextLine();
					t1 = System.currentTimeMillis();
					System.out.println(information.findSequentialClubByPetsType(petsType));
					t2 = System.currentTimeMillis();
					System.out.println("Time with sequential search "+(t2-t1));
					t1 = System.currentTimeMillis();
					System.out.println(information.findBinaryClubByPetsType(petsType));
					t2 = System.currentTimeMillis();
					System.out.println("Time with binary search "+(t2-t1));
					break;
				default: 
					System.out.println("Please select a correct option");
					break;
				}
				break;
			case 2:
				System.out.println("How do you want to find?");
				System.out.println("1. By id");
				System.out.println("2. By names");
				System.out.println("3. By last names");
				System.out.println("4. By birth date");
				System.out.println("4. By pets type");
				option = reader.nextInt();
				reader.nextLine();
				switch(option) {
				case 1:
					System.out.println("Ordering the owners by id...");
					information.orderOwnersById();
					System.out.println("Id of the owner: ");
					String id = reader.nextLine();
					long t1 = System.currentTimeMillis();
					System.out.println(information.findSequentialOwnerById(id));
					long t2 = System.currentTimeMillis();
					System.out.println("Time with sequential search "+(t2-t1));
					t1 = System.currentTimeMillis();
					System.out.println(information.findBinaryOwnerById(id));
					t2 = System.currentTimeMillis();
					System.out.println("Time with binary search "+(t2-t1));
					break;
				case 2:
					System.out.println("Ordering the owners by names...");
					information.orderOwnersByNames();
					System.out.println("Names of the owner: ");
					String names = reader.nextLine();
					t1 = System.currentTimeMillis();
					System.out.println(information.findSequentialOwnerByNames(names));
					t2 = System.currentTimeMillis();
					System.out.println("Time with sequential search "+(t2-t1));
					t1 = System.currentTimeMillis();
					System.out.println(information.findBinaryOwnerByNames(names));
					t2 = System.currentTimeMillis();
					System.out.println("Time with binary search "+(t2-t1));
					break;
				case 3:
					System.out.println("Ordering the owners by last names...");
					information.orderOwnersByNames();
					System.out.println("Last names of the owner: ");
					String lastNames = reader.nextLine();
					t1 = System.currentTimeMillis();
					System.out.println(information.findSequentialOwnerByLastNames(lastNames));
					t2 = System.currentTimeMillis();
					System.out.println("Time with sequential search "+(t2-t1));
					t1 = System.currentTimeMillis();
					System.out.println(information.findBinaryOwnerByLastNames(lastNames));
					t2 = System.currentTimeMillis();
					System.out.println("Time with binary search "+(t2-t1));
					break;
				case 4:
					System.out.println("Ordering the owners by birth date...");
					information.orderOwnersByBirthDate();
					System.out.println("Birth date of the owner: ");
					String birthDate = reader.nextLine();
					t1 = System.currentTimeMillis();
					System.out.println(information.findSequentialOwnerByBirthDate(birthDate));
					t2 = System.currentTimeMillis();
					System.out.println("Time with sequential search "+(t2-t1));
					t1 = System.currentTimeMillis();
					System.out.println(information.findBinaryOwnerByBirthDate(birthDate));
					t2 = System.currentTimeMillis();
					System.out.println("Time with binary search "+(t2-t1));
					break;
				case 5:
					System.out.println("Ordering the owners by pets type...");
					information.orderOwnersByPetsType();
					System.out.println("Birth date of the owner: ");
					String petsType = reader.nextLine();
					t1 = System.currentTimeMillis();
					System.out.println(information.findSequentialOwnerByPetsType(petsType));
					t2 = System.currentTimeMillis();
					System.out.println("Time with sequential search "+(t2-t1));
					t1 = System.currentTimeMillis();
					System.out.println(information.findBinaryOwnerByPetsType(petsType));
					t2 = System.currentTimeMillis();
					System.out.println("Time with binary search "+(t2-t1));
					break;
				default: 
					System.out.println("Please select a correct option");
					break;
				}
				break;
			case 3:
				System.out.println("How do you want to find?");
				System.out.println("1. By id");
				System.out.println("2. By name");
				System.out.println("3. By birth date");
				System.out.println("4. By gender");
				System.out.println("4. By type");
				option = reader.nextInt();
				reader.nextLine();
				switch(option) {
				case 1:
					System.out.println("Ordering the pets by id...");
					information.orderPetsById();
					System.out.println("Id of the pet: ");
					String id = reader.nextLine();
					long t1 = System.currentTimeMillis();
					System.out.println(information.findSequentialPetById(id));
					long t2 = System.currentTimeMillis();
					System.out.println("Time with sequential search "+(t2-t1));
					t1 = System.currentTimeMillis();
					System.out.println(information.findBinaryPetById(id));
					t2 = System.currentTimeMillis();
					System.out.println("Time with binary search "+(t2-t1));
					break;
				case 2:
					System.out.println("Ordering the pets by name...");
					information.orderPetsById();
					System.out.println("Name of the pet: ");
					String name = reader.nextLine();
					t1 = System.currentTimeMillis();
					System.out.println(information.findSequentialPetByName(name));
					t2 = System.currentTimeMillis();
					System.out.println("Time with sequential search "+(t2-t1));
					t1 = System.currentTimeMillis();
					System.out.println(information.findBinaryPetByName(name));
					t2 = System.currentTimeMillis();
					System.out.println("Time with binary search "+(t2-t1));
					break;
				case 3:
					System.out.println("Ordering the pets by birth date...");
					information.orderPetsByBirthDate();
					System.out.println("Birth date of the pet: ");
					String birthDate = reader.nextLine();
					t1 = System.currentTimeMillis();
					System.out.println(information.findSequentialPetByBirthDate(birthDate));
					t2 = System.currentTimeMillis();
					System.out.println("Time with sequential search "+(t2-t1));
					t1 = System.currentTimeMillis();
					System.out.println(information.findBinaryPetByBirthDate(birthDate));
					t2 = System.currentTimeMillis();
					System.out.println("Time with binary search "+(t2-t1));
					break;
				case 4:
					System.out.println("Ordering the pets gender...");
					information.orderPetsByGender();
					System.out.println("Birth date of the pet: ");
					int gender = reader.nextInt();
					reader.nextLine();
					t1 = System.currentTimeMillis();
					System.out.println(information.findSequentialPetByGender(gender));
					t2 = System.currentTimeMillis();
					System.out.println("Time with sequential search "+(t2-t1));
					t1 = System.currentTimeMillis();
					System.out.println(information.findBinaryPetByGender(gender));
					t2 = System.currentTimeMillis();
					System.out.println("Time with binary search "+(t2-t1));
					break;
				case 5:
					System.out.println("Ordering the pets by type...");
					information.orderPetsByBirthDate();
					System.out.println("Birth date of the pet: ");
					String type = reader.nextLine();
					t1 = System.currentTimeMillis();
					System.out.println(information.findSequentialPetByType(type));
					t2 = System.currentTimeMillis();
					System.out.println("Time with sequential search "+(t2-t1));
					t1 = System.currentTimeMillis();
					System.out.println(information.findBinaryPetByType(type));
					t2 = System.currentTimeMillis();
					System.out.println("Time with binary search "+(t2-t1));
					break;
				default: 
					System.out.println("Please select a correct option");
					break;
				}
				break;
			default: 
				System.out.println("Please select a correct option");
				break;
			}
		}catch(InputMismatchException e) {
			reader.nextLine();
			System.out.println(e.getMessage());
		}
	}
	
	public void addPet() {
		System.out.println("Id of the pet");
		String id = reader.nextLine();
		System.out.println("Name of the pet");
		String name = reader.nextLine();
		System.out.println("Birth date of the pet");
		System.out.println("Year");
		String year = reader.nextLine();
		System.out.println("Month (If the month is less than 10, please add a 0 in the front)");
		String month = reader.nextLine();
		System.out.println("Day (If the day is less than 10, please add a 0 in the front)");
		String day = reader.nextLine();
		String birthDate = year+"/"+month+"/"+day;
		System.out.println("Gender of the pet");
		System.out.println("1. Male");
		System.out.println("2. Female");
		int gender = 0;
		try {
			gender = reader.nextInt();
			reader.nextLine();
		}catch(InputMismatchException e) {
			reader.nextLine();
			System.out.println("Please select a correct option");
		}
		System.out.println("Type of the pet");
		String type = reader.nextLine();
		Pet e = new Pet(id, name, birthDate, gender, type);
		System.out.println("Id of the owner");
		String idOwner = reader.nextLine();
		try {
			System.out.println(information.addPet(idOwner, e));
		} catch (PetName e1) {
			System.out.println(e1.getMessage());
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		}
	}
	
	public void addOwner() {
		System.out.println("Id of the owner");
		String id = reader.nextLine();
		System.out.println("Names of the owner");
		String names = reader.nextLine();
		System.out.println("Last names of the owner");
		String lastNames = reader.nextLine();
		System.out.println("Birth date of the owner");
		System.out.println("Year");
		String year = reader.nextLine();
		System.out.println("Month (If the month is less than 10, please add a 0 in the front)");
		String month = reader.nextLine();
		System.out.println("Day (If the day is less than 10, please add a 0 in the front)");
		String day = reader.nextLine();
		String birthDate = year+"/"+month+"/"+day;
		System.out.println("Pets type of the owner");
		String petsType = reader.nextLine();
		Owner e = new Owner(id, names, lastNames, birthDate, petsType);		
		System.out.println("Id of the club");
		String idClub = reader.nextLine();
		try {
			information.addOwner(e, idClub);
		} catch (SameId e1) {
			System.out.println(e1.getMessage());
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		} catch (NoExist e1) {
			System.out.println(e1.getMessage());
		}
	}
	
	public void addClub() throws ClassNotFoundException, IOException, NumberFormatException, PetName {
		System.out.println("Id of the club");
		String id = reader.nextLine();
		System.out.println("Names of the club");
		String name = reader.nextLine();
		System.out.println("Creation date of the club");
		System.out.println("Year");
		String year = reader.nextLine();
		System.out.println("Month (If the month is less than 10, please add a 0 in the front)");
		String month = reader.nextLine();
		System.out.println("Day (If the day is less than 10, please add a 0 in the front)");
		String day = reader.nextLine();
		String creationDate = year+"/"+month+"/"+day;
		System.out.println("Pets type of the club");
		String petsType = reader.nextLine();
		Club e = new Club(id, name, creationDate, petsType);
		information.addClub(e);
	}
	
	public void eliminate() {
		int option = 0;
		System.out.println("What do you want to eliminate?");
		System.out.println("1. Club");
		System.out.println("2. Owner");
		System.out.println("3. Pet");
		try {
			option = reader.nextInt();
			reader.nextLine();
			switch(option) {
			case 1:
				System.out.println("Id or name:");
				String msg = reader.nextLine();
				try {
					System.out.println("Eliminating the club...");
					information.eliminateClub(msg);
				} catch (NoExist | ClassNotFoundException | IOException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				System.out.println("Id or name:");
				msg = reader.nextLine();
				try {
					information.eliminateOwner(msg);
				} catch (NoExist | IOException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("Id or name:");
				msg = reader.nextLine();
				try {
					information.eliminatePet(msg);
				} catch (NoExist e) {
					System.out.println(e.getMessage());
				}
				break;
			default:
				System.out.println("Please select a correct option");
				break;
			}
		}catch(InputMismatchException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		try {
			Main m = new Main();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
