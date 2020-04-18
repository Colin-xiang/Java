package cn.edu.zucc.iee.javacourse.test6;

import java.io.File;

public class Pro_CD extends Dir {

	private String temp_currentDir;
	
	public void processCD(String path) {
		
		if (path == null) {
			System.out.println("缺少参数\n");
			return;
		}
		
		temp_currentDir = current_dir;
		
		if (path.substring(0, 1).equals(".")) {		
			
			if (path.length() == 1) {
				return;
			}
			
			if (path.substring(0, 2).equals("..")) {

				if (path.substring(path.length() - 2).equals(":\\")) {
					return;
				} else {

					// File file = new File(current_dir);
					// File parent = file.getParentFile();

					current_dir = get_parent_path(current_dir);// parent.getAbsolutePath() + "\\";
					if (path.length() == 2) {
						return;
					}
					path = path.substring(3, path.length());
				}
			} else {
				path = path.substring(2, path.length());
			}
		}
		
		int find_index = current_dir.indexOf(path);
		
		if (find_index == -1) {
			
			String proc_path = process_path(path);
			File file = new File(proc_path);

			if (file.exists()) {
				current_dir = proc_path;
			} else {
				current_dir = temp_currentDir;
				System.out.println("系统找不到指定的路径。\n");
			}
		} else {
			
			if (path.substring(path.length() - 1) != "\\") {
				path += "\\";
			}
			current_dir = current_dir.substring(0, find_index) + path;
		}		
	}
}
