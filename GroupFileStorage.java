package homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
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
		
		List<Student> students = gr.getStudens();
		File file = new File(gr.getGroupName() + ".csv");		
		String del = ",";		
		String temp = "";
		
		try (PrintWriter pw = new PrintWriter(file)) {
			for (Student student : students) {
				temp = student.getName() + del + student.getLastName() 
				+ del + student.getGender() + del + student.getId() 
				+ del + student.getGroupName();
				pw.println(temp);	

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
				String tmp = (sc.nextLine() + System.lineSeparator());	
				tmp = tmp.substring(0, tmp.length() - 1);
				Student student = csvStrConv.fromStringRepresentation(tmp);
				group.addStudent(student);
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