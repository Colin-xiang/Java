package cn.edu.zucc.iee.javacourse.test6;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Pro_Del extends Dir {

	private boolean is_remind = true;  //�Ƿ���Ҫȷ��
	private boolean is_delAllinSub = false;
	private boolean delete_butten = true;  //ɾ������(��ĳһĿ¼ɾ��������ֹʱǿ��ȡ������)
	
	private void del_process(Path del_path) {
		
		File now_file = del_path.toFile();
		File[] sub_fileList = now_file.listFiles();
		
		if (sub_fileList != null) {
			for (int i = 0; i < sub_fileList.length; i++) {
				del_process(sub_fileList[i].toPath());
			}
		}
		
		if (now_file.isDirectory()) {
			return;
		}
		
		if (now_file.exists() && delete_butten) {
			
			try {
				if (is_remind) {
					
					System.out.print("�Ƿ�ɾ�� " + del_path.toString() + " ? [Y|N]: ");
					Scanner sc = new Scanner(System.in);
					
					String choose = sc.next();
					
					if (choose.equalsIgnoreCase("Y")) {
						Files.delete(del_path);
					} else {
						delete_butten = false;
						return;
					}
				} else {
					Files.delete(del_path);
				}
			} catch (Exception e) {
				System.out.println("DELETE ERROR: " + del_path.toString());
			}
		} else {
			System.out.println("�Ҳ��� " + del_path.toString() + "\n");
		}
	}
	
	public void processDEL(String[] params, int params_size) {
		
		int start = 0;
		
		if (params[start].equalsIgnoreCase("/Q")) {
			is_remind = false;
			start++;
		} else if (params[start].equalsIgnoreCase("/S")) {
			is_delAllinSub = true;
			start++;
		}
		
		for (int i = start; i < params_size; i++) {
			
			Path del_path = find_path(params[i]);
			
			if (del_path.toFile().isFile()) {
				try {
					Files.delete(del_path);
				} catch (Exception e) {
					System.out.println("DELETE ERROR: " + del_path.toString());                    
				}
			} else if (is_delAllinSub) {
				del_process(del_path);
			}
		}
	}
}
