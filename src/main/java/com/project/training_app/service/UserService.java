package com.project.training_app.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.training_app.to.UserTo;

@Service
public class UserService {
	private static final String TRAINING_APP_BASE_URL = "http://localhost:8081/training-app";
	private static final String ALL_USERS = TRAINING_APP_BASE_URL + "/user-service/all";
	private static final String CREATE_TRAINER = TRAINING_APP_BASE_URL + "/user-service/create";
	private static final String DELETE_USER = TRAINING_APP_BASE_URL + "/user-service/delete/{id}";
	private static final String UPDATE_USER = TRAINING_APP_BASE_URL + "/user-service/update";



		
	@Autowired
	private RestTemplate restTemplate;
	 
	public List<UserTo> getAllUsers(){
					
		UserTo[] userarray = this.restTemplate.getForObject(ALL_USERS, UserTo[].class);
			
		List<UserTo> userlist= Arrays.asList(userarray);
		    
		return userlist;
			
	}
	
	public void saveUser(UserTo userTo) {
		 		  
		try {
		  restTemplate.postForEntity(CREATE_TRAINER, userTo, UserTo.class); 	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeUser(int id) {
				  		  
		restTemplate.delete(DELETE_USER, id);

		}
	
	  public UserTo getUserById(int id) {
		
		UserTo[] userarray = this.restTemplate.getForObject(ALL_USERS, UserTo[].class);
			
		    List<UserTo> user= Arrays.asList(userarray);
		    
		    for (UserTo userTo : user) {
		    	
		    	if(userTo.getUserId() == id) {
		    		return userTo;
		    	}
			}
		return null;
	  }
	   
	public void updateUser(UserTo userTo) {
		
		 try {
			  restTemplate.postForEntity(UPDATE_USER, userTo, UserTo.class); 	
		  }catch (Exception e) {
	            e.printStackTrace();
		  }
	}
	
}
