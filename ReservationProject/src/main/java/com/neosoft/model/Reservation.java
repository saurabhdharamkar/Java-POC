package com.neosoft.model;





import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "reservations")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
	
	@Transient
	public static final String SEQUENCE_NAME="user_sequence";
	
    @Id
    
    private Long id;
    
    @NotBlank(message="Please provide a Firt Name.")
    private String firstName;
    
    @Size(max=100)
    @NotBlank(message="Please provide a Last Name.")
    private String lastName;
    
    @Size(max=10)
    @NotBlank(message="Please provide a Mobile No.")
    private String mobileNo;
    
    @Indexed(unique=true)
    @NotBlank(message="Please provide a Email Id.")
    private String emailId;
    
    @Size(max=100)
    @NotBlank(message="Please provide a City.")
    private String city;
    
    @Size(max=100)
    @NotBlank(message="Please provide a State.")
    private String state;
    
    private String date;
    
    public Reservation() {
		
	}
    
    

	public Reservation(Long id, @NotBlank(message = "Please provide a Firt Name.") String firstName,
			@Size(max = 100) @NotBlank(message = "Please provide a Last Name.") String lastName,
			@Size(max = 10) @NotBlank(message = "Please provide a Mobile No.") String mobileNo,
			@NotBlank(message = "Please provide a Email Id.") String emailId,
			@Size(max = 100) @NotBlank(message = "Please provide a City.") String city,
			@Size(max = 100) @NotBlank(message = "Please provide a State.") String state, String date) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.city = city;
		this.state = state;
		this.date = date;
	}



	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getDate() {
		return date;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setDate(String date) {
		this.date = date;
	}
    
  
  
	
	

	


    
}
