
package controller;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Stockvo {
    private StringProperty prodectName;
    private IntegerProperty idstore;
    private IntegerProperty amount;
    private IntegerProperty supplierId;
    private IntegerProperty Price;
    private IntegerProperty ID_search;

    public void setProdectName(StringProperty prodectName) {
        this.prodectName = prodectName;
    }

    public void setIdstore(IntegerProperty idstore) {
        this.idstore = idstore;
    }

    public void setAmount(IntegerProperty amount) {
        this.amount = amount;
    }

    public void setSupplierId(IntegerProperty supplierId) {
        this.supplierId = supplierId;
    }

    public void setPrice(IntegerProperty Price) {
        this.Price = Price;
    }

    public void setID_search(IntegerProperty ID_search) {
        this.ID_search = ID_search;
    }
    

    public Stockvo(Integer ID_search) {
        this.ID_search = new SimpleIntegerProperty(ID_search);
    }

    public Stockvo(Integer idstore, String prodectName,  Integer amount, Integer supplierId ,Integer Price) {
        this.prodectName = new SimpleStringProperty(prodectName);
        this.idstore = new SimpleIntegerProperty(idstore);
        this.amount = new SimpleIntegerProperty(amount);
        this.supplierId =   new SimpleIntegerProperty(supplierId);
        this.Price =   new SimpleIntegerProperty(Price);
    }

    public StringProperty prodectNameProperty() {
        return prodectName;
    }

    public IntegerProperty idstoreProperty() {
        return idstore;
    }

    public IntegerProperty amountProperty() {
        return amount;
    }

    public IntegerProperty supplierIdProperty() {
        return supplierId;
    }

    public IntegerProperty PriceProperty() {
        return Price;
    }

    public IntegerProperty ID_searchProperty() {
        return ID_search;
    }
    
    public String getPName() {
        return prodectName.get();
    }

    public Integer getidstore() {
        return idstore.get();
    }

    public Integer GetAmount() {
        return amount.get();
    }

    public Integer GetSupplierId() {
        return supplierId.get();
    }

    public Integer GetPrice() {
        return Price.get();
    }

    public Integer GetID_search() {
        return ID_search.get();
    }
    
    
    
    
    
    
    
    
}
