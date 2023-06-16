
 package com.kce.bean;

public class Fitness_Members {
	
	
	  public String name;
	  public String email;
	  public int age;
	  public String specialization;
	public Fitness_Members(String name, String email, int age, String specialization) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.specialization = specialization;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	@Override
	public String toString() {
		return "Fitness_Members [name=" + name + ", email=" + email + ", age=" + age + ", specialization="
				+ specialization + "]";


	}
}
