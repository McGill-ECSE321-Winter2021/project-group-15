package ca.mcgill.ecse321.projectgroup15.dto;

import ca.mcgill.ecse321.projectgroup15.model.RepairShop;

public class PersonDto {
	
	private String email;
	  private String username;
	  private String password;
	  private String firstName;
	  private String lastName;

	  private int id;
	  
	  
	  

	public PersonDto(String email, String username, String password, String firstName, String lastName, int id) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}

	public PersonDto(String username) {
		super();
		this.username = username;
	}

	public PersonDto(String email, String username, String password, String firstName, String lastName) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public PersonDto(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getId() {
		return id;
	}
	  
	  
}
