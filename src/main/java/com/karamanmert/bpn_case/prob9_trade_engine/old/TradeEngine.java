package com.karamanmert.bpn_case.prob9_trade_engine.old;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author karamanmert
 */

/*
Problem - Yüksek Hacimli Gerçek Zamanlı İşlemlerde Yanlış Concurrency Yönetimi
Bir borsada, yüksek hacimli emir (order) eşleştirme / trade işlemleri gerçekleştiren kod, aynı entity
üzerinde eş zamanlı güncellemeleri (concurrent updates) doğru yönetemiyor. Örneğin, TradeEngine sınıfı
şu şekilde:
Aşağıdaki ipucunu değerlendirerek nasıl bir çözüm üretirsiniz ?

İpucu:
• Concurrency Sorunu: orderBook in-memory ve eş zamanlı güncellemeleri korumak için yeterli
kilit (lock) veya senkronizasyon stratejisi yok.
• Yüksek hacimli işlemlerde, aynı anda gelen çoklu emirler orderBook’u güncelliyor olabilir. Sonuç:
Duplicated trade, missed match, hatalı hesap güncellemeleri vs.
• Code Smell: Tek bir sınıfta hem emir işleme (match), hem hesap güncelleme ve trade execution
mantığı var. Ayrıca senkronizasyon kuralları belirsiz.


PROBLEM & ÇÖZÜM:
Son maddede belirtildiği gibi, tek sınıfa çok sorumluluk yüklenmiş bundan kurtulmamız gerek.
İşlemleri thread safe yapmamız gerek.
Bunu da yapmak için aklıma 2 farklı yol geliyor.
Birisi db kullanıyorsan OptimisticLock kullanmak, diğeri methoda sync ya da lock eklemek.

1- OptimisticLock'ı uygulamak istedim fakat sorudaki in memory data structure dikkatimi çekti ->
Ama burada da şöyle bir nokta var. İn memory db h2, redis gibi bir şey ise jpa özelliklerini kullanabiliriz.
ama benim de 5. soruda yaptığım gibi map ile kendimizin oluşturduğu bir yapı ise bu optimisticlock burada kullanamayız.
Eğer kullanabileceğimiz bir yapı ise;
Kodda göstermeyeceğim ama yazayım. entity katmanına @version adı altında bir annotation ekleyerek işleri ilerletebiliriz.

2. olarak sync keywordunu koda dahil ederek race condition'a engel olabiliriz. ( bunu uygulayacağım )

3. Lock mekanizması kullanmak. (ReentrantLock) altında bu çözüm de var.
 */
public class TradeEngine {

    private OrderBook orderBook; // IN-MEMORY DATA STRUCTURE

    public void matchOrders(Order incomingOrder) {
        for (Order existing : orderBook.getOrders()) {
            if (existing.isMatch(incomingOrder)) {
                executeTrade(existing, incomingOrder);
                existing.setStatus(OrderStatus.FILLED);
                incomingOrder.setStatus(OrderStatus.FILLED);
                break;
            }
        }
    }

    private void executeTrade(Order existing, Order incomingOrder) {
        // trade logic
        BigDecimal price = existing.getPrice();
        BigDecimal total = price.multiply(BigDecimal.valueOf(existing.getQuantity()));
        // müşteri hesap güncellemeri, komisyon vb.
    }
}


@Setter
@Getter
class Order {

    private OrderStatus status;
    private Integer quantity;
    private BigDecimal price;

    public boolean isMatch(Order order) {
        return true;
    }
}

@Setter
@Getter
class OrderBook {
    private List<Order> orders;
}

enum OrderStatus {
    FILLED
}