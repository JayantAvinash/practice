package com.problem.practice.ds;

import com.problem.practice.commons.TreeNode;

public class BinaryTreeToDLL {
	
	static TreeNode head;
	static TreeNode prev;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree();
		tree.setRoot(new TreeNode(10));
		tree.getRoot().setlChild(new TreeNode(12));
		tree.getRoot().setrChild(new TreeNode(15));
		tree.getRoot().getlChild().setlChild(new TreeNode(25));
		tree.getRoot().getlChild().setrChild(new TreeNode(30));
		tree.getRoot().getrChild().setlChild(new TreeNode(36));
		
		/*TreeNode node = convertBtreeToDLL(tree.getRoot());
		print(node);*/
		
		convertBtreeToDllInorder(tree.getRoot());
		print(head);
	}
	
	public static void print(TreeNode node) {
		while(node != null) {
			System.out.print(node.getValue() + " ");
			node = node.getrChild();
		}
		System.out.println();
	}
	
	public static TreeNode convertBtreeToDLL(TreeNode node) {
		TreeNode dll = convertBtreeToDLLUtil(node);
		while(node.getlChild() != null) {
			node = node.getlChild();
		}
		return node;
	}
	
	private static TreeNode convertBtreeToDLLUtil(TreeNode node) {
		if(node == null) {
			return node;
		}
		if(node.getlChild() != null) {
			TreeNode left = convertBtreeToDLL(node.getlChild());
			
			while(left.getrChild() != null) {
				left = left.getrChild();
			}
			left.setrChild(node);
			node.setlChild(left);
		}
		if(node.getrChild() != null) {
			TreeNode right = convertBtreeToDLL(node.getrChild());
			
			while(right.getlChild() != null) {
				right = right.getlChild();
			}
			node.setrChild(right);
			right.setlChild(node);
		}
		return node;
	}
	
	public static void convertBtreeToDllInorder(TreeNode root) {
		if(root == null) {
			return;
		}
		convertBtreeToDllInorder(root.getlChild());
		
		if(prev == null) {
			head = root;
		} else {
			prev.setrChild(root);
			root.setlChild(prev);
		}
		prev = root;
		convertBtreeToDllInorder(root.getrChild());
	}

}
