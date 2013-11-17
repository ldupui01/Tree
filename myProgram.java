public class myProgram{

	public String[] arrayStr;
	public int[] arrayInt;
	public int[] rdmArrayInt;
	
	public myProgram(){
		this.arrayStr = new String[] {"Adam", "Bob", "Charles", "Davy", "Eddy", "Fred", "Alan", "Georges"};
		//this.arrayInt = new int[] {50,33,22,45,67,35,52,34,78,51,101,47,87,98,53,54,26,37,56,83,1189,2105,145,84};
		this.arrayInt = new int[] {6,5,9,3,8,11,12};
		this.rdmArrayInt = new int[100];
		
		for (int i=0;i<this.rdmArrayInt.length;i++){
			int z = (int)(Math.random() * 1000);
			this.rdmArrayInt[i] = z;
			//System.out.println(z);
		}
		//System.out.println(this.rdmArrayInt[5]);
	}

}

