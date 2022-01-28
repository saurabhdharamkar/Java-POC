package com.neo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	
	@Size(min = 4, message = "user name should have at least 4 characters")
	@NotNull
	@Column(name="first_name")
	private String firstName;
	
	@Size(min = 4, message = "user name should have at least 4 characters")
	@NotNull
	@Column(name="last_name")
	private String lastName;
	
	@Size(max=55)
	@NotNull
	@Column(name="address")
	private String address;
	
	@NotNull
	@Column(name="pin_code")
	private String pinCode;
	
	@NotNull
	@Column(name="dob")
	private Date dob;
	
	@NotNull
	@Column(name="doj")
	private Date doj;
	
	@Column(name="deleted")
	private int deleted;

}
