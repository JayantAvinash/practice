package com.problem.practice.ds;

import com.problem.practice.commons.TreeNode;

public class SinglyLinkedList {
	
	private Node root;
	
	public void insert(int a) {
		Node newNode = new Node();
		newNode.setValue(a);
		if(root == null) {
			/*root = new Node();
			root.setValue(a);*/
			root = newNode;
		} else {
			Node temp = root;
			while(temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(newNode);
		}
	}
	
	public void print() {
		if(root != null) {
			Node temp = root;
			while(temp != null) {
				System.out.print(temp.getValue() + " ");
				temp = temp.getNext();
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 class Node {
		int value;
		Node next;
		/**
		 * @return the value
		 */
		public int getValue() {
			return value;
		}
		/**
		 * @param value the value to set
		 */
		public void setValue(int value) {
			this.value = value;
		}
		/**
		 * @return the next
		 */
		public Node getNext() {
			return next;
		}
		/**
		 * @param next the next to set
		 */
		public void setNext(Node next) {
			this.next = next;
		}
		
	}

	/**
	 * @return the root
	 */
	public Node getRoot() {
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(Node root) {
		this.root = root;
	}

}
