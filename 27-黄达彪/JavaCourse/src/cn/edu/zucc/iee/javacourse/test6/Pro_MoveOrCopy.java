package cn.edu.zucc.iee.javacourse.test6;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Pro_MoveOrCopy extends Dir {

	private String cmd_option = "/-Y";
	private int start_pos = 0;

	private String[] name1 = new String[7];
	private String name2 = new String();

	private int name1_size;
	private String pro_mode;

	private void move_file(Path source, Path temp_destin) throws FileAlreadyExistsException {
					
		try {
			if (cmd_option.equals("/Y")) {
				Files.move(source, temp_destin, StandardCopyOption.REPLACE_EXISTING);
			} else {
				Files.move(source, temp_destin);
			}
		} catch (Exception FileAlreadyExistsException) {
			throw new FileAlreadyExistsException(temp_destin.toString());
		}
	}

	private void copy_file(Path source, Path temp_destin) throws FileAlreadyExistsException {
			
		try {
			if (cmd_option.equals("/Y")) {
				Files.copy(source, temp_destin, StandardCopyOption.REPLACE_EXISTING);
			} else {
				Files.copy(source, temp_destin);
			}
		} catch (Exception FileAlreadyExistsException) {
			throw new FileAlreadyExistsException(temp_destin.toString());
		}
	}
	
	private void print_msg(int count) {
		
		if (pro_mode.equals("move")) {
			System.out.printf("移动了\t%d 个文件\n", count);
		} else {
			System.out.printf("拷贝了\t%d 个文件\n", count);
		}
	}
	
	private void process_file(String[] filename, String destination) {
		
		Path destin = find_path(destination);
		int count = 0;
		
		for (int i = 0; i < name1_size; i++) {
			
			Path source = find_path(filename[i]);
			Path temp_destin = destin;
			
			if (!source.toFile().exists()) {
				System.out.println("系统找不到指定的文件。");
				return;
			}
			
			while (true) {
				
				try {
					
					if (pro_mode.equals("move")) {
						move_file(source, temp_destin);
					} else {
						copy_file(source, temp_destin);
					}
					count++;
					print_msg(count);
					break;
				} catch (Exception FileAlreadyExistsException) {

					if (temp_destin.toFile().isDirectory()) {
						// case1: the destination is a exist directory
						// solution: add filename at the end of the destination
						temp_destin = Paths.get(temp_destin.toString() + "\\" 
									+ source.getFileName().toString());
					} else {
						// case2: is a exist file
						// solution: throw two options to choose whether cover or not
						System.out.print("覆盖"
								+ temp_destin.toString() + "吗? [YES|NO]: ");
						
						Scanner sc = new Scanner(System.in);
						String ans = sc.next();
						
						if (ans.equalsIgnoreCase("YES")) {
							cmd_option = "/Y";
						} else {
							print_msg(count);
							break;
						}
					}
				}
			}
		}
	}
	
	public void processMOVEorCOPY(String[] params, int params_size, String mode) {

		if (params_size == 0) {
			System.out.println("缺少参数\n");
			return;
		}
		
		if (params[0].equalsIgnoreCase("/Y")) {
			cmd_option = "/Y";
			start_pos = 1;
			name1_size--;
		} else if (params[0].equalsIgnoreCase("/-Y")) {
			start_pos = 1;
			name1_size--;
		}

		name1_size += params_size - 1; // 减去name2
		for (int i = start_pos; i < start_pos + name1_size; i++) {
			name1[i - start_pos] = params[i];
		}

		name2 = params[start_pos + name1_size];
		pro_mode = mode;
		
		process_file(name1, name2);
	}
}
