package com.wanghao;


public class Composite extends Component {
	
	private Composite composite;
	private Leaf leaf;
	
	public Composite(int number)
	{
		leaf = new Leaf(number);
		if (number != 1) {
			composite = new Composite(number - 1);
		}
		else {
			composite = null;
		}
	}
	
	public int factorial(){
		if (composite != null) {
			return  composite.factorial() * leaf.getNumber();
		} else {
			return  leaf.getNumber();
		}
		
	}

}
