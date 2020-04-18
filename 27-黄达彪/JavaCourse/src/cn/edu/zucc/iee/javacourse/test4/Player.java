package cn.edu.zucc.iee.javacourse.test4;

import java.util.Scanner;

public class Player extends Person {

	public Player() {
		super();
	}
	
	public void step() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请出拳：R-石头, S-剪刀, P-布");
		
		String ychoose = sc.next();
		
		for (int i = 0; i < choose.transform.length; i++) {
			
			if (ychoose.equals(choose.transform[i].substring(0, 1))) {
				
				choose = choose.get_choose(i);
				break;
			}
		}
	}
}

