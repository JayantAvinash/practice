package com.problem.practice.commons;

public class TreeNode {
	
	private int value;
	private TreeNode lChild;
	private TreeNode rChild;
	
	public TreeNode() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TreeNode(int value) {
		super();
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public TreeNode getlChild() {
		return lChild;
	}
	public void setlChild(TreeNode lChild) {
		this.lChild = lChild;
	}
	public TreeNode getrChild() {
		return rChild;
	}
	public void setrChild(TreeNode rChild) {
		this.rChild = rChild;
	}
}
