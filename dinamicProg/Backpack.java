package dinamicProg;

import java.util.HashMap;
import java.util.Map;

public class Backpack {
	private int capacity;
	private int[] weights;
	private int[] values;
	private String[] items;

	public Backpack(int capacity, int[] weights, int[] values, String[] items) {
		this.capacity = capacity;
		this.weights = weights;
		this.values = values;
		this.items = items;
	}

	public void backpack() {
		int n = weights.length;
		int[] dp = new int[capacity + 1];
		int[] chosenItemsCount = new int[capacity + 1];

		for (int w = 0; w <= capacity; w++) {
			for (int i = 0; i < n; i++) {
				if (weights[i] <= w && dp[w - weights[i]] + values[i] > dp[w]) {
					dp[w] = dp[w - weights[i]] + values[i];
					chosenItemsCount[w] = i;
				}
			}
		}

		int w = capacity;
		Map<String, Integer> itemCounts = new HashMap<>();
		int totalWeight = 0;
		int totalValue = dp[capacity];

		while (w > 0 && chosenItemsCount[w] != -1) {
			int itemIndex = chosenItemsCount[w];
			String itemName = items[itemIndex] + " (вага: " + weights[itemIndex] + ", ціна: " + values[itemIndex] + ")";
			itemCounts.put(itemName, itemCounts.getOrDefault(itemName, 0) + 1);
			totalWeight += weights[itemIndex];
			w -= weights[itemIndex];
		}

		System.out.println("Максимальна вартість: " + totalValue);
		System.out.println("Загальна вага: " + totalWeight);
		System.out.print("Предмети у рюкзаку: ");

		boolean first = true;
		for (Map.Entry<String, Integer> entry : itemCounts.entrySet()) {
			if (!first)
				System.out.print(", ");
			System.out.print(entry.getValue() + " * " + entry.getKey());
			first = false;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		String[] items = { "Ноутбук", "Телефон", "Планшет" };
		int[] weights = { 1500, 200, 500 };
		int[] values = { 3700, 450, 1200 };
		int capacity = 1600;

		Backpack pack = new Backpack(capacity, weights, values, items);
		pack.backpack();
	}
}
