/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;


public class PricingStrategyFactory {

    CompositeBestForCustomerPricingStrategy cBestForCustomer = new CompositeBestForCustomerPricingStrategy();
    private static PricingStrategyFactory instance;

    private PricingStrategyFactory() {

    }

    public static PricingStrategyFactory getInstance() {
        if (instance == null) {
            instance = new PricingStrategyFactory();
        }
        return instance;
    }

    public ISalePricingStrategy getCustomerPercentage(Customer c, Date date) {
        ISalePricingStrategy pct = null;
       
        // if customer's class is 1 and today is monday , we will execute this if.
        if (c.getCustomerID().equals("1") && date.toString().contains("Mon")) {
            pct = new PercentageDiscountPricingStrategy(10);
        }
       
        // İf our customer's class 2 we will execute this else-if.
        else if(c.getCustomerID().equals("2")){
             pct = new PercentageDiscountPricingStrategy(15);
        }else {
            pct = new PercentageDiscountPricingStrategy(0);
        }
        //İf customer dont have discount we will return null
        return pct;

    }

    public void addCustomerPricingStrategy(Sale sale) {
        
        if (getCustomerPercentage(sale.getCustomer(),sale.getDate()) != null) {
            cBestForCustomer.addStrategy(getCustomerPercentage(sale.getCustomer(),sale.getDate()));
        }
        //we will add to composite clas's list thid percentage.
    }
    
   

    public ISalePricingStrategy getSalePricingStrategy() {
        
        cBestForCustomer.addStrategy(new PercentageDiscountPricingStrategy(0));
        return cBestForCustomer;
        // In this method we have 0 percent discount.
    }
}
