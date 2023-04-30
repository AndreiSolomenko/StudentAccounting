package homework;

import java.util.Scanner;

public class StudentRegistration {		
	
	public static Student createStudentAccount() throws WrongValueException {
		Scanner sc = new Scanner(System.in);		
		Student student = new Student();
		
		System.out.println("Input student name");
		student.setName(sc.nextLine());
		System.out.println("Input student last name");
		student.setLastName(sc.nextLine());	
		
		System.out.println("Input student gender (male or female)");
		String strEnum = sc.nextLine();
		if (strEnum.equals("male") || strEnum.equals("female")) {
			student.setGender(strEnum);
		}else {
			throw new WrongValueException("Wrong value entered!");			
		}
		
		System.out.println("Input student id");		
		if (sc.hasNextInt()) {
			student.setId(sc.nextInt());			
		} else {
			throw new WrongValueException("Wrong value entered!");			
		}
		
		sc.nextLine();
		System.out.println("Input student groupName");
		student.setGroupName(sc.nextLine());		
		
		return student;		
	} 
	
	public static void createStudentAccountAndAddToGroup(Group group) throws WrongValueException {
		try {
			group.addStudent(createStudentAccount());
		} catch (WrongValueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}