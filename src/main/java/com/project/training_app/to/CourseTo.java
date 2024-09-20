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
public class CourseTo {

	@GeneratedValue
	private int id;
	private String name;
	private String description;;
	private String topics;
	private boolean status;

}
