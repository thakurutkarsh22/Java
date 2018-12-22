package Queue;

public class DynamicQueue extends Queue{
	
	
	public DynamicQueue(int cap) {
		
		super(cap);
	}

	
	@Override 
	public void enqueue(int item) throws Exception {
		
		if (this.data.length == this.size) {
			
			int oa[] = this.data;
			int na[] = new int [2*oa.length];
			
			for (int i =0 ; i < this.size ; i ++) {
				
				int idx = (this.front+i) %oa.length ;
				na[i] = oa[idx];
				
			}
			
			
			this.data =na ;
			this.front=0;
		}
		super.enqueue(item);
		
		
	}
	
}
