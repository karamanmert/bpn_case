package prob3_invoice_service.new1;

import prob3_invoice_service.old.Invoice;

/**
 * @author karamanmert
 */
public interface Database {

    void connect();

    void insertInvoice(Invoice invoice);

    void disconnect();

    DbType getType();
}
