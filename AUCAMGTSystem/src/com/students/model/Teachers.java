package com.students.model;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name ="teacher")
public class Teachers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private String code;
	private String names;
	@Enumerated(EnumType.STRING)
	private Qualification qualification; //Equalification
	@Enumerated(EnumType.STRING)
	private Role role;
	@ManyToOne
	@JoinColumn(name = "courseId")
	private Courses courses;
	
	//  default constructor
	
public Teachers() {
		super();
	}
//primary key
public Teachers(int id) {
	super();
	this.id = id;
}
//constructor
public Teachers(int id, String code, String names, Qualification qualification, Role role, Courses courses) {
		super();
		this.id = id;
		this.code = code;
		this.names = names;
		this.qualification = qualification;
		this.role = role;
		this.courses = courses;
	}




public Teachers(String code, String names, Qualification qualification, Role role, Courses courses) {
	super();
	this.code = code;
	this.names = names;
	this.qualification = qualification;
	this.role = role;
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
public String getNames() {
	return names;
}
public void setNames(String names) {
	this.names = names;
}
public Qualification getQualification() {
	return qualification;
}
public void setQualification(Qualification qualification) {
	this.qualification = qualification;
}
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}
public Courses getCourses() {
	return courses;
}
public void setCourses(Courses courses) {
	this.courses = courses;
}

public enum Qualification {
	  Masters,
	    PHD,
	    PROFESSOR
}
public enum Role{
	Lecturer,
	Assistant
}

}
