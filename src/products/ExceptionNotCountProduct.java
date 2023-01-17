package products;

public class ExceptionNotCountProduct extends RuntimeException {
	public ExceptionNotCountProduct() {
		super("There are not so many products");
	}
}
