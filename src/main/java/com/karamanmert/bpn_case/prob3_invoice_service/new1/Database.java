package com.karamanmert.bpn_case.prob3_invoice_service.new1;


import com.karamanmert.bpn_case.prob3_invoice_service.Invoice;

/**
 * @author karamanmert
 */
public interface Database {

    void connect();

    void insertInvoice(Invoice invoice);

    void disconnect();

    DbType getType();
}
