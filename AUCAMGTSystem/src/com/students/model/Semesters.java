package com.students.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.students.model.Courses;
import com.students.model.StudentRegistrations;

@Entity
@Table(name="semester")
public class Semesters {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int semId;
	@Column(name="Sem_name")
	private String name;
	@Column(name="Sem_startdate")
	private LocalDate startdate;
	@Column(name="Sem_enddate")
	private LocalDate enddate;
	@OneToMany(mappedBy = "semester")
	private List<StudentRegistrations> reg;
 @OneToMany(mappedBy = "semester")
	private List<Courses> courses;
public Semesters() {
	super();
}
public Semesters(int semId) {
	super();
	this.semId = semId;
}
public Semesters(int semId, String name, LocalDate startdate, LocalDate enddate) {
	super();
	this.semId = semId;
	this.name = name;
	this.startdate = startdate;
	this.enddate = enddate;
}
public int getSemId() {
	return semId;
}
public void setSemId(int semId) {
	this.semId = semId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public LocalDate getStartdate() {
	return startdate;
}
public void setStartdate(LocalDate startdate) {
	this.startdate = startdate;
}
public LocalDate getEnddate() {
	return enddate;
}
public void setEnddate(LocalDate enddate) {
	this.enddate = enddate;
}
public List<StudentRegistrations> getReg() {
	return reg;
}
public void setReg(List<StudentRegistrations> reg) {
	this.reg = reg;
}
public List<Courses> getCourses() {
	return courses;
}
public void setCourses(List<Courses> courses) {
	this.courses = courses;
}
 
}
