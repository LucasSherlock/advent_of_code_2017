package q4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Q4Main {
	private static ArrayList<String> input = q1.Main.readFile("Q4_Input.txt");

	public static void main(String[] args) {
		ptOne();
		ptTwo();

	}
	
	
	public static void ptOne() {
		int numValid = 0;
		boolean valid;
		for(String s : input) {
			String[] line = s.split(" ");
			valid = true;
			for(int i = 0; i < line.length; i++) {
				int j = 0;
				while(j < line.length) {
					if(j == i) {
						j++;
						continue;
					}
					if(line[j].equals(line[i])) {
						valid = false;
					}
					j++;
				}
			}
			if(valid) {
				numValid++;
			}
		}
		System.out.println(numValid);
	}
	
	public static void ptTwo() {
		int numValid = 0;
		for(String s : input) {
			String[] line = s.split(" ");
			HashSet<String> words = new HashSet<String>();
			for(String word : line) {
				char[] newWord = word.toCharArray();
				Arrays.sort(newWord);
				word = new String(newWord);
				words.add(word);
			}
			
			if(words.size() == line.length) {
				numValid++;
			}
		}
		System.out.println(numValid);
	}
	

}
