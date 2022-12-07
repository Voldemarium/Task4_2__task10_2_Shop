import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Shop shop = new Shop();
		System.out.println(Arrays.toString(shop.getProducts(5000)));
		System.out.println(shop.containsProduct("fridge"));
		System.out.println(shop.findTheCheapest());
	}
}