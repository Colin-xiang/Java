package cn.edu.zucc.iee.javacourse.test4;

public class Person {
		
	public RSP choose;       
	public int total_win;
	
	public Person() {
		
		total_win = 0;
		choose = new RSP();
	}
	
	public void win() {
		total_win++;
	}
}
