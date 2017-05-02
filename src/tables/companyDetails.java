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
public class companyDetails {
    
    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty address;
    private final StringProperty date;
    private final StringProperty payment;
    public companyDetails(String id , String name,String address,String date,String payment){
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.address = new SimpleStringProperty(address);
        this.date = new SimpleStringProperty(date);
        this.payment = new SimpleStringProperty(payment);
        
    }

    public StringProperty IdProperty() {
        return id;
    }

    public StringProperty NameProperty() {
        return name;
    }

    public StringProperty AddressProperty() {
        return address;
    }

    public StringProperty DateProperty() {
        return date;
    }

    public StringProperty PaymentProperty() {
        return payment;
    }
    public String getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public String getAddress() {
        return address.get();
    }

    public String getDate() {
        return date.get();
    }

    public String getPayment() {
        return payment.get();
    }
    public void setId(String id){
        this.id.setValue(id);
    }
    public void setName(String name){
        this.name.setValue(name);
    }
    public void setAddress(String address){
        this.address.setValue(address);
    }
    public void setDate(String date){
        this.date.setValue(date);
    }
    public void setPayment(String Payment){
        this.payment.setValue(Payment);
    }
    
}
