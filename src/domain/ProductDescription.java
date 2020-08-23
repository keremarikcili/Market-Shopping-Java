/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import customTypes.ItemID;
import customTypes.Money;


public class ProductDescription {
    private ItemID id;
    private Money price;
    private String description;
   

    public ProductDescription(ItemID id, Money price, String description){
        this.id=id;
        this.price =price;
        this.description =description;
       
    }

    public ItemID getITemID(){
        return id;
    }

    public Money getPrice(){

        return price;
    }

    public String getDescription(){
        return  description;
    }

    

    @Override
    public String toString(){
        return id.toString()+ " - "+ price.toString()+" - " + description;
    }



}
