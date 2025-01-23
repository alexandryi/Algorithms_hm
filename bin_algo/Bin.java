package bin_algo;

public class Bin {

	static public int binAlgo(int[] array, int searchNumber) {
		int l = 0;
		int r = array.length - 1;
		int m;
		int result = -1;
		while(true) {
			m = (l + r) / 2;
			if(array[m] == searchNumber) {
				result = m;
				break;
			}
			else if(array[m] > searchNumber) {
				r = m-1;
			}
			else if(array[m] < searchNumber) {
				l = m + 1;
			}
			if (l>r) {
				break;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] Array = new int[10];
		for (int i = 0; i < Array.length; i++) {
			Array[i] = i * 3 + 2;
		}
		for (int i = 0; i < Array.length; i++) {
			System.out.print(Array[i] + " "); // 2 5 8 11 14 17 20 23 26 29
		}
		
		//int number = 15; // result = -1
		int number = 11;// result = 3
		
		System.out.println();
		System.out.println(binAlgo(Array, number));
	}

}
