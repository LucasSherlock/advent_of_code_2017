package q6;

import java.util.ArrayList;
import java.util.HashMap;



public class Q6Main {
	//tester input
	//private static int[] input = {2,1,0,1};
	private static int[] input = {5,1,10,0,1,7,13,14,3,12,8,10,7,12,0,6};
	public static void main(String[] args) {
		ptOne();
		ptTwo();
		
	}
	
	
	/*
	 * finds the number of iterations of the reallocation routine until an infinite loop forms
	 */
	public static void ptOne() {
		//setup the arraylist and record starting state
		ArrayList<String> stateIDs = new ArrayList<String>();
		int[] currState = input;
		String currID = ArrToStr(input);
		
		//set up variable to track number of iterations
		int iters = 0;
		
		//repeatedly realloc and add to arraylist until duplicate found.
		while(!stateIDs.contains(currID)) {
			stateIDs.add(currID);
			currState = realloc(currState);
			currID = ArrToStr(currState);
			//System.out.println(currID);
			iters++;
		}
		System.out.println(iters);
	
	}
	/*
	 * finds the length of the loop formed
	 */
	public static void ptTwo() {
		//setup the hashmap and record starting state
		HashMap<String, Integer> states = new HashMap<String, Integer>();
		int[] currState = input;
		String currID = ArrToStr(input);
		
		//set up variable to track number of iterations
		int iters = 0;
		
		//repeatedly realloc and add to arraylist until duplicate found.
		while(!states.containsKey(currID)) {
			states.put(currID, iters);
			currState = realloc(currState);
			currID = ArrToStr(currState);
			System.out.println(currID);
			iters++;
		}
		//print the difference between the final iteration number and the 
		//iteration number of the repeat.
		System.out.println(iters-states.get(currID));
	
	}
	
	
	
	
	/*
	 * Runs the reallocation routine described for day 6.
	 */
	private static int[] realloc(int[] arr) {
		//find the largest value and its index
		int val = arr[0];
		int index = 0;
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > val) {
				val = arr[i];
				index = i;
			}
		}
		
		//reallocate
		arr[index] = 0;
		index++;
		int inc = val / arr.length;
		for(int i : arr) {
			arr[i] += inc;
		}
		val = val % arr.length;
		while(val>0) {
			if(index == arr.length) {
				index = 0;
			}
			arr[index]++;
			index++;
			val--;
		}
		return arr;
	}
	
	/*
	 * Convert an integer array to a string of the consecutive integer values. Used
	 * to create the IDs in the list.
	 */
	private static String ArrToStr(int[] arr) {
		String id = "";
		for(int i : arr) {
			id += " "+i;
		}
		return id;
	}
}
