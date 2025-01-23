package bin_algo;

public class Trin {

	
	static public int trinAlgo(int[] array, int searchNumber) {
		int l = 0;
		int r = array.length - 1;
		int m1;
		int m2;
		int result = -1;
		while(true) {
			m1 = l + (r - l) / 3;
			m2 = r - (r - l) / 3;
			if(array[m1] == searchNumber) {
				result = m1;
				break;
			}
			else if(array[m2] == searchNumber) {
				result = m2;
				break;
			}
			else if(array[m2] < searchNumber) {
				l = m2 + 1;
			}
			else if(array[m1] > searchNumber) {
				r = m1 - 1;
			}
			else if(array[m1] < searchNumber && array[m2] > searchNumber) {
				l = m1 + 1;
				r = m2 - 1;
			}
			if (l > r) {
				break;
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		int[] Array = new int[20];
		for (int i = 0; i < Array.length; i++) {
			Array[i] = i * 3 + 2;
		}
		for (int i = 0; i < Array.length; i++) {
			System.out.print(Array[i] + " "); // 2 5 8 11 14 17 20 23 26 29 32 35 38 41 44 47 50 53 56 59 
		}
		
		//int number = 3;// result = -1
		int number = 50; // result = 16
		
		
		System.out.println();
		System.out.println(trinAlgo(Array, number));

	}

}
