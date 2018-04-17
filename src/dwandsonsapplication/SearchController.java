/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dwandsonsapplication;

//import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
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

/**
 * FXML Controller class
 *
 * @author Brandon Walker
 */
public class SearchController implements Initializable {

    @FXML
    private TextField searchByText;
    @FXML
    private Button apply;
    @FXML
    private ComboBox searchBy;
    
    
    
   ObservableList<UserDetails> userData;
   TableView table;
    
    public void receiveList(ObservableList<UserDetails> list){
        this.userData = list;    
    }
    public void receiveTable(TableView t){
        this.table = t;
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        searchBy.getItems().removeAll(searchBy.getItems());
        searchBy.getItems().addAll("First Name", "Last Name", "City", "Phone", "AccountNum");
    }    

    @FXML
    private void searchField(ActionEvent event) {
        FilteredList<UserDetails> filteredData = new FilteredList<>(userData, p -> true);    
    
            switch (searchBy.getSelectionModel().getSelectedItem().toString())//Switch on choiceBox value
                {
                    case "First Name":
                        filteredData.setPredicate(p -> p.getFirstName().toLowerCase().contains(searchByText.getText().toLowerCase().trim()));//filter table by first name
                        table.setItems(filteredData);
                        break;
                    case "Last Name":
                        filteredData.setPredicate(p -> p.getLastName().toLowerCase().contains(searchByText.getText().toLowerCase().trim()));//filter table by first name
                        table.setItems(filteredData);

                        break;
    //                case "Address":
    //                    filteredData.setPredicate(p -> p.getAddress().toLowerCase().contains(searchByText.getText().toLowerCase().trim()));//filter table by first name
    //                    break;
                    case "City":
                        filteredData.setPredicate(p -> p.getCity().toLowerCase().contains(searchByText.getText().toLowerCase().trim()));
                        table.setItems(filteredData);
                        break;
                    case "Phone":
                        filteredData.setPredicate(p -> p.getPhoneNum().toLowerCase().contains(searchByText.getText().toLowerCase().trim()));
                        table.setItems(filteredData);
                        break;
                    case "AccountNum":
                        filteredData.setPredicate(p -> String.valueOf(p.getAccountNum()).contains(searchByText.getText().trim()));
                        table.setItems(filteredData);
                        break;
}
    }
    
}
