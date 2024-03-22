package com.students.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Courses {

 @Id
 @GeneratedValue(strategy= GenerationType.IDENTITY)

 private int courseId;
 private String course_code;
 private String course_name;
	@OneToOne
	@JoinColumn(name="id")
	
	private CourseDefinition courseD;
	@OneToMany(mappedBy = "courses")
	private List<Teachers> teacher;
	@ManyToOne
	@JoinColumn(name="semId")
	private Semesters semester;
	@ManyToOne
	@JoinColumn(name="id")
	private AcademicUnits academic;
	@ManyToMany(mappedBy = "courses")
	private List<StudentRegistrations> students=new ArrayList<StudentRegistrations>();
	// default constructor
	public Courses() {
		super();
	}
	//primary key
	public Courses(int courseId) {
		super();
		this.courseId = courseId;
	}
	//constructor
	public Courses(int courseId, String course_code, String course_name, CourseDefinition courseD,
			List<Teachers> teacher, Semesters semester, AcademicUnits academic, List<StudentRegistrations> students) {
		super();
		this.courseId = courseId;
		this.course_code = course_code;
		this.course_name = course_name;
		this.courseD = courseD;
		this.teacher = teacher;
		this.semester = semester;
		this.academic = academic;
		this.students = students;
	}
	public Courses(CourseDefinition courseD, Semesters semester, AcademicUnits academic) {
		super();
		this.courseD = courseD;
		this.semester = semester;
		this.academic = academic;
	}
	//getter and setter
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourse_code() {
		return course_code;
	}
	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public CourseDefinition getCourseD() {
		return courseD;
	}
	public void setCourseD(CourseDefinition courseD) {
		this.courseD = courseD;
	}
	public List<Teachers> getTeacher() {
		return teacher;
	}
	public void setTeacher(List<Teachers> teacher) {
		this.teacher = teacher;
	}
	public Semesters getSemester() {
		return semester;
	}
	public void setSemester(Semesters semester) {
		this.semester = semester;
	}
	public AcademicUnits getAcademic() {
		return academic;
	}
	public void setAcademic(AcademicUnits academic) {
		this.academic = academic;
	}
	public List<StudentRegistrations> getStudents() {
		return students;
	}
	public void setStudents(List<StudentRegistrations> students) {
		this.students = students;
	}
	
}
