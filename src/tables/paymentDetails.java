/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Mustafa
 */
public class paymentDetails {
    
    private final StringProperty name;
    private final StringProperty userName;
    private final StringProperty cash;
    private final StringProperty date;
    public paymentDetails(  String name,String userName,String date,String cash){
        
        this.name = new SimpleStringProperty(name);
        this.userName= new SimpleStringProperty(userName);
        this.date = new SimpleStringProperty(date);
        this.cash = new SimpleStringProperty(cash);
        
        
    }

    

    public StringProperty NameProperty() {
        return name;
    }
    
    
    public StringProperty userNameProperty() {
        return userName;
    }

    public StringProperty DateProperty() {
        return date;
    }

    public StringProperty cashProperty() {
        return cash;
    }
    

    public String getName() {
        return name.get();
    }
    
    
    public String getuserName() {
        return userName.get();
    }

    public String getDate() {
        return date.get();
    }

    public String getcash() {
        return cash.get();
    }
    
    public void setName(String name){
        this.name.setValue(name);
    }
  
    public void setuserName(String address){
        this.userName.setValue(address);
    }
    public void setDate(String date){
        this.date.setValue(date);
    }
    public void setcash(String Payment){
        this.cash.setValue(Payment);
    }
    
    
}
