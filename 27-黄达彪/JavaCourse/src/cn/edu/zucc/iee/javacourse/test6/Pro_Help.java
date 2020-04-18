package cn.edu.zucc.iee.javacourse.test6;

public class Pro_Help extends Dir {
	
	public void processHELP(String cmd) {
		
		if (cmd == null) {
			
			System.out.println();
			System.out.println("CD:    显示当前目录的名称或将其更改。");
			System.out.println("DIR:   显示当前目录中的文件和子目录。");
			System.out.println("MOVE:  移动文件并重命名文件和目录。");
			System.out.println("COPY:  将一份或多份文件复制到另一个位置。");
			System.out.println("DEL:   删除一个或多个文件。");
			System.out.println("MD:    创建目录。");
			System.out.println("RD:    删除一个目录。");
			System.out.println("VER:   显示 Windows 版本。");
			System.out.println("DATE:  显示或设置日期。");
			System.out.println("TIME:  显示或设置系统时间。");
			System.out.println("\n有关某个命令的详细信息，请键入 HELP 命令名");
			System.out.println();
		} else {
			
			if (cmd.equalsIgnoreCase("CD")) {
				System.out.println("CD [path]  显示当前目录的名称或将其更改。\n");
			} else if (cmd.equalsIgnoreCase("DIR")) {
				
				System.out.println("DIR [[/A[[:]attributes]] | [/O[[:]sortorder]]]");
				System.out.println("\t默认按原始顺序显示\n");
				
				System.out.println(" /A\t显示具有指定属性的文件");
				System.out.println(" 属性      \tD 目录       \tF 文件");
				
				System.out.println(" /O\t用分类顺序列出文件。");
				System.out.println(" 排列顺序\tN 按名称   \tD 按日期/时间");
				System.out.println("        \tG 目录优先\tF 文件优先\n");
			} else if (cmd.equalsIgnoreCase("MOVE")) {
				
				System.out.println("移动文件并重命名文件和目录。");
				
				System.out.println("\n要移动至少一个文件(至多5个):");
				System.out.println("MOVE [/Y | /-Y] [path]filename1[,...] destination");
				
				System.out.println("\n要重命名一个目录:");
				System.out.println("MOVE [/Y | /-Y] [path]dirname1 dirname2\n");
				
				System.out.println("  [path]filename1  指定你想移动的文件位置和名称。");
				System.out.println("  destination     指定文件的新位置。目标可包含一个驱动器号\r\n" + 
						           "                                 和冒号、一个目录名或组合。如果只移动一个文件");
				System.out.println("  [path]dirname1    指定要重命名的目录。");
				System.out.println("  dirname2               指定目录的新名称。\n");
				System.out.println("  /Y              取消确认覆盖一个现有目标文件的提示。");
				System.out.println("  /-Y             对确认覆盖一个现有目标文件发出提示。\n");
			} else if (cmd.equalsIgnoreCase("COPY")) {
				
				System.out.println("将一份或多份文件复制到另一个位置。(至多5个)\n");
				System.out.println("COPY [/Y | /-Y] source[,...] destination\n");
				System.out.println("  source       指定要复制的文件。");
				System.out.println("  destination  为新文件指定目录和/或文件名。");
				System.out.println("  /Y           不使用确认是否要覆盖现有目标文件\r\n" 
							+ "               的提示。");
				System.out.println("  /-Y          使用确认是否要覆盖现有目标文件\r\n" 
							+ "               的提示。\n");
			} else if (cmd.equalsIgnoreCase("DEL")) {
				
				System.out.println("删除一个或多个文件。(至多5个)\n");
				System.out.println("DEL [/Q] names\n");
				System.out.println("  names         指定一个或多个文件或者目录列表。\r\n" 
						+ "            \t通配符可用来删除多个文件。\r\n" 
						+ "            \t如果指定了一个目录，该目录中的所\r\n" 
						+ "            \t有文件都会被删除。\r\n");
				System.out.println("  /Q            安静模式。不要求确认删除");
				System.out.println("  /S            删除所有子目录中的文件。\n");
			} else if (cmd.equalsIgnoreCase("MD")) {
				
				System.out.println("创建目录。\n");
				System.out.println("MD path");
			} else if (cmd.equalsIgnoreCase("RD")) {
				
				System.out.println("删除一个目录。\n");
				System.out.println("RD [/Q] path\n");
				System.out.println("除目录本身外，还将删除指定目录下的所有子目录和\r\n" 
							+ " 文件。用于删除目录树。\n");
				System.out.println("  /Q            安静模式。不要求确认删除\n");
			} else if (cmd.equalsIgnoreCase("VER")) {
				
				System.out.println("显示 Windows 版本。\n");
				System.out.println("VER\n");
			} else if (cmd.equalsIgnoreCase("DATE")) {
				
				System.out.println("显示或设置日期。\n");
				System.out.println("DATE [/T]\n");
				System.out.println("显示当前日期设置和输入新日期的提示，请键入\r\n" 
						+ "不带参数的 DATE。要保留现有日期，请输入-1。");
				System.out.println(" /T\t该开关指示命令只输出当前日期，但不提示输入新日期。\n");
			} else if (cmd.equalsIgnoreCase("TIME")) {

				System.out.println("显示或设置系统时间。\n");
				System.out.println("TIME [/T]\n");
				System.out.println("显示当前日期设置和输入新日期的提示，请键入\r\n" 
						+ "不带参数的 DATE。要保留现有时间，请输入-1。");
				System.out.println(" /T\t该开关指示命令只输出当前日期，但不提示输入新日期。\n");
			} else if (cmd.equalsIgnoreCase("EXIT")) {
				System.out.println("EXIT       退出。");
			} else {
				System.out.println("帮助工具不支持此命令。\n");
			}
		}
	}
}
