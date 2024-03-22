package com.students.model;

import javax.persistence.*;

import com.students.model.Courses;

@Entity
@Table(name="coursedefinition")
public class CourseDefinition {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)

    private int id;
	private String code;
	private String name;
	private String descriptions;
	@OneToOne(mappedBy = "courseD")
	private Courses courses;
	//default constructor
	public CourseDefinition() {
		super();
	}
//primary key
	public CourseDefinition(int id) {
		super();
		this.id = id;
	}
//constructor
	public CourseDefinition(int id, String code, String name, String descriptions, Courses courses) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.descriptions = descriptions;
		this.courses = courses;
	}

	public CourseDefinition(String code, String name, String descriptions, Courses courses) {
		super();
		this.code = code;
		this.name = name;
		this.descriptions = descriptions;
		this.courses = courses;
	}

//getter and setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	
	
}
