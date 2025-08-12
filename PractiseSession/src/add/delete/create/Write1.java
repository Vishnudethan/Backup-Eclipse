package add.delete.create;


import java.io.File;
import java.io.FileWriter;

public class Write1 {
	public static void main(String[] args) {
		try {
			File existingFile = new File("E:\\achu\\EclipsePractice\\FileA.txt");
			FileWriter file1=new FileWriter(existingFile);
			file1.write("hi this is line number 1\n");
			file1.write("hi this is line number 2\n");
			file1.write("hi this is line number 3\n");
			file1.write("hi this is line number 4\n");
			file1.write("hi this is line number 5\n");
			file1.close();
			
			System.out.println("Hi the contents has been added successfully");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}

}
