package com.mg.WebCrawler;

public class ApplicationException extends RuntimeException {

    private static final long serialVersionUID = 1234567L;

    /**
     * Instantiates a new application exception.
     */
    public ApplicationException() {
        super("Error in Web crawler.");
    }

    /**
     * Instantiates a new application exception.
     *
     * @param message
     *            the message
     */
    public ApplicationException(final String message) {
        super(message);
    }

    /**
     * Instantiates a new application exception.
     *
     * @param message
     *            the message
     * @param tr
     *            the Throwable
     */
    public ApplicationException(final String message, final Throwable tr) {
        super(message, tr);
    }
}
