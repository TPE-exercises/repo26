package de.hsMannheim.informatik.ads.uebung06;

public class TreeNode {
private int value;
private TreeNode right;
private TreeNode left;
	
/**
 * 
 * @param value
 * @param right
 * @param left
 */



	public TreeNode(int value){
		this.value = value;
		this.right = null;
		this.left = null;
	}
	
	public TreeNode getLeft(){
		return left;
	}
	
	public TreeNode getRight(){
		return right;
	}
	
	public int getValue(){
		return value;
	}
	
	public void setLeft(TreeNode n){
		left=n;
	}
	
	public void setRight(TreeNode n){
		right=n;
	}
	
	public void setValue(int n){
		value=n;
	}
}
