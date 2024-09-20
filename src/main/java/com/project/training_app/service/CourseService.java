package com.project.training_app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.training_app.to.CourseTo;



@Service
public class CourseService {
	List<CourseTo> courseList = new ArrayList<>();
	
	@Autowired
	private RestTemplate restTemplate;
	 
	public List<CourseTo> getAllActiveCourse(){
		
		String training_app_url_courses ="http://localhost:8081/training-app/course-service/all";
		
			CourseTo[] coursearray = this.restTemplate.getForObject(training_app_url_courses, CourseTo[].class);
			
		    List<CourseTo> cour= Arrays.asList(coursearray);

			return cour;
		
	}
	  
	public void saveCourse(CourseTo courseTo) {
		
		String training_app_url_create = "http://localhost:8081/training-app/course-service/create";
		  
		try {
			restTemplate.postForEntity(training_app_url_create, courseTo,CourseTo.class);
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	} 
	 
	public void removeCourse(int id) {
		
		String training_app_url_delete = "http://localhost:8081/training-app/course-service/delete/{id}";
		  		  
		restTemplate.delete(training_app_url_delete, id);

	}
	  
	  
	public CourseTo updateById(int id) {
		  
		String training_app_url_courses ="http://localhost:8081/training-app/course-service/all";
				
		CourseTo[] coursearray = this.restTemplate.getForObject(training_app_url_courses, CourseTo[].class);
				
		List<CourseTo> cour= Arrays.asList(coursearray);
			  
		for (CourseTo courseTo : cour) {
			
			if(courseTo.getId() == id) {
					return courseTo;
			}
		}
		  return null;
	 }
		
	  public void updateCourse(CourseTo courseTo) throws JsonProcessingException {
		  
		  String training_app_url_update = "http://localhost:8081/training-app/course-service/update";		  
		  
		  try {
			  restTemplate.postForEntity(training_app_url_update, courseTo,CourseTo.class);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }  
	  }
}

