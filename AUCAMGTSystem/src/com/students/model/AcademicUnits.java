package com.students.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Academic_unit")
public class AcademicUnits {

	 @Id
	    @Column(name = "id")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id; //academic id

	    @Column(name = "code")
	    private String code;

	    @Column(name = "name")
	    private String name;

	    @Enumerated(EnumType.STRING)
	    @Column(name = "unity_type")
	    private UnityType unityType;

	    @ManyToOne(cascade = CascadeType.REMOVE)
	    @JoinColumn(name = "parent_id", referencedColumnName = "id",nullable = true)
	    private AcademicUnits parentUnit;
	    @OneToMany(mappedBy = "unit")
	    private List<StudentRegistrations> students;
	    @OneToMany(mappedBy="academic")
	    private List<Courses> courses;
	  //default constructor
	    public AcademicUnits() {
			super();
		}
	    //primary key

		public AcademicUnits(int id) {
			super();
			this.id = id;
		}


		//constructor
	    
		public AcademicUnits(int id, String code, String name, UnityType unityType, AcademicUnits parentUnit,
				List<StudentRegistrations> students, List<Courses> courses) {
			super();
			this.id = id;
			this.code = code;
			this.name = name;
			this.unityType = unityType;
			this.parentUnit = parentUnit;
			this.students = students;
			this.courses = courses;
		}


		public AcademicUnits(String code, String name, UnityType unityType, AcademicUnits parentUnit) {
			super();
			this.code = code;
			this.name = name;
			this.unityType = unityType;
			this.parentUnit = parentUnit;
		}


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

		public UnityType getUnityType() {
			return unityType;
		}

		public void setUnityType(UnityType unityType) {
			this.unityType = unityType;
		}

		public AcademicUnits getParentUnit() {
			return parentUnit;
		}

		public void setParentUnit(AcademicUnits parentUnit) {
			this.parentUnit = parentUnit;
		}

		public List<StudentRegistrations> getStudents() {
			return students;
		}

		public void setStudents(List<StudentRegistrations> students) {
			this.students = students;
		}

		public List<Courses> getCourses() {
			return courses;
		}

		public void setCourses(List<Courses> courses) {
			this.courses = courses;
		}


		public enum UnityType {
	        PROGRAMME,
	        FACULTY,
	        DEPARTMENT
	    }
	
}
