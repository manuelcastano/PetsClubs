import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.Club;
import model.NoExist;
import model.Owner;
import model.Pet;
import model.PetName;
import model.Program;
import model.SameId;

public class testProgram {
	
	private Program theProgram;
	
	private void setupStage() {
		try {
			theProgram = new Program();
		} catch (NumberFormatException | ClassNotFoundException | IOException e) {
			fail();
		}
	}
	
	@Test
	public void testAddClub() {
		try {
			setupStage();
			Club e = null;
			try {
			    e = new Club("1059463589", "Icesi", "2019/03/18", "Dogs");
				theProgram.addClub(e);
			}catch(Exception e1) {
				fail();
			}
			File f = new File(Program.ARCHIVE_PLANE);
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line;
			boolean finded = false;
			while((line = br.readLine())!=null && !finded) {
	        	if(line.equals(e.toString())) {
	        		finded = true;
	            }
	        }
	        br.close();
	        if(!finded) {
	        	fail();
	        }
		} catch (IOException e) {
			fail();
		}
	}
	
	@Test
	public void testAddOwner() {
		setupStage();
		Owner e = new Owner("1005966201", "Manuel David", "Castaño", "2001/12/14", "Dogs");
		try {
			theProgram.addOwner(e, "1059463589");
			File f = new File("0000000001");
			try {
				ObjectInputStream o = new ObjectInputStream(new FileInputStream(f));
				ArrayList<Owner> a = new ArrayList<Owner>();
				a = (ArrayList<Owner>) o.readObject();
				o.close();
				assertTrue(e.getId().equals(a.get(0).getId()));
			}catch(Exception e2) {
				fail();
			}
		} catch (SameId e1) {
		} catch (IOException e1) {
			fail();
		} catch (NoExist e1) {
			fail();
		}
	}
	
	@Test
	public void testOrderClubsById() {
		setupStage();
		theProgram.orderClubsById();
		for(int i = 0; i < theProgram.getClubs().size()-1; i++) {
			if(theProgram.getClubs().get(i).getId().compareTo(theProgram.getClubs().get(i+1).getId()) > 0) {
				fail();
			}
		}
	}
	
	@Test
	public void testFindBinaryClubById() {
		setupStage();
		theProgram.orderClubsById();
		if(theProgram.findBinaryClubById("1059463589").equals("The club doesn't exist")) {
			fail();
		}
	}
	
	@Test
	public void testAddPet() {
		setupStage();
		Pet e = new Pet("58", "Manchas", "2018/2/18", 1, "Pastor");
		Owner a = new Owner("1005966201", "Hi", "lo", "2018/02/09", "Dogs");
		try {
			theProgram.addOwner(a, "1059463589");
			theProgram.addPet("1005966201", e);
			theProgram.orderPetsById();
			assertTrue(theProgram.findBinaryPetById("58").equals("The pet exist"));
		} catch (PetName e1) {
			
		} catch (IOException e1) {
			fail();
		} catch (SameId e1) {
			
		} catch (NoExist e1) {
			
		}
	}
	
	@Test
	public void testEliminatePet() {
		setupStage();
		Pet e = new Pet("58", "Manchas", "2018/2/18", 1, "Pastor");
		Owner a = new Owner("1005966201", "Hi", "lo", "2018/02/09", "Dogs");
		try {
			theProgram.addOwner(a, "1059463589");
			theProgram.addPet("1005966201", e);
			theProgram.eliminatePet("58");
			theProgram.orderPetsById();
			assertTrue(theProgram.findBinaryPetById("58").equals("The pet doesn't exist"));
		} catch (PetName e1) {
			
		} catch (IOException e1) {
			fail();
		} catch (SameId e1) {
			
		} catch (NoExist e1) {
			
		}
	}
	
	@Test
	public void testEliminateOwner() {
		setupStage();
		Owner a = new Owner("10051966201", "Hi", "lo", "2018/02/09", "Dogs");
		try {
			theProgram.addOwner(a, "1059463589");
			theProgram.eliminateOwner("10051966201");
			assertTrue(theProgram.findSequentialOwnerById("10051966201").equals("The owner doesn't exist"));
		} catch (IOException e1) {
			fail();
		} catch (SameId e1) {
			
		} catch (NoExist e1) {
			fail();
		}
	}
	
	@Test
	public void testEliminateClub() {
		setupStage();
		try {
			Club a = new Club("00000000001", "Hi", "2018/02/09", "lo");
			theProgram.addClub(a);
			theProgram.eliminateClub("00000000001");
			theProgram.orderClubsById();
			assertTrue(theProgram.findBinaryClubById("00000000001").equals("The club doesn't exist"));
		} catch (NumberFormatException e2) {
			fail();
		} catch (ClassNotFoundException e2) {
			fail();
		} catch (IOException e2) {
			fail();
		} catch(NoExist e) {
			fail();
		}
	}
	
	@Test
	public void testLoadData() {
		setupStage();
		assertTrue(theProgram.getClubs().size() >= 5);
		for (int i = 0; i < theProgram.getClubs().size(); i++) {
			assertTrue(theProgram.getClubs().get(i).getOwners().size() > 0);
		}
	}
}
