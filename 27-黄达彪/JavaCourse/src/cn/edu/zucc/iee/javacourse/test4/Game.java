package cn.edu.zucc.iee.javacourse.test4;

import java.util.Scanner;

public class Game {
	
	public int type;          //game mode(the number of game played)
	public int winPlayer;     //count of player's win
	public int winComputer;   //count of computer's win
	public static boolean game_continue;  //judge whether game is continued or not
	
	//define players
	public Player player;
	public Computer computer;
	
	public Game() {
		
		type = 0;
		winPlayer = 0;
		winComputer = 0;
		game_continue = true;
		
		player = new Player();
		computer = new Computer();
	}
	
	public void start_msg() {
		
		System.out.println("#######欢迎来到石头剪刀布#######");
		System.out.println("选择游戏模式：\n"
							+ "    3-三局两胜\n"
							+ "    5-五局三胜\n"
							+ "    9-九局五胜\n"
							+ "    others-退出");
	}
	
	public void get_gameMode() {
		
		Scanner sc = new Scanner(System.in);
		type = sc.nextInt();
		
		if (type == 3) {
			System.out.println("模式：三局两胜。请开启大写模式");
		} else if (type == 5) {
			System.out.println("模式：五局三胜。请开启大写模式");
		} else if (type == 9) {
			System.out.println("模式：九局五胜。请开启大写模式");
		} else {
			game_continue = false;
		}
	}
	
	public void judge_game() {
		
		if (player.choose.ID  == computer.choose.ID) {
			
			System.out.println("平局");
			System.out.println("玩家胜场：" + winPlayer 
					+ "; 电脑胜场：" + winComputer);
			System.out.println("#######################");
		} else if (player.choose.ID - computer.choose.ID == -1 
				|| player.choose.ID - computer.choose.ID == 2) {
		
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
	
	public void judge_win() {
		
		if (winComputer > winPlayer) {
			
			computer.win();
			System.out.println("游戏结束，电脑胜利");
		} else {
			
			player.win();
			System.out.println("游戏结束，玩家胜利");
		}
		System.out.println("总胜场：玩家 " + player.total_win
				+ "; 电脑 " + computer.total_win);
	}
	
	public void is_continue() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("是否继续[Y/N]: ");
		String res = sc.next();
		game_continue = res.equals("Y");
		
		winPlayer = 0;
		winComputer = 0;
	}
	
	public void game_start() {
		
		while (winPlayer <= (int) (type / 2) && winComputer <= (int) (type / 2)) {
			
			player.step();
			computer.step();
			System.out.println("玩家：" + player.choose.name 
					+ "; 电脑：" + computer.choose.name);
			judge_game();
		}		
		judge_win();
	}
	
	public static void main(String[] args) {
		
		Game game = new Game();
		game.start_msg();
		game.get_gameMode();
		
		while (game_continue) {
			
			game.game_start();
			game.is_continue();
		}
		System.out.println("退出游戏");
	}
}
