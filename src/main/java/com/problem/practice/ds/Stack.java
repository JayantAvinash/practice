package com.problem.practice.ds;

import com.problem.practice.commons.TreeNode;

public class Stack {
	
	TreeNode root;
	
	public void push(int value) {
		if(root == null) {
			root = new TreeNode(value);
		} else {
			TreeNode temp = new TreeNode(value);
			temp.setrChild(root);
			root.setlChild(temp);
			root = temp;
		}
	} 
	
	public boolean pop() {
		if(root == null) {
			return false;
		}
		TreeNode temp = root.getrChild();
		if(temp == null) {
			root = null;
		} else {
			temp.setlChild(null);
			root.setrChild(null);
			root = temp;
		}
		return true;
	}
	
	public int peek() {
		if(root != null) {
			return root.getValue();
		}
		return 0;
		
	}
	
	public void print() {
		if(root != null) {
			TreeNode temp = root;
			while(temp != null) {
				System.out.print(temp.getValue() + " ");
				temp = temp.getrChild();
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Stack s = new Stack();
		for(int i = 1; i < 10; i++) {
			s.push(i);
		}
		System.out.println(s.peek());
		s.print();
		s.pop();
		s.print();
		System.out.println(s.peek());
	}

}
