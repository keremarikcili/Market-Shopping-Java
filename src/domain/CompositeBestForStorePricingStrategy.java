/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import customTypes.Money;
import java.util.Iterator;


public class CompositeBestForStorePricingStrategy extends CompositePricingStrategy{

    @Override
    public Money getTotal(Sale sale) {
       Money highestTotal = new Money(Integer.MIN_VALUE);
        for(Iterator i = strategies.iterator(); i.hasNext();){
            
         ISalePricingStrategy strategy = (ISalePricingStrategy)i.next();
       
         Money total = strategy.getTotal(sale);
        
             highestTotal =total.max(highestTotal);
       
        }
        return highestTotal;
    }
    
    
}

/*
 Money lowestTotal = new Money(Integer.MAX_VALUE);
        for (Iterator i = strategies.iterator(); i.hasNext();) {

            ISalePricingStrategy strategy = (ISalePricingStrategy) i.next();

            Money total = strategy.getTotal(sale);
            lowestTotal = total.min(lowestTotal);

        }
        return lowestTotal;
*/
