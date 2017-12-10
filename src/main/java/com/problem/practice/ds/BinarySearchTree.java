package com.problem.practice.ds;

import java.util.Stack;

import com.problem.practice.commons.TreeNode;

public class BinarySearchTree {

	private TreeNode root;
	
	public void recursiveInorder() {
		recursiveInorder(root);
		System.out.println();
	}

	private void recursiveInorder(TreeNode node) {
		if(node != null) {
			recursiveInorder(node.getlChild());
			System.out.print(node.getValue() + " ");
			recursiveInorder(node.getrChild());
		}
	}
	
	public void stackInorder() {
		if(root != null) {
			Stack<TreeNode> s = new Stack<TreeNode>();
			TreeNode temp = root;
			while(temp != null) {
				s.push(temp);
				temp = temp.getlChild();
			}
			while(!s.isEmpty()) {
				temp = s.pop();
				System.out.println(temp.getValue());
				if(temp.getrChild() != null) {
					temp = temp.getrChild();
					while(temp != null) {
						s.push(temp);
						temp = temp.getlChild();
					}
				}
				
			}
		}
	}
	
	public void recursivePreorder() {
		recursivePreorder(root);
		System.out.println();
	}

	private void recursivePreorder(TreeNode node) {
		if(node != null) {
			System.out.print(node.getValue() + " ");
			recursiveInorder(node.getlChild());
			recursiveInorder(node.getrChild());
		}
	}
	
	public void recursivePostorder() {
		recursivePostorder(root);
		System.out.println();
	}

	private void recursivePostorder(TreeNode node) {
		if(node != null) {
			recursiveInorder(node.getlChild());
			recursiveInorder(node.getrChild());
			System.out.print(node.getValue() + " ");
		}
	}
	
	public void insert(int a) {
		if (root != null) {
			TreeNode node = new TreeNode(a);
			insert(node, root);
		} else {
			root = new TreeNode(a);
		}
	}

	private void insert(TreeNode node, TreeNode root2) {
		if(root2 == null) {
			root2 = new TreeNode(node.getValue());
		} else if(node.getValue() >= root2.getValue()) {
			if(root2.getrChild() != null) {
				insert(node, root2.getrChild());
			} else {
				root2.setrChild(node);
			}
		} else {
			if(root2.getlChild() != null) {
				insert(node, root2.getlChild());
			} else {
				root2.setlChild(node);
			}
		}
		
	}
	
	public int size() {
		if(root != null) {
			int count = 0;
			TreeNode temp = root;
			while(temp != null) {
				count++;
				temp = temp.getrChild();
			}
			return count;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		for(int i = 6; i < 15; i++) {
			bst.insert(i);
		}
		for(int i = 5; i >= 0; i--) {
			bst.insert(i);
		}
		bst.recursivePreorder();
		bst.recursivePostorder();
		bst.recursiveInorder();
	}
}
