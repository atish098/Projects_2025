package API.Ecommerce;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class orderDetails {

	private List<order> orders;

	public List<order> getOrders() {
		return orders;
	}

	public void setOrders(List<order> orders) {
		this.orders = orders;
	}

	@Test
	public void demo() {

		Integer[] numbers = { 1, 0, 2, 0, 3, 4, 5, 0, 0 };
		ArrayList<Integer> numbers1 = new ArrayList<>();
		ArrayList<Integer> numbers2 = new ArrayList<>();

		int b = numbers.length;

		for (int i = 0; i <= b - 1; i++) {

			int c = numbers[i];

			if (c != 0) {
				numbers1.add(c);
			} else {
				numbers2.add(c);
			}
		}

		int d = numbers2.size();
		for (int j = 0; j <= d - 1; j++) {

			numbers1.add(numbers2.get(j));
		}

		Integer[] array = numbers1.toArray(new Integer[0]);

		numbers = array;

		for (int k = 0; k <= array.length - 1; k++) {
			int h = numbers1.get(k);
			System.out.println(h);

		}

	}

}
