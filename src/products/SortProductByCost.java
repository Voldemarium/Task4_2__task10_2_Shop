package products;

import java.util.Comparator;

public class SortProductByCost implements Comparator<Product> {
	@Override
	public int compare(Product p1, Product p2) {
		if (p1.getPrice() != p2.getPrice()) {
			if (p1.getPrice() > p2.getPrice()) {
				return 1;
			} else {
				return -1;
			}
		} else {
			if (p1.hashCode() != p2.hashCode()) {
				if (p1.hashCode() > p2.hashCode()) {
					return 1;
				} else {
					return -1;
				}
			} else {
				return 0;
			}
		}
	}
}
