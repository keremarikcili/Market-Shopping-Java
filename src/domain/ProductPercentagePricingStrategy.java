/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import customTypes.Money;
import java.math.BigDecimal;
import java.util.Currency;

/**
 *
 * @author emredursun
 */
public class ProductPercentagePricingStrategy implements ISaleItemPricingStrategy{
    
    private float percentage;

    public ProductPercentagePricingStrategy(float percentage) {
        this.percentage = percentage;
    }
    
    @Override
    public float getPercentage(){
        return this.percentage;
    }
    

    public ProductPercentagePricingStrategy() {
    }
   

    @Override
    public Money GetSubTotal(Money amount) {
        Currency currency=amount.getCurrency();
        return new Money(amount.getAmount().multiply(new BigDecimal((100-percentage)/100)),currency); //In this method  we will design product's total money.
    }
    
}
