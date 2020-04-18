package cn.edu.zucc.iee.javacourse.test6;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Dir {
	
	public static String current_dir = "C:\\";
	public final static String ERROR = "error";
		
	public String is_start(String path) {
		//每个盘的开头显示\，如C:\>   其他情况不显示，如C:\User>
		if (path.substring(path.length() - 2).equals(":\\")) {
			return path;
		} else {
			return path.substring(0, path.length() - 1);
		}
	}
	
	protected String process_path(String path) {
		
		if (path.substring(path.length() - 1) != "\\") {
			path += "\\";
		}
		
		if (path.indexOf(":") != -1) {
			return path;
		} else {
			return current_dir + path;
		}
	}
	
	protected String get_parent_path(String path) {
		
		int index = path.length() - 1;

		while (path.substring(index, index + 1).equals("\\") && index >= 0) {
			index--;
		}
		
		while (!path.substring(index, index + 1).equals("\\") && index >= 0) {
			index--;
		}
		
		if (index < 0) {
			return ERROR;
		}
		return path.substring(0, index + 1);    //带反斜杠
	}
	
	protected Path find_path(String path_name) {

		Path process_file = Paths.get(current_dir);
		
		if (path_name.indexOf(".") == 0) {

			if (path_name.indexOf("..") == 0) {
				process_file = process_file.getParent();
				if (path_name.length() == 2) {
					return process_file;
				}
				path_name = path_name.substring(3, path_name.length());
			} else {
				if (path_name.length() == 1) {
					return process_file;
				}
				path_name = path_name.substring(2, path_name.length());
			}
		}
		
		return process_file.resolve(path_name);
		/*
		String process_file = current_dir;
		
		if (path_name.indexOf(".") == 0) {

			if (path_name.indexOf("..") == 0) {
				process_file = get_parent_path(process_file);
				path_name = path_name.substring(3, path_name.length());
			} else {
				path_name = path_name.substring(2, path_name.length());
			}
		}

		if (path_name.indexOf(process_file) != -1) {  //absolute path
			return path_name;
		}
			
		if (!process_file.equals(ERROR)) {
			process_file += path_name;
		}
		return process_file;*/	
	}
}
