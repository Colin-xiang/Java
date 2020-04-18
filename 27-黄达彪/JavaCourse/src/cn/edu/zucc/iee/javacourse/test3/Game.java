package cn.edu.zucc.iee.javacourse.test3;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		
		String[] cnNames = {"ʯͷ", "����", "��"};
		String[] enNames = {"Rock", "Scissors", "Paper"};
		
		int winPlayer = 0;    //���ʤ��
		int winComputer = 0;  //����ʤ��
		int nComputer = 0;    //����ѡ��
		int nYour = 0;        //���ѡ��
		int type = 0;         //��Ϸģʽ(���г���)
		String game_continue = "Y";  //��Ϸ�Ƿ����
		
		System.out.println("#######��ӭ����ʯͷ������#######");
		System.out.println("ѡ����Ϸģʽ��\n"
							+ "    3-������ʤ\n"
							+ "    5-�����ʤ\n"
							+ "    9-�ž���ʤ\n"
							+ "    others-�˳�");
		
		Scanner sc = new Scanner(System.in);
		type = sc.nextInt();
		
		if (type == 3) {
			System.out.println("ģʽ��������ʤ���뿪����дģʽ");
		} else if (type == 5) {
			System.out.println("ģʽ�������ʤ���뿪����дģʽ");
		} else if (type == 9) {
			System.out.println("ģʽ���ž���ʤ���뿪����дģʽ");
		} else {
			game_continue = "N";
		}
		
		while (game_continue.equals("Y") || game_continue.equals("y")) {
			
			while (winPlayer <= (int)(type / 2) && winComputer <= (int)(type / 2)) {
							
				System.out.println("���ȭ��R-ʯͷ, S-����, P-��");
				
				nComputer = (int)(Math.random()*3);
				String ychoose = sc.next();
		
				for (int i = 0; i < enNames.length; i++) {
				
					if (ychoose.equals(enNames[i].substring(0, 1))) {
						nYour = i;
						break;
					}
				}
			
				System.out.println("��ң�" + cnNames[nYour] 
						+ "; ���ԣ�" + cnNames[nComputer]);
			
				if (nYour == nComputer) {
				
					System.out.println("ƽ��");
					System.out.println("���ʤ����" + winPlayer 
							+ "; ����ʤ����" + winComputer);
					System.out.println("#######################");
				} else if (nYour - nComputer == -1 || nYour - nComputer == 2) {
				
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
			
			if (winComputer > winPlayer) {
				System.out.println("��Ϸ����������ʤ��");
			} else {
				System.out.println("��Ϸ���������ʤ��");
			}
			
			System.out.println("�Ƿ����[Y/N]: ");
			game_continue = sc.next();
			winPlayer = 0;
			winComputer = 0;
		}
		System.out.println("��Ϸ����");
		sc.close();
	}
}
