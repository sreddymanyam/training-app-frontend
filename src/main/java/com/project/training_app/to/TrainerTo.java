package com.project.training_app.to;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TrainerTo {      

	@GeneratedValue
	private  int trainerId;
	
	private String firstName;
	
	private String lastName;
	
	private long contactNo;
	
	private String emailId;
	
	private String address;
	
	private long aadharNo;
	
	private String idProofType;
	
	private String idProofDocument;
	
	private String qualification;
	
	private int trainingExperience ;
	
	private List<String> selectedCourseList;
	

}
