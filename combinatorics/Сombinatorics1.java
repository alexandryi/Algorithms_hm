package combinatorics;

import java.util.Arrays;

public class Сombinatorics1 {

	public static int findMaxIndex(int[] permutation) {
		for (int i = permutation.length - 2; i >= 0; i--) {
			if (permutation[i] < permutation[i + 1]) {
				return i;
			}
		}
		return -1;
	}

	public static int findIndexBiggerElement(int[] permutation, int element) {
		for (int i = permutation.length - 1; i >= 0; i--) {
			if (permutation[i] > element) {
				return i;
			}
		}
		return -1;
	}

	public static void swap(int[] permutation, int i, int j) {
		int temp = permutation[i];
		permutation[i] = permutation[j];
		permutation[j] = temp;
	}

	public static void reverse(int[] permutation, int index) {
		int shift = index + 1;
		for (int i = 0; i < (permutation.length - shift) / 2; i++) {
			int temp = permutation[shift + i];
			permutation[shift + i] = permutation[permutation.length - i - 1];
			permutation[permutation.length - i - 1] = temp;
		}
	}

	public static void permutationGenerator(int n, String[] arr) {
		int[] permutation = new int[n];
		int scor = 1;
		for (int i = 0; i < n; i++) {
			permutation[i] = i;
		}
		System.out.print(scor + "  ");
		printPermutation(permutation, arr);

		int index = findMaxIndex(permutation);
		while (index != -1) {
			scor++;
			int element = permutation[index];
			int swapIndex = findIndexBiggerElement(permutation, element);
			swap(permutation, index, swapIndex);
			reverse(permutation, index);
			System.out.print(scor + "  ");
			printPermutation(permutation, arr);
			index = findMaxIndex(permutation);
		}
	}

	public static void printPermutation(int[] permutation, String[] arr) {

		for (int index : permutation) {

			System.out.print(arr[index] + "; ");

		}
		System.out.println();
		System.out.println();
	}

	public static void main(String[] args) {

		String[] words = { "hello", "Java", "programming", "algorithms", "learning" };
		int n = words.length;
		permutationGenerator(n, words);

	}

}
