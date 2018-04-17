/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dwandsonsapplication;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
/**
 *
 * @author Brandon Walker
 */
public class UserDetails {
    private final StringProperty name;
    private final StringProperty name2;
    private final StringProperty addy1;
//    private final StringProperty addy2;
//    private final StringProperty state;
//    private final IntegerProperty zip;
//    private final StringProperty phoneNum2;
//    private final StringProperty receiverNum;
//    private final StringProperty smartNum;
//    private final StringProperty superDish;
//    private final StringProperty dateCreated;
//    private final StringProperty serialNum;
//    private final StringProperty modelNum;
//    private final StringProperty comments;


    private final IntegerProperty accountNum;
    private final StringProperty phoneNum;
    private final StringProperty city;
    
    
    
    public UserDetails(String nme, String nme2, int account, String phone, String cty){
        this.name = new SimpleStringProperty(nme);
        this.name2 = new SimpleStringProperty(nme2);
        this.accountNum = new SimpleIntegerProperty(account);
        this.phoneNum = new SimpleStringProperty(phone);
        this.city = new SimpleStringProperty(cty);       
        
        
        //irrelevant
        this.addy1 = new SimpleStringProperty ("");
//        this.addy2 = new SimpleStringProperty(""); 
//        this.state = new SimpleStringProperty(""); 
//        this.zip = new SimpleIntegerProperty(0); 
//        this.phoneNum2 = new SimpleStringProperty(""); 
//        this.receiverNum = new SimpleStringProperty(""); 
//        this.smartNum = new SimpleStringProperty(""); 
//        this.superDish = new SimpleStringProperty(""); 
//        this.dateCreated = new SimpleStringProperty(""); 
//        this.serialNum = new SimpleStringProperty(""); 
//        this.modelNum = new SimpleStringProperty(""); 
//        this.comments = new SimpleStringProperty(""); 
                
    }
    
    
//    public UserDetails(String fn, String ln, String ad1, String ad2, String ct, String st,
//                        int zp, String p1, String p2, String rnum, int anum, String scnum,
//                        String sd, String dc, String sernum, String modnum, String comm){
//        
//        this.name = new SimpleStringProperty(fn);
//        this.name2 = new SimpleStringProperty(ln);
//        this.accountNum = new SimpleIntegerProperty(anum);
//        this.phoneNum = new SimpleStringProperty(p1);
//        this.city = new SimpleStringProperty(ct); 
//        
//        
//        this.addy1 = new SimpleStringProperty(ad1); 
//        this.addy2 = new SimpleStringProperty(ad2); 
//        this.state = new SimpleStringProperty(st); 
//        this.zip = new SimpleIntegerProperty(zp); 
//        this.phoneNum2 = new SimpleStringProperty(p2); 
//        this.receiverNum = new SimpleStringProperty(rnum); 
//        this.smartNum = new SimpleStringProperty(scnum); 
//        this.superDish = new SimpleStringProperty(sd); 
//        this.dateCreated = new SimpleStringProperty(dc); 
//        this.serialNum = new SimpleStringProperty(sernum); 
//        this.modelNum = new SimpleStringProperty(modnum); 
//        this.comments = new SimpleStringProperty(comm); 
//        
//        
//    }


    
    public String getName() {
        return (name.get() + " " + name2.get()) ;
    }
    public String getFirstName(){
        return name.get();
    }
    public String getLastName(){
        return name2.get();
    }
    

    public int getAccountNum() {
        return accountNum.get();
    }

    public String getPhoneNum() {
        return phoneNum.get();
    }

    public String getCity() {
        return city.get();
    }
    
    public void setName(String nm, String nm2){
        name.set(nm + " " + nm2);
    }
    
     public void setAccount(int ac){
        accountNum.set(ac);
    }
     
      public void setPhone(String ph){
        phoneNum.set(ph);
    }
      
      
      
      
    public String getAddy1() {
        return addy1.get();
    }
//
//    public String getAddy2() {
//        return addy2.get();
//    }
//
//    public String getState() {
//        return state.get();
//    }
//
//    public int getZip() {
//        return zip.get();
//    }
//
//    public String getPhoneNum2() {
//        return phoneNum2.get();
//    }
//
//    public String getReceiverNum() {
//        return receiverNum.get();
//    }
//
//    public String getSmartNum() {
//        return smartNum.get();
//    }
//
//    public String getSuperDish() {
//        return superDish.get();
//    }
//
//    public String getDateCreated() {
//        return dateCreated.get();
//    }
//
//    public String getSerialNum() {
//        return serialNum.get();
//    }
//
//    public String getModelNum() {
//        return modelNum.get();
//    }
//
//    public String getComments() {
//        return comments.get();
//    }
      
    
}
