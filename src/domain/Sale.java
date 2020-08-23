/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import customTypes.CurrencyException;
import customTypes.Money;


public class Sale {

    private Customer customer;
    private ISalePricingStrategy ps;
 
    private List<SalesLineItem> lineItems = new ArrayList<>();
    private Date date = new Date(); // we should understand time.

    public Date getDate() {
        return date; //we will use customersfactory for create if clause.
    }
    private boolean isComplete = false;
    private Payment payment;
    private final Tax tax = new Tax();

    public Sale() {
        ps = PricingStrategyFactory.getInstance().getSalePricingStrategy();
        
        
    }


    
    public void enterCustomerForDiscount(Customer c) {
        customer = c;
        
  // when we have customer's type we will add to factory this discount. when we add this type we will understand discount from percentage class.
        PricingStrategyFactory.getInstance().addCustomerPricingStrategy(this);
        

        
    }
    


    public Money getBalance() {
             
        return payment.getAmount().minus(getTotal()); //It gives balance
    }

    public void becomeComplete() {
        isComplete = true; //Sale's finish flag.
    }

    public boolean isComplete() {
        return isComplete; // we get iscomplete.
    }

    public String makeLineItem(ProductDescription desc, int quantity) throws CurrencyException {
        SalesLineItem sl = new SalesLineItem(desc, quantity);
        String slString = sl.toString();
        if (lineItems.size() > 0) { //if our list have item
            Currency firstItemCurrency = lineItems.get(0).getSubTotal().getCurrency();
            if (firstItemCurrency == desc.getPrice().getCurrency()) {//when we try to add item, we will look item's type
                lineItems.add(sl);
            } else {
                throw new CurrencyException();
            }
        } else {
            lineItems.add(sl);
        }
        return slString;
    }

    public Money getPreDiscountTotal() {
        
        //In this method, we use discount for special customer.
        Money total = new Money();
        Money subTotal = null;

        for (SalesLineItem lineItem : lineItems) {
            subTotal = lineItem.getSubTotal();
            total = total.add(subTotal);
        }
        
        
        
        total.toString();
        return total; //we return totalmoney of list
    }
  
    public Money getsubtotals(){
        
        //In this method, we use discount for special product
        Money turn=new Money(0);
        Money abcd=null;
        for (SalesLineItem lineItem : lineItems) {
            
           abcd=lineItem.getSubTotal(); // we did no forget to add special product's discount.
           turn= turn.add(abcd);
        }
        return turn;
    }
    public Money getTotal() {
          
        return ps.getTotal(this);
        //  return pFactory.getSalePricingStrategy(20).getTotal(this);

        //Tax calculation
        /*tax.setTaxAmount(total);
        total = total.add(tax.getTaxAmount()); */
        //return total;
       
        
        
        
    }

    public ISalePricingStrategy getSalePricingStrategy() {
                
        return ps;
    }

    public void makePayment(Money cashTendered) {
        payment = new Payment(cashTendered);
    }
    
    @Override
    public String toString() {
        Money totalWithoutTax = new Money();
        Money subTotal = null;
        
        
        String s = "Date: " + date.toString() + "\n";
        
        Iterator i = lineItems.iterator();
        while (i.hasNext()) {
            SalesLineItem sli = (SalesLineItem) i.next();
            s += sli.toString();
            subTotal = sli.getSubTotal();
            
            //subTotal
            totalWithoutTax = totalWithoutTax.add(subTotal);
        }
            
        
        s += "\n";
        s += "Total (without tax): " + totalWithoutTax + "\n";
        s += "Total (customer discount and threshold discount): " + getTotal() + "\n";      
        s += "(Tax Amount:" + tax.getTaxAmount() + ")\n";

        if (payment != null) {
            s += "Payment: " + payment.toString() + "\n";
            s += "Balance: " + getBalance() + "\n"; // In this area if you see + money, you will get money. But if you see - money, you need to pay some more.
        }
        s += "--------------------------------------\n";
        return s;
    }

    public List<SalesLineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<SalesLineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
