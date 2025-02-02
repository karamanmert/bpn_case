package prob3_invoice_service.new1;

import prob3_invoice_service.old.Invoice;

/*
      losely coupled sağlandı.
      kod artık birden fazla db'yi destekliyor.
      factory pattern ile obje oluşturma sağlandı.
      dip sağlandı.
 */
public class InvoiceService {
    
    private final Database database;

    public InvoiceService(Database database) {
        this.database = database;
    }

    public void createInvoice(Invoice invoice) {
        database.connect();
        database.insertInvoice(invoice);
        database.disconnect();
    }
}