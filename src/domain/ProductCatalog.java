/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;


import fileOperations.ProductDescriptionFileOperator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import customTypes.ItemID;

public class ProductCatalog {
    private Map<ItemID,ProductDescription> descriptions = new HashMap<>();
    
    
    ProductDescriptionFileOperator pfdo = new ProductDescriptionFileOperator("ProductDescriptions.txt");
//we will understand product's information.
    public ProductCatalog(){
        loadProdSpecs();
    }

    public ProductDescription getProductDescription(ItemID id){
        return descriptions.get(id);
    }

    public void loadProdSpecs(){
        pfdo.readFromFile();
        descriptions = pfdo.getDescriptions();
    }

    public ArrayList<String> getProductIds() {
        ArrayList<String> ids = new ArrayList<>();
        descriptions.forEach((key, value) -> ids.add(key.toString()));
        return ids;
    }
}