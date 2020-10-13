package com.capgemini.linkedlist;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyLinkedList {
	private static final Logger log = LogManager.getLogger(MyLinkedList.class);
	public INode head;
	public INode tail;
	public MyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public void add(INode newNode) {
		if(this.tail == null)
			this.tail = newNode;
		if(this.head == null)
			this.head = newNode;
		else {
			INode tempNode = this.head;
			this.head = newNode;
			this.head.setNext(tempNode);
		}
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
	}	

	public void printMyNodes() {
		StringBuffer myNodes = new StringBuffer("My Nodes: ");
		INode tempNode = head;
		while(tempNode.getNext() != null) {
			myNodes.append(tempNode.getKey());
			if(!tempNode.equals(tail)) myNodes.append("->");
			tempNode = tempNode.getNext();
		}
		myNodes.append(tempNode.getKey());
		log.info(myNodes);
	}

	public void insert(INode myNode, INode newNode) {
		INode tempNode = myNode.getNext();
		myNode.setNext(newNode);
		newNode.setNext(tempNode);
	}
	
	public INode pop() {
		INode tempNode = this.head;
		this.head = head.getNext();
		return tempNode;
	}
}
