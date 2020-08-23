/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customTypes;



public class CurrencyException extends Exception {
    public CurrencyException(){
        super("Product currencies must be same in order to be in the same sale");
    }
}
