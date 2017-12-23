package q7;

import java.util.ArrayList;

public class Node {
	private String _name;
	private int _weight;
	private Node _parent = null;
	private ArrayList<Node> _children = new ArrayList<Node>();
	private int _totalWeight = -1;
	
	public Node(int weight, String name) {
		this._weight = weight;
		this._totalWeight = weight;
		this._name = name;
	}
	
	public void addChild(Node child) {
		this._children.add(child);
	}
	
	public String getName() {
		return this._name;
	}
	
	public void setParent(Node parent) {
		this._parent = parent;
		parent.addChild(this);
	}
	
	public int getWeight() {
		return this._weight;
	}
	
	public Node getParent() {
		return this._parent;
	}
	
	public boolean hasParent() {
		return _parent != null;
	}
	
	public boolean hasChildren() {
		return _children.size() > 0;
	}
	
	public int getTotalWeight() {
		if(!this.hasChildren()) {
			return this._weight;
		}

		int weight = this._weight;
		for(Node child : this._children) {
			weight += child.getTotalWeight();
		}
		this._totalWeight = weight;
		return weight;
	}
	
	public int findCommonWeight() {
		ArrayList<Integer> weights = new ArrayList<Integer>();
		for(Node child : this._children) {
			weights.add(child._totalWeight);
		}
		int weight = weights.get(0);
		for(int i = 1; i < weights.size(); i++) {
			if(weights.get(i) == weight) {
				return weight;
			}
		}
		return weights.get(1);
	}
	
	public boolean isBalanced() {
		if(!this.hasChildren()) {
			return true;
		}

		int weight = this.findCommonWeight();
		for (Node child : this._children) {
			if(child._totalWeight != weight) {
				if(child.isBalanced()) {
					this.print();
					child.print();
					System.out.println("Answer: " + (child._weight + (weight-child._totalWeight)));
				}
				return false;
			} 
		}
		return true;

	}
	
	public void print() {
		System.out.println("Parent: " + this.getName() + " = " + this._weight);
		for(Node child : this._children) {
			System.out.println("child: " + child.getName() + " = " + child._totalWeight);
		}
		System.out.println();
	}


}
