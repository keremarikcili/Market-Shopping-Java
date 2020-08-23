/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import customTypes.Money;
import java.math.BigDecimal;
import java.math.BigInteger;


public class SalesLineItem  {
    private int quantity;
    private ProductDescription description;
    float percent;
    public ISaleItemPricingStrategy Is;
    

    public SalesLineItem(ProductDescription desc, int quantity){
        this.description = desc;
        this.quantity = quantity;
               
        this.percent=enterproductfordiscount();
    }

    public float enterproductfordiscount(){
       return ProductPrincingStrategyFactory.getInstance().takeProductCustomerPricingStrategy(this.description);
        // we will cgange this factory method.
    }
    
    

    
 
    
    public Money getSubTotal(){
       
  
      // we design product's subtotalmoney.
        return ProductPrincingStrategyFactory.getInstance().getProductPercentage(description).GetSubTotal(new Money(description.getPrice().times(quantity).getAmount()));        
    }
    
   

    @Override
    public String toString(){
        return description.toString() + " (x" +quantity +") " + "(Subtotal: "  + getSubTotal()+")" + "\n";
    }

    public ProductDescription getDescription() {
        return description;
    }

    public void setDescription(ProductDescription description) {
        this.description = description;
    }
    


}
