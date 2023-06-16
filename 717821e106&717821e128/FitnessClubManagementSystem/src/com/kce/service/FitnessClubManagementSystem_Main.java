
package com.kce.service;
import com.kce.dao.*;
import com.kce.bean.*;

import java.util.Scanner;

public class FitnessClubManagementSystem_Main {
	public static void main(String[] args) throws InvalidDateException,ClassNotFoundException  {
		
		Scanner sc = new Scanner(System.in);
		Fitness_Trainer_DAO fDAO= new Fitness_Trainer_DAO();
		Fitness_Member_DAO pDAO = new Fitness_Member_DAO();

		System.out.println("Enter 1 for Updatements");
		System.out.println("Enter 2 for Entry Trainer Details");
		int choice = sc.nextInt();

		if (choice == 1) {
			while (true) {
				System.out.println("Choose an operation:");
				System.out.println("1. Insert Data");
				System.out.println("2. Update Data");
				System.out.println("3. Delete Data");
				System.out.println("4. Display Data");
				System.out.println("5. Exit");
				System.out.println("Enter the Operation:");
				int operation = sc.nextInt();

				switch(operation) {
				case 1:
					System.out.println("Enter the number clubs to be insert:");
					int numclub = sc.nextInt();
					Fitness_Trainer_DAO.InsertData(numclub);
					break;

				case 2:
					System.out.println("Enter the TrainerName:");
					String TrainerName = sc.next();
					System.out.println("Enter the specialization :");
					String specialization = sc.next();
					Fitness_Trainer_DAO.updateData(TrainerName, specialization);
					break;

				case 3:
					System.out.println("Enter the qualification:");
					
					String deletequalification=sc.next();
					Fitness_Trainer_DAO.deleteData(deletequalification);
					break;

				case 4:
					Fitness_Trainer_DAO.displayData();
					break;

				case 5:
					System.out.println("Exit...Thank you!!!");
					sc.close();
					System.exit(0);
					break;

				default:
					System.out.println("Wrong choice..Please try again!");
					break;
				}
			}
		} else if (choice == 2) {
			while (true) {
				System.out.println("Enter the choice:");
				System.out.println("1. Choose the TeamMembers:");
				System.out.println("2. Display  the TrainersDetails");
				System.out.println("3. Delete the TrainersDetails ");
				System.out.println("4. Exit");
				int clubChoice = sc.nextInt();
				sc.nextLine();

				switch (clubChoice) {
				case 1:
					Fitness_Trainer_DAO.displayData();
					
					System.out.println("Enter the name:");
					String name = sc.next();
					
					System.out.println("Enter the email:");
					String email = sc.next();
					
					System.out.println("Enter the age:");
					int age = sc.nextInt();
					
					System.out.println("Enter the specialization:");
					String specialization = sc.next();
					
					FitnessDetails fm = new FitnessDetails(name,email,age, specialization);
					 pDAO.addPlayers(fm);
					break;

				case 2:
					
					pDAO.displayData();
				
					break;

				case 3:
				
					pDAO.deleteDetails();
					
					break;
				case 4:
					System.out.println("Exit!!!");
					sc.close();
					System.exit(0);
					break;

				default:
					System.out.println("Invalid choice...Please try again!!!");
					break;
				}
			}
		} 
		else {
			System.out.println("Invalid choice...Please try again!!!");
		
}

}
}