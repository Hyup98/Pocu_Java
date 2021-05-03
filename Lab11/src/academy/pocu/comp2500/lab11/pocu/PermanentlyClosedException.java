package academy.pocu.comp2500.lab11.pocu;

public class PermanentlyClosedException extends RuntimeException {
    private static final long serialVersionUID = 10L;

    public PermanentlyClosedException(final String message) {
        super(message);
    }
}
