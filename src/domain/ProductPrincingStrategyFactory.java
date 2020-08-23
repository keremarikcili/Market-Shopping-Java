/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.List;



/**
 *
 * @author emredursun
 */
public class ProductPrincingStrategyFactory {
    
    
    
    
    private static ProductPrincingStrategyFactory instance;

    private ProductPrincingStrategyFactory() {

    }
    
     public static ProductPrincingStrategyFactory getInstance() {
        if (instance == null) {
            instance = new ProductPrincingStrategyFactory();
        }
        return instance;
    }
     
     public ISaleItemPricingStrategy getProductPercentage(ProductDescription desc) {
       ISaleItemPricingStrategy pct = null;
       if(desc!=null){
            if(desc.getDescription().equalsIgnoreCase("Somon")){
                 pct=new ProductPercentagePricingStrategy(10);
             }
              
               else if(desc.getDescription().equalsIgnoreCase("Bira")){
                 pct=new ProductPercentagePricingStrategy(9);
             }
             
               else if(desc.getDescription().equalsIgnoreCase("Sigara")){
                 pct=new ProductPercentagePricingStrategy(12);
             }
               else if(desc.getDescription().equalsIgnoreCase("Kola")){
                 pct=new ProductPercentagePricingStrategy(15);
             }
               else {
                   pct=new ProductPercentagePricingStrategy(0);
               }
           
       }else {
           pct=new ProductPercentagePricingStrategy(0);
       }
       

             
             //Some product have special discount.
         
         
         
         
         return pct;

    }
     
    public float takeProductCustomerPricingStrategy(ProductDescription desc) {
          
        if (getProductPercentage(desc) != null) {
            
           
           
        }
        return getProductPercentage(desc).getPercentage();
    }


}
