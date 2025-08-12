package add.delete.create;

import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;




/*import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Update1 {
    public static void main(String[] args) {
        try {
            File existingFile = new File("E:\\achu\\EclipsePractice\\FileA.txt");
            List<String> contents = new ArrayList<>();

            try (Scanner sc = new Scanner(existingFile)) {
                while (sc.hasNextLine()) {
                    contents.add(sc.nextLine());
                }
            }
            FileWriter file = new FileWriter(existingFile,true);
            for(int i=contents.size()+1;i<=contents.size()+5;i++) {
            file.write("hi this is line number " + i+  " \n");
            }
            file.close();

            System.out.println("Existing Contents: " + contents);

          

            System.out.println("File updated successfully!");
        } catch (Exception e) {
            System.out.println();
        }
    }
}*/
public class Update1{
	public static void main(String[] args) {
		try {
			File existingFile=new File("E:\\\\achu\\\\EclipsePractice\\\\FileA.txt");
			Scanner sc=new Scanner(existingFile);
			List<String> contents =new LinkedList<String>();
			while(sc.hasNextLine()) {
				contents.add(sc.nextLine());
				
			}
			FileWriter File =new FileWriter(existingFile,true);
			for(int i=contents.size()+1;i<=contents.size()+3;i++) {
				File.write("Hi these are the new contents " + i+ "\n");
				
				}
			File.close();
			System.out.println("Existing contents are " +contents);
			System.out.println("The files are updated successfully.. \n go back to the Read1 and run it to view");
			sc.close();
			
		}
		catch(Exception e){
			System.out.println(e);
			
		}
		}
	}
	


