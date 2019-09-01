package model;
import java.io.Serializable;
import java.util.Comparator;

public class Pet implements Serializable{
	
	public static final int MALE = 1;
	public static final int FEMALE = 2;
	
	private String id;
	private String name;
	private String birthDate;
	private int gender;
	private String type;
	
	public Pet(String id, String name, String birthDate, int gender, String type) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.gender = gender;
		this.type = type;
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

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public int compareById(Pet e) {
		return id.compareTo(e.getId());
	}
	
	public int compareByName(Pet e) {
		return name.compareTo(e.getName());
	}
	
	public int compareByBirthDate(Pet e) {
		return birthDate.compareTo(e.getBirthDate());
	}
	
	public int compareByGender(Pet e) {
		return gender-e.getGender();
	}
	
	public int compareByType(Pet e) {
		return type.compareTo(e.getType());
	}
}
