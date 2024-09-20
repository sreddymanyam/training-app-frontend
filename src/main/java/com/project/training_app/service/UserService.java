package com.project.training_app.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.training_app.to.UserTo;

@Service
public class UserService {
		
	@Autowired
	private RestTemplate restTemplate;
	 
	public List<UserTo> getAllUsers(){
		
		String training_app_url ="http://localhost:8081/training-app/user-service/all";
			
		UserTo[] userarray = this.restTemplate.getForObject(training_app_url, UserTo[].class);
			
		List<UserTo> userlist= Arrays.asList(userarray);
		    
		return userlist;
			
	}
	
	public void saveUser(UserTo userTo) {
		 
		String training_app_url_create = "http://localhost:8081/training-app/user-service/create";
		  
		try {
		  restTemplate.postForEntity(training_app_url_create, userTo, UserTo.class); 	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeUser(int id) {
		
		String training_app_url_delete = "http://localhost:8081/training-app/user-service/delete/{id}";
		  		  
		restTemplate.delete(training_app_url_delete, id);

		}
	
	  public UserTo getUserById(int id) {
		
		String training_app_url ="http://localhost:8081/training-app/user-service/all";

		UserTo[] userarray = this.restTemplate.getForObject(training_app_url, UserTo[].class);
			
		    List<UserTo> user= Arrays.asList(userarray);
		    
		    for (UserTo userTo : user) {
		    	
		    	if(userTo.getUserId() == id) {
		    		return userTo;
		    	}
			}
		return null;
	  }
	   
	public void updateUser(UserTo userTo) {
		
		String training_app_url_update = "http://localhost:8081/training-app/user-service/update";

		 try {
			  restTemplate.postForEntity(training_app_url_update, userTo, UserTo.class); 	
		  }catch (Exception e) {
	            e.printStackTrace();
		  }
	}
	
}
