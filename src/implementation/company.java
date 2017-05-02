/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

/**
 *
 * @author Mustafa
 */
public class company extends customer{
    
    
    
    public int computeDiscount(int percent , int payment1){
        payment = (int)(payment1-(percent*payment1/100));
        return payment;
        
    }
    
    
}
