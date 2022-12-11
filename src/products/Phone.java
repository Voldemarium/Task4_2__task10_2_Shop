package products;

public class Phone extends Product {
    private String maker;

    public Phone(String name, int price, String maker) {
        super(name, price);
        this.maker = maker;
    }

    public String getMaker() {
        return maker;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + this.getName() + '\'' +
                ", price=" + this.getPrice() + '\'' +
                ", maker='" + maker + '\'' +
                '}';
    }
}
