package com.project.training_app.to;

import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserTo {
	
	@GeneratedValue
	private int userId;
	
	private String firstName;
	
	private String lastName;
	
	private String mobile;
	
	private String emailId;
	
	private String address; 
	
	private String idProof;
	
	private String aadharNumber;

	private String profession;
	
	private String collegeOrOffice;
	
	private String yearOfPassedoutOrExperience;

}
