
public class DoubleLinkedList implements IList{
	private Node head;
	private Node tail;
	private int size;
	int maxPriority = 0;
	Patient patient = null;
	
	public DoubleLinkedList(){
		head = null;
		tail = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public Node getNode(int pos){
		Node n = null;
		for (int i = 1; i <= pos; i++){
			if(i==1){
				n = this.head;				
			}else{
				n = n.getNext();
			}
		}
		return n;
	}
	
	
    public void add(Object data, int priority) {        
        Node tmp = new Node(data, null, tail, priority);
        if(head == null) {
        	head = tmp;
        	}
        if(tail != null) {
        	tail.setNext(tmp); 
        	tmp.setPrevious(tail); // should i include this line?
        
        	}
        tail = tmp;
        
        size++;
    }

	
	public void remove(int pos){  
		if(pos == 1 && size <= 1){  // remove first making the list empty			
			Node head = getNode(1);
			this.head = null;
			head = null;
		}else if(pos == 1 ){  // remove first
			Node head = getNode(1);
			this.head = head.getNext();
			this.head.setPrevious(null);						
		}else if(pos == size && size >1){ // remove last
			Node tail = getNode(pos);
			this.tail = tail.getPrevious();
			this.tail.setNext(null);			
		}else{ // remove middle
			Node current = getNode(pos);
			Node previous = getNode(pos-1);
			Node next = getNode(pos+1);
			previous.setNext(current.getNext());
			next.setPrevious(current.getPrevious());			
		}
		size -=1; 
	}
	
//	public String getNodeToString(int i) {  // think i can delete this one after
//		
//		patient = (Patient) this.getNode(i).getData();
//		return patient.getFirstName() + ", " + patient.getLastName() +  ", Node number:" + String.valueOf(i);	
//	}
	
	
	public String toString(){
		String output = "";
		if(head != null){
			Node n = head;
			while (n != null){
				Patient patient = (Patient) n.getData();  // getting the patient associated with the Node
				output += patient.getFirstName() + " " + patient.getLastName() + "\n";  // obtaining patient's details
				// output += "***" + n.getData().toString() + "***";
				// put stuff to do in here				
				n = n.getNext();
			}
		}
		return output;		
	}
	
    public String iterateBackward(){        
        System.out.println("iterating backword..");
        String output = "";
        if(tail != null){
        	Node n = tail;
            while(n != null){
            	
				Patient patient = (Patient) n.getData();  // getting the patient associated with the Node
				output += patient.getFirstName() + " " + patient.getLastName() + "\n";  // obtaining patient's details
				
            	//System.out.println("step2");
            	//output += "***" + n.getData().toString() + "***";
                n = n.getPrevious();
            }        
        }
        return output;
   }
    
    
//	public Node getHighestPriorityNode(){ // this is the original one
//		Node n = null;
//		int highestPriority = 0 ;
//		int pos = 0;
//		
//		for (int i = 1; i <= size; i++){
//			n = getNode(i);
//			if(n.getPriority() > highestPriority){
//				highestPriority = n.getPriority();
//				pos = i;
//			}
//		}
//		System.out.println(pos);		
//		n = getNode(pos);	
//		return n;
//	}
	
	
	public int getHighestPriorityPosition(){ // altered to return the position
		Node n = null;
		int highestPriority = 0 ;
		int pos = 0;
		
		for (int i = 1; i <= size; i++){
			n = getNode(i);
			if(n.getPriority() > highestPriority){
				highestPriority = n.getPriority();
				pos = i;
			}
		}
		// System.out.println(pos);
		return pos;
	}
	
//	public void nextPatientToDoctor(){		
//		Patient patient = (Patient) this.getHighestPriorityNode().getData();  // getting the patient assiocated with the Node
//		System.out.println("The doctor will now see " + patient.getFirstName() + " " + patient.getLastName() + "\n");  // obtaing patient's details
//		System.out.println("Patient: " + patient.getFirstName() + " " + patient.getLastName() + ", has been removed from the list \n");
//		
//	}
	
	
    

	
}
