/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NUWAA
 */
public class CheckExpiryDate implements Chain{
    
    private Chain nextInChain;

    @Override
    public void nextChain(Chain nextChain) {
         this.nextInChain = nextChain;
    }

    @Override
    public String validate(CardDetails request) {
       String value = "false";
        
        if (request.getValidation().equals("expiryDate")) {
           
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy");
            try {
                Date expiryDate = simpleDateFormat.parse(request.getDetail());               
                Date today = new Date();           
                boolean isexpired = expiryDate.after(today);
                if (isexpired) {
                    value = "true";
                }               
            } catch (ParseException ex) {
                Logger.getLogger(CheckExpiryDate.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            value = this.nextInChain.validate(request);
        }        

        return value;
    }
    
}
