public class IntegerTreeNode{
	private int value;
	private int increment;
	private IntegerTreeNode left;
	private IntegerTreeNode right;
	
	public IntegerTreeNode(int myValue){
		this.value = myValue;
		this.left = null;
		this.right = null;
		this.increment = 1;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public int getIncrement(){
		return this.increment;
	}
	
	public void setValue(int myInt){
		this.value = myInt;
	}
	
	public void setIncrement(int myInt){
		this.increment = myInt;
	}
	
	
	public boolean checkRight(){
		if(this.getRight() == null){
			return false;
		}
		return true;
	}
	
	public boolean checkLeft(){
		if(this.getLeft() == null){
			return false;
		}
		return true;
	}
	
	public boolean checkNext(){
		if(this.getRight() == null && this.getLeft() == null){
			return false;
		}
		return true;
	}
	
	public IntegerTreeNode getLeft(){
		return this.left;
	}
	
	public IntegerTreeNode getRight(){
		return this.right;
	}
	
	public void setLeft(IntegerTreeNode myLeft){
		this.left = myLeft;
	}
	
	public void setRight(IntegerTreeNode myRight){
		this.right = myRight;
	}
	
	public void add(int myNumber){
		IntegerTreeNode myNode = new IntegerTreeNode(myNumber);
		if (myNumber > this.value) {
			//System.out.println(myNumber + " right");
			if (this.right == null){
				this.setRight(myNode);
			}else {
				if (this.right.value <= myNumber){
					this.right.add(myNumber);
				}else{
					myNode.setRight(this.right);
					this.right = myNode;
				}
			}
		}else if (myNumber < this.value) {
			//System.out.println(myNumber + " left");
			if (this.left == null){
				this.setLeft(myNode);
			}else {
				if (this.left.value >= myNumber){
					this.left.add(myNumber);
				}else{
					myNode.setLeft(this.left);
					this.left = myNode;
				}
			}
		}else if (myNumber == this.value){
			//System.out.println(myNumber + " +1");
			this.setIncrement(this.increment + 1);
		}
		
		
	}
	
	public boolean contains(int myInt){
		if (myInt == this.value){
			return true;
		}else if (myInt > this.value){
			if (this.right == null){
				//System.out.println(myInt + "Right False");
				return false;
			}else{
				//System.out.println(myInt + "Right Loop");
				return this.right.contains(myInt);
			}
		}else {
			if (this.left == null){
				//System.out.println(myInt + "Left False");
				return false;
			}else{
				//System.out.println(myInt + "Left Loop");
				return this.left.contains(myInt);
			}
		}
	}
	
	public String toString(){
		String g="", d="";
		if (this.checkLeft()){
			g = this.getLeft().toString();
		}
		if (this.checkRight()){
			d = this.getRight().toString();
		}
		String result = this.getValue() + "L[" + g + "]" + "R[" + d + "]";
		
		return result;
	}
	
	public int depth(int myDeep){
		int result = myDeep;
		if(this.checkLeft() && this.checkRight()){
			myDeep++;
			if(this.getLeft().depth(myDeep) > this.getRight().depth(myDeep) ){
				return this.getLeft().depth(myDeep);
			}else{
				return this.getRight().depth(myDeep);
			}	
		}else if (this.checkLeft()){
			myDeep++;
			return this.getLeft().depth(myDeep);
			//System.out.println(this.getValue() + " L- " + myDeep);
		}else if (this.checkRight()){
			myDeep++;
			return this.getRight().depth(myDeep);
			//System.out.println(this.getValue() + " R- " + myDeep);
		}
		/*if (result < myDeep){
			result = myDeep;
		}*/
		return result;
	}
	
	
}