package main.java.org.invoice_generator.utils;

import main.java.org.invoice_generator.model.Invoice;

public class Smtp implements Send{
    public void send(Invoice invoice) {
        System.out.println("enviando por email");
    }
}
