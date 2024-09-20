package com.project.training_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.training_app.service.CourseService;
import com.project.training_app.to.CourseTo;



@Controller
public class CourseController {
	
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/courses.htm")
	public String getAllActiveCourses(Model model) {
		
		List<CourseTo> courseList = null;
		courseList = courseService.getAllActiveCourse();
		
		model.addAttribute("courses", courseList);
		
		return "course/courses";
	}
	
	
	
	@GetMapping("/createCourse.htm")
	public String createCourse(Model model) {
		
		
		model.addAttribute("course", new CourseTo());
		
		return "course/createCourse";
		
	}
	
	@PostMapping("/saveCourse.htm")
	public String saveCourse( @ModelAttribute CourseTo courseTo) {
		
		courseService.saveCourse(courseTo);
		return "redirect:/courses.htm";
	}
	
	@GetMapping("/deleteCourse.htm/{id}")
	public String deleteCourse(@PathVariable int id ) {
		
		courseService.removeCourse(id);
		
		return "redirect:/courses.htm";
	}
	
	@GetMapping("/updateCourse.htm/{id}")
	public String updateCourse( Model model,@PathVariable int id ) {
		
		CourseTo course =  courseService.updateById(id);
		model.addAttribute( "course"  , course);
		return "course/updateCourse";
		
	}
	
	
	@PostMapping("/saveCoursechanges.htm")
	public String saveCourseChanges( @ModelAttribute CourseTo courseTo) throws JsonProcessingException {
		
		courseService.updateCourse(courseTo);
		return "redirect:/courses.htm";
	}
	
}
