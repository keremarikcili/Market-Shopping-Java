/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import customTypes.Money;


public class Payment {
    private Money amount;

    public Payment(Money cashTendered){
        amount=cashTendered;
    }

    public Money getAmount(){
        return amount;
    }

    public String toString(){
        return amount.toString();
    }
}
