package q2;

import java.util.ArrayList;

public class Q2Main {
	private static ArrayList<String> input = q1.Main.readFile("Q2_Input.txt");
	public static void main(String[] args) {
		ptOne();
		ptTwo();

	}
	
	
	public static void ptOne() {
		int total = 0;
		for(String line : input) {
			int[] nums = toIntArray(line);
			int min = nums[0];
			int max = nums[0];
			
			for(int i = 1; i < nums.length; i++) {
				if(nums[i] < min) {
					min = nums[i];
				}
				if(nums[i] > max) {
					max = nums[i];
				}
				
			}
			total += (max-min);
		}
		System.out.println(total);
	}
	
	public static void ptTwo() {
		int total = 0;
		for(String line : input) {
			int[] nums = toIntArray(line);
			for(int i = 0; i < nums.length; i++) {
				for(int j = 0; j < nums.length; j++) {
					if(j != i && nums[j]%nums[i] == 0) {
						total += nums[j]/nums[i];
					}
				}
			}
			
		}
		System.out.println(total);
	}
	
	public static int[] toIntArray(String line) throws NumberFormatException {
		String[] strings = line.split("\t");
		int[] nums = new int[strings.length];
		for(int i = 0; i < strings.length; i++) {
			nums[i] = Integer.parseInt(strings[i]);
		}
		return nums;
	}

}
