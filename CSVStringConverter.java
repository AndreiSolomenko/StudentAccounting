package homework;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CSVStringConverter implements StringConverter {
	
	private File file;
	
	public void saveToCSVfile(Student student) {
		file = new File("New student.csv");
		String del = ",";
		try (PrintWriter pw = new PrintWriter(file)) {
			pw.println(student.getName() + del + student.getLastName() 
			+ del + student.getGender() + del + student.getId() + del + student.getGroupName());			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public String toStringRepresentation(Student student) {	
		
		saveToCSVfile(student);
		
		String res = "";		
//		res = student.getName() + "," + student.getLastName() 
//		+ "," + student.getGender() + "," + student.getId() + "," + student.getGroupName();
				
		try (Scanner sc = new Scanner(file)) {
			for (; sc.hasNextLine();) {
				res += sc.nextLine() + System.lineSeparator();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res.substring(0, res.length() - 1);
	}

	@Override
	public Student fromStringRepresentation(String str) {
		
		Student student = new Student();	
		
		String[] strArr = str.split(",");
		
		student.setName(strArr[0]);
		student.setLastName(strArr[1]);
		student.setGender(strArr[2]);
		student.setId(Integer.valueOf(strArr[3]));
		student.setGroupName(strArr[4]);	
		
		return student;
	}
}