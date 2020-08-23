/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Iterator;
import customTypes.Money;
import java.util.List;


public class CompositeBestForCustomerPricingStrategy extends CompositePricingStrategy {

    @Override
    public Money getTotal(Sale sale) {

        Money lowestTotal = new Money(Integer.MAX_VALUE);
        
        
        ISalePricingStrategy strategy = null;
        
        for (Iterator i = strategies.iterator(); i.hasNext();) {

            strategy = (ISalePricingStrategy) i.next();
            
 
        }
        // In this class we designed diffrent from B part. In this design we can control Customers special discount
        
        Money total  = strategy.getTotal(sale); //Müşterinin tip oranıyla çarpılması  + ürünün kendinden gelen oran
        
        Money productPercentege=sale.getsubtotals();  // ürünün kendi oranın çarpılması 
                
        
        
           
       Money ProductPercentegeminus=new AbsoluteDiscountOverThresholdPricingStrategy(new Money(500), new Money(50)).getTotal(sale); // ürünün kendi oranında 50 çıkarılması
       

       
      total=total.minus(productPercentege.minus(ProductPercentegeminus));

       
       
           
        return total;
    }

    

    

}
