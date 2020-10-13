package com.capgemini.linkedlist;

public class MyNode<K> {
	private K key;
	private MyNode<K> next;
	public MyNode(K key) {
		this.key = key;
		this.next = null;
	}
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public MyNode<K> getNext() {
		return next;
	}
	public void setNext(MyNode<K> next) {
		this.next = next;
	}
}
