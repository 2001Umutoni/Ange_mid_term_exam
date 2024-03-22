package com.students.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.students.model.AcademicUnits;
import com.students.model.Courses;
import com.students.model.Semesters;
import com.students.model.Students;
@Entity
@Table(name="Registration")
public class StudentRegistrations {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int regid;// registration id
	@Column(name="registration_date")
	private LocalDate registrationDate;
	@ManyToOne
	@JoinColumn(name = "id")
	private Students student;
	@ManyToOne
	@JoinColumn(name="semId")
	private Semesters semester;
	@ManyToOne
	@JoinColumn(name="id")
	private AcademicUnits unit;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "student_course",joinColumns = @JoinColumn(name="id")
	,inverseJoinColumns =@JoinColumn(name="courseId"))
	private List<Courses>courses=new ArrayList<Courses>();
	//default constructor
	public StudentRegistrations() {
		super();
	}
	//primary key
	public StudentRegistrations(int regid) {
		super();
		this.regid = regid;
	}
	//constructor
	public StudentRegistrations(int regid, LocalDate registrationDate, Students student, Semesters semester,
			AcademicUnits unit, List<Courses> courses) {
		super();
		this.regid = regid;
		this.registrationDate = registrationDate;
		this.student = student;
		this.semester = semester;
		this.unit = unit;
		this.courses = courses;
	}
	public StudentRegistrations(LocalDate registrationDate, Students student, Semesters semester, AcademicUnits unit,
			List<Courses> courses) {
		super();
		this.registrationDate = registrationDate;
		this.student = student;
		this.semester = semester;
		this.unit = unit;
		this.courses = courses;
	}
	//getter and setter
	public int getRegid() {
		return regid;
	}
	public void setRegid(int regid) {
		this.regid = regid;
	}
	public LocalDate getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}
	public Students getStudent() {
		return student;
	}
	public void setStudent(Students student) {
		this.student = student;
	}
	public Semesters getSemester() {
		return semester;
	}
	public void setSemester(Semesters semester) {
		this.semester = semester;
	}
	public AcademicUnits getUnit() {
		return unit;
	}
	public void setUnit(AcademicUnits unit) {
		this.unit = unit;
	}
	public List<Courses> getCourses() {
		return courses;
	}
	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}
	
	
	
}
