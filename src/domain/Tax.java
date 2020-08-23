/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import customTypes.Money;
// we dont need this class for now.
public class Tax  {
    private final double TAX_PERCENTAGE_DEFAULT = 10;

    private final double taxPercentage;
    private Money taxAmount;

    public Tax(double taxPercentage){
        this.taxPercentage = taxPercentage;
    }

    public Tax(){
        taxPercentage =TAX_PERCENTAGE_DEFAULT;
    }

    public Money getTaxAmount(){
        return taxAmount;
    }

    public void setTaxAmount(Money total){
        double factor= taxPercentage/100;
        taxAmount= total.times(factor);
    }
}

