package cn.edu.zucc.iee.javacourse.test5;

import java.util.Scanner;

public class Search {

	public Dictionary dict;
	public String search_str;
	public boolean is_continue;
	
	public Search() {
		
		Read_dict read_d = new Read_dict("words.txt");
		dict = read_d.get_data();
		is_continue = true;
	}
	
	public void show_MSG() {
		
		System.out.println("============================");
		System.out.print("Find: ");
	}
	
	public void read_input() {
		
		Scanner sc = new Scanner(System.in);
		search_str = sc.next();
	}
	
	public void is_continue() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("============================");
		System.out.print("Continue?[Y/N]: ");
		
		String enter = sc.next();
		is_continue = enter.equals("Y");
	}
	
	public void search_over() {
		
		System.out.println("============================");
		System.out.println("Exit");
	}
	
	public static void main(String[] args) {
		
		Search do_search = new Search();
		
		while (do_search.is_continue) {
			
			do_search.show_MSG();
			do_search.read_input();
			do_search.dict.search(do_search.search_str);
			do_search.is_continue();
		}
	
		do_search.search_over();
	}
}
