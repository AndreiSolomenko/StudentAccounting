package homework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Group {
	
	private String groupName;	
	private final Student[] students;	
	
	public Group(String groupName) {
		super();
		this.groupName = groupName;
		this.students = new Student[10];
	}

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
	
	public boolean isEqualsStudents() {
		for (int i = 0; i < students.length; i++) {
			for (int j = i + 1; j < students.length; j++) {
				if (students[i] != null && students[j] != null) {
					if (students[i].equals(students[j])) {
						return true;
					}					
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(students);
		result = prime * result + Objects.hash(groupName);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		return Objects.equals(groupName, other.groupName) && Arrays.equals(students, other.students);
	}	
}