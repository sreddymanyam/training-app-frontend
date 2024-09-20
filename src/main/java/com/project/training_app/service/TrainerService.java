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
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<TrainerTo> getAllTrainers(){
		
		String training_app_url ="http://localhost:8081/training-app/trainer-service/all";
			
		TrainerTo[] trainerarray = this.restTemplate.getForObject(training_app_url, TrainerTo[].class);
			
		List<TrainerTo> trainer= Arrays.asList(trainerarray);

			
		return trainer;
		
	}
	
	 public void saveTrainer(TrainerTo trainerTo) {
	
		 String training_app_url_create = "http://localhost:8081/training-app/trainer-service/create";
		 
		 try {
			  restTemplate.postForEntity(training_app_url_create, trainerTo, TrainerTo.class); 	
		  }catch (Exception e) {
	            e.printStackTrace();
		  }
	  }
	   
	  public void removeTrainer(int id) {
		  
		  String training_app_url_delete = "http://localhost:8081/training-app/trainer-service/delete/{id}";  
			
		  restTemplate.delete(training_app_url_delete, id);

	}
	
	
	public TrainerTo updateById(int id) {
		
		String training_app_url ="http://localhost:8081/training-app/trainer-service/all";

		TrainerTo[] trainerarray = this.restTemplate.getForObject(training_app_url, TrainerTo[].class);
		
	    List<TrainerTo> trainer= Arrays.asList(trainerarray);
	    
	    for (TrainerTo trainerTo : trainer) {
	    	
	    	if(trainerTo.getTrainerId() == id) {
	    		return trainerTo;
	    	}
		}
	    return null;
	}
	
	public void updateTrainer(TrainerTo trainerTo) throws JsonProcessingException {
		  String training_app_url_update = "http://localhost:8081/training-app/trainer-service/update";		  
		  
		  try {
			  restTemplate.postForEntity(training_app_url_update, trainerTo,TrainerTo.class);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }  
	  }
	
	 
	public List<String> getCourseNamesList() {
		String training_app_url_courses ="http://localhost:8081/training-app/course-service/all";
		
		List<String> courseNamesList = new ArrayList<>();
		
		CourseTo[] coursearray = this.restTemplate.getForObject(training_app_url_courses, CourseTo[].class);
		
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
