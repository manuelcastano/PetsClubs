import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.*;

class testOwner {

	private Owner owner;
	
	private void setupStage() {
		owner = new Owner("3443446", "John", "Mayor", "2015/08/09", "Dogs");
	}
	
	@Test
	public void testAddPets() {
		setupStage();
		Pet e = new Pet("73465465", "Perla", "2018/02/21", 2, "Dog");
		Pet e2 = new Pet("7466445", "Perla", "2017/02/21", 1, "Fish");
		try {
			owner.addPets(e);
		} catch (PetName e1) {
			fail();
		}
		try {
			owner.addPets(e2);
		} catch (PetName e1) {
			
		}
	}
	
	@Test
	public void testOrderPetsByBirthDate() {
		setupStage();
		Pet e = new Pet("73465465", "Perla", "2018/02/21", 2, "Dog");
		Pet e2 = new Pet("7466445", "Perla", "2017/08/01", 1, "Fish");
		try {
			owner.addPets(e);
		} catch (PetName e1) {
			fail();
		}
		try {
			owner.addPets(e2);
		} catch (PetName e1) {
			
		}
		owner.orderPetsByBirthDate();
		for(int i = 0; i < owner.getPets().size()-1; i++) {
			assertTrue(owner.getPets().get(i).getBirthDate().compareTo(owner.getPets().get(i+1).getBirthDate()) <= 0);
		}
	}
	
	@Test
	public void testFindBinaryPetById() {
		setupStage();
		Pet e = new Pet("73465465", "Perla", "2018/02/21", 2, "Dog");
		Pet e2 = new Pet("7466445", "Perla", "2017/08/01", 1, "Fish");
		Pet e3 = new Pet("3746357", "Tobias", "2010/08/01", 1, "Cat");
		try {
			owner.addPets(e);
		} catch (PetName e1) {
			fail();
		}
		try {
			owner.addPets(e2);
		} catch (PetName e1) {
			
		}
		try {
			owner.addPets(e3);
		} catch (PetName e1) {
			fail();
		}
		owner.orderPetsById();
		assertTrue(owner.findBinaryPetById("3746357").equals("The pet exist"));
	}
	
	@Test
	public void testEliminatePet() {
		setupStage();
		Pet e = new Pet("73465465", "Perla", "2018/02/21", 2, "Dog");
		Pet e2 = new Pet("7466445", "Perla", "2017/08/01", 1, "Fish");
		try {
			owner.addPets(e);
		} catch (PetName e1) {
			fail();
		}
		try {
			owner.addPets(e2);
		} catch (PetName e1) {
			
		}
		assertTrue(owner.eliminatePet("Perla"));
		assertTrue(owner.getPets().size() == 0);
	}
}
