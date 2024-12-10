package Mystudent;

import java.util.Scanner;

public class Student {
	
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		StudentInterface si = new StudentImplementation();
		System.out.println("Enter your choice");
		
		while(true) {
			System.out.println("1:AddStudent\n2:UpdateStudent\n3:DeleteStudent\n4:GetAllStudent\n5:DeleteAllStudent\n6:GetStudentById\n7:Exit");
			
			int choice=sc.nextInt();
			switch(choice) {
			
			case 1: si.addStudent();
			break;
			
			case 2: si.upadteStudent();
			break;
			
			case 3: si.deleteStudent();
			break;
			
			case 4: si.getAllStudent();
			break;
			
			case 5: si.deleteAllStudent();
			break;
			
			case 6: si.getStudentById();
			break;
			
			case 7: System.out.println("Thank u");
			       System.exit(0);
			 break;
			 
			 default: System.out.println("Invalid");
			
			
	}

		}
		
	}
}

