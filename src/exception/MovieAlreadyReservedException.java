package exception;

public class MovieAlreadyReservedException extends Exception {
    public MovieAlreadyReservedException(String message) {
        super(message);
    }
}
