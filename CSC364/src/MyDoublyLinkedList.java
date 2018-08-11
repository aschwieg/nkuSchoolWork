//Alex Schwiegeraht
//Description: A linked list that has links to both the next element and the previous element and has a dummy head node.

import java.util.*;

public class MyDoublyLinkedList<E> extends MyAbstractSequentialList<E> implements Cloneable {
	private Node<E> head = new Node<E>(null);

	/** Create a default list */
	public MyDoublyLinkedList() {
		head.next = head;
		head.previous = head;
	}

	//Node Object that has a next and a previous node
	private static class Node<E> {
		E element;
		Node<E> previous;
		Node<E> next;

		public Node(E element) {
			this.element = element;
		}
	}

	//Converts list to string
	public String toString() {
		StringBuilder result = new StringBuilder("[");

		Node<E> current = head.next;
		for (int i = 0; i < size; i++) {
			result.append(current.element);
			current = current.next;
			if (current != head) {
				result.append(", "); // Separate two elements with a comma
			}
		}
		result.append("]"); // Insert the closing ] in the string

		return result.toString();
	}

	//finds a node at a given index
	private Node<E> getNode(int index) {
		Node<E> current = head;
		if (index < size / 2)
			for (int i = -1; i < index; i++)
				current = current.next;
		else
			for (int i = size; i > index; i--)
				current = current.previous; 
		return current;
	}

	//Adds node at index and element given
	public void add(int index, E e) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		Node<E> prev = getNode(index - 1);
		Node<E> next = prev.next;
		Node<E> newNode = new Node<E>(e);
		newNode.previous = prev;
		newNode.next = next;
		prev.next = newNode;
		next.previous = newNode;

		size++;
	}

	public void clear() {

		head.next = head;
		head.previous = head;
		size = 0;

	}

	public boolean contains(E o) {

		for (Node<E> current = head.next; current != head; current = current.next) {
			E e = current.element;
			if (o == null ? e == null : o.equals(e))
				return true;
		}
		return false;
	}

	public E get(int index) {
		if (index < 0 || index > size-1) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		else{
			return getNode(index).element;
		}	
	}

	public int indexOf(E e) {

		for(int i = 0; i < size; i++){		
			if(e==null ? get(i)==null : e.equals(get(i))){
				return i;
			}
		}
		return -1;
	}

	public int lastIndexOf(E e) {

		int lastIndex = -1;

		for(int i = 0; i < size; i++){
			if(e==null ? get(i)==null : e.equals(get(i))){
				lastIndex = i;
			}
		}
		return lastIndex;
	}

	//Removes the element at given index
	public E remove(int index) {
		if (index < 0 || index > size-1) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		else if(index == 0){
			return removeFirst();
		}
		else if(index == size - 1){
			return removeLast();
		}
		else{
			Node<E> temp = getNode(index);

			temp.previous.next = temp.next;
			temp.next.previous = temp.previous;

			size--;

			return temp.element;
		}
	}

	//Changes the node at the given index to the new element
	public Object set(int index, E e) {

		if (index < 0 || index > size-1) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}

		Node<E> temp = getNode(index);

		temp.element = e;

		return temp;
	}

	public E getFirst() {
		return get(0);
	}

	public E getLast() {
		return get(size-1);
	}

	public void addFirst(E e) {
		add(0, e);
	}

	public void addLast(E e) {
		add(size, e);
	}

	public E removeFirst() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		else {
			Node<E> temp = head.next;

			head.next = temp.next;
			temp.next.previous = head;

			size--;
			return temp.element;
		}
	}

	public E removeLast() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		else{
			Node<E> temp = getNode(size-1);

			head.previous = temp.previous;
			temp.previous.next = head;

			size--;
			return temp.element;
		}
	}

	//Creates a clone of the list with a new head
	public Object clone(){
		try{
			@SuppressWarnings("unchecked")
			MyDoublyLinkedList<E> newClone = (MyDoublyLinkedList<E>) super.clone();
			Node<E> headClone = new Node<E>(null);
			headClone.next = headClone;
			headClone.previous = headClone;
			newClone.head = headClone;
			newClone.size = 0;
			ListIterator<E> listIter = this.listIterator(0);
			for(int i = 0; i < size; i++){
				E nodeClone = listIter.next();
				newClone.add(i, nodeClone);
			}
			return newClone;

		}
		catch(CloneNotSupportedException e){
			throw new RuntimeException();
		}
	}

	//Checks if two lists are the same
	@SuppressWarnings("unchecked")
	public boolean equals(Object other){
		if(this == other){
			return true;
		}
		else if(((MyList<E>) other).size() != this.size()){
			return false;
		}
		else{
			ListIterator<E> thisIter = this.listIterator(0);
			ListIterator<E> otherIter = ((MyDoublyLinkedList<E>) other).listIterator(0);

			while(thisIter.hasNext()){
				E thisE = thisIter.next();
				E otherE = otherIter.next();
				if (!(otherE == null ? thisE == null : otherE.equals(thisE)))
					return false;

			}
			return true;
		}
	}

	//Calls the MyDoublyLinkedListIterator
	public ListIterator<E> listIterator(int index) {
		return new MyDoublyLinkedListIterator(index);
	}

	//Three states the iterator can be in
	private static enum ITERATOR_STATE  
	{ CANNOT_REMOVE, CAN_REMOVE_PREV, CAN_REMOVE_CURRENT };


	private class MyDoublyLinkedListIterator implements ListIterator<E> {
		private Node<E> current; // node that holds the next element in the iteration
		private int nextIndex;   // index of current
		ITERATOR_STATE iterState = ITERATOR_STATE.CANNOT_REMOVE;

		private MyDoublyLinkedListIterator(int index) {
			if (index < 0 || index > size)
				throw new IndexOutOfBoundsException("iterator index out of bounds");
			current = getNode(index);
			nextIndex = index;
		}

		public void add(E e) {
			Node<E> newNode = new Node<E>(e);
			newNode.next = current;
			newNode.previous = current.previous;
			current.previous.next = newNode;
			current.previous = newNode;
			size++;
			iterState = ITERATOR_STATE.CANNOT_REMOVE;
		}

		public boolean hasNext() {
			return (nextIndex() < size);
		}

		public boolean hasPrevious() {
			return (previousIndex() >= 0);
		}

		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();
			E returnVal = current.element;
			current = current.next;
			nextIndex++;
			iterState = ITERATOR_STATE.CAN_REMOVE_PREV;
			return returnVal;
		}

		public int nextIndex() {
			return nextIndex;
		}

		public E previous() {
			if(!hasPrevious()){
				throw new NoSuchElementException();
			}		
			E returnVal = current.previous.element;
			current = current.previous;
			nextIndex--;
			iterState = ITERATOR_STATE.CAN_REMOVE_CURRENT;
			return returnVal;
		}

		public int previousIndex() {
			return nextIndex-1;
		}

		public void remove() {
			switch (iterState) {
			case CANNOT_REMOVE:
				throw new IllegalStateException();
			case CAN_REMOVE_PREV: 

				current.previous.previous.next = current;
				current.previous = current.previous.previous;

				size--;
				iterState = ITERATOR_STATE.CANNOT_REMOVE;
				break;
			case CAN_REMOVE_CURRENT:

				current.previous.next = current.next;
				current.next.previous = current.previous;

				size--;
				iterState = ITERATOR_STATE.CANNOT_REMOVE;
				break;
			}

		}

		public void set(E e) {
			switch (iterState) {
			case CANNOT_REMOVE:
				throw new IllegalStateException();
			case CAN_REMOVE_PREV:

				current.previous.element = e;

				iterState = ITERATOR_STATE.CANNOT_REMOVE;
				break;
			case CAN_REMOVE_CURRENT:

				current.element = e;

				iterState = ITERATOR_STATE.CANNOT_REMOVE;
				break;
			}
		}
	}
}