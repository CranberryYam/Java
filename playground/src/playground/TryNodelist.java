package playground;

public class TryNodelist {

	public static void main(String[] args) {
		int[] values = {3, 5, 7, 9};
		NodeList nodeList = new NodeList(values);
        System.out.println("haha"+nodeList.nodes[0].next.value);
	}

}
class NodeList {
	Node[] nodes;
	
	public NodeList(int[] values) {
		for(int i=0;i<values.length;i++) {
			 int value = values[i];
             Node node = new Node(value, null);
             if(i>0) 
            	    nodes[i-1].next = node;
		}
	}
}

class Node {
	int value;
	Node next;
	
	public Node(int value, Node next) {
		this.value = value;
		this.next = next;
	}
}
