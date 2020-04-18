package cn.edu.zucc.iee.javacourse.test6;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;

public class Pro_Dir extends Dir {

	private void print_fileDetail(SimpleDateFormat sdf, File file, String getName
			, int[] dir_num, int[] file_num, boolean dir, boolean fil) {
		
		String file_time = sdf.format(new Date(file.lastModified()));
		
		if (file.isDirectory() && dir) {
			
			System.out.print(file_time);
			System.out.print("\t<DIR>\t");
			dir_num[0]++;
			
			if (getName.equals("")) {
				System.out.println(file.getName());
			}
		} else if (file.isFile() && fil) {
			
			System.out.print(file_time);
			System.out.print("\t   \t");
			file_num[0]++;
			
			if (getName.equals("")) {
				System.out.println(file.getName());
			}
		}
		
		if (getName.equals("") == false) {
			System.out.println(getName);
		}
	}
	
	private void default_dir() {
		
		System.out.println("\n " 
				+ is_start(current_dir) + " 的目录\n");
		
		File file = new File(current_dir);
		File parent = file.getParentFile();
		File[] file_list = file.listFiles();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		int[] dir_num = new int[] {0};
		int[] file_num = new int[] {0};
		
		print_fileDetail(sdf, file, ".", dir_num, file_num, true, true);
		if (parent != null) {
			print_fileDetail(sdf, parent, "..", dir_num, file_num, true, true);
		}
		
		for (int i = 0; i < file_list.length; i++) {
			print_fileDetail(sdf, file_list[i], "", dir_num, file_num, true, true);
		}	
		
		System.out.printf("\t\t%d个文件\n\t\t%d个目录\n", file_num[0], dir_num[0]);
	}
	
	private void Case_A(String attr) {
		
		boolean dire;
		boolean fil;
		
		if (attr.equalsIgnoreCase("D")) {
			dire = true;
			fil = false;
		} else if (attr.equalsIgnoreCase("F")) {
			dire = false;
			fil = true;
		} else {
			System.out.println("参数格式不正确 - \"" + attr + "\"");
			return;
		}
		
		System.out.println("\n " 
				+ is_start(current_dir) + " 的目录\n");
		
		File file = new File(current_dir);
		File[] file_list = file.listFiles();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		int[] dir_num = new int[] {0};
		int[] file_num = new int[] {0};
		
		for (int i = 0; i < file_list.length; i++) {
			print_fileDetail(sdf, file_list[i], "", dir_num, file_num, dire, fil);
		}	
		
		System.out.printf("\t\t%d个文件\n\t\t%d个目录\n", file_num[0], dir_num[0]);
	}
	
	private void Case_O(String sort_method) {
		
		File file = new File(current_dir);
		File[] file_list = file.listFiles();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		int[] dir_num = new int[] {0};
		int[] file_num = new int[] {0};
		
		if (sort_method.equalsIgnoreCase("N") 
				|| sort_method.equalsIgnoreCase("D")) {
			//按名称 || 按日期
			System.out.println("\n " 
					+ is_start(current_dir) + " 的目录\n");
			
			Comparator<File> cmp;
			
			if (sort_method.equalsIgnoreCase("N")) {
				
				cmp = new Comparator<File>() {
					
					public int compare(File a, File b) {
						return a.getName().compareTo(b.getName());
					}
				};
			} else {
				
				cmp = new Comparator<File>() {
					
					public int compare(File a, File b) {
						
						if (a.lastModified() == b.lastModified()) {
							return 0;
						} else if (a.lastModified() < b.lastModified()) {
							return -1;
						} else {
							return 1;
						}
					}
				};
			}
			
			Arrays.sort(file_list, 0, file_list.length, cmp);
			
			for (int i = 0; i < file_list.length; i++) {
				
				print_fileDetail(sdf, file_list[i], "", 
						dir_num, file_num, true, true);
			}
		} else if (sort_method.equalsIgnoreCase("G") 
				|| sort_method.equalsIgnoreCase("F")) {
			//目录优先 || 文件优先
			System.out.println("\n " 
					+ is_start(current_dir) + " 的目录\n");
			
			if (sort_method.equalsIgnoreCase("G")) {
				
				for (int i = 0; i < file_list.length; i++) {				
					print_fileDetail(sdf, file_list[i], "", 
							dir_num, file_num, true, false);
				}
				for (int i = 0; i < file_list.length; i++) {					
					print_fileDetail(sdf, file_list[i], "", 
							dir_num, file_num, false, true);
				}
			} else if (sort_method.equalsIgnoreCase("F")) {
				
				for (int i = 0; i < file_list.length; i++) {				
					print_fileDetail(sdf, file_list[i], "", 
							dir_num, file_num, false, true);
				}			
				for (int i = 0; i < file_list.length; i++) {					
					print_fileDetail(sdf, file_list[i], "", 
							dir_num, file_num, true, false);
				}	
			}
		} else {
			System.out.println("参数格式不正确 - \"" + sort_method + "\"");
			return;
		}
		
		System.out.printf("\t\t%d个文件\n\t\t%d个目录\n", file_num[0], dir_num[0]);
	}
	
	public void processDIR(String[] params) {
		
		if (params[0] == null) {
			default_dir();
		} else if (params[0].substring(0, 2).equalsIgnoreCase("/A")) {
			if (params[0].length() < 3) {
				default_dir();
			} else {
				Case_A(params[0].substring(2, 3));
			}
		} else if (params[0].substring(0, 2).equalsIgnoreCase("/O")) {
			if (params[0].length() < 3) {
				params[0] = params[0] + "N";
			}
			Case_O(params[0].substring(2, 3));
		} else {
			System.out.println("无效开关 - \"" + params[0] + "\"");
		}
	}
}
