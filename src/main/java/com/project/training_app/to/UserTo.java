package com.project.training_app.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserTo {

	
	private int userId;
	
	private String firstName;
	
	private String lastName;
	
	private long contactNumber;
	
	private String emailId;
	
	private String address; 
	
	private String idProof;
	
	private long aadharNumber;

	private String profession;
	
	private String collegeOrOffice;
	
	private String yearOfPassedoutOrExperience;

}
