package tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author mostafa
 */
public class salary {
   
     private StringProperty firstName;
     private StringProperty lastName; 
     private StringProperty jop;
     private IntegerProperty Salary;

public salary( String firstName, String lastName, String jop, Integer Salary) {

       
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.jop = new SimpleStringProperty(jop);
        this.Salary = new SimpleIntegerProperty(Salary);
        
       

    }

public StringProperty firstName() {
        return firstName;
    }

    public StringProperty lastName() {
        return lastName;
    }
    
    
    public StringProperty jop() {
        return jop;
    }
     public IntegerProperty Salary() {
        return Salary;
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
    
     public String getJop() {
        return jop.get();
    }

    public void setJop(StringProperty jop) {
        this.jop = jop;
    }
    
    
     public int getSalary() {
        return Salary.get();
    }

    public void setSalary(IntegerProperty Salary) {
        this.Salary = Salary;
    }



}
