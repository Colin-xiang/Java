package cn.edu.zucc.iee.javacourse.test6;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Pro_DateOrTime extends Dir{
	
	private boolean alter_butten = true;
	private LocalDate ldate;
	private LocalTime ltime;
	
	private void alter_date() {
		
		int[] date_elem = new int[3];
		System.out.print("����������: (�������Կո�ֿ�) ");
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 3; i++) {	
			
			date_elem[i] = (sc.nextInt());
			
			if (date_elem[i] == -1) {
				return;
			}
		}
		
		try {
			LocalDate.of(date_elem[0], date_elem[1], date_elem[2]);
			System.out.println();
		} catch (Exception e) {
			System.out.println("�������\n");
		}
	}
	
	private void alter_time() {
		
		int[] date_elem = new int[3];
		System.out.print("������ʱ��: (ʱ�����Կո�ֿ�) ");
		
		Scanner sc = new Scanner(System.in);
				
		for(int i = 0; i < 3; i++) {	
			
			date_elem[i] = (sc.nextInt());
			
			if (date_elem[i] == -1) {
				return;
			}
		}
		
		try {
			LocalTime.of(date_elem[0], date_elem[1], date_elem[2]);
			System.out.println();
		} catch (Exception e) {
			System.out.println("�������\n");
		}
	}
	
	public void processDATEorTIME(String option, String mode) {

		if (option != null && option.equalsIgnoreCase("/T")) {
			alter_butten = false;
		} else if (option != null) {
			System.out.println("��������");
			return;
		}
        
        if (mode.equals("date")) {
        	
        	ldate = LocalDate.now();
        	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        	System.out.print("��ǰ����: " + ldate.format(dtf));
        	System.out.println(" " + ldate.getDayOfWeek());
        	
        	if (alter_butten) {
        		alter_date();
        	}
        } else {
        	
        	ltime = LocalTime.now();
        	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        	System.out.println(ltime.format(dtf));

        	if (alter_butten) {
        		alter_time();
        	}
        }       
	}
}
