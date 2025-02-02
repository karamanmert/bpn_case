package prob2_shipping_cost_calculator.old;

/**
 * @author karamanmert
 */
/*
PROBLEMS
iç içe ifler kodun okunmasını zorlaştırıyor.
tekrarlanan yerler var.
genişletmek zor ( region değişebilir, currency değişebilir. )
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
