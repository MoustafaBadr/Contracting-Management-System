/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Smart
 */
public class SupplierVo {
     private StringProperty name;
    private StringProperty address;
    private StringProperty email;
    private StringProperty phone;
    private StringProperty timeline;
    private StringProperty payment;
    private StringProperty idSupplier;
    
    
    public SupplierVo (String ID_search) {
        this.idSupplier= new SimpleStringProperty(ID_search);
    }

    public SupplierVo (String idSupplier ,String name,String payment,String timeline,String address, String email,String phone) {
        this.name = new SimpleStringProperty(name);
        this.address = new SimpleStringProperty(address);
        this.email = new SimpleStringProperty(email);
        this.phone = new SimpleStringProperty(phone);
        this.timeline = new SimpleStringProperty(timeline);
        this.payment = new SimpleStringProperty(payment);
        this.idSupplier = new SimpleStringProperty(idSupplier);
        
    }

    public StringProperty getNameProperty() {
        return name;
    }

    public StringProperty getAddressProperty() {
        return address;
    }

    public StringProperty getEmailProperty() {
        return email;
    }

    public StringProperty getPhoneProperty(){
        return phone;
    }

    public StringProperty getTimelineProperty() {
        return timeline;
    }

    public StringProperty getPaymentProperty() {
        return payment;
    }

    public StringProperty getIdSupplierProperty() {
        return idSupplier;
    }

    public void setName(StringProperty name) {
        this.name = name;
    }

    public void setAddress(StringProperty address) {
        this.address = address;
    }

    public void setEmail(StringProperty email) {
        this.email = email;
    }

    public void setPhone(StringProperty phone) {
        this.phone = phone;
    }

    public void setTimeline(StringProperty timeline) {
        this.timeline = timeline;
    }

    public void setPayment(StringProperty payment) {
        this.payment = payment;
    }

    public void setIdSupplier(StringProperty idSupplier) {
        this.idSupplier = idSupplier;
    }
    
    
    public String GetName() {
        return name.get();
    }

    public String GetAddress() {
        return address.get();
    }

    public String GetEmail() {
        return email.get();
    }

    public String GetPhone() {
        return phone.get();
    }

    public String GetTimeline() {
        return timeline.get();
    }

    public String GetPayment() {
        return payment.get();
    }

    public String GetIdSupplier() {
        return idSupplier.get();
    }

 
    
}
