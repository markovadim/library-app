package by.markov.libraryapp.exceptions;

public class PrintedProductionNotFoundException extends RuntimeException {
    public PrintedProductionNotFoundException() {
        super("Printed Productions Not Found.");
    }
}
