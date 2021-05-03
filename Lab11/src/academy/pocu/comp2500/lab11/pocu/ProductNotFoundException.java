package academy.pocu.comp2500.lab11.pocu;

public class ProductNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ProductNotFoundException(final String message) {
        super(message);
    }
}
