/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;


import fileOperations.SaleFileOperator;
import java.util.ArrayList;
import java.util.List;

public class Store {

    private ProductCatalog catalog = new ProductCatalog();
    private Register register = new Register(catalog, this);
    private List<Sale> completedSales = new ArrayList<>();
    SaleFileOperator sfo = new SaleFileOperator("Sales.txt");

    public Register getRegister() {
        return register;
    }

    public void addSale(Sale s) {
        completedSales.add(s);
        saveSale(s);
    }

    public void saveSale(Sale s) {
        sfo.saveSale(s);
    }

    public Customer getCustomer(String custID) {
        Customer customer = new Customer(custID);
        return customer;
    }
}
