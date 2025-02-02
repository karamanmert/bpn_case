package prob3_invoice_service.old;

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
