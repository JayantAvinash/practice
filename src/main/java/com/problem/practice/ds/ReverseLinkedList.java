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
	
}
