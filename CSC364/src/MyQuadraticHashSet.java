//Alex Schwiegeraht
//Description: A hash table using a quadratic probing. The iterator is not implemented.

import java.util.Iterator;

public class MyQuadraticHashSet<E> implements MySet<E> {

	private Object table[];
	private final static Object REMOVED = new Object();
	private double loadThreshold;
	private int[] primes;
	int size = 0, numRemoved = 0, primeLocation = 0;


	public MyQuadraticHashSet(double loadThreshold, int[] primes){
		this.loadThreshold = loadThreshold;
		this.primes = primes;
		table = new Object[primes[primeLocation]];
	}

	private static int probeIndex(int hashCode, long modifier, int tableLength) {
		return (int)((hashCode % tableLength + tableLength + modifier * modifier) % tableLength);
	}

	@SuppressWarnings("unchecked")
	private void rehash(){
		Object oldTable[] = table;

		primeLocation++;

		table = new Object[primes[primeLocation]];
		size = 0;
		numRemoved = 0;

		for(int i = 0; i < oldTable.length; i++){
			if(oldTable[i] != REMOVED && oldTable[i] != null)
				add((E) oldTable[i]);
		}
	}

	@Override
	public void clear() {
		table = new Object[primes[0]];
		size = 0;
		numRemoved = 0;
		primeLocation = 0;
	}

	@Override
	public boolean contains(E e) {
		int n, modifier = 0;
		while(true){
			n = probeIndex(e.hashCode(),modifier, table.length);
			if(table[n] == null){
				return false;
			}
			else if(table[n].equals(e)){
				return true;
			}
			else{
				modifier++;
			}
		}
	}

	@Override
	public boolean add(E e) {
		if(contains(e)){
			return false;
		}
		
		if(size + numRemoved > (int)(table.length*loadThreshold))
			rehash();

		int n, modifier = 0;

		while(true){
			n = probeIndex(e.hashCode(),modifier, table.length);
			if(table[n] == null){
				table[n] = e;
				size++;
				return true;
			}
			else if(table[n] == REMOVED){
				table[n] = e;
				size++;
				numRemoved--;
				return true;
			}
			else{
				modifier++;
			}
		}	
	}

	@Override
	public boolean remove(E e) {
		if(!contains(e))
			return false;
		
		int n, modifier = 0;
		
		while(true){
			n = probeIndex(e.hashCode(),modifier, table.length);
			if(table[n].equals(e)){
				table[n] = REMOVED;
				size--;
				numRemoved++;
				return true;
			}
			else{
				modifier++;
			}
		}
	}

	@Override
	public boolean isEmpty() {
		if(size == 0)
			return true;
		else
			return false;
	}

	@Override
	public int size() {
		return size;
	}


	@Override
	public Iterator<E> iterator() {
		throw new UnsupportedOperationException();
	}


}
