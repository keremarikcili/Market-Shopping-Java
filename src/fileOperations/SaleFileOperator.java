/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileOperations;

import domain.Sale;
import java.io.FileOutputStream;
import java.io.IOException;


public class SaleFileOperator {
    private String filePath;

    public SaleFileOperator(String filePath){
        this.filePath = filePath;
    }

    public void saveSale(Sale sale){
        try {
            FileOutputStream fout = new FileOutputStream(filePath,true);
            String s = sale.toString();
            byte b[] = s.getBytes();//converting string into byte array
            fout.write(b);
            fout.close();
            System.out.println("Sale has been saved");
        }
        catch (IOException e){
            System.out.println(e.toString());
        }

    }
}
