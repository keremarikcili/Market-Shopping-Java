/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;


import customTypes.Money;
import java.util.ArrayList;
import customTypes.CurrencyException;
import customTypes.ItemID;

public class Register {
    
    private ProductCatalog catalog;
    private Sale currentSale;
    private Store store;
    
    public Register(ProductCatalog catalog, Store store) {
        this.catalog = catalog;
        this.store = store;
    }

    public void enterCustomerForDiscount(String custID) {
        Customer c = store.getCustomer(custID);
        currentSale.enterCustomerForDiscount(c);
        //we will call entercustomerfordiscount, we we have customer.
    }

   

    public void endSale() {
        currentSale.becomeComplete();
    }

    public String enterItem(ItemID id, int quantity) throws CurrencyException {
        ProductDescription desc = catalog.getProductDescription(id);
     
        return currentSale.makeLineItem(desc, quantity);
    }

    public void makeNewSale() {
        currentSale = new Sale();
    }

    public void makePayment(Money cashTendered) {
        currentSale.makePayment(cashTendered);
    }

    public ArrayList<String> getProductIds() {
        return catalog.getProductIds();
    }

    public String getSummary() {
        
        return currentSale.toString();
    }

    public void saveSale() {
        store.addSale(currentSale);
    }

}
