package heaps;

public class HeapSort {
	public static void siftDOwn(int[] array, int i, int lasIndex) {
		for (;;) {
			int leftIndex = 2 * i + 1;
			int rightIndex = 2 * i + 2;
			int j = i;
			if (leftIndex <= lasIndex && array[leftIndex] > array[j]) {
				j = leftIndex;
			}
			if (rightIndex <= lasIndex && array[rightIndex] > array[j]) {
				j = rightIndex;
			}
			if (i != j) {
				swap(array, i, j);
				i = j;
			} else {
				break;
			}
		}
	}

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void heapSort(int[] array) {
		int n = array.length / 2;
		int lastIndex = array.length - 1;
		for (int i = n; i >= 0; i--) {
			siftDOwn(array, i, lastIndex);
		}
		for (; lastIndex > 0;) {
			swap(array, 0, lastIndex);
			lastIndex -= 1;
			siftDOwn(array, 0, lastIndex);
		}
	}

	public static void printArray(int[] array) {
		for (int num : array) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] array = { 42, 23, 4, 16, 8, 15 };
		System.out.println("Масив до сортування:");
		printArray(array);

		heapSort(array); 

		System.out.println("Масив після сортування:");
		printArray(array);
	}

}
