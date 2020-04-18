package cn.edu.zucc.iee.javacourse.test1;

public class HelloWorld {
	
	public static void main(String[] args) {
		
		String greeting = "Hello World";
		for(int i = 0; i < greeting.length(); i++)
			System.out.print("=");
		System.out.println();
		
		System.out.println(greeting);
		
		for(int i = 0; i < greeting.length(); i++)
			System.out.print("=");
		System.out.println();
	}
}
