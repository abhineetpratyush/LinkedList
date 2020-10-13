package com.capgemini.linkedlist;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import jdk.internal.org.jline.utils.Log;

public class MyLinkedListTest {
	private static final Logger log = LogManager.getLogger(MyLinkedListTest.class);
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

	@Test
	public void given3Numbers_WhenLastDeleted_ShouldPassLinkedListTest() {
		MyNode<Integer> myFirstNode = new MyNode<Integer>(56);
		MyNode<Integer> mySecondNode = new MyNode<Integer>(30);
		MyNode<Integer> myThirdNode = new MyNode<Integer>(70);
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.add(myFirstNode);
		myLinkedList.append(myThirdNode);
		myLinkedList.insert(myFirstNode, mySecondNode);
		myLinkedList.printMyNodes();
		Assert.assertEquals(myThirdNode, myLinkedList.popLast());
		myLinkedList.printMyNodes();
	}

	@Test
	public void given3Numbers_WhenFindNode30_ShouldReturn30() {
		MyNode<Integer> myFirstNode = new MyNode<Integer>(56);
		MyNode<Integer> mySecondNode = new MyNode<Integer>(30);
		MyNode<Integer> myThirdNode = new MyNode<Integer>(70);
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.add(myFirstNode);
		myLinkedList.append(myThirdNode);
		myLinkedList.insert(myFirstNode, mySecondNode);
		Assert.assertEquals(mySecondNode, myLinkedList.findNode(mySecondNode));
	}

	@Test
	public void WhenFindKey30_Append40InFrontOfIt_ShouldPassLinkedListTest() {
		MyNode<Integer> myFirstNode = new MyNode<Integer>(56);
		MyNode<Integer> mySecondNode = new MyNode<Integer>(30);
		MyNode<Integer> myThirdNode = new MyNode<Integer>(70);
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.add(myFirstNode);
		myLinkedList.append(myThirdNode);
		myLinkedList.insert(myFirstNode, mySecondNode);
		MyNode<Integer> myNodeToAdd = new MyNode<Integer>(40);
		myLinkedList.insertWhenFound(30, myNodeToAdd);
		boolean result = myLinkedList.head.equals(myFirstNode) && myLinkedList.head.getNext().equals(mySecondNode) && myLinkedList.head.getNext().getNext().equals(myNodeToAdd) && myLinkedList.tail.equals(myThirdNode);
		Assert.assertTrue(result);
		myLinkedList.printMyNodes();
	}

	@Test
	public void WhenFindKey40_DeleteIt_ShouldPassLinkedListTest() {
		MyNode<Integer> myFirstNode = new MyNode<Integer>(56);
		MyNode<Integer> mySecondNode = new MyNode<Integer>(30);
		MyNode<Integer> myThirdNode = new MyNode<Integer>(70);
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.add(myFirstNode);
		myLinkedList.append(myThirdNode);
		myLinkedList.insert(myFirstNode, mySecondNode);
		MyNode<Integer> myNodeToAdd = new MyNode<Integer>(40);
		myLinkedList.insertWhenFound(30, myNodeToAdd);
		myLinkedList.printMyNodes();
		Assert.assertEquals(myNodeToAdd, myLinkedList.deleteNodeWithKey(40));
		Assert.assertEquals(3, myLinkedList.sizeOfLinkedList());
		myLinkedList.printMyNodes();
		log.info("The size of the linked list is : " + myLinkedList.sizeOfLinkedList());
	}
}

