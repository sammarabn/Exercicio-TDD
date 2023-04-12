package main.java.org.invoice_generator.utils;

import main.java.org.invoice_generator.model.Invoice;

public interface Send {
    public void send(Invoice invoice);
}
