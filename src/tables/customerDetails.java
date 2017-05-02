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
public class customerDetails {
    
     private final StringProperty id;
    private final StringProperty name;
    private final StringProperty address;
    private final StringProperty tybe;
    private final StringProperty payment;
    private final StringProperty phone;
    private final StringProperty email;
    
    public customerDetails(String id , String name,String address,String phone,String payment,String email,String tybe){
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.address = new SimpleStringProperty(address);
        this.phone = new SimpleStringProperty(phone);
        this.payment = new SimpleStringProperty(payment);
        this.email = new SimpleStringProperty(email);
        this.tybe = new SimpleStringProperty(tybe);
        
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

    public StringProperty phoneProperty() {
        return phone;
    }

    public StringProperty PaymentProperty() {
        return payment;
    }
    public StringProperty emailProperty() {
        return email;
    }
    public StringProperty tybeProperty() {
        return tybe;
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

    public String getPhone() {
        return phone.get();
    }

    public String getPayment() {
        return payment.get();
    }
    public String getEmail() {
        return email.get();
    }
    public String getTybe() {
        return tybe.get();
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
    public void setPhone(String date){
        this.phone.setValue(date);
    }
    public void setPayment(String Payment){
        this.payment.setValue(Payment);
    }
    public void setEmail(String email){
        this.email.setValue(email);
    }
    public void setTybe(String tybe){
        this.tybe.setValue(tybe);
    }
    
    
}
