package cn.edu.zucc.iee.javacourse.test4;

public class RSP {

	public final static int choose_rock = 0;      
	public final static int choose_sissor = 1;    
	public final static int choose_paper = 2;    
	
	public int ID;
	public String name;
	
	public String[] transform = {"Rock", "Sissors", "Paper"};
	
	public RSP get_choose(int choose) {
		
		if (choose == choose_rock) {
			return new Rock();
		} else if (choose == choose_sissor) {
			return new Sissor();
		} else if (choose == choose_paper) {
			return new Paper();
		} else {
			return new RSP();
		}
	}
}
