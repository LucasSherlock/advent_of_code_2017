package q7;

import java.util.ArrayList;
import java.util.HashMap;

public class Q7Main {

	private static ArrayList<String> input = q1.Main.readFile("Q7_Input.txt");
	private static HashMap<String, Node> nodes = new HashMap<String, Node>();
	public static void main(String[] args) {
		populateNodes();
		//printMap();
		String rootName = getRoot(input.get(0).split(" ")[0]);
		System.out.println(rootName);
		nodes.get(rootName).getTotalWeight();
		nodes.get(rootName).isBalanced();
		
	}
	

	
	private static String getRoot(String key) {
		if(!nodes.get(key).hasParent()) {
			return key;
		}
		return getRoot(nodes.get(key).getParent().getName());
	}
	
	private static void populateNodes() throws NumberFormatException {
		for(String s : input) {
			String[] line = s.split(" ");
			nodes.put(line[0], new Node(Integer.parseInt(line[1].substring(1, line[1].length()-1)), line[0]));
		}
		
		for(String s : input) {
			String[] line = s.split(" ");
			if(line.length > 2) {
				for(int i = 3; i < line.length-1; i++) {
					nodes.get(line[i].substring(0, line[i].length()-1)).setParent(nodes.get(line[0]));
				}
				nodes.get(line[line.length-1]).setParent(nodes.get(line[0]));
			}
		}
	}
	
	public static void printMap() {
		for(String s : input) {
			String[] line = s.split(" ");
			nodes.get(line[0]).print();
		}
	}

}
