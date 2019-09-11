import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import org.junit.jupiter.api.Test;

import model.*;

class testClub {
	
	private Club club;
	
	private void setupStage() {
		try {
			club = new Club("6874387645", "Asus", "2019/09/11", "Komodo Dragons");
		} catch (NumberFormatException | ClassNotFoundException | IOException e) {
			fail();
		}
	}
	
	@Test
	public void testAddOwner() {
		setupStage();
		Owner e = new Owner("150", "manuel", "Castaño", "2018/02/18", "Dogs");
		try {
			club.addOwner(e);
		} catch (IOException e1) {
			fail();
		}
		ObjectInputStream o = null;
		boolean exist = false;
		try {
			File f = new File(club.getId());
			o = new ObjectInputStream(new FileInputStream(f));
			Owner aux = (Owner)o.readObject();
			while(aux != null && !exist) {
				if(aux.getId().equals("150")) {
					exist = true;
				}
				aux = (Owner)o.readObject();
			}
			o.close();
			assertTrue(exist);
		}catch(IOException e1) {
			assertTrue(exist);
		}catch(Exception e2) {
			fail();
		}
	}
	
	@Test
	public void testSaveData() {
		setupStage();
		Owner e = new Owner("897", "yo", "Castaño", "2018/02/18", "Dogs");
		club.getOwners().add(e);
		try {
			club.saveData();
		} catch (IOException e1) {
			fail();
		}
		ObjectInputStream o = null;
		boolean exist = false;
		try {
			File f = new File(club.getId());
			o = new ObjectInputStream(new FileInputStream(f));
			Owner aux = (Owner)o.readObject();
			while(aux != null && !exist) {
				if(aux.getId().equals("897")) {
					exist = true;
				}
				aux = (Owner)o.readObject();
			}
			o.close();
			assertTrue(exist);
		}catch(IOException e1) {
			assertTrue(exist);
		}catch(Exception e2) {
			fail();
		}
	}
	
	@Test
	public void testOrderOwnersByPetsNumber() {
		setupStage();
		club.orderOwnersByPetsNumber();
		for(int i = 0; i < club.getOwners().size()-1; i++) {
			assertTrue(club.getOwners().get(i).compare(club.getOwners().get(i), club.getOwners().get(i+1)) <= 0);
		}
	}
	

	@Test
	public void testFindBinaryOwnerById() {
		setupStage();
		Owner e = new Owner("7867", "Fercho", "Cataño", "2015/06/21", "Turtle");
		try {
			club.addOwner(e);
		} catch (IOException e1) {
			fail();
		}
		club.orderOwnersById();
		assertTrue(club.findBinaryOwnerById("7867").equals("The owner exist"));
	}
	
	@Test
	public void addPet() {
		setupStage();
		Owner e = new Owner("4545", "gloria", "Cataño", "2015/06/21", "Turtle");
		try {
			club.addOwner(e);
		} catch (IOException e1) {
			fail();
		}
		Pet p = new Pet("437545", "Toby", "2008/09/02", 1, "Horse");
		try {
			club.addPet(p, "4545");
		} catch (PetName e1) {
			
		} catch (IOException e1) {
			fail();
		}
		setupStage();
		assertTrue(club.findSequentialPetByName("Toby").equals("The pet exist"));
	}
	
	@Test
	public void testEliminatePet() {
		setupStage();
		Owner e = new Owner("46443634", "Sebas", "Cataño", "2015/06/21", "Turtle");
		try {
			club.addOwner(e);
		} catch (IOException e1) {
			fail();
		}
		Pet p = new Pet("753326888", "Manchas", "2008/09/02", 1, "Horse");
		try {
			club.addPet(p, "46443634");
		} catch (PetName e1) {
			
		} catch (IOException e1) {
			fail();
		}
		try {
			club.eliminatePet("Manchas");
		} catch (IOException e1) {
			fail();
		}
		setupStage();
		assertTrue(club.findSequentialPetById("753326888").equals("The pet doesn't exist"));
	}
	
	@Test
	public void testEliminateOwner() {
		setupStage();
		Owner e = new Owner("35435435", "Maria", "Lopez", "2015/06/21", "Turtle");
		try {
			club.addOwner(e);
		} catch (IOException e1) {
			fail();
		}
		try {
			club.eliminateOwner("Maria");
		} catch (IOException e1) {
			fail();
		}
		setupStage();
		club.orderOwnersByNames();
		assertTrue(club.findBinaryOwnerByNames("Maria").equals("The owner doesn't exist"));
	}
	
	@Test
	public void testLoadData() {
		setupStage();
		assertTrue(club.getOwners().size() > 0);
	}
}
