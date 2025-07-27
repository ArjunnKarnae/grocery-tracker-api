package Exceptions;

public class GroceryItemNotFoundException extends RuntimeException{

    public GroceryItemNotFoundException(String message) {
        super(message);
    }
}
