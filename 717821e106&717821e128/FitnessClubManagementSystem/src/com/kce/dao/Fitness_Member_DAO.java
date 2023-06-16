 package com.kce.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.kce.bean.Fitness_Members;
import com.kce.service.FitnessDetails;
import com.kce.bean.*;
import com.kce.util.DButil;
	 
	 public class Fitness_Member_DAO {
	

			public static void addMembers(FitnessDetails m)throws InvalidDateException {
				try {
					Connection con = DButil.getConnection();
					PreparedStatement psmt = con.prepareStatement("INSERT INTO Members VALUES (?,?,?,?)");
					
					psmt.setString(1, m.getName());
					psmt.setString(2, m.getEmail());
					psmt.setInt(3, m.getAge());
					psmt.setString(4, m.getSpecialization());
				
					psmt.close();
					con.close();
				} catch (SQLException e) {
					System.out.println(e);
				}
			}

			public static void displayData()  {
				try {
					Connection con= DButil.getConnection();
					PreparedStatement psmt = con.prepareStatement("SELECT  Name, Email, Age,Specialization   FROM Members");
					ResultSet rs = psmt.executeQuery();
					
					System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |%n","Name","  Email"," Age","  Specialization");
					while (rs.next()) {
						String Name = rs.getString("Name");
						String Email = rs.getString("Email");
						int Age = rs.getInt("Age");
						String Specialization = rs.getString("Specialization");
						


						System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |%n",Name,Email,Age,Specialization);
					}

					rs.close();
					psmt.close();
					con.close();
				} catch (SQLException e) {
					System.out.println(e);
				} 
			}

			public static void deleteDetails() {
				try {
					Connection con = DButil.getConnection();
					Statement st = con.createStatement();
					int affectedRows = st.executeUpdate("TRUNCATE TABLE Members");
					if (affectedRows > 0) {
						System.out.println("Details are deleted successfully!");
					} else {
						System.out.println("Failed to delete details...");
					}

					st.close();
					con.close();
				} catch (SQLException e) {
					System.out.println(e);
				}
			
			}

			public void addPlayers(Fitness_Members fm) {
				// TODO Auto-generated method stub
				
			}

		}
