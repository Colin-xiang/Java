package cn.edu.zucc.iee.javacourse.test6;

import java.nio.file.Files;
import java.nio.file.Path;

public class Pro_Md extends Dir{

	public void processMD(String path) {
		
		if (path == null) {
			System.out.println("È±ÉÙ²ÎÊý\n");
			return;
		}
		
		Path create_path = find_path(path);
		
		try {
			
			if (create_path.getFileName().toString().indexOf(".") != -1) {
				Files.createDirectories(create_path.getParent());
				Files.createFile(create_path);
			} else {
				Files.createDirectories(create_path);
			}
		} catch (Exception e) {
			System.out.println(e);
		} 
	}
}
