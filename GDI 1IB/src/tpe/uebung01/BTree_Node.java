package tpe.uebung01;

public class BTree_Node {

	private Integer[] value = new Integer[2 * BTree.m + 1];
	private BTree_Node[] bTreeNode = new BTree_Node[2 * BTree.m + 2];

	/**
	 * 
	 * @param Integer[]
	 *            value
	 * @param BTree_Node[]
	 *            bTreeNode
	 */
	public BTree_Node(Integer[] value, BTree_Node[] bTreeNode) {
		this.value = value;
		this.bTreeNode = bTreeNode;
	}


	/**
	 * 
	 * @param Integer...o[not more than m]
	 */
	public BTree_Node(Integer... o) {
		
		Integer[] value = new Integer[2 * BTree.m + 1];
		BTree_Node[] bTreeNode = new BTree_Node[2 * BTree.m + 2];
		for (int i=0;i<o.length; i++) {
			value[i]=o[i];
		}
		this.value=value;
		this.bTreeNode=bTreeNode;
	}

	/**
	 * 
	 * @param index
	 * @return Integer
	 */
	public Integer getValue(int index) {
		return this.value[index];
	}

	/**
	 * 
	 * @param value
	 * @param index
	 */
	public void setValue(Integer value, int index) {
		this.value[index] = value;
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	public BTree_Node getNode(int index) {
		return this.bTreeNode[index];
	}

	/**
	 * 
	 * @param node
	 * @param index
	 */
	public void setNode(BTree_Node node, int index) {
		this.bTreeNode[index] = node;
	}

	/**
	 * 
	 * @return boolean
	 */
	public boolean isFull() {
		for (int i = 0; i < this.value.length; i++) {
			if (this.value[i] == null)
				return false;
		}
		return true;
	}
	/**
	 * move inclusive index 
	 * @param int index
	 */
	public void moveForward(int index){
		

		for(int i=2*BTree.m;i>index;i--){
			Integer integer; 
			if(this.value[i-1]==null){
				integer = new Integer(0);
			}
			else{
				integer = new Integer(this.value[i-1]);
			}
		value[i]=integer;
		}
		
		
	}

}
