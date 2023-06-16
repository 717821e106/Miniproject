 package com.kce.bean;

public class Fitness_Trainer {
public String trainerName;
public int age;
public double salary;
public String qualification;
public String email;
public String specialization;
public Fitness_Trainer(String trainerName, int age, double salary, String qualification, String email,
		String specialization) {
	super();
	this.trainerName = trainerName;
	this.age = age;
	this.salary = salary;
	this.qualification = qualification;
	this.email = email;
	this.specialization = specialization;
}
public String getTrainerName() {
	return trainerName;
}
public void setTrainerName(String trainerName) {
	this.trainerName = trainerName;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public String getQualification() {
	return qualification;
}
public void setQualification(String qualification) {
	this.qualification = qualification;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getSpecialization() {
	return specialization;
}
public void setSpecialization(String specialization) {
	this.specialization = specialization;
}
@Override
public String toString() {
	return "Fitness_Trainer [trainerName=" + trainerName + ", age=" + age + ", salary=" + salary + ", qualification="
			+ qualification + ", email=" + email + ", specialization=" + specialization + "]";
}



}

