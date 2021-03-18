package ca.mcgill.ecse321.projectgroup15.dto;

import java.sql.Date;
import java.util.Collections;
import java.util.List;

public class PaymentDto {

	
	 private Date date;
	  private float totalCost;
	  private String id;
	  
	  private List<AppointmentDto> appointments;
	  

	  @SuppressWarnings("unchecked") // because the Collection the Appointment list needs to be empty at the start.
	  
	  

		//Second Constructor 
		public PaymentDto(String id) {
			this(id, Collections.EMPTY_LIST);
		}
	  
	  
		/**
	 * @param date
	 * @param totalCost
	 * @param id
	 * @param appointments
	 */
	public PaymentDto(Date date, float totalCost, String id, List<AppointmentDto> appointments) {
		super();
		this.date = date;
		this.totalCost = totalCost;
		this.id = id;
		this.appointments = appointments;
	}
	
	
	
	 @SuppressWarnings("unchecked") // because the Collection the Appointment list needs to be empty at the start.

		/**
		 * @param date
		 * @param totalCost
		 * @param id
		 */
		public PaymentDto(Date date, float totalCost, String id) {
			super();
			this.date = date;
			this.totalCost = totalCost;
			this.id = id;
			this.appointments = Collections.EMPTY_LIST;
		}


		public PaymentDto(String id, List<AppointmentDto> arrayList) {
			this.id = id;
			this.appointments = arrayList;
		}
		
		
	  
	public String getId() {
			return id;
		}



	public List<AppointmentDto> getAppointments() {
		return appointments;
	}
	public Date getDate() {
		return date;
	}
	public float getTotalCost() {
		return totalCost;
	}
}
