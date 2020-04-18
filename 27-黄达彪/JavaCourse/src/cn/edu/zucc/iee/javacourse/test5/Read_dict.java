package cn.edu.zucc.iee.javacourse.test5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Scanner;

public class Read_dict {
	
	private String path_dict = "";
	private Dictionary dict;
	
	public Read_dict(String dict_name) {
		
		String root = System.getProperty("user.dir");
		path_dict = root + File.separator
				+ "src\\cn\\edu\\zucc\\iee\\javacourse\\test5\\" 
				+ dict_name;
		
		dict = new Dictionary();
	}
	
	public boolean judge_english(char ch) {
		//判断是否为英文或者.
		if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || ch == '.') {
			return true;
		} else {
			return false;
		}
	}
	
	public int find_separator(String word) {
		//寻找分隔位置
		int separator_index = 0;      //分隔位置（第一个除空格外的非英文字符）
		int prev_wordC = 0;           //分隔位置之前的词性长度
		
		for (; separator_index < word.length(); separator_index++) {
			
			if (word.charAt(separator_index) == ' ' 
					|| word.charAt(separator_index) == '	') {				
				prev_wordC = 0;
			} else if (judge_english(word.charAt(separator_index))) {
				prev_wordC++;
			} else {
				break;
			}
		}
		
		return separator_index - prev_wordC;
	}
	
	public Dictionary get_data() {
		
		try {
			
			InputStream is = Word.class.getResourceAsStream("words.txt");
			Scanner ds = new Scanner(is);
			
			String line;
			
			while (ds.hasNextLine()) {
				
				line = ds.nextLine();
				Word word = new Word();
				int point_i = find_separator(line);
							
				word.word = line.substring(0, point_i);
				word.translate = line.substring(point_i, line.length());
				
				if (word.word.equals("") || word.translate.equals("")) {
					continue;
				}
				
				dict.insert(dict.get_initials(word.word), word);
			}
		} catch (Exception e) {
			
			System.out.println("read error!");
			System.out.println(e);
		}
		
		dict.sort_dict();
		
		return dict;
	}
}
