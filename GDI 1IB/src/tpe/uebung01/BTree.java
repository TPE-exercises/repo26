package tpe.uebung01;

import gdi.MakeItSimple.*;

public class BTree implements BTree_Interface {

	public int m;
	private BTree_Node root;
	private BTree tree = new BTree(1);
	private BTree otherTree = new BTree(1);

	BTree(int ordnung) {
		this.root = null;
		this.m = ordnung;
	}

	@Override
	public boolean insert(Integer o) {
		if (this.contains(o))
			return false;

		if (root == null) {
			BTree_Node node = new BTree_Node(o);
			root = node;
			return true;
		} else
			return rec_insert(o, root, 0);

		// 2. insert
		// 3. burst?

	}

	private boolean rec_insert(Integer o, BTree_Node node, int index) {
		if(o<node.getValue(index)){
			if(node.getNode(index)!=null){
				return rec_insert(o, node.getNode(index), 0);
			}else{
				
			}
		}
		
		
		return false;
	}
	

	@Override
	public boolean insert(String filename) {
		// Schleife -> insert
		return false;
	}

	/**
	 * 
	 */
	private void burst() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean contains(Integer o) {
		if (isEmpty())
			return false;
		return rec_contains(o, root, 0);

	}

	/**
	 * 
	 * @param o
	 * @param node
	 * @param index
	 * @return
	 */
	private boolean rec_contains(Integer o, BTree_Node node, int index) {
		if (o.intValue() == node.getValue(index)) {
			return true;
		} else if (o.intValue() < node.getValue(index)) {
			if (node.getNode(index) != null) {
				return rec_contains(o, node.getNode(index), 0);
			} else
				return false;
		}
		// (o.intValue() > node.getValue(index))
		else {
			if (index < 2 * m) {
				return rec_contains(o, node, ++index);
			} else
				return false;
		}

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Integer getMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getMin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addAll(BTree_Interface otherTree) {
		// TODO Auto-generated method stub

	}

	public BTree clone() {
		return null;

	}

	@Override
	public void printInorder() {
		// TODO Auto-generated method stub

	}

	@Override
	public void printPostorder() {
		// TODO Auto-generated method stub

	}

	@Override
	public void printPreorder() {
		// TODO Auto-generated method stub

	}

	@Override
	public void printLevelorder() {
		// TODO Auto-generated method stub

	}

}
