package homework;

import java.util.Scanner;

public class StudentRegistration {	
	Scanner sc = new Scanner(System.in);
	
	
	public Student createStudentAccount() throws WrongValueException {
		
		Student student = new Student();
		
		System.out.println("Input student name");
		student.setName(sc.nextLine());
		System.out.println("Input student last name");
		student.setLastName(sc.nextLine());	
		
		System.out.println("Input student gender (male or female)");
		String strEnum = sc.nextLine();
		if (strEnum.equals("male") || strEnum.equals("male")) {
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
	
	public void createStudentAccountAndAddToGroup(Group group) throws WrongValueException {
		try {
			group.addStudent(createStudentAccount());
		} catch (GroupOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}