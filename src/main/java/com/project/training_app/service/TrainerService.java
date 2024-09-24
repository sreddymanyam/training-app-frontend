package com.project.training_app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.training_app.to.CourseTo;
import com.project.training_app.to.TrainerTo;

@Service
public class TrainerService {
	private static final String TRAINING_APP_BASE_URL = "http://localhost:8081/training-app";
	private static final String ALL_TRAINERS = TRAINING_APP_BASE_URL + "/trainer-service/all";
	private static final String CREATE_TRAINER = TRAINING_APP_BASE_URL + "/trainer-service/create";
	private static final String DELETE_TRAINER = TRAINING_APP_BASE_URL + "/trainer-service/delete/{id}";
	private static final String UPDATE_TRAINER = TRAINING_APP_BASE_URL + "/trainer-service/update";
	private static final String ALL_COURSES = TRAINING_APP_BASE_URL + "/course-service/all";


	@Autowired
	private RestTemplate restTemplate;
	
	public List<TrainerTo> getAllTrainers(){
					
		TrainerTo[] trainerarray = this.restTemplate.getForObject(ALL_TRAINERS, TrainerTo[].class);
			
		List<TrainerTo> trainer= Arrays.asList(trainerarray);

			
		return trainer;
		
	}
	
	 public void saveTrainer(TrainerTo trainerTo) {
			 
		 try {
			  restTemplate.postForEntity(CREATE_TRAINER, trainerTo, TrainerTo.class); 	
		  }catch (Exception e) {
	            e.printStackTrace();
		  }
	  }
	   
	  public void removeTrainer(int id) {
		  			
		  restTemplate.delete(DELETE_TRAINER, id);

	}
	
	
	public TrainerTo updateById(int id) {
		
		TrainerTo[] trainerarray = this.restTemplate.getForObject(ALL_TRAINERS, TrainerTo[].class);
		
	    List<TrainerTo> trainer= Arrays.asList(trainerarray);
	    
	    for (TrainerTo trainerTo : trainer) {
	    	
	    	if(trainerTo.getTrainerId() == id) {
	    		return trainerTo;
	    	}
		}
	    return null;
	}
	
	public void updateTrainer(TrainerTo trainerTo) throws JsonProcessingException {
		  
		  try {
			 
			  
			  restTemplate.postForEntity(UPDATE_TRAINER, trainerTo,TrainerTo.class);
			  
			  
			  
	        } catch (Exception e) {
	            e.printStackTrace();
	        }  
	  }
	
	 
	public List<String> getCourseNamesList() {
		
		List<String> courseNamesList = new ArrayList<>();
		
		CourseTo[] coursearray = this.restTemplate.getForObject(ALL_COURSES, CourseTo[].class);
		
	    List<CourseTo> cour= Arrays.asList(coursearray);
	    
	    for (CourseTo courseTo : cour) {
		    String value = courseTo.getName();
		    courseNamesList.add(value);
		}
		return courseNamesList;
	}


	public void registroCourse(TrainerTo trainerTo, List<String> selectedCourses) {
		
			// load trainer
		
			// add course data
			// load all courses
			// put inside trainer
			// send trainer to update.
		
	}
	
}
