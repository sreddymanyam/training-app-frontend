package com.project.training_app.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.training_app.service.TrainerService;
import com.project.training_app.to.TrainerTo;



@Controller
public class TrainerController {
	
	
	@Autowired
	private TrainerService trainerService;
	
	@GetMapping("/trainers.htm")
	public String getAllTrainers(Model model) {
		
		List<TrainerTo> trainerList = null;
		trainerList = trainerService.getAllTrainers();
		
		model.addAttribute("trainers", trainerList);
		
		return "trainer/trainers";
	}
	
	
	@GetMapping("/createTrainer.htm")
	public String createTrainer(Model model) {
		
		
		model.addAttribute("trainer", new TrainerTo());
		
		return "trainer/createTrainer";
		
	}
	
	@PostMapping("/saveTrainer.htm")
	public String saveTrainer(Model model , @ModelAttribute TrainerTo trainerTo) {
		
		trainerService.saveTrainer(trainerTo);
		return "redirect:/trainers.htm";
	}
	
	
	@GetMapping("/deleteTrainer.htm/{id}")
	public String deleteTrainer(@PathVariable int id ) {
		
		trainerService.removeTrainer(id);
		
		return "redirect:/trainers.htm";
	}
	
	@GetMapping("/updateTrainer.htm/{id}")
	public String updateTrainer( Model model,@PathVariable int id ) {
		
		TrainerTo trainerTo = trainerService.updateById(id);
		
		model.addAttribute("trainer", trainerTo);
		
		return "trainer/updateTrainer";
		
	}
	
	
	@PostMapping("/saveTrainerChanges.htm")
	public String saveTrainerChanges(Model model , @ModelAttribute TrainerTo trainerTo) throws JsonProcessingException {
		trainerService.updateTrainer(trainerTo);
		return "redirect:/trainers.htm";
	}
	
	@GetMapping("/viewTrainer.htm/{id}")
	public String viewTrainer( Model model,@PathVariable int id ) {
		
		TrainerTo trainerTo = trainerService.updateById(id);
		List<String> courseNamesList = trainerService.getCourseNamesList();
		
		model.addAttribute("trainer", trainerTo);
		model.addAttribute("courses", courseNamesList);
		
		return "trainer/viewTrainer";
	}
	
	@PostMapping("/addCourses.htm")
	public String selectedCourses(Model model , @ModelAttribute TrainerTo trainerTo) throws JsonProcessingException {
		
			System.out.println(trainerTo.getSelectedCourseList().size());
			
			List<String> selectedCourses = trainerTo.getSelectedCourseList();
			Iterator<String> courseItr = selectedCourses.iterator();
 			while(courseItr.hasNext()) { 				
 				if(courseItr.next() == null) {
 					courseItr.remove();
 				}
 			}
			
 			trainerService.updateTrainer(trainerTo);
 			
 			
 			System.out.println(selectedCourses.size());
			
			return "redirect:/trainers.htm";
	}
}
