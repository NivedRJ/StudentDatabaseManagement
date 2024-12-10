package Mystudent;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Statement;



public class StudentImplementation implements StudentInterface {
	Scanner sc = new Scanner(System.in);
	Connection connection;

	@Override
	public void addStudent() {
		System.out.println("Enter the Student  Id :");
		int id=sc.nextInt();
		System.out.println("Enter the Student name :");
		String name=sc.next();
		System.out.println("Enter the Student age :");
		String age=sc.next();
		System.out.println("Enter the Student mark :");
		double mark=sc.nextDouble();
		
		
		try {
			System.out.println("Welcome to Student Database");
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mystudent","root","root");
			
			PreparedStatement preparedstatement=connection.prepareStatement("insert into students values(?,?,?,?)");
			preparedstatement.setInt(1,id);
			preparedstatement.setString(2,name);
			preparedstatement.setString(3,age);
			preparedstatement.setDouble(4,mark);
			preparedstatement.execute();
			System.out.println("data Saved");
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void upadteStudent() {
			Scanner s =new Scanner(System.in);

			  
			   try {
				   Class.forName("com.mysql.cj.jdbc.Driver");
				    Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mystudent","root","root");
				    while(true) {
				    System.out.println("update on the basis of\n1name\n2age\n3mark\n4exit");
					   int O=s.nextInt();
			   switch(O) {
			  case 1:{
				  System.out.println("Enter id : ");
				  int id=s.nextInt();
				  System.out.println("Enter new name :");
				  String sname=s.next();
				 PreparedStatement preparedStatement=connection.prepareStatement("update students set sname=? where id=?");
				 preparedStatement.setString(1,sname);
				 preparedStatement.setInt(2, id);
				 preparedStatement.execute();
				 break;
			  }
			  case 2:{
				  System.out.println("Enter id :");
				  int id=s.nextInt();
				  System.out.println("Enter new age :");
				  int age=s.nextInt();
				 PreparedStatement preparedStatement=connection.prepareStatement("update students set age=? where id=?");
				 preparedStatement.setInt(1,age);
				 preparedStatement.setInt(2, id);
				 preparedStatement.execute();
				 break;
			  }
			  case 3:{
				  System.out.println("Enter id :");
				  int id=s.nextInt();
				  System.out.println("Enter new mark:");
				  int mark=s.nextInt();
				 PreparedStatement preparedStatement=connection.prepareStatement("update students set mark=? where id=?");
				 preparedStatement.setDouble(1,mark);
				 preparedStatement.setInt(2, id);
				 preparedStatement.execute();
				 break;
			  }
			  case 4:{
				  System.exit(0);
			  }
			  
				  
			  }
		}
			   }
			   catch(ClassNotFoundException | SQLException e) {
					 e.printStackTrace();
				 }
		}

		

	@Override
	public void deleteStudent() {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("Enter id of student want to Delete :");
		 int id=s.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mystudent","root","root");
		 
		 PreparedStatement preparedStatement=connection.prepareStatement("delete from students where id=?");
		 preparedStatement.setInt(1,id);
		 preparedStatement.execute();
		}
		 catch(ClassNotFoundException | SQLException e) {
			 e.printStackTrace();
		 }

		
	}


	@Override
	public void getAllStudent() {
		// TODO Auto-generated method stub
		  try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			    Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mystudent","root","root");
	  Statement statement=  connection.createStatement();
	   ResultSet resultSet= statement.executeQuery("select * from students");
	   while(resultSet.next())
	   {
		   System.out.println("Student id is"+ resultSet.getInt(1));
		   System.out.println("student name is "+ resultSet.getString(2));
		   System.out.println("student age is"+ resultSet.getInt(3));
		   System.out.println("student mark is"+ resultSet.getDouble(4));
		  
		   
	      System.out.println("------------------------------------------------");
	   }
 }
		  catch(ClassNotFoundException | SQLException e) {
				 e.printStackTrace();
			 }

		
	}

	@Override
	public void deleteAllStudent() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mystudent","root","root");
		 
		    Statement statement=connection.createStatement();
		    statement.execute("delete from students");
		
		}
		 catch(ClassNotFoundException | SQLException e) {
			 e.printStackTrace();
		 }

		
	}

	@Override
	public void getStudentById() {
		// TODO Auto-generated method stub
		 Scanner s=new Scanner(System.in);
			System.out.println("Enter id :");
			int id=s.nextInt();
			try {
				 Class.forName("com.mysql.cj.jdbc.Driver");
				    Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mystudent","root","root");
			 
			 PreparedStatement preparedStatement=connection.prepareStatement("select * from students where id=?");
			 preparedStatement.setInt(1,id);
			 ResultSet resultSet = preparedStatement.executeQuery();
			 while(resultSet.next()){
			   System.out.println("Student id is"+ resultSet.getInt(1));
			   System.out.println("student name is "+ resultSet.getString(2));
			   System.out.println("student age is"+ resultSet.getInt(3));
			   System.out.println("student mark is"+ resultSet.getDouble(4));
			   
			 }  
			 
			 
			   connection.close();
			}
			
			 catch(ClassNotFoundException | SQLException e) {
				 e.printStackTrace();



		
	} } 
}
	

