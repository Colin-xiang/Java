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
		
		System.out.println("#######��ӭ����ʯͷ������#######");
		System.out.println("ѡ����Ϸģʽ��\n"
							+ "    3-������ʤ\n"
							+ "    5-�����ʤ\n"
							+ "    9-�ž���ʤ\n"
							+ "    others-�˳�");
	}
	
	public void get_gameMode() {
		
		Scanner sc = new Scanner(System.in);
		type = sc.nextInt();
		
		if (type == 3) {
			System.out.println("ģʽ��������ʤ���뿪����дģʽ");
		} else if (type == 5) {
			System.out.println("ģʽ�������ʤ���뿪����дģʽ");
		} else if (type == 9) {
			System.out.println("ģʽ���ž���ʤ���뿪����дģʽ");
		} else {
			game_continue = false;
		}
	}
	
	public void judge_game() {
		
		if (player.choose.ID  == computer.choose.ID) {
			
			System.out.println("ƽ��");
			System.out.println("���ʤ����" + winPlayer 
					+ "; ����ʤ����" + winComputer);
			System.out.println("#######################");
		} else if (player.choose.ID - computer.choose.ID == -1 
				|| player.choose.ID - computer.choose.ID == 2) {
		
			winPlayer++;
			System.out.println("���ʤ��");
			System.out.println("���ʤ����" + winPlayer 
					+ "; ����ʤ����" + winComputer);
			System.out.println("#######################");
		} else {
		
			winComputer++;
			System.out.println("����ʤ��");
			System.out.println("���ʤ����" + winPlayer 
					+ "; ����ʤ����" + winComputer);
			System.out.println("#######################");
		}
	}
	
	public void judge_win() {
		
		if (winComputer > winPlayer) {
			
			computer.win();
			System.out.println("��Ϸ����������ʤ��");
		} else {
			
			player.win();
			System.out.println("��Ϸ���������ʤ��");
		}
		System.out.println("��ʤ������� " + player.total_win
				+ "; ���� " + computer.total_win);
	}
	
	public void is_continue() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�Ƿ����[Y/N]: ");
		String res = sc.next();
		game_continue = res.equals("Y");
		
		winPlayer = 0;
		winComputer = 0;
	}
	
	public void game_start() {
		
		while (winPlayer <= (int) (type / 2) && winComputer <= (int) (type / 2)) {
			
			player.step();
			computer.step();
			System.out.println("��ң�" + player.choose.name 
					+ "; ���ԣ�" + computer.choose.name);
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
		System.out.println("�˳���Ϸ");
	}
}
