package practice;
import java.util.Scanner;

public class Facto {
	public  int Factor(int n) {
	//public  static int Factor(int n) {
		if(n==0||n==1) {
			return 1;
		}
		else {
			return n*Factor(n-1);
		}
	}
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.print("Enter a positive number:");
	int num=sc.nextInt();
Facto obj=new Facto();
	if(num>0) {
		//System.out.println("The factorial  of the number is:" +obj.Factor(num));
		System.out.println("The factorial  of the number is:" +obj.Factor(num));
	}
	else {
		System.out.println("Enter a valid number!!");
	}
}
	
}

