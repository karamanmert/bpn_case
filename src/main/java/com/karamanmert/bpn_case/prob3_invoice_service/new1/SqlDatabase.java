package com.karamanmert.bpn_case.prob3_invoice_service.new1;


import com.karamanmert.bpn_case.prob3_invoice_service.Invoice;

/**
 * @author karamanmert
 */
public class SqlDatabase implements Database {

    public void connect() {
        System.out.println("SqlDatabase Connected..");
    }

    public void insertInvoice(Invoice invoice) {
        System.out.println("SqlDatabase Invoice inserted..");
    }

    public void disconnect() {
        System.out.println("SqlDatabase Disconnected..");
    }

    @Override
    public DbType getType() {
        return DbType.Sql;
    }
}
