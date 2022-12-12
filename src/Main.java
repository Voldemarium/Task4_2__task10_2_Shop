import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        System.out.println(Arrays.toString(shop.getProducts(5000)));
        System.out.println(shop.containsProduct("Car"));
        System.out.println(shop.findTheCheapest());

        System.out.println(Arrays.toString(shop.findPhones("Samsung")));
        System.out.println(Arrays.toString(shop.findToys(4)));
        System.out.println(Arrays.toString(shop.findFood(
                new GregorianCalendar(2022, Calendar.DECEMBER, 31).getTime()))
        );
    }
}