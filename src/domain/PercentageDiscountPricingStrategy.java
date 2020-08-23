/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.ISalePricingStrategy;
import customTypes.Money;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;


public class PercentageDiscountPricingStrategy implements ISalePricingStrategy {

    private float percentage;

    PercentageDiscountPricingStrategy(int percent) {
        this.percentage = percent;
    }

    public PercentageDiscountPricingStrategy() {
    }
    

    @Override
    public Money getTotal(Sale sale) {
        // In this part we can change item's subtotal. Percentage comes from the Productfactory.
        Currency currency=sale.getPreDiscountTotal().getCurrency();
        return new Money(sale.getPreDiscountTotal().getAmount().multiply(new BigDecimal((100-percentage)/100)),currency);

    }

}



