//Alex Schwiegeraht
//A BST with a much faster iterator

import java.util.NoSuchElementException;

public class BSTWithFastIter<E extends Comparable<E>> extends BST<E>	{
	
	public java.util.Iterator iterator(){
		return new FastIterator();
	}
	
	private class FastIterator implements java.util.Iterator<E> {
		private java.util.Stack<TreeNode<E>> stack = new java.util.Stack<>();
		private TreeNode<E> current = root;
		private E lastReturned = null;
		
		public FastIterator(){}
		
		@Override
		public boolean hasNext() {
			if(current != null || !(stack.empty()))
				return true;
			else
				return false;
		}
		
		@Override
		public E next() {
			if(!hasNext())
				throw new NoSuchElementException();
			while(current != null){
				stack.push(current);
				current = current.left;
			}
			TreeNode<E> temp = stack.pop();
			
			lastReturned = temp.element;
			current = temp.right;
			return lastReturned;
		}
		
		@Override
		public void remove(){
			if(lastReturned.equals(null))
				throw new IllegalStateException();
			delete(lastReturned);
			lastReturned = null;
		}
		
	}
}
