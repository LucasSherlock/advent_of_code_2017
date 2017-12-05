package q1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<String> input = readFile("Q1_Input.txt");
		String num = input.get(0);
		int total = 0;
		for(int i = 0; i < num.length() - 1; i++) {
			if(num.charAt(i) == num.charAt(i+1)) {
				total += num.charAt(i)-'0';
			}
		}
		if(num.charAt(0) == num.charAt(num.length()-1)) {
			total += num.charAt(0)-'0';
		}
		System.out.println(total);

	}
	
	public static ArrayList<String> readFile(String fileName) {
		ArrayList<String> input = new ArrayList<String>();
		try {
			File inputFile = new File(fileName);
			FileReader fr = new FileReader(inputFile);
			BufferedReader br = new BufferedReader(fr);
			String inputLine = null;
			while((inputLine = br.readLine()) != null) {
				input.add(inputLine);
			}
			br.close();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		return input;
	}


}
