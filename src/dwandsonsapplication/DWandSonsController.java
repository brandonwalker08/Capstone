/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dwandsonsapplication;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import javafx.collections.ObservableList;
import javafx.collections.*;
import javafx.collections.transformation.FilteredList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Brandon Walker
 */
public class DWandSonsController implements Initializable {
    
   
    @FXML
    MenuItem select;
    @FXML
    MenuItem findRec;
    @FXML
    MenuItem findJob;
    @FXML
    ImageView dishNetwork;
    @FXML
    ImageView direcTV;
    @FXML
    TextField fname;
    @FXML
    TextField lname;
    @FXML
    TextField address;
    @FXML
    TextField city;
    @FXML
    TextField state;
    @FXML
    TextField zip;
    @FXML
    TextField phone1;
    @FXML
    TextField phone2;
    @FXML
    TextField receiverNum;
    @FXML
    TextField smartCardNum;
    @FXML
    TextField superDish;
    @FXML
    TextField serialNum;
    @FXML
    TextField date;
    @FXML
    TextField modelNum;
    @FXML
    TextArea comment;
    @FXML
    TextField accountNum;
    @FXML 
    TableView<UserDetails> viewTable;
    @FXML
    TableColumn<UserDetails, String> columnName;
    @FXML
    TableColumn<UserDetails, Integer> columnAccount;
    @FXML
    TableColumn<UserDetails, String> columnPhone;
    @FXML
    TableColumn<UserDetails, String> columnCity;
   
    @FXML
    TableView<JobDetails> jobs;
    @FXML
    TableColumn<JobDetails, String> descript;
    @FXML
    TableColumn<JobDetails, String> timePlace;
    
    @FXML
    TextField jobDescript;
    @FXML
    TextField dateOrTime;
    @FXML
    Button addJobButton;
    @FXML
    Button removeJobButton;
    @FXML
    Button refresh;
    @FXML
    Button refreshJobs;

    
    
    ObservableList<UserDetails> data;
    ObservableList<JobDetails> jobsData;
    DatabaseConnection dbc;
    
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        dbc = new DatabaseConnection();
        loadDataFromDatabase();
        loadJobDataFromDatabase();
        
        
    viewTable.setOnMouseClicked((MouseEvent event) -> {
    if (event.getClickCount() > 1) {
        fillTextFields();
    }
    });
    
    jobs.setOnMouseClicked((MouseEvent event1) -> {
        if (event1.getClickCount() > 1 ){
            fillJobFields();
        }
    });
    
    refresh.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent e) {
            loadDataFromDatabase();
        }
    });
     refreshJobs.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent e) {
            loadJobDataFromDatabase();
        }
    });
            
    }    
    
    
    
    
    
    @FXML
    private void handleAddButtonAction(){
        String first = fname.getText();
        String last = lname.getText();
        String address1 = address.getText();
        String city1 = city.getText();
        String state1 = state.getText();
        
        int zip1;
        if(zip.getText().equals("")){
            zip1 = 0;
        }
        else{
            zip1 = Integer.parseInt(zip.getText());
        }
        String phone11 = phone1.getText();
        String phone21 = phone2.getText();
        String receiver= receiverNum.getText();
        String smartCard = smartCardNum.getText();
        String superDish1 = superDish.getText();
        String serial = serialNum.getText();
        String date1 = date.getText();
        String model = modelNum.getText();
        String comments = comment.getText();
        int account;
        if(accountNum.getText().equals("")){
            Random r = new Random();
            account = r.nextInt(2000001);
        }
        else{
            account = Integer.parseInt(accountNum.getText());
        }  
        Connection connect;
        Statement stmt = null;

        try{
            connect = dbc.connect();
            stmt = connect.createStatement();
            String query = "INSERT INTO Customer VALUES('"+first+"','"+last+"','"+address1+"','"+""+"','"+city1+"','"+state1+"','"+zip1+"','"+phone11+"','"+phone21+"','"+receiver+"','"+smartCard+"','"+superDish1+"','"+serial+"','"+date1+"','"+model+"','"+comments+"','"+account+"')";
            stmt.executeUpdate( query);
            connect.close();       
            loadDataFromDatabase();
        } catch (SQLException e){
            System.out.println(e.getMessage() + " error ");
            Alert a = new Alert(AlertType.ERROR, "Account Number already used, please try again");
            a.show();
          }
    }
    
    @FXML
    public void handleDeleteButtonAction(){
        
        
        Alert alert = new Alert(AlertType.CONFIRMATION, "Delete this record?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            try{
            Connection connect = dbc.connect();
            Statement stmt = connect.createStatement();
            stmt.executeUpdate("DELETE FROM Customer WHERE AccountNum IS "+accountNum.getText()); //DELETE FROM Customer WHERE AccountNum IS 0            
            connect.close();
            }
            catch(SQLException e){
                System.out.println(e.getMessage() + "    error ");
            }
            
            loadDataFromDatabase();
        }
        
        
        fname.clear();
        lname.clear();
        accountNum.clear();
        city.clear();
        phone1.clear();
        address.clear();
        state.clear();
        phone2.clear();
        zip.clear();
        receiverNum.clear();
        smartCardNum.clear();
        superDish.clear();
        date.clear();
        serialNum.clear();
        modelNum.clear();
        comment.clear();
    }
    
    @FXML
    public void handleEditButtonAction(){
        
           try{
            Connection connect = dbc.connect();
            Statement stmt = connect.createStatement();
            stmt.executeUpdate("DELETE FROM Customer WHERE AccountNum IS "+accountNum.getText()); //DELETE FROM Customer WHERE AccountNum IS 0            
            connect.close();
            }
            catch(SQLException e){
                System.out.println(e.getMessage() + "    error ");
            }
            
        loadDataFromDatabase();
        handleAddButtonAction();
    }
    
    @FXML
    public void aboutDialog(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Doug Walker & Sons Portal");
        alert.setContentText("The Doug Walker and Sons Portal is designed to manage customer information for Doug Walker & Sons Inc. It was developed in the Spring of 2018 by Brandon Walker");
                //, "Delete this record?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();
    }
    
    @FXML
    public void selectRecords() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Filter.fxml"));
            Parent root = loader.load();
            FilterController controller = loader.<FilterController>getController();
            controller.receiveList(data);
            controller.receiveTable(viewTable);     
            Stage stage = new Stage();
            stage.setTitle("Filter Customers");
             Scene s = new Scene(root);
            stage.setScene(s);
            stage.show();
         // Hide this current window (if this is what you want)
         //((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
     }
    
    @FXML
    public void findCustomer(){
        
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("search.fxml"));
            Parent root = loader.load();
            SearchController controller = loader.<SearchController>getController();
            controller.receiveList(data);
            controller.receiveTable(viewTable);           
            Stage stage = new Stage();
            stage.setTitle("Search Customers");
            Scene s = new Scene(root);
            stage.setScene(s);
            stage.show();
           
         
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    @FXML 
    public void findJob(){
      
         try {
             
            FXMLLoader loader = new FXMLLoader(getClass().getResource("searchJobs.fxml"));
            Parent root = loader.load();
            SearchJobsController controller = loader.<SearchJobsController>getController();
            controller.receiveList(jobsData);
            controller.receiveTable(jobs);
            Stage stage = new Stage();
            stage.setTitle("Search Jobs");
             Scene s = new Scene(root);
            stage.setScene(s);
            stage.show();      
         
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
    }

  
    @FXML
    public void loadDataFromDatabase(){
       try{
            Connection connect = dbc.connect();
            data = FXCollections.observableArrayList();
            ResultSet rs = connect.createStatement().executeQuery("SELECT * FROM Customer;");
            while (rs.next()){
                data.add(new UserDetails(rs.getString(1), rs.getString(2), rs.getInt(17),rs.getString(8),rs.getString(5)));
            }
            connect.close();
        }
        catch(SQLException e){
            System.out.println("Error " + e);
        }
       
       
       columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
       columnAccount.setCellValueFactory(new PropertyValueFactory<>("AccountNum"));
       columnPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNum"));
       columnCity.setCellValueFactory(new PropertyValueFactory<>("city"));
       
       viewTable.setItems(data);
    }
    
    @FXML
    public void loadJobDataFromDatabase(){
        try{
            Connection connect = dbc.connect();
            jobsData = FXCollections.observableArrayList();
            ResultSet rs = connect.createStatement().executeQuery("SELECT * FROM Jobs;");
            while (rs.next()){
                jobsData.add(new JobDetails(rs.getString(2), rs.getString(3)));
            }     
            

            connect.close();
        }
        catch(SQLException e){
            
        }
        
       descript.setCellValueFactory(new PropertyValueFactory<>("description"));
       timePlace.setCellValueFactory(new PropertyValueFactory<>("dateTime"));
   
       jobs.setItems(jobsData);
    
    }
    
    
    
    
    @FXML
    public void addJob(ActionEvent event){

        String jobD = jobDescript.getText();
        String date = dateOrTime.getText();
        
        Connection connect;
        Statement stmt = null;

    try{
       connect = dbc.connect();
        stmt = connect.createStatement();
        ResultSet rs = connect.createStatement().executeQuery("SELECT * FROM Jobs ORDER BY jobID DESC LIMIT 1");
        int jobNum = rs.getInt(1) + 1;
        System.out.println(jobNum);
        String query = "INSERT INTO Jobs VALUES('"+jobNum+"','"+jobD+"','"+date+"')";
        stmt.executeUpdate( query);
        connect.close();
        
        
    } catch (SQLException e){
        //Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, e);
        System.out.println(e.getMessage() + " error ");
    }
    loadJobDataFromDatabase();
    }
   
    
    
    @FXML
    public void removeJob(ActionEvent event){        
         try{
            Connection connect = dbc.connect();
            Statement stmt = connect.createStatement();
            stmt.executeUpdate("DELETE FROM Jobs WHERE description IS '" +jobDescript.getText() + "'" + "AND dateTimePlace IS '" + dateOrTime.getText() + "'"); //+ " AND dateTimePlace IS " + dateOrTime.getText() ); //DELETE FROM Customer WHERE AccountNum IS 0            
            connect.close();
            }
            catch(SQLException e){
                System.out.println(e.getMessage() + "    error ");
            }
            jobDescript.clear();
            dateOrTime.clear();
            loadJobDataFromDatabase();
        
        
    }
    
    public void fillTextFields(){
        ResultSet rs;
        

// check the table's selected item and get selected item
        if (viewTable.getSelectionModel().getSelectedItem() != null) {
            UserDetails selectedPerson = viewTable.getSelectionModel().getSelectedItem();
            fname.setText(selectedPerson.getFirstName());
            lname.setText(selectedPerson.getLastName());
            accountNum.setText(String.valueOf(selectedPerson.getAccountNum()));
            city.setText(selectedPerson.getCity());
            phone1.setText(selectedPerson.getPhoneNum());
            
            try{
                Connection connect = dbc.connect();
                rs = connect.createStatement().executeQuery("SELECT * FROM Customer WHERE AccountNum IS '"+selectedPerson.getAccountNum()+"' ;");
                address.setText(rs.getString(3));
                state.setText(rs.getString(5));
                phone2.setText(rs.getString(9));
                zip.setText(String.valueOf(rs.getInt(7)));
                receiverNum.setText(rs.getString(10));
                smartCardNum.setText(rs.getString(11));
                superDish.setText(rs.getString(12));
                date.setText(rs.getString(13));
                serialNum.setText(rs.getString(14));
                modelNum.setText(rs.getString(15));
                comment.setText(rs.getString(16));
                connect.close();
            }
            catch(SQLException e){
                
            }
            
        }

    }
    
    public void fillJobFields(){
         if (jobs.getSelectionModel().getSelectedItem() != null) {
            JobDetails selectedJob = jobs.getSelectionModel().getSelectedItem();
            jobDescript.setText(selectedJob.getDescription());
            dateOrTime.setText(selectedJob.getDateTime());
        }
    }
    
    public void findJobs(){
        FilteredList<JobDetails> filteredJobs = new FilteredList<>(jobsData, p -> true);
       
    }
    @FXML
    public void importButtonAction(){
        Alert e = new Alert(AlertType.CONFIRMATION, "Are you sure you want to import information from customers.csv and jobs.csv to your database?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        e.showAndWait();

        if (e.getResult() == ButtonType.YES) {

            ImportExport i = new ImportExport();
            i.importToDB();
        }
    }
    @FXML
    public void exportButtonAction(){
       Alert e = new Alert(AlertType.CONFIRMATION, "Are you sure you want to export information from your database to customers.csv and jobs.csv?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        e.showAndWait();

        if (e.getResult() == ButtonType.YES) {

            ImportExport i = new ImportExport();
            i.exportToCSV();
        }
    }
    
    
        
}
