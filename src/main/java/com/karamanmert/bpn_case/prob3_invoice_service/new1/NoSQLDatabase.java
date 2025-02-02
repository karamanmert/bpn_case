package com.karamanmert.bpn_case.prob3_invoice_service.new1;


import com.karamanmert.bpn_case.prob3_invoice_service.Invoice;

/**
 * @author karamanmert
 */
public class NoSQLDatabase implements Database {

    public void connect() {
        System.out.println("NoSQLDatabase Connected..");
    }

    public void insertInvoice(Invoice invoice) {
        System.out.println("NoSQLDatabase Invoice inserted..");
    }

    public void disconnect() {
        System.out.println("NoSQLDatabase Disconnected..");
    }

    @Override
    public DbType getType() {
        return DbType.NoSql;
    }
}