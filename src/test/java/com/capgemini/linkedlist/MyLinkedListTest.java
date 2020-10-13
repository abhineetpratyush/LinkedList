package com.capgemini.linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class MyLinkedListTest {
	@Test
	public void given3Numbers_WhenAddedToLinkedList_ShouldBeAddedToTop() {
		MyNode<Integer> myFirstNode = new MyNode<Integer>(70);
		MyNode<Integer> mySecondNode = new MyNode<Integer>(30);
		MyNode<Integer> myThirdNode = new MyNode<Integer>(56);
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.add(myFirstNode);
		myLinkedList.add(mySecondNode);
		myLinkedList.add(myThirdNode);
		myLinkedList.printMyNodes();
		boolean result = myLinkedList.head.equals(myThirdNode) && myLinkedList.head.getNext().equals(mySecondNode) && myLinkedList.tail.equals(myFirstNode);
		Assert.assertTrue(result);
	}
	
	@Test
	public void given3Numbers_WhenAddedToLinkedList_ShouldBeAddedToEnd() {
		MyNode<Integer> myFirstNode = new MyNode<Integer>(56);
		MyNode<Integer> mySecondNode = new MyNode<Integer>(30);
		MyNode<Integer> myThirdNode = new MyNode<Integer>(70);
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.append(myFirstNode);
		myLinkedList.append(mySecondNode);
		myLinkedList.append(myThirdNode);
		myLinkedList.printMyNodes();
		boolean result = myLinkedList.head.equals(myFirstNode) && myLinkedList.head.getNext().equals(mySecondNode) && myLinkedList.tail.equals(myThirdNode);
		Assert.assertTrue(result);
	}
	
	@Test
	public void given3Numbers_WhenInsertSecondInBetween_ShouldPassLinkedListTest() {
		MyNode<Integer> myFirstNode = new MyNode<Integer>(56);
		MyNode<Integer> mySecondNode = new MyNode<Integer>(30);
		MyNode<Integer> myThirdNode = new MyNode<Integer>(70);
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.add(myFirstNode);
		myLinkedList.append(myThirdNode);
		myLinkedList.insert(myFirstNode, mySecondNode);
		myLinkedList.printMyNodes();
		boolean result = myLinkedList.head.equals(myFirstNode) && myLinkedList.head.getNext().equals(mySecondNode) && myLinkedList.tail.equals(myThirdNode);
		Assert.assertTrue(result);
	}
	
	@Test
	public void given3Numbers_WhenFirstDeleted_ShouldPassLinkedListTest() {
		MyNode<Integer> myFirstNode = new MyNode<Integer>(56);
		MyNode<Integer> mySecondNode = new MyNode<Integer>(30);
		MyNode<Integer> myThirdNode = new MyNode<Integer>(70);
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.add(myFirstNode);
		myLinkedList.append(myThirdNode);
		myLinkedList.insert(myFirstNode, mySecondNode);
		myLinkedList.printMyNodes();
		Assert.assertEquals(myFirstNode, myLinkedList.pop());
		myLinkedList.printMyNodes();
	}
}
