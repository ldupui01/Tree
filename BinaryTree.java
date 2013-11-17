public class BinaryTree{
	
	private IntegerTreeNode rootInt;
	
	public BinaryTree(){
		rootInt = null;
	}
	
	public void getMax(){
		IntegerTreeNode current = rootInt;
		IntegerTreeNode fromLast = rootInt;
		while (current != null){
			//System.out.print(" " + current.getValue());
			fromLast = current;
			current = current.getRight();
		}
		System.out.println("Max is : " + fromLast.getValue());
	}
	
	public void getMin(){
		IntegerTreeNode current = rootInt;
		IntegerTreeNode fromLast = rootInt;
		while (current != null){
			//System.out.print(" " + current.getValue());
			fromLast = current;
			current = current.getLeft();
		}
		System.out.println("Min is : " + fromLast.getValue());
	}
	
	public void contains(){
		// A loop to check the 100 first number in the tree
		for (int i=0;i<100;i++){
			IntegerTreeNode checkNode = rootInt;
			if(checkNode.getValue() == i){
				System.out.println (i + " is in the list (as head)");
			}else {
				if (checkNode.checkNext()){
					checkNode.contains(i);
					if(checkNode.contains(i)){
						System.out.println (i + " is in the list");
					}	
				}else{
					
				}
			}
			/*IntegerTreeNode checkNode = rootInt;
			if(checkNode.getValue() == i){
				System.out.println (i + " is in the list (as head)");
			}else {
				while (checkNode.checkNext()){
					if (i>checkNode.getValue()){
						if (checkNode.checkRight()){
							if (checkNode.getRight().getValue()==i){
								System.out.println (i + " is " + checkNode.getRight().getIncrement() + " in the list (right)");
								break;
							}else{
								checkNode = checkNode.getRight();
							}
						}else{
							System.out.println (i + " is not in the list (right)");
							break;
						}	
					}else if (i<checkNode.getValue()){
						if (checkNode.checkLeft()){
							if (checkNode.getLeft().getValue()==i){
								System.out.println (i + " is " + checkNode.getLeft().getIncrement() + " time in the list (left)");
								break;
							}else{
								checkNode = checkNode.getLeft();
							}
						}else{
							System.out.println (i + " is not in the list (left)");
							break;
						}
					}else{
						System.out.println (i + " blablabla");
						break;
					}
				}
			}*/
		} //end For loop
	}
	
	public void printList(){
		IntegerTreeNode newNode = rootInt;
		String printOut = "";
		if (newNode != null){
			printOut = newNode.toString();
		}
		System.out.println(printOut);
	}
	
	public void depth(){
		IntegerTreeNode newNode = rootInt;
		int printOut = -1;
		if (newNode != null){
			printOut = newNode.depth(0);
		}
		System.out.println("the depth of the tree is : " + printOut);
	}
	
	
	public void launcher(){
		myProgram newData = new myProgram();
		int arrayLength = newData.rdmArrayInt.length;
		
		//** Create the tree
		for (int i=0;i<arrayLength;i++){
			IntegerTreeNode newNode = new IntegerTreeNode(newData.rdmArrayInt[i]);
			if (rootInt == null){
				rootInt = newNode;
			}else{
				rootInt.add(newData.rdmArrayInt[i]);
			}
		}	
		this.getMax();
		this.getMin();
		//this.contains();
		this.depth();
		this.printList();
	}
	
	public static void main(String[] args){
		BinaryTree bt = new BinaryTree();
		bt.launcher();
	}
}