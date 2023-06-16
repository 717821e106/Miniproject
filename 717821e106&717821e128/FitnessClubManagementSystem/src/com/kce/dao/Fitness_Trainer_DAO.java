 package com.kce.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.kce.util.DButil;
import com.kce.bean.*;
public class Fitness_Trainer_DAO {

	
	 static Scanner sc = new Scanner(System.in);
	
		public static void InsertData(int Trainer) {
			try {
				Fitness_Trainer[]  f= new Fitness_Trainer[Trainer];

				for (int i = 0; i < Trainer; i++) {
					System.out.println("Enter the TrainerName");
					String trainerName = sc.next();
					
					System.out.println("Enter the age");
					int age = sc.nextInt();
					
					System.out.println("Enter the salary");
					Double salary = sc.nextDouble();
					
					System.out.println("Enter the qualification");
					String qualification = sc.next();
					
                    System.out.println("Enter the email");	
					String email = sc.next();
					
					System.out.println("Enter the specialization");	
					String specialization = sc.next();


					f[i] = new Fitness_Trainer(trainerName,age,salary,qualification,email,specialization);
				}

				Connection con = DButil.getConnection();
				PreparedStatement psmt = con.prepareStatement("INSERT INTO Fitness_Trainer VALUES (?,?,?,?,?,?)");

				for (int i = 0; i < Trainer; i++) {
					psmt.setString(1, f[i].getTrainerName());
					psmt.setInt(2, f[i].getAge());
					psmt.setDouble(3, f[i].getSalary());
					psmt.setString(4, f[i].getQualification());
					psmt.setString(5, f[i].getEmail());
					psmt.setString(6, f[i].getSpecialization());
					psmt.executeUpdate();
				}
				System.out.println("Data inserted Successfully");
			}
			catch (SQLException e) {
				System.out.println(e);
			} 
					

				
		}

		public static void updateData(String TrainerName,String qualification) throws ClassNotFoundException {
			try {
				Connection con = DButil.getConnection();
				PreparedStatement psmt = con.prepareStatement("UPDATE Fitness_Trainer SET TrainerName = ? WHERE qualification = ?");
				
				psmt.setString(1, TrainerName);
				psmt.setString(2, qualification);
				int rows = psmt.executeUpdate();

				if (rows > 0) {
					System.out.println("Data updated successfully...");
				} else {
					System.out.println("No record found with the provided !!!");
				}

			} catch (SQLException e) {
				System.out.println(e);
			} 
		}

		public static void deleteData(String specialization){
			try {
				Connection con = DButil.getConnection();
				PreparedStatement psmt = con.prepareStatement("DELETE FROM Fitness_Trainer WHERE specialization = ?");
				psmt.setString(1, specialization);
				int rows = psmt.executeUpdate();

				if (rows > 0) {
					System.out.println("Data deleted successfully...");
				} else {
					System.out.println("No record found with the provided !!!");
				}

			} catch (SQLException e) {
				System.out.println(e);
			} 
			
		}

		public static void displayData(){
			try {
				Connection con = DButil.getConnection();
				PreparedStatement psmt = con.prepareStatement("SELECT * FROM Fitness_Trainer");
				ResultSet rs = psmt.executeQuery();
			
				System.out.printf( "| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n","TrainerName","age","salary","qualification","email","specialization");
				while (rs.next()) {
			
					
					String TrainerName = rs.getString("TrainerName");
					int age = rs.getInt("age");
					String salary = rs.getString("salary");
					String qualification = rs.getString("qualification");
					String email = rs.getString("email");
					String specialization = rs.getString("specialization");

					System.out.printf("| %-20s | %-20s | %-20s | %-20s| %-20s |  %-20s |%n",TrainerName,age,salary,qualification,email,specialization);
				}

			} 
			catch (SQLException e) {
				System.out.println(e);
			} 
		}
		}
