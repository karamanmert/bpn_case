package com.karamanmert.bpn_case.prob2_shipping_cost_calculator.new1;

/**
 * @author karamanmert
 */


import static com.karamanmert.bpn_case.prob2_shipping_cost_calculator.new1.ShippingCostEnum.EU_LIGHT_FRAGILE;
import static com.karamanmert.bpn_case.prob2_shipping_cost_calculator.new1.ShippingCostEnum.EU_LIGHT_NON_FRAGILE;
import static com.karamanmert.bpn_case.prob2_shipping_cost_calculator.new1.ShippingCostUtil.calculateShippingCost;

/**
 * region, currency bilgileri gerekli
 */
// gerekli parametreler 1- region, 2- weight, 3- isFragile

        /*
        kaç farklı olasılık var? 2 if * 2 if * 2  = 8 --
        1- region = eu, weight < 5, isFragile true          = 10 USD
        2- region = eu, weight < 5, isFragile false         = 5  USD
        3- region = eu, weight >= 5, isFragile true         = 20 USD
        4- region = eu, weight >= 5, isFragile false        = 15 USD
        -
        5- region = other, weight < 5, isFragile true       = 15 USD
        6- region = other, weight < 5, isFragile false      = 10 USD
        7- region = other, weight >= 5, isFragile true      = 25 USD
        8- region = other, weight >= 5, isFragile false     = 20 USD

*/

public class New1 {

    private static final Integer WEIGHT_THRESHOLD = 5;

    private static final Integer REGION_COST_DIFF = 5;

    private static final Integer FRAGILE_ITEM_DIFF = 5;

    private static final Integer BASE_ITEM_COST = 5;

    public String getShippingCost(ShippingCostDto shippingCostDto) {
        if (shippingCostDto == null) {
            throw new RuntimeException("shippingCostDto must not be null");
        }

        final int cost = calculateBaseCost(shippingCostDto);

        return calculateShippingCost(cost, shippingCostDto.getCurrency()); //  currency arası uyumluluk göz ardı edildi
    }

    private int calculateBaseCost(ShippingCostDto shippingCostDto) {
        final Region region = shippingCostDto.getShippingRegion();
        final int weight = shippingCostDto.getWeight();
        final boolean isFragile = shippingCostDto.getFragile();

        if (region == Region.EU) {
            return getEuShippingCost(weight, isFragile);
        } else {
            return getInternationalShippingCost(weight, isFragile);
        }
    }

    private int getEuShippingCost(int weight, boolean isFragile) {
        if (weight < WEIGHT_THRESHOLD) {
            return isFragile ? EU_LIGHT_FRAGILE.getCost() : EU_LIGHT_NON_FRAGILE.getCost(); // we can also do this.
        } else {
            return isFragile ? 20 : 15; // EU_HEAVY_FRAGILE, EU_HEAVY_NON_FRAGILE
        }
    }

    private int getInternationalShippingCost(int weight, boolean isFragile) {
        if (weight < WEIGHT_THRESHOLD) {
            return isFragile ? 15 : 10;
        } else {
            return isFragile ? 25 : 20;
        }
    }
}