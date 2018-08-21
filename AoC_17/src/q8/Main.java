package q8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
	//The question input
	private static ArrayList<String> input = q1.Main.readFile("Q8_Input.txt");
	
	// A hashmap to list all the registers.
	protected static HashMap<String, Integer> regs = new HashMap<String, Integer>();
	
	public static void main(String[] args) {
		ptOne();

	}
	
	private static void ptOne() {
		populateRegs();
		
		for(String s : input) {
			doOperation(s);	
		}
		int max = regs.get(input.get(0).split(" ")[0]);
		for(int i : regs.values()) {
			if(i > max) {
				max = i;
			}
		}
		System.out.println(max);
	}
	
	private static void populateRegs() {
		String[] line;
		HashSet<String> names = new HashSet<String>();
		for(String s : input) {
			line = s.split(" ");
			names.add(line[0]);	
			names.add(line[4]);	
		}
		 for(String name : names) {
			 regs.put(name, 0);
		 }
	}
	
	private static void doOperation(String s) {
		String[] line = s.split(" ");
		boolean condition = false;
		switch(line[5]) {
		
		case "<": if(regs.get(line[4]) < Integer.parseInt(line[6])) {
			condition = true;
		}
		break;
		
		case ">": if(regs.get(line[4]) > Integer.parseInt(line[6])) {
			condition = true;
		}
		break;
		
		case "<=": if(regs.get(line[4]) <= Integer.parseInt(line[6])) {
			condition = true;
		}
		break;
		
		case ">=": if(regs.get(line[4]) >= Integer.parseInt(line[6])) {
			condition = true;
		}
		break;
		case "==": if(regs.get(line[4]) == Integer.parseInt(line[6])) {
			condition = true;
		}
		break;
		
		case "!=": if(regs.get(line[4]) != Integer.parseInt(line[6])) {
			condition = true;
		}
		break;

		}
		
		if(condition) {
			if(line[1].equals("inc")) {
				regs.put(line[0], regs.get(line[0])+Integer.parseInt(line[2]));
			} else {
				regs.put(line[0], regs.get(line[0])-Integer.parseInt(line[2]));
			}
		}
	}

}
