package com.capgemini.linkedlist;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SortedLinkedList {
	private static final Logger log = LogManager.getLogger(SortedLinkedList.class);
	public INode head;
	public INode tail;
	public SortedLinkedList() {
		this.head = null;
		this.tail = null;
	}	

	public void append(INode newNode) {
		if(this.head == null)
			this.head = newNode;
		if(this.tail == null)
			this.tail = newNode;
		else {
			this.tail.setNext(newNode);
			this.tail = newNode;
		}
		sort();
	}

	public void printMyNodes() {
		StringBuffer myNodes = new StringBuffer("My Nodes: ");
		INode tempNode = head;
		while(tempNode.getNext() != null) {
			myNodes.append(tempNode.getKey());
			if(!tempNode.equals(tail)) 
				myNodes.append("->");
			tempNode = tempNode.getNext();
		}
		myNodes.append(tempNode.getKey());
		log.info(myNodes);
	}
	
	public void sort() {
		boolean wasChanged;
		do {
			INode current = head;
			INode previous = null;
			INode next = head.getNext();
			wasChanged = false;
			while ( next != null ) {
				if ((Integer)current.getKey() > (Integer)next.getKey()) {
					wasChanged = true;
					if ( previous != null ) {
						INode sig = next.getNext();
						previous.setNext(next);
						next.setNext(current);
						current.setNext(sig);
					} else {
						INode sig = next.getNext();
						head = next;
						next.setNext(current);
						current.setNext(sig);
					}
					previous = next;
					next = current.getNext();
				} else { 
					previous = current;
					current = next;
					next = next.getNext();
				}
			} 
		} while( wasChanged );
	}
}
