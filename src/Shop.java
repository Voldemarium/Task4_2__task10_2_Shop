import products.*;

import java.util.Arrays;
import java.util.Date;

public class Shop {
	private Product[] products;
	private int maxSize;
	private int countProducts = 0;

	public Shop(int maxSize) {
		this.products = new Product[maxSize];
		this.maxSize = maxSize;
	}

	public Shop addProduct(Product product) {
		try {
			products[countProducts] = product;
			countProducts++;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("The shop is full!");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return this;
	}

	public void deleteProduct(String name) {
		try {
			boolean isProduct = false;
			for (int i = 0; i < countProducts; i++) {
				if (products[i].getName().equals(name)) {
					if (i == countProducts - 1) {
						products[i] = null;
					} else {
						//передвигаем все ячейки, находящиеся правее найденной, влево
						for (int j = i; j < countProducts && j < maxSize - 1; j++) {
							products[j] = products[j + 1];
						}
						products[countProducts - 1] = null;
					}
					countProducts--;
					isProduct = true;
				}
			}
			if (!isProduct) {
				throw new ExceptionNoProduct();
			}
		} catch (ExceptionNoProduct e) {
			e.printStackTrace();
		}
	}

	public int size() {
		return countProducts;
	}

	public Product[] getProducts(int cost) {
		int lengthArray = 0;
		for (int i = 0; i < countProducts; i++) {
			if (products[i].getPrice() <= cost) {
				lengthArray++;
			}
		}
		Product[] productsCost = new Product[lengthArray];
		int j = 0;
		for (int i = 0; i < countProducts && j < productsCost.length; i++) {
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
		for (int i = 0; i < countProducts; i++) {
			if (products[i].getPrice() < maxPrice) {
				theCheapestProduct = products[i];
				maxPrice = products[i].getPrice();
			}
		}
		return theCheapestProduct;
	}

	public Phone[] findPhones(String maker) {
		int lengthArray = 0;
		for (Product product : products) {
			if (product instanceof Phone && ((Phone) product).getMaker().equals(maker)) {
				lengthArray++;
			}
		}
		Phone[] phones = new Phone[lengthArray];
		int j = 0;
		for (int i = 0; i < products.length && j < phones.length; i++) {
			if (products[i] instanceof Phone && ((Phone) products[i]).getMaker().equals(maker)) {
				phones[j] = (Phone) products[i];
				j++;
			}
		}
		return phones;
	}

	public Toy[] findToys(int age) {
		int lengthArray = 0;
		for (Product product : products) {
			if (product instanceof Toy && ((Toy) product).getAgeRestriction() < age) {
				lengthArray++;
			}
		}
		Toy[] toys = new Toy[lengthArray];
		int j = 0;
		for (int i = 0; i < products.length && j < toys.length; i++) {
			if (products[i] instanceof Toy && ((Toy) products[i]).getAgeRestriction() < age) {
				toys[j] = (Toy) products[i];
				j++;
			}
		}
		return toys;
	}

	public Food[] findFood(Date date) {
		int lengthArray = 0;
		for (Product product : products) {
			if (product instanceof Food && ((Food) product).getDate().compareTo(date) > 0) {
				lengthArray++;
			}
		}
		Food[] foods = new Food[lengthArray];
		int j = 0;
		for (int i = 0; i < products.length && j < foods.length; i++) {
			if (products[i] instanceof Food && ((Food) products[i]).getDate().compareTo(date) > 0) {
				foods[j] = (Food) products[i];
				j++;
			}
		}
		return foods;
	}

	@Override
	public String toString() {
		return "Shop{" +
				"products=" + Arrays.toString(products) +
				'}';
	}
}
