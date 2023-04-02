package homework;

public class Main {

	public static void main(String[] args) {
		
		
//		Testing
		
		Student student1 = new Student("George", "Washington", Gender.MALE, 1, "first");	
		Student student2 = new Student("John", "Adams", Gender.MALE, 2, "first");
		Student student3 = new Student("Thomas", "Jefferson", Gender.MALE, 3, "first");
		Student student4 = new Student("James", "Madison", Gender.MALE, 4, "first");
		Student student5 = new Student("James", "Monroe", Gender.MALE, 5, "first");
		Student student6 = new Student("Andrew", "Jackson", Gender.MALE, 6, "first");
		Student student7 = new Student("John", "Tyler", Gender.MALE, 7, "first");
		Student student8 = new Student("Millard", "Fillmore", Gender.MALE, 8, "first");
		Student student9 = new Student("Franklin", "Pierce", Gender.MALE, 9, "first");
		Student student10 = new Student("James", "Buchanan", Gender.MALE, 10, "first");
		Student student11 = new Student("Abraham", "Lincoln", Gender.MALE, 11, "first");
		
		Group group1 = new Group();
		
		try {
			group1.addStudent(student1);
			group1.addStudent(student2);
			group1.addStudent(student3);
			group1.addStudent(student4);
			group1.addStudent(student5);
			group1.addStudent(student6);
			group1.addStudent(student7);
			group1.addStudent(student8);
			group1.addStudent(student9);
			group1.addStudent(student10);
			group1.addStudent(student11);
		} catch (GroupOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		System.out.println(group1);		
		
		try {
			System.out.println(group1.searchStudentByLastName("Lincoln"));			
		} catch (StudentNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		try {
			System.out.println(group1.searchStudentByLastName("Jackson"));			
		} catch (StudentNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		System.out.println("The student with the specified id has been deleted: " + group1.removeStudentByID(4));
		System.out.println("The student with the specified id has been deleted: " + group1.removeStudentByID(6));
		System.out.println("The student with the specified id has been deleted: " + group1.removeStudentByID(8));
		
		try {
			group1.addStudent(student11);
		} catch (GroupOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(group1);
		
		StudentRegistration registration1 = new StudentRegistration();
		
		try {
			registration1.createStudentAccountAndAddToGroup(group1);
		} catch (WrongValueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(group1);
		
		CSVStringConverter csvStrConv1 = new CSVStringConverter();		
		
		System.out.println(csvStrConv1.toStringRepresentation(student11));
		
		String studentStr = "Andrew,Johnson,MALE,13,first";
		
		Student student13 = csvStrConv1.fromStringRepresentation(studentStr);
		
		System.out.println(student13);
		
		
	}
}