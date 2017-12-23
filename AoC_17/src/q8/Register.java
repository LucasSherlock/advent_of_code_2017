package q8;

public class Register {
	protected String _name;
	protected int _signal;
	
	public Register(String name) {
		_name = name;
		_signal = 0;
	}
	
	
	public boolean equals(Register r) {
		if(r._name == this._name) {
			return true;
		}
		return false;
	}
	
	public String  getName() {
		return this._name;
	} 	
	
}
