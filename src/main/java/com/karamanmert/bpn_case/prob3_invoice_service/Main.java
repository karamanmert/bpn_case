package prob3_invoice_service;

import prob3_invoice_service.new1.Database;
import prob3_invoice_service.new1.DatabaseFactory;
import prob3_invoice_service.new1.DbType;
import prob3_invoice_service.new1.InvoiceService;
import prob3_invoice_service.old.Invoice;

/**
 * @author karamanmert
 */
public class Main {

    public static void main(String[] args) {
        Database db = DatabaseFactory.createDb(DbType.Sql);
        InvoiceService service = new InvoiceService(db);
        service.createInvoice(new Invoice());

        System.out.println("----");

        Database db2 = DatabaseFactory.createDb(DbType.NoSql);
        InvoiceService service2 = new InvoiceService(db2);
        service2.createInvoice(new Invoice());
    }
}
