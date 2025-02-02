package prob5_tax_and_commission_calculation.new1;

import java.util.EnumMap;

/**
 * @author karamanmert
 */
public class TaxFactory {

    private static final EnumMap<Country, Tax> taxStrategyEnumMap = new EnumMap<>(Country.class);

    static {
        taxStrategyEnumMap.put(Country.TURKEY, new TurkeyTax());
        taxStrategyEnumMap.put(Country.SWITZERLAND, new SwitzerlandTax());
    }

    public static Tax getTaxStrategy(Country country) {
        if (country == null || country.name().isEmpty()) {
            throw new RuntimeException("exception");
        }

        return taxStrategyEnumMap.get(country);
    }
}
