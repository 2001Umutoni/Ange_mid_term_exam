package com.students.model;

import javax.persistence.*;

@Entity
@Table(name= "Student_User")

public class Student_Users {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private int id;

	    @Column(name = "email")
	    private String email;
	    @Column(name = "password")
	    private String password;
	    @Column(name="role")
	    private String role;
//default constructor
		public Student_Users() {
			super();
		}
	    //primary key
public Student_Users(int id) {
	super();
	this.id = id;
}
		//constructor
		public Student_Users(int id, String email, String password, String role) {
			super();
			this.id = id;
			this.email = email;
			this.password = password;
			this.role = role;
		}
//getter and setter
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		 
}
