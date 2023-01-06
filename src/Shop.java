import products.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Shop {
	//	private Product[] products;
	private List<Product> products;

	public Shop() {
		this.products = new LinkedList<>();
	}

	public Shop addProduct(Product product) {
		products.add(product);
		return this;
	}

	public void deleteProduct(String name) {
		try {
			boolean isProduct = false;
			for (Product product : products) {
				if (product.getName().equals(name)) {
					isProduct = products.remove(product);
					break;
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
		return products.size();
	}

	public Product[] getProducts(int cost) {
		List<Product> productsCostList = new LinkedList<>();
		for (Product product : products) {
			if (product.getPrice() <= cost) {
				productsCostList.add(product);
			}
		}
		Product[] productsCostArray = new Product[productsCostList.size()];
		productsCostList.toArray(productsCostArray);
		return productsCostArray;
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

	public Phone[] findPhones(String maker) {
		List<Phone> phonesList = new LinkedList<>();
		for (Product product : products) {
			if (product instanceof Phone && ((Phone) product).getMaker().equals(maker)) {
				phonesList.add((Phone) product);
			}
		}
		Phone[] phones = new Phone[phonesList.size()];
		phonesList.toArray(phones);
		return phones;
	}

	public <T> Toy[] findToys(T age) {
		int ageInt;
		if (age instanceof String) {
			try {
				ageInt = Integer.parseInt((String) age);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				System.out.println("This is not a number, enter a number!");
				return null;
			}
		} else {
			try {
				ageInt = (int) age;
			} catch (ClassCastException e) {
				e.printStackTrace();
				System.out.println("This is not number type \"int\"");
				return null;
			}
		}
		List<Toy> toyList = new LinkedList<>();
		for (Product product : products) {
			if (product instanceof Toy && ((Toy) product).getAgeRestriction() < ageInt) {
				toyList.add((Toy) product);
			}
		}
		Toy[] toys = new Toy[toyList.size()];
		toyList.toArray(toys);
		return toys;
	}

	public <T> Food[] findFood(T date) {
		Date dateFood;
		if (date instanceof String) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
			try {
				String[] dataArray = ((String) date).split("\\.");
				if (dataArray.length != 3 || !dataArray[0].matches("\\d{4}")
						|| !dataArray[1].matches("\\d{2}")
						|| !dataArray[2].matches("\\d{2}")) {
					throw new ParseException("Invalid date format, please enter the format \"yyyy-MM-dd\"!", 1);
				}
				dateFood = formatter.parse((String) date);
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			try {
				dateFood = (Date) date;
			} catch (ClassCastException e) {
				e.printStackTrace();
				System.out.println("This is not date type \"Date\"!");
				return null;
			}
		}
		List<Food> foodList = new LinkedList<>();
		for (Product product : products) {
			if (product instanceof Food && ((Food) product).getDate().compareTo(dateFood) > 0) {
				foodList.add((Food) product);
			}
		}
		Food[] foods = new Food[foodList.size()];
		foodList.toArray(foods);
		return foods;
	}

	@Override
	public String toString() {
		return "Shop{" +
				"products=" + products +
				'}';
	}
}
