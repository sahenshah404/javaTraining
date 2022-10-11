//package core;
//
//import java.sql.Date;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class StudentAppl {
//	private static Scanner sc = new Scanner(System.in);
//
//	public static void main(String[] args) {
//		StudentTransaction studentTransaction = new StudentTransaction();
//
//		int choice = 0;
//		while (true) {
//			System.out.println("Press 1 to enroll new student");
//			System.out.println("Press 2 to update Student details");
//			System.out.println("Press 3 to remove student");
//			System.out.println("Press 4 to view all students");
//			System.out.println("Press 5 to exit");
//			choice = sc.nextInt();
//			sc.nextLine();
//			if (choice == 5)
//				break;
//
//			if (choice == 1) {
//				System.out.println(choice + "awdfad");
//				System.out.println("Enter student ID");
//				int id = sc.nextInt();
//				sc.nextLine();
//				System.out.println("Enter Student name");
//				String name = sc.nextLine();
//				System.out.println("Enter dob in dd-mm--yyyy format");
//				String stringDob = sc.nextLine();
//
//				SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
//				Date dob = new Date(0);
//				try {
//					dob = new Date(sdf.parse(stringDob).getTime());
//				} catch (ParseException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				Student student = new Student(id, name, dob);
//				studentTransaction.insertStudent(student);
//			}
//
//			if (choice == 2) {
//
//			}
//
//			if (choice == 3) {
//				System.out.println("Enter student ID");
//				int id = sc.nextInt();
//				sc.nextLine();
//				studentTransaction.removeStudent(id);
//			}
//
//			if (choice == 4) {
//				List<Student> students = new ArrayList<Student>();
//			}
//		}
//
//	}
//
//}
