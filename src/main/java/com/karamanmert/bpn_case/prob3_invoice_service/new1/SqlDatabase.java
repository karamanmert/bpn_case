package prob3_invoice_service.new1;

import prob3_invoice_service.old.Invoice;

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
