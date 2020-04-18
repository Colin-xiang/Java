package cn.edu.zucc.iee.javacourse.test6;

import java.util.Scanner;

public class Command {
	
	private final static String COM_HELP = "help";
	private final static String COM_CD = "cd";
	private final static String COM_DIR = "dir";
	private final static String COM_MOVE = "move";
	private final static String COM_COPY = "copy";
	private final static String COM_DEL = "del";
	private final static String COM_MD = "md";
	private final static String COM_RD = "rd";
	private final static String COM_VER = "ver";
	private final static String COM_DATE = "date";
	private final static String COM_TIME = "time";
	private final static String COM_EXIT = "exit";
	
	private final static int CMD_MAXLEN = 10;
	
	private String cmd;
	private String[] params;
	private Dir dir = new Dir();
	
	private int params_size = 0;
	
	private void get_command() {
		
		System.out.print(dir.is_start(Dir.current_dir) + ">");
		
		params = new String[CMD_MAXLEN - 1];
		
		Scanner sc = new Scanner(System.in);
		String[] whole_cmd = sc.nextLine().split(" ");
		
		cmd = whole_cmd[0];
		params_size = whole_cmd.length - 1;
		for (int i = 0; i < whole_cmd.length - 1; i++) {
			params[i] = whole_cmd[i + 1];
		}
	}
	
	public void ex_command() {
		
		System.out.println("输入 HELP 获得帮助\n");
		
		while (true) {
			
			get_command();
			
			if (cmd.equalsIgnoreCase(COM_EXIT)) {
				break;
			} else if (cmd.equalsIgnoreCase(COM_HELP)) {
				
				Pro_Help Cmd_oj = new Pro_Help();
				Cmd_oj.processHELP(params[0]);
			} else if (cmd.equalsIgnoreCase(COM_CD)) {
				
				Pro_CD Cmd_oj = new Pro_CD();
				Cmd_oj.processCD(params[0]);
			} else if (cmd.equalsIgnoreCase(COM_DIR)) {
				
				Pro_Dir Cmd_oj = new Pro_Dir();
				Cmd_oj.processDIR(params);
			} else if (cmd.equalsIgnoreCase(COM_MOVE)) {
				
				Pro_MoveOrCopy Cmd_oj = new Pro_MoveOrCopy();
				Cmd_oj.processMOVEorCOPY(params, params_size, COM_MOVE);
			} else if (cmd.equalsIgnoreCase(COM_COPY)) {
				
				Pro_MoveOrCopy Cmd_oj = new Pro_MoveOrCopy();
				Cmd_oj.processMOVEorCOPY(params, params_size, COM_COPY);
			} else if (cmd.equalsIgnoreCase(COM_DEL)) {
				
				Pro_Del Cmd_oj = new Pro_Del();
				Cmd_oj.processDEL(params, params_size);
			} else if (cmd.equalsIgnoreCase(COM_MD)) {
				
				Pro_Md Cmd_oj = new Pro_Md();
				Cmd_oj.processMD(params[0]);
			} else if (cmd.equalsIgnoreCase(COM_RD)) {
				
				Pro_Rd Cmd_oj = new Pro_Rd();
				Cmd_oj.processRD(params, params_size);
			} else if (cmd.equalsIgnoreCase(COM_VER)) {
				
				Pro_Ver Cmd_oj = new Pro_Ver();
				Cmd_oj.processVER();
			} else if (cmd.equalsIgnoreCase(COM_DATE)) {
				
				Pro_DateOrTime Cmd_oj = new Pro_DateOrTime();
				Cmd_oj.processDATEorTIME(params[0], COM_DATE);
			} else if (cmd.equalsIgnoreCase(COM_TIME)) {

				Pro_DateOrTime Cmd_oj = new Pro_DateOrTime();
				Cmd_oj.processDATEorTIME(params[0], COM_TIME);
			} else {
				System.out.println(cmd + " 不是内部或外部命令，也不是可运行的程序\r\n"
						+ "或批处理文件。");
			}
		}	
	}
	
}
