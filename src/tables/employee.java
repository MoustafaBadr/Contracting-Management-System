package tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author mostafa
 */
public class employee {

    
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty phone;
    private StringProperty email;
    private StringProperty Salary;
    private StringProperty address;
    private StringProperty state;
    private StringProperty jop;

    public employee( String firstName, String lastName, String phone, String Salary, String email, String address, String state, String jop) {

       
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.phone = new SimpleStringProperty(phone);
        this.email = new SimpleStringProperty(email);
        this.Salary = new SimpleStringProperty(Salary);
        this.address = new SimpleStringProperty(address);
        this.state = new SimpleStringProperty(state);
        this.jop = new SimpleStringProperty(jop);

    }

   

    public StringProperty firstName() {
        return firstName;
    }

    public StringProperty lastName() {
        return lastName;
    }

    public StringProperty phone() {
        return phone;
    }

    public StringProperty email() {
        return email;
    }

    public StringProperty Salary() {
        return Salary;
    }

    public StringProperty address() {
        return address;
    }

    public StringProperty state() {
        return state;
    }

    public StringProperty jop() {
        return jop;
    }

   

   

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(StringProperty firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(StringProperty lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone.get();
    }

    public void setPhone(StringProperty phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(StringProperty email) {
        this.email = email;
    }

    public String getSalary() {
        return Salary.get();
    }

    public void setSalary(StringProperty Salary) {
        this.Salary = Salary;
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(StringProperty address) {
        this.address = address;
    }

    public String getState() {
        return state.get();
    }

    public void setState(StringProperty state) {
        this.state = state;
    }

    public String getJop() {
        return jop.get();
    }

    public void setJop(StringProperty jop) {
        this.jop = jop;
    }

}
