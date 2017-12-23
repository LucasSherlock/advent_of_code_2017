package q3;

import java.awt.Point;
import java.util.HashMap;

public class Q3Main {

	private static HashMap<Point, Integer> spiral = new HashMap<Point, Integer>();
	private static MappingFunction func = new MappingFunction(spiral);
	private static int input = 277678;
	public static void main(String[] args) {
		ptOne();
		ptTwo();
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

	public static void ptTwo() {
		spiral.put(new Point(), 1);
		
		int x = 0;
		int y = 0;
		int maxX = 0;
		int maxY = 0;
		int minX = 0;
		int minY = 0;
		
		while(spiral.get(new Point(x,y)) <= input) {	
			do {
				x++;
				spiral.computeIfAbsent(new Point(x,y), func);
				if(spiral.get(new Point(x,y)) > input) {
					break;
				}
			} while(x < maxX+1);
			if(spiral.get(new Point(x,y)) > input) {
				break;
			}
			maxX = x;
			do {
				y++;
				spiral.computeIfAbsent(new Point(x,y), func);
				if(spiral.get(new Point(x,y)) > input) {
					break;
				}
			} while(y < maxY+1);
			if(spiral.get(new Point(x,y)) > input) {
				break;
			}
			maxY = y;
			do {
				x--;
				spiral.computeIfAbsent(new Point(x,y), func);
				if(spiral.get(new Point(x,y)) > input) {
					break;
				}
			} while(x > minX-1);
			if(spiral.get(new Point(x,y)) > input) {
				break;
			}
			minX = x;
			do {
				y--;
				spiral.computeIfAbsent(new Point(x,y), func);
				if(spiral.get(new Point(x,y)) > input) {
					break;
				}
			} while(y > minY-1);
			if(spiral.get(new Point(x,y)) > input) {
				break;
			}
			minY = y;
		}
		System.out.println(spiral.get(new Point(x,y)));
		
		
	}
}


