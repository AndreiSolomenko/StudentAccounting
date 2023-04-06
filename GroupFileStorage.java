package homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class GroupFileStorage {
	
	public static long copyFile(File in, File out) throws IOException {
		try (InputStream is = new FileInputStream(in); OutputStream os = new FileOutputStream(out)) {
			return is.transferTo(os);
		}
	}

	public static void СopyFilesWithSpecifiedExtension(File folderIn, File folderOut, String extension)
			throws IOException {
		File[] files = folderIn.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile()) {
				String[] strArr = files[i].getName().split("[.]");				
				if (strArr[strArr.length - 1].equals(extension)) {
					File file = new File(folderOut, files[i].getName());
					System.out.println(copyFile(files[i], file));					
				}				
			}
		}
	}
	
	public static void saveGroupToCSV(Group gr) throws IOException {
		Student[] students = gr.getStudens();
		File file = new File(gr.getGroupName() + ".csv");
		String del = ",";			
		try (PrintWriter pw = new PrintWriter(file)) {
			for (int i = 0; i < students.length; i++) {
				if (students[i] != null) {
					pw.println(students[i].getName() + del + students[i].getLastName() 
						+ del + students[i].getGender() + del + students[i].getId() 
						+ del + students[i].getGroupName());					
				}				
			}						
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public static Group loadGroupFromCSV(File file) throws IOException {
		Group group = new Group();
		CSVStringConverter csvStrConv = new CSVStringConverter();		
		try (Scanner sc = new Scanner(file)) {
			for (; sc.hasNextLine(); ) {
				String tmp = sc.nextLine() + System.lineSeparator();	
				Student student = csvStrConv.fromStringRepresentation(tmp);
				try {
					group.addStudent(student);
				} catch (GroupOverflowException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return group;
	}
	
	public static File findFileByGroupName(String groupName, File workFolder) throws IOException {
		
		File res = null;
		File[] files = workFolder.listFiles();
		
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile()) {
				String[] strArr = files[i].getName().split("[.]");				
				if (strArr[0].equals(groupName)) {
					res = files[i];					
				}				
			}
		}
		return res;		
	}	
}