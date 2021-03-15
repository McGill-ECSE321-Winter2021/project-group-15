package ca.mcgill.ecse321.projectgroup15.model;

import javax.persistence.*;

@Entity
public abstract class Person
{

  //Person Attributes
  private String email;
  private String username;
  private String password;
  private String firstName;
  private String lastName;

  //Person Associations
  private RepairShop repairShop;
  private String id;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  
  public String getFirstName() {
	  return firstName;
  }
  
  public void setFirstName(String firstName) {
	  this.firstName = firstName;
  }
  
  public String getLastName() {
	  return lastName;
  }
  
  public void setLastName(String lastName) {
	  this.lastName = lastName;
  }

  @ManyToOne(cascade = {CascadeType.ALL})
  public RepairShop getRepairShop() {
    return repairShop;
  }

  public void setRepairShop(RepairShop repairShop) {
    this.repairShop = repairShop;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public String getId() {
    return id;
  }
}