package de.hsMannheim.informatik.ads.uebung05;

interface Queue{
	
	LinkedList enter(int element, LinkedList list);
	LinkedList leave(LinkedList list);
	int front(LinkedList list);
	
	LinkedList emptyQueue();
	boolean isEmpty(LinkedList list);
}
