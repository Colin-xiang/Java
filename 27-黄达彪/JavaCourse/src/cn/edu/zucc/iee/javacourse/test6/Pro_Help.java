package cn.edu.zucc.iee.javacourse.test6;

public class Pro_Help extends Dir {
	
	public void processHELP(String cmd) {
		
		if (cmd == null) {
			
			System.out.println();
			System.out.println("CD:    ��ʾ��ǰĿ¼�����ƻ�����ġ�");
			System.out.println("DIR:   ��ʾ��ǰĿ¼�е��ļ�����Ŀ¼��");
			System.out.println("MOVE:  �ƶ��ļ����������ļ���Ŀ¼��");
			System.out.println("COPY:  ��һ�ݻ����ļ����Ƶ���һ��λ�á�");
			System.out.println("DEL:   ɾ��һ�������ļ���");
			System.out.println("MD:    ����Ŀ¼��");
			System.out.println("RD:    ɾ��һ��Ŀ¼��");
			System.out.println("VER:   ��ʾ Windows �汾��");
			System.out.println("DATE:  ��ʾ���������ڡ�");
			System.out.println("TIME:  ��ʾ������ϵͳʱ�䡣");
			System.out.println("\n�й�ĳ���������ϸ��Ϣ������� HELP ������");
			System.out.println();
		} else {
			
			if (cmd.equalsIgnoreCase("CD")) {
				System.out.println("CD [path]  ��ʾ��ǰĿ¼�����ƻ�����ġ�\n");
			} else if (cmd.equalsIgnoreCase("DIR")) {
				
				System.out.println("DIR [[/A[[:]attributes]] | [/O[[:]sortorder]]]");
				System.out.println("\tĬ�ϰ�ԭʼ˳����ʾ\n");
				
				System.out.println(" /A\t��ʾ����ָ�����Ե��ļ�");
				System.out.println(" ����      \tD Ŀ¼       \tF �ļ�");
				
				System.out.println(" /O\t�÷���˳���г��ļ���");
				System.out.println(" ����˳��\tN ������   \tD ������/ʱ��");
				System.out.println("        \tG Ŀ¼����\tF �ļ�����\n");
			} else if (cmd.equalsIgnoreCase("MOVE")) {
				
				System.out.println("�ƶ��ļ����������ļ���Ŀ¼��");
				
				System.out.println("\nҪ�ƶ�����һ���ļ�(����5��):");
				System.out.println("MOVE [/Y | /-Y] [path]filename1[,...] destination");
				
				System.out.println("\nҪ������һ��Ŀ¼:");
				System.out.println("MOVE [/Y | /-Y] [path]dirname1 dirname2\n");
				
				System.out.println("  [path]filename1  ָ�������ƶ����ļ�λ�ú����ơ�");
				System.out.println("  destination     ָ���ļ�����λ�á�Ŀ��ɰ���һ����������\r\n" + 
						           "                                 ��ð�š�һ��Ŀ¼������ϡ����ֻ�ƶ�һ���ļ�");
				System.out.println("  [path]dirname1    ָ��Ҫ��������Ŀ¼��");
				System.out.println("  dirname2               ָ��Ŀ¼�������ơ�\n");
				System.out.println("  /Y              ȡ��ȷ�ϸ���һ������Ŀ���ļ�����ʾ��");
				System.out.println("  /-Y             ��ȷ�ϸ���һ������Ŀ���ļ�������ʾ��\n");
			} else if (cmd.equalsIgnoreCase("COPY")) {
				
				System.out.println("��һ�ݻ����ļ����Ƶ���һ��λ�á�(����5��)\n");
				System.out.println("COPY [/Y | /-Y] source[,...] destination\n");
				System.out.println("  source       ָ��Ҫ���Ƶ��ļ���");
				System.out.println("  destination  Ϊ���ļ�ָ��Ŀ¼��/���ļ�����");
				System.out.println("  /Y           ��ʹ��ȷ���Ƿ�Ҫ��������Ŀ���ļ�\r\n" 
							+ "               ����ʾ��");
				System.out.println("  /-Y          ʹ��ȷ���Ƿ�Ҫ��������Ŀ���ļ�\r\n" 
							+ "               ����ʾ��\n");
			} else if (cmd.equalsIgnoreCase("DEL")) {
				
				System.out.println("ɾ��һ�������ļ���(����5��)\n");
				System.out.println("DEL [/Q] names\n");
				System.out.println("  names         ָ��һ�������ļ�����Ŀ¼�б�\r\n" 
						+ "            \tͨ���������ɾ������ļ���\r\n" 
						+ "            \t���ָ����һ��Ŀ¼����Ŀ¼�е���\r\n" 
						+ "            \t���ļ����ᱻɾ����\r\n");
				System.out.println("  /Q            ����ģʽ����Ҫ��ȷ��ɾ��");
				System.out.println("  /S            ɾ��������Ŀ¼�е��ļ���\n");
			} else if (cmd.equalsIgnoreCase("MD")) {
				
				System.out.println("����Ŀ¼��\n");
				System.out.println("MD path");
			} else if (cmd.equalsIgnoreCase("RD")) {
				
				System.out.println("ɾ��һ��Ŀ¼��\n");
				System.out.println("RD [/Q] path\n");
				System.out.println("��Ŀ¼�����⣬����ɾ��ָ��Ŀ¼�µ�������Ŀ¼��\r\n" 
							+ " �ļ�������ɾ��Ŀ¼����\n");
				System.out.println("  /Q            ����ģʽ����Ҫ��ȷ��ɾ��\n");
			} else if (cmd.equalsIgnoreCase("VER")) {
				
				System.out.println("��ʾ Windows �汾��\n");
				System.out.println("VER\n");
			} else if (cmd.equalsIgnoreCase("DATE")) {
				
				System.out.println("��ʾ���������ڡ�\n");
				System.out.println("DATE [/T]\n");
				System.out.println("��ʾ��ǰ�������ú����������ڵ���ʾ�������\r\n" 
						+ "���������� DATE��Ҫ�����������ڣ�������-1��");
				System.out.println(" /T\t�ÿ���ָʾ����ֻ�����ǰ���ڣ�������ʾ���������ڡ�\n");
			} else if (cmd.equalsIgnoreCase("TIME")) {

				System.out.println("��ʾ������ϵͳʱ�䡣\n");
				System.out.println("TIME [/T]\n");
				System.out.println("��ʾ��ǰ�������ú����������ڵ���ʾ�������\r\n" 
						+ "���������� DATE��Ҫ��������ʱ�䣬������-1��");
				System.out.println(" /T\t�ÿ���ָʾ����ֻ�����ǰ���ڣ�������ʾ���������ڡ�\n");
			} else if (cmd.equalsIgnoreCase("EXIT")) {
				System.out.println("EXIT       �˳���");
			} else {
				System.out.println("�������߲�֧�ִ����\n");
			}
		}
	}
}
