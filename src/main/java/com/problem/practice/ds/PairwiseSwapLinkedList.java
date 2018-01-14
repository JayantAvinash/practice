package com.problem.practice.ds;

import com.problem.practice.ds.SinglyLinkedList.Node;

public class PairwiseSwapLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList l = new SinglyLinkedList();
		for(int i = 1; i < 9; i++) {
			l.insert(i);
		}
		l.print();
		pairwiseSwapValue(l.getRoot());
		l.print();
		pairwiseSwapValueRecursive(l.getRoot());
		l.print();
		Node temp = pairwiseSwapNode(l.getRoot());
		l.setRoot(temp);
		l.print();
		pairwiseSwapNodeRecursive(l);
		l.print();
	}
	
	public static void pairwiseSwapValue(Node node) {
		while (node != null && node.getNext() != null) {
			int val = node.getValue();
			node.setValue(node.getNext().getValue());
			node.getNext().setValue(val);
			node = node.getNext().getNext();
		}
	}
	
	public static void pairwiseSwapValueRecursive(Node node) {
		if(node != null && node.getNext() != null) {
			int val = node.getValue();
			node.setValue(node.getNext().getValue());
			node.getNext().setValue(val);
			pairwiseSwapValue(node.getNext().getNext());
		}
	}
	
	public static Node pairwiseSwapNode(Node node) {
		Node temp1 = node.getNext();
		Node prev = null;
		while(node != null && node.getNext() != null) {
			Node temp = node.getNext().getNext();
			node.getNext().setNext(node);
			if (prev != null) {
				prev.setNext(node.getNext());
			}
			node.setNext(temp);
			prev = node;
			node = temp;
			
		}
		return temp1;
	}
	
	public static void pairwiseSwapNodeRecursive(SinglyLinkedList l) {
		Node temp = l.getRoot().getNext();
		pairwiseSwapNodeRecursive(l.getRoot(), null);
		l.setRoot(temp);
	}
	
	private static void pairwiseSwapNodeRecursive(Node node, Node prev) {
		if(node != null && node.getNext() != null) {
			Node temp = node.getNext().getNext();
			node.getNext().setNext(node);
			
			if(prev != null) {
				prev.setNext(node.getNext());
			}
			node.setNext(temp);
			pairwiseSwapNodeRecursive(temp, node);
		}
	}

}
