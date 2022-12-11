import products.Food;
import products.Phone;
import products.Product;
import products.Toy;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Shop {
    private Product[] products = {
            new Phone("Nokia-g10", 10_000, "Nokia"),
            new Phone("Nokia-g11", 10_000, "Nokia"),
            new Phone("Samsung-s20", 20_000, "Samsung"),
            new Phone("Samsung-s21", 20_000, "Samsung"),
            new Phone("Samsung-s22", 20_000, "Samsung"),
            new Toy("Car", 1_000, 3),
            new Toy("Barby", 1_300, 5),
            new Food("Cheese", 400, new GregorianCalendar(2023, Calendar.JANUARY, 12)),
            new Food("Sausage", 600, new GregorianCalendar(2023, Calendar.JANUARY, 2)),
            new Food("Fish", 500, new GregorianCalendar(2022, Calendar.DECEMBER, 25))
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
