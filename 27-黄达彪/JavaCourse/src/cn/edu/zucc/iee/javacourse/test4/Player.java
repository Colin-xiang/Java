package cn.edu.zucc.iee.javacourse.test4;

import java.util.Scanner;

public class Player extends Person {

	public Player() {
		super();
	}
	
	public void step() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("���ȭ��R-ʯͷ, S-����, P-��");
		
		String ychoose = sc.next();
		
		for (int i = 0; i < choose.transform.length; i++) {
			
			if (ychoose.equals(choose.transform[i].substring(0, 1))) {
				
				choose = choose.get_choose(i);
				break;
			}
		}
	}
}

