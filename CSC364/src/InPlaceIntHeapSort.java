//Alex Schwiegeraht
//Description: Takes an array on ints and puts them in order using heap method without a heap object


public class InPlaceIntHeapSort {

	public static void heapSort(int[] list){	

		int n = list.length;
		//put array into heap
		for(int i = 1; i < n; i++){

			int currentIndex = i;
			
			while (currentIndex > 0) {
				int parentIndex = (currentIndex - 1) / 2;

				if (list[currentIndex] > list[parentIndex]) {	
					int temp = list[currentIndex];
					list[currentIndex] =  list[parentIndex];
					list[parentIndex] =  temp;
				}
				else break;
				currentIndex = parentIndex;
			}
		}
		//oders heap
		for (int i = n - 1; i > 0; i--){

			int temp = list[0];
			list[0] = list[i];
			list[i] = temp;

			int currentIndex = 0;
			while (currentIndex < i) {
				int leftChildIndex = 2 * currentIndex + 1;
				int rightChildIndex = 2 * currentIndex + 2;

				// Find the maximum between two children
				if (leftChildIndex >= i) break; // The tree is a heap
				int maxIndex = leftChildIndex;
				if (rightChildIndex < i) {
					if (list[maxIndex] < list[rightChildIndex]) {
						maxIndex = rightChildIndex;
					}
				}

				// Swap if the current node is less than the maximum
				if (list[currentIndex] < list[maxIndex]) {
					temp = list[maxIndex];
					list[maxIndex] = list[currentIndex];
					list[currentIndex] = temp;
					currentIndex = maxIndex;
				}
				else
					break; // The tree is a heap
			}

		}

	}

}

