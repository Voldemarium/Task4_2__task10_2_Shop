import products.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class Shop {
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
        List<Toy> toyList = new LinkedList<>();
        try {
            for (Product product : products) {
                if (product instanceof Toy && ((Toy) product).getAgeRestriction() < Integer.parseInt(String.valueOf(age))) {
                    toyList.add((Toy) product);
                }
            }
        } catch (ClassCastException | NumberFormatException e2) {
            e2.printStackTrace();
            System.out.println("This is not an integer!");
            return null;
        }
        Toy[] toys = new Toy[toyList.size()];
        toyList.toArray(toys);
        return toys;
    }

    public <T> Food[] findFood(T date) {
        Date dateFood = null;
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy.MM.dd");
        SimpleDateFormat formatter2 = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        DateFormat[] dateFormats = {formatter1, formatter2};
        for (int i = 0; i < dateFormats.length; i++) {
            try {
                String dateStr = date.toString();
                if (dateFormats[i] == formatter1 && !dateStr.substring(0, 4).matches("\\d{4}")) {
                    continue;
                }
                dateFood = dateFormats[i].parse(dateStr);
                break;
            } catch (ClassCastException | ParseException e) {
                if (i == dateFormats.length - 1) {
                    e.printStackTrace();
                    System.out.println("Invalid date format, please enter the format type \"Date\" or \"yyyy.MM.dd\" " +
                            "or \"E MMM dd HH:mm:ss z yyyy, Locale.ENGLISH\"!");
                    return null;
                }
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
