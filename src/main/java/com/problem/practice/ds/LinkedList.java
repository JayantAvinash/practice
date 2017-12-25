package com.problem.practice.ds;

import com.problem.practice.commons.TreeNode;

public class LinkedList {
	
	TreeNode root;
	
	public void add(int a) {
		if(root == null) {
			root = new TreeNode(a);
		} else {
			TreeNode temp = root;
			while(temp.getrChild() != null) {
				temp = temp.getrChild();
			}
			TreeNode temp1 = new TreeNode(a);
			temp.setrChild(temp1);
			temp1.setlChild(temp);
		}
	}
	
	public boolean delete() {
		if(root != null) {
			TreeNode temp = root;
			TreeNode temp1 = null;
			while(temp.getrChild() != null) {
				temp1 = temp;
				temp = temp.getrChild();
			}
			if(temp == root) {
				root = null;
				return true;
			} else {
				temp1.setrChild(null);
				temp.setrChild(null);
				return true;
			}
		}
		return false;
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
		LinkedList l = new LinkedList();
		for(int i = 1; i < 10; i++) {
			l.add(i);
		}
		l.print();
		l.delete();
		l.print();
	}

}
