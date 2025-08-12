package add.delete.create;

import java.io.File;

public class Delete {
	public static void main(String[] args) {
		try {
			File existingFile=new File("E:\\achu\\EclipsePractice\\FileA.txt");
			existingFile.delete();
			System.out.println("contents are deleted");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
