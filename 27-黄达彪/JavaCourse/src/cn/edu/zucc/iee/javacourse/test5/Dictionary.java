package cn.edu.zucc.iee.javacourse.test5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Dictionary {
	
	public final static int MAX_CAPASITY = 50000;   //每个首字母字典的最大容量
	
	public Word[][] dictionary;
	public int[] sizeForDict;
	
	public ArrayList<Word> result;
	public Comparator<Word> cmp;
	
	public Dictionary() {
		
		sizeForDict = new int[26];
		dictionary = new Word[26][MAX_CAPASITY];
		result = new ArrayList<Word>();
		
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < MAX_CAPASITY; j++) {
				dictionary[i][j] = new Word();
			}
		}
		
		cmp = new Comparator<Word>() {
			
			public int compare(Word a, Word b) {
				return a.word.compareTo(b.word);
			}
		};
	}
	
	public int get_initials(String word) {
		//返回首字母的位置
		int pos_dic = 0;
		
		if (word.charAt(0) <= 'z' && word.charAt(0) >= 'a') {
			pos_dic = word.charAt(0) - 'a';
		} else {
			pos_dic = word.charAt(0) - 'A';
		}
		
		return pos_dic;
	}
	
	public void insert(int initials, Word element) {
		
		dictionary[initials][sizeForDict[initials]] = element;
		sizeForDict[initials]++;
	}
	
	public void sort_dict() {
		
		for (int i = 0; i < 26; i++) {
			Arrays.sort(dictionary[i], 0, sizeForDict[i], cmp);
		}
	}
	
	public void search(String word) {
		
		int initials = get_initials(word);
		result.clear();
		
		for (int i = 0; i < sizeForDict[initials]; i++) {
			
			if (dictionary[initials][i].word.indexOf(word) != -1) {
				result.add(dictionary[initials][i]);
			}
		}
		
		//Collections.sort(result, cmp);
		
		System.out.println("Search Result: ");
		
		if (result.isEmpty()) {
			System.out.println("No such word");
		} else {
			
			for (Word i: result) {
				System.out.println(i.word + " " + i.translate);
			}
		}
	}
}
