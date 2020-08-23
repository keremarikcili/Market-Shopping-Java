/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import customTypes.Money;

/**
 *
 * @author emredursun
 */
public interface ISaleItemPricingStrategy {

    public Money GetSubTotal(Money amount);
    
    public float getPercentage();
    
}
