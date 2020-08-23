/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customTypes;



import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;

public class Money implements Serializable {
    //public static Currency getInstance(String currencyCode)-> currencyCode - the ISO 4217 code of the currency
    private static Currency DEFAULT_CURRENCY = Currency.getInstance("EUR");

    private BigDecimal amount;
    private Currency currency;

    public Money(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Money() {
        this(BigDecimal.ZERO, DEFAULT_CURRENCY);
    }

    public Money(int amount){
        this(new BigDecimal(amount), DEFAULT_CURRENCY);
    }

    public Money(double amount){
        this(BigDecimal.valueOf(amount), DEFAULT_CURRENCY);
    }

    public Money(BigDecimal amount) {
        this(amount, DEFAULT_CURRENCY);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;

    }

    public Money add(Money m)  {
        return new Money(amount.add(m.amount), currency);
    }

    public Money minus(Money m) {
        return new Money(amount.subtract(m.amount), currency);
    }

    public Money times(int k) {
        BigDecimal factor = new BigDecimal(k);
        return new Money(amount.multiply(factor), currency);
    }

    public Money times(double d) {
        BigDecimal factor = new BigDecimal(d);
        return new Money(amount.multiply(factor), currency);
    }
    
    public float divide(Money m){
        float factor = m.getAmount().floatValue();
        
        
        
        return (amount.floatValue()-factor)/amount.floatValue();
    }
    
    public Money min(Money lowestTotal){
        if(lowestTotal.getAmount().compareTo(amount)<0){
            amount = lowestTotal.getAmount();
        }
        return this;
    }
    public Money max(Money highestTotal){
        if(highestTotal.getAmount().compareTo(amount)>0){
            amount= highestTotal.getAmount();
        }
        return this;
    }

    @Override
    public String toString() {
        return String.format("%.4f", amount) + " " + currency.toString();
    }


}
