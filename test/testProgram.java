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
			try {
				theProgram = new Program();
			} catch (NumberFormatException | PetName e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			fail();
		} catch (IOException e) {
			fail();
		}
	}
	
	@Test
	public void testAddClub() {
		try {
			setupStage();
			Club e;
			try {
				e = new Club("0000000001", "Icesi", "2019/03/18", "Dogs");
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (PetName e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			theProgram.addClub(e);
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
		} catch (ClassNotFoundException e) {
			fail();
		} catch (IOException e) {
			fail();
		}
	}
	
	@Test
	public void testAddOwner() {
		setupStage();
		Owner e = new Owner("1005966201", "Manuel David", "Castaño", "2001/12/14", "Dogs");
		try {
			theProgram.addOwner(e, "0000000001");
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
			fail();
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
		long t1 = System.currentTimeMillis();
		if(theProgram.findBinaryClubById("0001814192").equals("The club doesn't exist")) {
			long t2 = System.currentTimeMillis();
			System.out.println(t2-t1);
			fail();
		}else {
			long t2 = System.currentTimeMillis();
			System.out.println(t2-t1);
		}
	}
	
	@Test
	public void testAddPet() {
		setupStage();
		Pet e = new Pet("58", "Manchas", "2018/2/18", 1, "Pastor");
		try {
			theProgram.addPet("1005966201", e);
		} catch (PetName e1) {
			fail();
		} catch (IOException e1) {
			fail();
		}
	}
}
