package cn.edu.zucc.iee.javacourse.test3;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		
		String[] cnNames = {"石头", "剪刀", "布"};
		String[] enNames = {"Rock", "Scissors", "Paper"};
		
		int winPlayer = 0;    //玩家胜场
		int winComputer = 0;  //电脑胜场
		int nComputer = 0;    //电脑选择
		int nYour = 0;        //玩家选择
		int type = 0;         //游戏模式(进行场数)
		String game_continue = "Y";  //游戏是否继续
		
		System.out.println("#######欢迎来到石头剪刀布#######");
		System.out.println("选择游戏模式：\n"
							+ "    3-三局两胜\n"
							+ "    5-五局三胜\n"
							+ "    9-九局五胜\n"
							+ "    others-退出");
		
		Scanner sc = new Scanner(System.in);
		type = sc.nextInt();
		
		if (type == 3) {
			System.out.println("模式：三局两胜。请开启大写模式");
		} else if (type == 5) {
			System.out.println("模式：五局三胜。请开启大写模式");
		} else if (type == 9) {
			System.out.println("模式：九局五胜。请开启大写模式");
		} else {
			game_continue = "N";
		}
		
		while (game_continue.equals("Y") || game_continue.equals("y")) {
			
			while (winPlayer <= (int)(type / 2) && winComputer <= (int)(type / 2)) {
							
				System.out.println("请出拳：R-石头, S-剪刀, P-布");
				
				nComputer = (int)(Math.random()*3);
				String ychoose = sc.next();
		
				for (int i = 0; i < enNames.length; i++) {
				
					if (ychoose.equals(enNames[i].substring(0, 1))) {
						nYour = i;
						break;
					}
				}
			
				System.out.println("玩家：" + cnNames[nYour] 
						+ "; 电脑：" + cnNames[nComputer]);
			
				if (nYour == nComputer) {
				
					System.out.println("平局");
					System.out.println("玩家胜场：" + winPlayer 
							+ "; 电脑胜场：" + winComputer);
					System.out.println("#######################");
				} else if (nYour - nComputer == -1 || nYour - nComputer == 2) {
				
					winPlayer++;
					System.out.println("玩家胜利");
					System.out.println("玩家胜场：" + winPlayer 
							+ "; 电脑胜场：" + winComputer);
					System.out.println("#######################");
				} else {
				
					winComputer++;
					System.out.println("电脑胜利");
					System.out.println("玩家胜场：" + winPlayer 
							+ "; 电脑胜场：" + winComputer);
					System.out.println("#######################");
				}
			}
			
			if (winComputer > winPlayer) {
				System.out.println("游戏结束，电脑胜利");
			} else {
				System.out.println("游戏结束，玩家胜利");
			}
			
			System.out.println("是否继续[Y/N]: ");
			game_continue = sc.next();
			winPlayer = 0;
			winComputer = 0;
		}
		System.out.println("游戏结束");
		sc.close();
	}
}
