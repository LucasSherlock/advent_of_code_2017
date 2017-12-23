package q3;

import java.util.ArrayList;

public class Q3Main {

	private static int input = 277678;
	public static void main(String[] args) {
		ptOne();
	}
	
	public static void ptOne() {
		int i = 1;
		while(input > (i*i)) {
			i += 2;
		}		
		int steps = input - (i-2)*(i-2);
		if(steps%(i-1) == 0) {
			steps = i-1;
		} else {
			steps = steps%(i-1);
		}
		System.out.println(steps);
	}

}
