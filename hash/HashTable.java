package hash;

import java.util.Random;

public class HashTable {

	private static final int TABLE_SIZE = 256;
	private static final int[] TRANSITION_TABLE = new int[TABLE_SIZE];

	static {
		Random random = new Random(42); 
		for (int i = 0; i < TABLE_SIZE; i++) {
			TRANSITION_TABLE[i] = random.nextInt();
		}
	}

	public static int hash(String input) {
		int[] hashArray = new int[input.length()];
		for (int i = 0; i < input.length(); i++) {
			hashArray[i] = TRANSITION_TABLE[input.charAt(i) % TABLE_SIZE];
		}
		return arrayToNumber(hashArray);
	}

	public static int arrayToNumber(int[] array) {
		int result = array[0];
		for (int i = 0; i < array.length - 1; i++) {
			result = (result << 5) - result + array[i + 1]; 
		}
		return result;
	}

	public static void main(String[] args) {
		String line1 = "Hello";
		String line2 = "World";
		String line3 = "Hello"; 

		System.out.println("Hello: " + hash(line1));
		System.out.println("World: " + hash(line2));
		System.out.println("Hello(повтор): " + hash(line3));
	}

}
