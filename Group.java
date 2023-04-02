package homework;

import java.util.Arrays;
import java.util.Comparator;

public class Group {
	
	private String groupName;	
	private final Student[] students;
	
	public Group() {
		super();
		students = new Student[10];
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Student[] getStudens() {
		return students;
	}
	
	public void addStudent(Student student) throws GroupOverflowException {
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = student;				
				return;
			}
		}
		throw new GroupOverflowException("Group is full");
	}
	
	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {				
				if (students[i].getLastName().equals(lastName)) {
					return students[i];					
				}					
			}
		}
		throw new StudentNotFoundException("No student found for the specified last name");
	}	
	
	public boolean removeStudentByID(int id) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				if (students[i].getId() == id) {
					students[i] = null;
					return true;					
				}				
			}			
		}	
		return false;
	}

	@Override
	public String toString() {
		Arrays.sort(students, Comparator.nullsFirst(new StudentsNameComparator()));

		String res = "Group list" + System.lineSeparator();
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				res += students[i] + System.lineSeparator();
			}
		}
		return res;
	}
}