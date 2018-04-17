/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dwandsonsapplication;

/**
 *
 * @author Brandon Walker
 */



import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
public class JobDetails {
    
    private final StringProperty description;
    private final StringProperty dateTime;
    
    public JobDetails(String des, String time){
        this.description = new SimpleStringProperty(des);
        this.dateTime = new SimpleStringProperty(time);
    }

    public String getDescription() {
        return description.get();
    }

    public String getDateTime() {
        return dateTime.get();
    }
    
    public void setDescription(String d){
        description.set(d);
    }
    public void setDateTime(String t){
        dateTime.set(t);
    }
}
