public class InsufficientDepositException extends Exception{
    public InsufficientDepositException() {
        super("Error: Initial deposit must exceed $25!");
    }
}
