package com.karamanmert.bpn_case.prob2_shipping_cost_calculator.new1;

/**
 * @author karamanmert
 */


public class ShippingCostDto {

    private Integer weight;
    private Region shippingRegion;
    private Currency currency;
    private Boolean isFragile;

    public ShippingCostDto() {
    }

    public ShippingCostDto(Integer weight, Region shippingRegion, Currency currency, Boolean isFragile) {
        this.weight = weight;
        this.shippingRegion = shippingRegion;
        this.currency = currency;
        this.isFragile = isFragile;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Region getShippingRegion() {
        return shippingRegion;
    }

    public void setShippingRegion(Region shippingRegion) {
        this.shippingRegion = shippingRegion;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Boolean getFragile() {
        return isFragile;
    }

    public void setFragile(Boolean fragile) {
        isFragile = fragile;
    }
}
