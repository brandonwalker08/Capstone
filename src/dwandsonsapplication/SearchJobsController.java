/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dwandsonsapplication;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author Brandon Walker
 */
public class SearchJobsController implements Initializable {

    @FXML
    private TextField searchByTextJobs;
    @FXML
    private Button applyJobs;
    @FXML
    private ComboBox searchByJobs;
    
    
    TableView table;

    ObservableList<JobDetails> userData;

    /**
     * Initializes the controller class.
     */
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        searchByJobs.getItems().removeAll(searchByJobs.getItems());
        searchByJobs.getItems().addAll("Job Description", "Job Time/Place");
        
        
//        searchByTextJobs.setOnKeyReleased(KeyEvent ->{
//            searchFieldJobs(KeyEvent);
//        });
        
   }
            

    @FXML
    private void searchFieldJobs(){
        
    FilteredList<JobDetails> filteredData = new FilteredList<>(userData, p -> true);    
    
            switch (searchByJobs.getSelectionModel().getSelectedItem().toString())//Switch on choiceBox value
                {
                    case "Job Description":
                        filteredData.setPredicate(p -> p.getDescription().toLowerCase().contains(searchByTextJobs.getText().toLowerCase().trim()));//filter table by first name
                        table.setItems(filteredData);
                        break;
                    case "Job Time/Place":
                        filteredData.setPredicate(p -> p.getDateTime().toLowerCase().contains(searchByTextJobs.getText().toLowerCase().trim()));//filter table by first name
                        table.setItems(filteredData);

                        break;
                }
        
    }
    
    
    public void receiveList(ObservableList<JobDetails> list){
        this.userData = list;    
    }
    public void receiveTable(TableView t){
        this.table = t;
        
    }
    
}



//
//ObservableList<UserDetails> userData;
//    
//    public void receiveList(ObservableList<UserDetails> list){
//        this.userData = list;    
//    }
//    public void receiveTable(TableView t){
//        this.table = t;
//        
//    }
//    
//    
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        searchBy.getItems().removeAll(searchBy.getItems());
//        searchBy.getItems().addAll("First Name", "Last Name", "City", "Phone", "AccountNum");
//        
//        
////        searchByText.setOnKeyReleased(KeyEvent ->{
////            searchField(KeyEvent);
////        });
//        
//   }
//            
//
//    @FXML
//    private void searchField(){
//        
//    FilteredList<UserDetails> filteredData = new FilteredList<>(userData, p -> true);    
//    
//            switch (searchBy.getSelectionModel().getSelectedItem().toString())//Switch on choiceBox value
//                {
//                    case "First Name":
//                        filteredData.setPredicate(p -> p.getFirstName().toLowerCase().contains(searchByText.getText().toLowerCase().trim()));//filter table by first name
//                        table.setItems(filteredData);
//                        break;
//                    case "Last Name":
//                        filteredData.setPredicate(p -> p.getLastName().toLowerCase().contains(searchByText.getText().toLowerCase().trim()));//filter table by first name
//                        table.setItems(filteredData);
//
//                        break;
//    //                case "Address":
//    //                    filteredData.setPredicate(p -> p.getAddress().toLowerCase().contains(searchByText.getText().toLowerCase().trim()));//filter table by first name
//    //                    break;
//                    case "City":
//                        filteredData.setPredicate(p -> p.getCity().toLowerCase().contains(searchByText.getText().toLowerCase().trim()));
//                        table.setItems(filteredData);
//                        break;
//                    case "Phone":
//                        filteredData.setPredicate(p -> p.getPhoneNum().toLowerCase().contains(searchByText.getText().toLowerCase().trim()));
//                        table.setItems(filteredData);
//                        break;
//                    case "AccountNum":
//                        filteredData.setPredicate(p -> String.valueOf(p.getAccountNum()).contains(searchByText.getText().trim()));
//                        table.setItems(filteredData);
//                        break;
//}
        
 //   }
