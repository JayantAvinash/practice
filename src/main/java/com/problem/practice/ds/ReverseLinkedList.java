package com.problem.practice.ds;

import com.problem.practice.ds.SinglyLinkedList.Node;

public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList l = new SinglyLinkedList();
		for(int i = 1; i < 10; i++) {
			l.insert(i);
		}
		l.print();
		reverseLinkedList(l);
		l.print();
		Node head = recursiveReverse(l.getRoot(), null);
		l.setRoot(head);
		l.print();
	}

	private static void reverseLinkedList(SinglyLinkedList l) {
		Node p,q,r;
		p = l.getRoot();
		q = p.getNext();
		p.setNext(null);
		while(q != null) {
			r = q.getNext();
			q.setNext(p);
			p = q;
			q  = r;
		}
		l.setRoot(p);
	}
	
	private static Node recursiveReverse(Node current, Node prev) {
		Node head = null;
		if(current.getNext() == null) {
			head = current;
			current.setNext(prev);
			return head;
		}
		Node temp = current.getNext();
		current.setNext(prev);
		return recursiveReverse(temp, current);
		
	}
	
	
}
