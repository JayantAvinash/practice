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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lChild == null) ? 0 : lChild.hashCode());
		result = prime * result + ((rChild == null) ? 0 : rChild.hashCode());
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TreeNode other = (TreeNode) obj;
		if (lChild == null) {
			if (other.lChild != null)
				return false;
		} else if (!lChild.equals(other.lChild))
			return false;
		if (rChild == null) {
			if (other.rChild != null)
				return false;
		} else if (!rChild.equals(other.rChild))
			return false;
		if (value != other.value)
			return false;
		return true;
	}
}
