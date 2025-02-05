package com.karamanmert.bpn_case.prob2_shipping_cost_calculator.old;

/**
 * @author karamanmert
 */
/*
koşula göre eklenen if elseler var ve kodu karmaşık hale getiriyor.
tekrarlanan yerler var.
kodu genişletmek zor ( region değişebilir, currency değişebilir. )
kodu anlamayı da kısmen zorlaştırıyor.
burada ilk başta farklı bir şekilde ilerlemiştim ama 2. bakışımda
ücretlendirmeler arası belirli bir oran olduğunu gördüm ve code'daki gibi son haline çevirdim.
Mantık şu;

temel ücret:5
Eğer bölge EU değilse +5
Eğer ağırlık >= 5 kg ise +10
Eğer kırılgan ürün ise +5

ayrıca shipping cost da hep usd olmasın istedim. ayarlanabilir olması için ShippingCostUtil'i oluşturdum böylece amount + currency type ile ilerleyebileceğiz.


 */
public class Old {

    public String getShippingCost(int weight, String shippingRegion, boolean isFragile) {

        if (shippingRegion.equals("EU")) {
            if (weight < 5) {
                if (isFragile)
                    return "10 USD";
                else
                    return "5 USD";
            } else {
                if (isFragile)
                    return "20 USD";
                else
                    return "15 USD";
            }
        } else {
            if (weight < 5) {
                if (isFragile)
                    return "15 USD";
                else
                    return "10 USD";
            } else {
                if (isFragile)
                    return "25 USD";
                else
                    return "20 USD";
            }
        }
    }
}
