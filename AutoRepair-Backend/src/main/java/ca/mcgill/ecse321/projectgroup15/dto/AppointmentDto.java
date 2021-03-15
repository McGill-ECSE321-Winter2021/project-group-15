package ca.mcgill.ecse321.projectgroup15.dto;

public class AppointmentDto {

	private CustomerDto customer;
	private TechnicianDto technician;
	private TimeSlotDto ts;
	
	public AppointmentDto() {
	}
	
	public AppointmentDto(CustomerDto customer, TechnicianDto technician, TimeSlotDto ts) {
		this.customer = customer;
		this.technician = technician;
		this.ts = ts;
	}
	
	public CustomerDto getCustomer() {
		return customer;
	}
	
	public void setCustomer(CustomerDto customer) {
		this.customer=customer;
	}
	
	public TechnicianDto getTechnician() {
		return technician;
	}
	
	public void setTechnician(TechnicianDto technician) {
		this.technician=technician;
	}
	
	public TimeSlotDto getTimeSlot() {
		return ts;
	}
	
	public void setTimeSlot(TimeSlotDto ts) {
		this.ts = ts;
	}
}
