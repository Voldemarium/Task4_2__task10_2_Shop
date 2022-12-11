package products;

public class Toy extends Product {
    private int ageRestriction;

    public Toy(String name, int price, int ageRestriction) {
        super(name, price);
        this.ageRestriction = ageRestriction;
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "name='" + this.getName() + '\'' +
                ", price=" + this.getPrice() + '\'' +
                ", ageRestriction=" + ageRestriction +
                '}';
    }
}
