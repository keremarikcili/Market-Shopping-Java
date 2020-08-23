/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.List;
import customTypes.Money;


public abstract class CompositePricingStrategy implements ISalePricingStrategy{
    protected List strategies = new ArrayList();

    @Override
    public abstract Money getTotal(Sale sale);
     // In this method , we should understand this, we will design this method in subclass of this class.
    
    public void addStrategy(ISalePricingStrategy s){
        strategies.add(s);
        // we will add information to strategy list
    }
    public void removeStrategy(ISalePricingStrategy s){
        strategies.remove(s);
        // The opposite of add method.
    }
    
}
