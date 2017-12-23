package q8;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {

	private static ArrayList<String> input = q1.Main.readFile("Q8_InputTest.txt");
	
	public static void main(String[] args) {
		String[] line;
		ArrayList<Register> regs = new ArrayList<Register>();
		HashSet<String> names = new HashSet<String>();
		for(String s : input) {
			line = s.split(" ");
			names.add(line[0]);
		}
		 for(String name : names) {
			 regs.add(new Register(name));
		 }
	

	}

}
