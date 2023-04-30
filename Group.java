package homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import homeworknine.Pair;

public class Group {
	
	private String groupName;	
	private final List<Student> students = new ArrayList<>();	
	
	public Group(String groupName) {
		super();
		this.groupName = groupName;
	}

	public Group() {
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<Student> getStudens() {
		return students;
	}
	
	public void addStudent(Student student) {
		if (students.size()<10) {
			students.add(student);				
			return;
		} 
		System.out.println("Group is full");
	}
	
	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
		for (Student student : students) {			
			if (student.getLastName().equals(lastName)) {
				return student;	
			}
		}
		throw new StudentNotFoundException("No student found for the specified last name");
	}	
	
	public boolean removeStudentByID(int id) {
		for (Student student : students) {
			if (student.getId() == id) {
				students.remove(student);
				return true;					
			}	
		}	
		return false;
	}

	public boolean isEqualsStudents() {	
		for (Student student : students) {
			int repeat = 0;
			for (Student student2 : students) {
				if (student.equals(student2)) {
					repeat++;
					if (repeat > 1) {
						return true;					
					}
				}
			}				
		}
		return false;	
	}	
	
	@Override
	public String toString() {
		
		Collections.sort(students, new Comparator<Human>() {
			public int compare(Human o1, Human o2) {
				if (o1.getLastName().compareTo((o2.getLastName())) < 0) {
					return -1;
				} else if (o1.getLastName().equals((o2.getLastName()))) {
					return 0;
				} else {
					return 1;
				}	
			}
		});

		String res = "Group list" + System.lineSeparator();
		for (Student student : students) {
			res += student + System.lineSeparator();
		}
		return res.substring(0, res.length() - 1);
	}

	@Override
	public int hashCode() {
		return Objects.hash(groupName, students);
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
		return Objects.equals(groupName, other.groupName) && Objects.equals(students, other.students);
	}

	
	
}