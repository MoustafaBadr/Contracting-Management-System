package tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author mostafa
 */
public class Workers {
     
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty state;
    private StringProperty jop;
    private StringProperty project;
    private StringProperty id;
    
    public Workers(String id, String firstName, String lastName, String state, String jop,String project) {

        
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.state = new SimpleStringProperty(state);
        this.jop = new SimpleStringProperty(jop);
         this.project = new SimpleStringProperty(project);
         this.id = new SimpleStringProperty(id);

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

    public String getState() {
        return state.get();
    }

    public void setState(StringProperty state) {
        this.state = state;
    }

    public String getJop() {
        return jop.get();
    }
     public String getId() {
        return id.get();
    }

    public void setJop(StringProperty jop) {
        this.jop = jop;
    }
    public void setId(StringProperty id) {
        this.id = id;
    }
    
    public String getProject() {
        return project.get();
    }

    public void setProject(StringProperty address) {
        this.project = address;
    }
   
 

    public StringProperty firstName() {
        return firstName;
    }

    public StringProperty lastName() {
        return lastName;
    }

    public StringProperty state() {
        return state;
    }

    public StringProperty jop() {
        return jop;
    }
     public StringProperty Id() {
        return id;
    }


      public StringProperty project() {
        return project;
    }

   
    
}
