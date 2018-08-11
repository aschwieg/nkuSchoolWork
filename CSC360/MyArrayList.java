public class MyArrayList<E> extends MyAbstractList<E> {
  public static final int INITIAL_CAPACITY = 16;
  private E[] data = (E[])new Object[INITIAL_CAPACITY];

  /** Create a default list */
  public MyArrayList() {
 }

  /** Create a list from an array of objects */
  public MyArrayList(E[] objects) {
	//super(objects);  // Warning: don’t use super(objects)! Can you see why?
    for (int i = 0; i < objects.length; i++)
      add(objects[i]);
  }

  @Override /** Add a new element at the specified index */
  public void add(int index, E e) {
    if (index < 0 || index > size) // This is the proper check.
      throw new IndexOutOfBoundsException
        ("Index: " + index + ", Size: " + size);
    
    ensureCapacity();

    // Elements at, or to the right of, the specified index
    // get shifted one index to the right.
    for (int i = size - 1; i >= index; i--)
      data[i + 1] = data[i];

    // Insert new element to data[index]
    data[index] = e;

    // Increase size by 1
    size++;
  }

  /** Create a new larger array, double the current size + 1 */
  private void ensureCapacity() {
    if (size >= data.length) {
      E[] newData = (E[])(new Object[size * 2 + 1]);
      System.arraycopy(data, 0, newData, 0, size);
      data = newData;
    }
  }

  @Override /** Clear the list */
  public void clear() {
    data = (E[])new Object[INITIAL_CAPACITY];
    size = 0;
  }

  @Override /** Return true if this list contains the element */
  public boolean contains(E e) {
	for (int i = 0; i < size; i++)
    	if (e == null ? data[i] == null : e.equals(data[i]))
        	return true;
    return false;
  }

  @Override /** Return the element at the specified index */
  public E get(int index) {
    checkIndex(index);
    return data[index];
  }

  private void checkIndex(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException
        ("Index: " + index + ", Size: " + size);
  }
  
  @Override /** Return the index of the first matching element 
   *  in this list. Return -1 if no match. */
  public int indexOf(E e) {
    for (int i = 0; i < size; i++)
      if (e.equals(data[i])) return i;

    return -1;
  }

  @Override /** Return the index of the last matching element 
   *  in this list. Return -1 if no match. */
  public int lastIndexOf(E e) {
    for (int i = size - 1; i >= 0; i--)
      if (e.equals(data[i])) return i;

    return -1;
  }

  @Override /** Remove the element at the specified position 
   *  in this list. Shift any subsequent elements to the left.
   *  Return the element that was removed from the list. */
  public E remove(int index) {
    checkIndex(index);
    
    E e = data[index];

    // Shift data to the left
    for (int j = index; j <= size - 2; j++)
      data[j] = data[j + 1];

    data[size - 1] = null;

    // Decrement size
    size--;

    return e;
  }

  @Override /** Replace the element at the specified position 
   *  in this list with the specified element. */
  public E set(int index, E e) {
    checkIndex(index);
    E old = data[index];
    data[index] = e;
    return old;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder("[");

    for (int i = 0; i < size; i++) {
      result.append(data[i]);
      if (i < size - 1) result.append(", ");
    }

    return result.toString() + "]";
  }

  /** Trims the capacity to current size */
  public void trimToSize() {
    if (size != data.length) { 
      E[] newData = (E[])(new Object[size]);
      System.arraycopy(data, 0, newData, 0, size);
      data = newData;
    } // If size == capacity, no need to trim
  }

  @Override /** Override iterator() defined in Iterable */
  public java.util.Iterator<E> iterator() {
    return new ArrayListIterator();
  }
 
  private class ArrayListIterator 
      implements java.util.Iterator<E> {
    private int current = 0; // Index of the next element in the iteration
    private boolean canRemove = false; 

    @Override
    public boolean hasNext() {
      return (current < size);
    }

    @Override
    public E next() {
      if (!hasNext())
      	throw new java.util.NoSuchElementException();
      canRemove = true;
      return data[current++];
    }

    @Override
    public void remove() {
      if (!this.canRemove)
      	throw new IllegalStateException();
      MyArrayList.this.remove(current - 1);
      canRemove = false;
      current--;
    }
  }
}