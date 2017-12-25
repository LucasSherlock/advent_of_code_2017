package q5;

import java.util.ArrayList;

public class Q5Main {


	private static ArrayList<String> input = q1.Main.readFile("Q5_Input.txt");
	public static void main(String[] args) {
		ptOne();
		ptTwo();
	}
	
	public static void ptOne() {
		int[] jumps = new int[input.size()];
		int i = 0;
		for(String s : input) {
			jumps[i] = Integer.parseInt(s);
			i++;
		}

		int steps = 0;
		try {
			i = 0;
			while(true) {
				jumps[i] += 1;
				i += jumps[i]-1;
				
				steps++;
			}
		} catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println(steps);
		}
	}
	
	public static void ptTwo() {
		int[] jumps = new int[input.size()];
		int i = 0;
		for(String s : input) {
			jumps[i] = Integer.parseInt(s);
			i++;
		}

		int steps = 0;
		try {
			i = 0;
			while(true) {
				
				if(jumps[i] >= 3) { 
					jumps[i] -= 1;
					i += jumps[i]+1;
				} else {
					jumps[i] += 1;
					i += jumps[i]-1;
				}
					
				steps++;
			}
		} catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println(steps);
		}
	}
	
	

}
