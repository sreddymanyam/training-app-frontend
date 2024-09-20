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
	private static final String TRAINING_APP_BASE_URL = "http://localhost:8081/training-app";
	private static final String ALL_COURSES = TRAINING_APP_BASE_URL + "/course-service/all";
	private static final String CREATE_COURSE = TRAINING_APP_BASE_URL + "/course-service/create";
	private static final String DELETE_COURSE = TRAINING_APP_BASE_URL + "/course-service/delete/{id}";
	private static final String UPDATE_COURSE = TRAINING_APP_BASE_URL + "/course-service/update";



	List<CourseTo> courseList = new ArrayList<>();

	@Autowired
	private RestTemplate restTemplate;

	public List<CourseTo> getAllActiveCourse() {

		CourseTo[] coursearray = this.restTemplate.getForObject(ALL_COURSES, CourseTo[].class);

		List<CourseTo> cour = Arrays.asList(coursearray);

		return cour;

	}

	public void saveCourse(CourseTo courseTo) {

		try {
			restTemplate.postForEntity(CREATE_COURSE, courseTo, CourseTo.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeCourse(int id) {

		restTemplate.delete(DELETE_COURSE, id);

	}

	public CourseTo updateById(int id) {

		CourseTo[] coursearray = this.restTemplate.getForObject(ALL_COURSES, CourseTo[].class);

		List<CourseTo> cour = Arrays.asList(coursearray);

		for (CourseTo courseTo : cour) {

			if (courseTo.getId() == id) {
				return courseTo;
			}
		}
		return null;
	}

	public void updateCourse(CourseTo courseTo) throws JsonProcessingException {

		try {
			restTemplate.postForEntity(UPDATE_COURSE, courseTo, CourseTo.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
