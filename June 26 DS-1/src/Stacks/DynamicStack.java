package Stacks;

public class DynamicStack extends stack {
	
	public DynamicStack(int cap) {
		
		super(cap);
	}
	
	@Override
	public void push (int item) throws Exception{
		
		if(this.data.length ==this.size() ) {
		
			int[] ol = this.data ;
			this.data = new int [2 * this.data.length];
			for(int i =0 ; i< ol.length ; i++) {
				
				this.data[i] = ol[i];
			}
			
		}
		
		super.push(item);
		
		
	}
	
	
}
