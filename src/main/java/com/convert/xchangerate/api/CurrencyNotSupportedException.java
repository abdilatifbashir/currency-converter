package com.convert.xchangerate.api;

public class CurrencyNotSupportedException extends Exception{
        public CurrencyNotSupportedException() {
                super();
        }

        public CurrencyNotSupportedException(String message) {
                super(message);
        }

        public CurrencyNotSUpportedException(String message, Throwable cause) {
                super(message, cause);
        }

        
}
