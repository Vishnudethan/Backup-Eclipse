package practice;

public class StringBufferExample
{
	public static void main(String args[])
{
		StringBuffer sb=new StringBuffer("Hello ");
		//append
	sb.append("Java");//now original string is changed
		System.out.println(sb);
	//insert
	sb.insert(1,"Java");
	System.out.println(sb);
//	//replace
	sb.replace(1,3,"Java");
	System.out.println(sb);
	//delete
	sb.delete(1,3);
	System.out.println(sb);
//reverse
	sb.reverse();
	System.out.println(sb);
//capacity
	StringBuffer sb1 = new StringBuffer();
	//printing default capacity of string buffer
	System.out.println("default capacity: " + sb1.capacity());
	sb = new StringBuffer("A");
		System.out.println("capacity: " + sb.capacity());
}
}