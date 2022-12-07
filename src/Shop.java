import java.util.Arrays;

public class Shop {
	private Product[] products = {
			new Product("TV", 10_000),
			new Product("fridge", 15_000),
			new Product("vacuum cleaner", 5_000),
			new Product("microwave", 4_000),
			new Product("iron", 3_000),
			new Product("phone", 5_000),
			new Product("laptop", 40_000),
	};
	public Product[] getProducts(int cost) {
		int lengthArray = 0;
		for (Product product : products) {
			if (product.getPrice() <= cost) {
				lengthArray++;
			}
		}
		Product[] productsCost = new Product[lengthArray];
		int j = 0;
		for (int i = 0; i < products.length && j < productsCost.length; i++) {
			if (products[i].getPrice() <= cost) {
				productsCost[j] = products[i];
				j++;
			}
		}
		return productsCost;
	}
	public boolean containsProduct(String name) {
		boolean isProduct = false;
		for (Product product : products) {
			if (product.getName().toLowerCase().contains(name.toLowerCase())) {
				isProduct = true;
				break;
			}
		}
		return isProduct;
	}
	public Product findTheCheapest() {
		Product theCheapestProduct = null;
		int maxPrice = Integer.MAX_VALUE;
		for (Product product : products) {
			if (product.getPrice() < maxPrice) {
				theCheapestProduct = product;
				maxPrice = product.getPrice();
			}
		}
		return theCheapestProduct;
	}

	@Override
	public String toString() {
		return "Shop{" +
				"products=" + Arrays.toString(products) +
				'}';
	}
}
