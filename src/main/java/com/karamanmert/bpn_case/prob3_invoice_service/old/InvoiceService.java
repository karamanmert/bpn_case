package com.karamanmert.bpn_case.prob3_invoice_service.old;

import com.karamanmert.bpn_case.prob3_invoice_service.Invoice;

/**
 * @author karamanmert
 */
public class InvoiceService {

    /*
Bu koddaki problem tek bir db'ye sıkı sıkıya bağlanmadır. ( tighly coupled )
InvoiceService tamamen SqlDatabase'e bağlı bir classtır.
Yarın SqlDatabase değil başka bir db kullanmak istersek her yeri yeriden yazmamız gerekir.
Bu kodu gevşek bağlı ( loosely coupled ) hale getirmemiz lazım.

DIP -> depend on abstraction, not conctre classes.
Database interface'ini ekledikten sonra kodumuz (Invoice service) artık tek bir sabit class'a bağımlı kalmayacak
bir abstraction(interface'e) bağlı kalacak. dolayısıyla dip sağlanmış olacak.
+ factory ile de hangisinin objesini üretmemiz gerekiyorsa üretmiş oalcağız.
     */

    private SqlDatabase sqlDatabase = new SqlDatabase();

    public void createInvoice(Invoice invoice) {
        sqlDatabase.connect();
        sqlDatabase.insertInvoice(invoice);
        sqlDatabase.disconnect();
    }
}
