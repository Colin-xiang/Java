package cn.edu.zucc.iee.javacourse.test4;

public class Computer extends Person {
	
	public Computer() {
		super();
	}
	
	public void step() {
		
		int cComputer = (int)(Math.random()*3);
		choose = choose.get_choose(cComputer);
	}
}
