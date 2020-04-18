package cn.edu.zucc.iee.javacourse.test2;

import java.util.Scanner;
import java.lang.Math;

public class Guess {
	
	public static void main(String[] args) {	
		
		System.out.println("please input you answer");
		Scanner sc = new Scanner(System.in);
		
		int random = (int)(Math.random() * 100);
		int answer = sc.nextInt();
		
		while (true) {			
			
			if (answer == random) {
				System.out.println("Congratulations, your answer is right");
				break;
			} else if (answer < random) {
				System.out.println("your answer is too small, please re-input");
			} else {
				System.out.println("your answer is too big, please re-input");
			}			
			answer = sc.nextInt();
		}
	}
}
