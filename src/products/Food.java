package products;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Food extends Product {
	private Date date;

	public Food(String name, int price, Calendar calendar) {
		super(name, price);
		this.date = calendar.getTime();
	}

	public Food(String name, int price, int year, int month, int dayOfMonth) {
		super(name, price);
		this.date = new GregorianCalendar(year, month - 1, dayOfMonth).getTime();
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
