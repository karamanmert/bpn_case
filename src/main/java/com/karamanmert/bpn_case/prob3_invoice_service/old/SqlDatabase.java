package com.karamanmert.bpn_case.prob3_invoice_service.old;

import com.karamanmert.bpn_case.prob3_invoice_service.Invoice;

/**
 * @author karamanmert
 */
public class SqlDatabase {

    public void connect() {
        System.out.println("Connected..");
    }

    public void insertInvoice(Invoice invoice) {
        System.out.println("Invoice inserted..");
    }

    public void disconnect() {
        System.out.println("Disconnected..");
    }
}
