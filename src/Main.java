import products.Food;
import products.Phone;
import products.Toy;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
	public static void main(String[] args) {
		Shop shop = new Shop();
		shop.addProduct(new Phone("Nokia-g10", 10_000, "Nokia"), 1)
				.addProduct(new Phone("Nokia-g11", 10_000, "Nokia"), 2)
				.addProduct(new Phone("Samsung-s20", 20_000, "Samsung"), 1)
				.addProduct(new Phone("Samsung-s21", 20_000, "Samsung"), 1)
				.addProduct(new Toy("Car", 1_000, 3), 1)
				.addProduct(new Toy("Barby", 1_400, 3), 1)
				.addProduct(new Food("Cheese", 400, new GregorianCalendar(2023, Calendar.JANUARY, 12)), 1)
				.addProduct(new Food("Sausage", 600, new GregorianCalendar(2023, Calendar.JANUARY, 2)), 1)
				.addProduct(new Food("Fish", 500, new GregorianCalendar(2022, Calendar.DECEMBER, 25)), 1)
				.addProduct(new Food("Milk", 50, 2023, 1, 5), 1);
		System.out.println("Shop: " + shop);
		System.out.println("Size = " + shop.size());
		shop.deleteProduct("Nokia-g11", 1);
		System.out.println("Shop: " + shop);
		System.out.println("Size = " + shop.size());

		System.out.println("Products with a price equal to or less than 5000: " + Arrays.toString(shop.getProducts(5000)));
		System.out.println(shop.containsProduct("Car"));
		System.out.println("The cheapest product: " + shop.findTheCheapest());

		System.out.println(Arrays.toString(shop.findPhones("Samsung")));
		System.out.println(Arrays.toString(shop.findToys(4)));
		System.out.println(Arrays.toString(shop.findToys("4")));
		System.out.println(Arrays.toString(shop.findFood(
				new GregorianCalendar(2022, Calendar.DECEMBER, 31).getTime()))
		);
		System.out.println(Arrays.toString(shop.findFood("2022.12.31")));
		System.out.println(Arrays.toString(shop.findFood("Sat Dec 31 00:00:00 GMT+04:00 2022")));
	}
}