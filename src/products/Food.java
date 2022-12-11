package products;

import java.util.Calendar;
import java.util.Date;

public class Food extends Product {
    private Date date;

    public Food(String name, int price, Calendar calendar) {
        super(name, price);
        this.date = calendar.getTime();
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + this.getName() + '\'' +
                ", price=" + this.getPrice() + '\'' +
                ", date=" + date +
                '}';
    }
}
