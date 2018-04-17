/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dwandsonsapplication;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Brandon Walker
 */
public class FilterController implements Initializable {

    @FXML
    private TextArea field1Text;
    @FXML
    private TextArea field2Text;
    @FXML
    private RadioButton andOP;
    @FXML
    private RadioButton orOP;
    @FXML
    private CheckBox useSecField;
    @FXML
    private Button filter;
    @FXML
    private ComboBox field1;
    @FXML
    private ComboBox filter2;
    @FXML
    private ComboBox filter1;
    @FXML
    private ComboBox field2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){

        
    field1.getItems().removeAll(field1.getItems());
    field1.getItems().addAll("First Name", "Last Name", "City", "Phone", "AccountNum");
     
    field2.getItems().removeAll(field2.getItems());
    field2.getItems().addAll("First Name", "Last Name", "City", "Phone", "AccountNum");

    filter1.getItems().removeAll(filter1.getItems());
    filter1.getItems().addAll("Starts With", "Ends With", "Contains");

    filter2.getItems().removeAll(filter2.getItems());
    filter2.getItems().addAll("Starts With", "Ends With", "Contains");

     
  
        
    filter2.setDisable(true);
    field2.setDisable(true);
    andOP.setDisable(true);
    //orOP.setDisable(true);

    useSecField.selectedProperty().addListener(new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
          if(!useSecField.isSelected()){
                filter2.setDisable(true);
                field2.setDisable(true);
                andOP.setDisable(true);
                //orOP.setDisable(true);
         }
           if(useSecField.isSelected()){
                filter2.setDisable(false);
                field2.setDisable(false);
                andOP.setDisable(false);
                //orOP.setDisable(false);
           }
        }
    });


      
    }   
    @FXML
    private void filterResults(ActionEvent event) {
        if(!useSecField.isSelected()){
            filterOneField();
        }
        else{
            filterTwoFields();
        }
    }
    
    private void filterOneField(){
    
    FilteredList<UserDetails> filteredData = new FilteredList<>(userData, p -> true);    
    
    String ft1 = filter1.getSelectionModel().getSelectedItem().toString();
    switch (field1.getSelectionModel().getSelectedItem().toString())//Switch on choiceBox value
        {
            case "First Name":
                if(ft1.equals("Contains")){
                    filteredData.setPredicate(p -> p.getFirstName().toLowerCase().contains(field1Text.getText().toLowerCase().trim()));
                    table.setItems(filteredData);
                    break;
                }
                if(ft1.equals("Starts With")){
                    filteredData.setPredicate(p -> p.getFirstName().toLowerCase().startsWith(field1Text.getText().toLowerCase().trim()));
                    table.setItems(filteredData);
                    break;
                }

                if(ft1.equals("Ends With")){
                    filteredData.setPredicate(p -> p.getFirstName().toLowerCase().endsWith(field1Text.getText().toLowerCase().trim()));
                    table.setItems(filteredData);
                    break;
                }


            case "Last Name":
                if(ft1.equals("Contains")){
                    filteredData.setPredicate(p -> p.getLastName().toLowerCase().contains(field1Text.getText().toLowerCase().trim()));
                    table.setItems(filteredData);
                    break;
                }
                if(ft1.equals("Starts With")){
                    filteredData.setPredicate(p -> p.getLastName().toLowerCase().startsWith(field1Text.getText().toLowerCase().trim()));
                    table.setItems(filteredData);
                    break;
                }

                if(ft1.equals("Ends With")){
                    filteredData.setPredicate(p -> p.getLastName().toLowerCase().endsWith(field1Text.getText().toLowerCase().trim()));
                    table.setItems(filteredData);
                    break;
                }
            case "City":
                if(ft1.equals("Contains")){
                    filteredData.setPredicate(p -> p.getCity().toLowerCase().contains(field1Text.getText().toLowerCase().trim()));
                    table.setItems(filteredData);
                    break;
                }
                if(ft1.equals("Starts With")){
                    filteredData.setPredicate(p -> p.getCity().toLowerCase().startsWith(field1Text.getText().toLowerCase().trim()));
                    table.setItems(filteredData);
                    break;
                }

                if(ft1.equals("Ends With")){
                    filteredData.setPredicate(p -> p.getCity().toLowerCase().endsWith(field1Text.getText().toLowerCase().trim()));
                    table.setItems(filteredData);
                    break;
                }
            case "Phone":
                if(ft1.equals("Contains")){
                    filteredData.setPredicate(p -> p.getPhoneNum().toLowerCase().contains(field1Text.getText().toLowerCase().trim()));
                    table.setItems(filteredData);
                    break;
                }
                if(ft1.equals("Starts With")){
                    filteredData.setPredicate(p -> p.getPhoneNum().toLowerCase().startsWith(field1Text.getText().toLowerCase().trim()));
                    table.setItems(filteredData);
                    break;
                }

                if(ft1.equals("Ends With")){
                    filteredData.setPredicate(p -> p.getPhoneNum().toLowerCase().endsWith(field1Text.getText().toLowerCase().trim()));
                    table.setItems(filteredData);
                    break;
                }
            case "AccountNum":

                if(ft1.equals("Contains")){
                    filteredData.setPredicate(p -> String.valueOf(p.getAccountNum()).contains(field1Text.getText().trim()));
                    table.setItems(filteredData);
                    break;
                }
                if(ft1.equals("Starts With")){
                    filteredData.setPredicate(p -> String.valueOf(p.getAccountNum()).startsWith(field1Text.getText().trim()));
                    table.setItems(filteredData);
                    break;
                }

                if(ft1.equals("Ends With")){
                    filteredData.setPredicate(p -> String.valueOf(p.getAccountNum()).endsWith(field1Text.getText().trim()));
                    table.setItems(filteredData);
                    break;
                }
            }
        
    }
    
    private String[] helpHelper(UserDetails p){
        
     String fd1 = field1.getSelectionModel().getSelectedItem().toString();
     String fd2 = field2.getSelectionModel().getSelectedItem().toString();
     String option1;
     String option2; 
        
        if(fd1.equals("First Name") && fd2.equals("Last Name")){
              option1 = p.getFirstName();
              option2 = p.getLastName();
              String[] ar = {option1, option2};
              return ar;
        }
        else if(fd1.equals("First Name") && fd2.equals("City")){
              option1 = p.getFirstName();
              option2 = p.getCity();
              String[] ar = {option1, option2};
              return ar;       
        }
        else if(fd1.equals("First Name") && fd2.equals("Phone")){
              option1 = p.getFirstName();
              option2 = p.getPhoneNum();
              String[] ar = {option1, option2};
              return ar;       
        }
        else if(fd1.equals("First Name") && fd2.equals("Address")){
              option1 = p.getFirstName();
              option2 = p.getAddy1();
              String[] ar = {option1, option2};
              return ar;       
        }
        else if(fd1.equals("First Name") && fd2.equals("AccountNum")){
              option1 = p.getFirstName();
              option2 = String.valueOf(p.getAccountNum());
              String[] ar = {option1, option2};
              return ar;           }
        else if(fd1.equals("Last Name") && fd2.equals("First Name")){
              option1 = p.getLastName();
              option2 = p.getFirstName();
              String[] ar = {option1, option2};
              return ar;       
        }
        else if(fd1.equals("Last Name") && fd2.equals("City")){
              option1 = p.getLastName();
              option2 = p.getCity();
              String[] ar = {option1, option2};
              return ar;       
        }
        else if(fd1.equals("Last Name") && fd2.equals("Phone")){
              option1 = p.getLastName();
              option2 = p.getPhoneNum();
              String[] ar = {option1, option2};
              return ar;       
        }
        else if(fd1.equals("Last Name") && fd2.equals("Address")){
              option1 = p.getLastName();
              option2 = p.getAddy1();
              String[] ar = {option1, option2};
              return ar;      
        }
        else if(fd1.equals("Last Name") && fd2.equals("AccountNum")){
              option1 = p.getLastName();
              option2 = String.valueOf(p.getAccountNum());
              String[] ar = {option1, option2};
              return ar;           }
        else if(fd1.equals("City") && fd2.equals("Last Name")){
              option1 = p.getCity();
              option2 = p.getLastName();
              String[] ar = {option1, option2};
              return ar;
        }
        else if(fd1.equals("City") && fd2.equals("First Name")){
              option1 = p.getCity();
              option2 = p.getFirstName();
              String[] ar = {option1, option2};
              return ar;
        }
        else if(fd1.equals("City") && fd2.equals("Phone")){
              option1 = p.getCity();
              option2 = p.getPhoneNum();
              String[] ar = {option1, option2};
              return ar;
        }
        else if(fd1.equals("City") && fd2.equals("Address")){
              option1 = p.getCity();
              option2 = p.getAddy1();
              String[] ar = {option1, option2};
              return ar;
        }
        else if(fd1.equals("City") && fd2.equals("AccountNum")){
              option1 = p.getCity();
              option2 = String.valueOf(p.getAccountNum());
              String[] ar = {option1, option2};
              return ar;           
        }
        else if(fd1.equals("Address") && fd2.equals("Last Name")){
              option1 = p.getAddy1();
              option2 = p.getLastName();
              String[] ar = {option1, option2};
              return ar;
        }
        else if(fd1.equals("Address") && fd2.equals("City")){
              option1 = p.getAddy1();
              option2 = p.getCity();
              String[] ar = {option1, option2};
              return ar;
        }
        else if(fd1.equals("Address") && fd2.equals("Phone")){
              option1 = p.getAddy1();
              option2 = p.getPhoneNum();
              String[] ar = {option1, option2};
              return ar;
        }
        else if(fd1.equals("Address") && fd2.equals("First Name")){
              option1 = p.getAddy1();
              option2 = p.getFirstName();
              String[] ar = {option1, option2};
              return ar;
        }
        else if(fd1.equals("Address") && fd2.equals("AccountNum")){
              option1 = p.getAddy1();
              option2 = String.valueOf(p.getAccountNum());
              String[] ar = {option1, option2};
              return ar;           }
        else if(fd1.equals("Phone") && fd2.equals("Last Name")){
              option1 = p.getPhoneNum();
              option2 = p.getLastName();
              String[] ar = {option1, option2};
              return ar;
        }
        else if(fd1.equals("Phone") && fd2.equals("City")){
              option1 = p.getPhoneNum();
              option2 = p.getCity();
              String[] ar = {option1, option2};
              return ar;
        }
        else if(fd1.equals("Phone") && fd2.equals("First Name")){
              option1 = p.getPhoneNum();
              option2 = p.getFirstName();
              String[] ar = {option1, option2};
              return ar;
        }
        else if(fd1.equals("Phone") && fd2.equals("Address")){
              option1 = p.getPhoneNum();
              option2 = p.getAddy1();
              String[] ar = {option1, option2};
              return ar;
        }
        else if(fd1.equals("Phone") && fd2.equals("AccountNum")){
          option1 = p.getPhoneNum();
          option2 = String.valueOf(p.getAccountNum());
          String[] ar = {option1, option2};
          return ar;       
        }
        else if(fd1.equals("AccountNum") && fd2.equals("First Name")){
          option1 = String.valueOf(p.getAccountNum());
          option2 = p.getFirstName();
          String[] ar = {option1, option2};
          return ar;       
        }
        else if(fd1.equals("AccountNum") && fd2.equals("Address")){
          option1 = String.valueOf(p.getAccountNum());
          option2 = p.getAddy1();
          String[] ar = {option1, option2};
          return ar;       
        }
        else if(fd1.equals("AccountNum") && fd2.equals("Phone")){
          option1 = String.valueOf(p.getAccountNum());
          option2 = p.getPhoneNum();
          String[] ar = {option1, option2};
          return ar;       
        }
        else if(fd1.equals("AccountNum") && fd2.equals("City")){
          option1 = String.valueOf(p.getAccountNum());
          option2 = p.getCity();
          String[] ar = {option1, option2};
          return ar;       
        }
        else if(fd1.equals("AccountNum") && fd2.equals("Last Name")){
          option1 = String.valueOf(p.getAccountNum());
          option2 = p.getLastName();
          String[] ar = {option1, option2};
          return ar;       
        }          
        else{
            String[] ar = { "", ""};
            return ar;
        }
    }
    
    private void helpTwoFields(){
        FilteredList<UserDetails> filteredData = new FilteredList<>(userData, p -> true);    

        String ft1 = filter1.getSelectionModel().getSelectedItem().toString();
        String ft2 = filter2.getSelectionModel().getSelectedItem().toString();
        

        if(ft1.equals("Contains") && ft2.equals("Contains") ){
          filteredData.predicateProperty().bind(Bindings.createObjectBinding(() ->
          p -> helpHelper(p)[0].toLowerCase().contains(field1Text.getText().toLowerCase().trim())
                  && helpHelper(p)[1].toLowerCase().contains(field2Text.getText().toLowerCase().trim()), 
                   field1Text.textProperty(), field2Text.textProperty()));

           table.setItems(filteredData);
       }
       else if(ft1.equals("Contains") && ft2.equals("Starts With") ){
          filteredData.predicateProperty().bind(Bindings.createObjectBinding(() ->
          p -> helpHelper(p)[0].toLowerCase().contains(field1Text.getText().toLowerCase().trim())
                  && helpHelper(p)[1].toLowerCase().startsWith(field2Text.getText().toLowerCase().trim()), 
                   field1Text.textProperty(), field2Text.textProperty()));

           table.setItems(filteredData);
       }
       else if(ft1.equals("Contains") && ft2.equals("Ends With") ){
          filteredData.predicateProperty().bind(Bindings.createObjectBinding(() ->
          p -> helpHelper(p)[0].toLowerCase().contains(field1Text.getText().toLowerCase().trim())
                  && helpHelper(p)[1].toLowerCase().endsWith(field2Text.getText().toLowerCase().trim()), 
                   field1Text.textProperty(), field2Text.textProperty()));

           table.setItems(filteredData);
       }
       else if(ft1.equals("Starts With") && ft2.equals("Starts With") ){
          filteredData.predicateProperty().bind(Bindings.createObjectBinding(() ->
          p -> helpHelper(p)[0].toLowerCase().startsWith(field1Text.getText().toLowerCase().trim())
                  && helpHelper(p)[1].toLowerCase().startsWith(field2Text.getText().toLowerCase().trim()), 
                   field1Text.textProperty(), field2Text.textProperty()));

           table.setItems(filteredData);
       }
       else if(ft1.equals("Starts With") && ft2.equals("Contains") ){
          filteredData.predicateProperty().bind(Bindings.createObjectBinding(() ->
          p -> helpHelper(p)[0].toLowerCase().startsWith(field1Text.getText().toLowerCase().trim())
                  && helpHelper(p)[1].toLowerCase().contains(field2Text.getText().toLowerCase().trim()), 
                   field1Text.textProperty(), field2Text.textProperty()));

           table.setItems(filteredData);
       }
       else if(ft1.equals("Starts With") && ft2.equals("Ends With") ){
          filteredData.predicateProperty().bind(Bindings.createObjectBinding(() ->
          p -> helpHelper(p)[0].toLowerCase().startsWith(field1Text.getText().toLowerCase().trim())
                  && helpHelper(p)[1].toLowerCase().endsWith(field2Text.getText().toLowerCase().trim()), 
                   field1Text.textProperty(), field2Text.textProperty()));

           table.setItems(filteredData);
       }
       else if(ft1.equals("Ends With") && ft2.equals("Ends With") ){
          filteredData.predicateProperty().bind(Bindings.createObjectBinding(() ->
          p -> helpHelper(p)[0].toLowerCase().endsWith(field1Text.getText().toLowerCase().trim())
                  && helpHelper(p)[1].toLowerCase().endsWith(field2Text.getText().toLowerCase().trim()), 
                   field1Text.textProperty(), field2Text.textProperty()));

           table.setItems(filteredData);
       }
       else if(ft1.equals("Ends With") && ft2.equals("Starts With") ){
          filteredData.predicateProperty().bind(Bindings.createObjectBinding(() ->
          p -> helpHelper(p)[0].toLowerCase().endsWith(field1Text.getText().toLowerCase().trim())
                  && helpHelper(p)[1].toLowerCase().startsWith(field2Text.getText().toLowerCase().trim()), 
                   field1Text.textProperty(), field2Text.textProperty()));

           table.setItems(filteredData);
       }
       else if(ft1.equals("Ends With") && ft2.equals("Contains") ){
          filteredData.predicateProperty().bind(Bindings.createObjectBinding(() ->
          p -> helpHelper(p)[0].toLowerCase().endsWith(field1Text.getText().toLowerCase().trim())
                  && helpHelper(p)[1].toLowerCase().contains(field2Text.getText().toLowerCase().trim()), 
                   field1Text.textProperty(), field2Text.textProperty()));

           table.setItems(filteredData);
       }
     }
    private void filterTwoFields(){
        
  
     FilteredList<UserDetails> filteredData = new FilteredList<>(userData, p -> true);    
    
     String ft1 = filter1.getSelectionModel().getSelectedItem().toString();
     String ft2 = filter2.getSelectionModel().getSelectedItem().toString();
     String fd1 = field1.getSelectionModel().getSelectedItem().toString();
     String fd2 = field2.getSelectionModel().getSelectedItem().toString();
    
            if(fd1.equals("First Name") && fd2.equals("Last Name")){
                helpTwoFields();
            }
            else if(fd1.equals("First Name") && fd2.equals("City")){
                helpTwoFields();
            }
            else if(fd1.equals("First Name") && fd2.equals("Phone")){
                helpTwoFields();
            }
            else if(fd1.equals("First Name") && fd2.equals("Address")){
                helpTwoFields();
            }
            else if(fd1.equals("First Name") && fd2.equals("AccountNum")){
                helpTwoFields();
            }
            else if(fd1.equals("Last Name") && fd2.equals("First Name")){
                helpTwoFields();
            }
            else if(fd1.equals("Last Name") && fd2.equals("City")){
                helpTwoFields();
            }
            else if(fd1.equals("Last Name") && fd2.equals("Phone")){
                helpTwoFields();
            }
            else if(fd1.equals("Last Name") && fd2.equals("Address")){
                helpTwoFields();
            }
            else if(fd1.equals("First Name") && fd2.equals("AccountNum")){
                helpTwoFields();
            }
            else if(fd1.equals("City") && fd2.equals("Last Name")){
                helpTwoFields();
            }
            else if(fd1.equals("City") && fd2.equals("First Name")){
                helpTwoFields();
            }
            else if(fd1.equals("City") && fd2.equals("Phone")){
                helpTwoFields();
            }
            else if(fd1.equals("City") && fd2.equals("Address")){
                helpTwoFields();
            }
            else if(fd1.equals("First Name") && fd2.equals("AccountNum")){
                helpTwoFields();
            }
            else if(fd1.equals("Address") && fd2.equals("Last Name")){
                helpTwoFields();
            }
            else if(fd1.equals("Address") && fd2.equals("City")){
                helpTwoFields();
            }
            else if(fd1.equals("Address") && fd2.equals("Phone")){
                helpTwoFields();
            }
            else if(fd1.equals("Address") && fd2.equals("First Name")){
                helpTwoFields();
            }
            else if(fd1.equals("First Name") && fd2.equals("AccountNum")){
                helpTwoFields();
            }
            else if(fd1.equals("Phone") && fd2.equals("Last Name")){
                helpTwoFields();
            }
            else if(fd1.equals("Phone") && fd2.equals("City")){
                helpTwoFields();
            }
            else if(fd1.equals("Phone") && fd2.equals("First Name")){
                helpTwoFields();
            }
            else if(fd1.equals("Phone") && fd2.equals("Address")){
                helpTwoFields();
            }
            else if(fd1.equals("First Name") && fd2.equals("AccountNum")){
                helpTwoFields();
            }
            


            }
        
    
    
    
    
    TableView table;

    ObservableList<UserDetails> userData;
    
    public void receiveList(ObservableList<UserDetails> list){
        this.userData = list;    
    }
    public void receiveTable(TableView t){
        this.table = t;
        
    }
    
    
}



   