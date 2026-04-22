package org.example.VendingMaching;

/**
 * Exception thrown when a vending machine transaction is invalid.
 */
public class InvalidTransactionException extends Exception {

    /**
     * Constructs a new InvalidTransactionException with no detail message.
     */
    public InvalidTransactionException() {
        super();
    }

    /**
     * Constructs a new InvalidTransactionException with the specified detail message.
     *
     * @param message the detail message
     */
    public InvalidTransactionException(String message) {
        super(message);
    }

    /**
     * Constructs a new InvalidTransactionException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause
     */
    public InvalidTransactionException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new InvalidTransactionException with the specified cause.
     *
     * @param cause the cause
     */
    public InvalidTransactionException(Throwable cause) {
        super(cause);
    }
}