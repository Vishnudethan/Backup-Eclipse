package add.delete.create;



import java.io.File;

import java.util.Scanner;
public class Read1 {
    public static void main(String[] args) {
        try {
            File existingFile = new File("E:\\achu\\EclipsePractice\\FileA.txt");
            		Scanner hi=new Scanner(existingFile);
            while (hi.hasNextLine()) {  // Corrected method name
                System.out.println(hi.nextLine());
            }
            hi.close();
        } catch (Exception e) {
            System.out.println(e); 
        }
    }
}