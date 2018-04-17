/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dwandsonsapplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 *
 * @author Brandon Walker
 */
public class ImportExport {
    
    
    public ImportExport(){
        
    }
    
    public void importToDB(){
        
        DatabaseConnection db = new DatabaseConnection();
        
        BufferedReader br = null;
        String line = "";
        int cnt = 0;
        try{
            br = new BufferedReader(new FileReader("C:\\DWAndSons\\customers.csv"));
            while ((line = br.readLine()) != null) {
                if(cnt == 0){
                    cnt++;
                }
                else{
                    String[] table = line.split(",");
                }
            } 
            
            Connection connect = db.connect();

            PreparedStatement delete = connect.prepareStatement("DELETE FROM Customer");
            delete.executeUpdate();
            System.out.println("Deleted");
            
            
            PreparedStatement stmt =
            connect.prepareStatement("insert into Customer (FirstName, LastName, Address1, Address2, City, State, ZIP, Phone1, Phone2, ReceiverNum, SmartCardNum, SuperDish, SerialNum, Date, ModelNum, AdditionalInfo, AccountNum) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            br = new BufferedReader(new FileReader("C:\\DWAndSons\\customers.csv"));
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] table = null;
               
                table = line.trim().split(",");

                if(table[0].equals("FirstName")){
                    System.out.println("Here");
                }
                else{
                    // set values to replace question marks in prepared statement
                    stmt.setString(1, table[0]);
                    stmt.setString(2, table[1]);
                    stmt.setString(3, table[2]);
                    stmt.setString(4, table[3]);
                    stmt.setString(5, table[4]);
                    stmt.setString(6, table[5]);
                    
                    String numS = table[6].trim();
                    Integer num = Integer.valueOf(numS.replaceAll("^\"|\"$", ""));
                    stmt.setInt(7, num);
                    
                    stmt.setString(8, table[7]);
                    stmt.setString(9, table[8]);
                    stmt.setString(10, table[9]);
                    stmt.setString(11, table[10]);
                    stmt.setString(12, table[11]);
                    stmt.setString(13, table[12]);
                    stmt.setString(14, table[13]);
                    stmt.setString(15, table[14]);
                    stmt.setString(16, table[15]);
                    
                    String numA = table[16].trim();
                    Integer numAN = Integer.valueOf(numA.replaceAll("^\"|\"$", ""));
                     stmt.setInt(17,numAN);
                }
                
                 System.out.println("Statement Finshed, executing now");
           
                stmt.executeUpdate(); // insert data into table       
                System.out.println("populated?");
             }
           
        }
            
           
        catch(Exception e){
            System.out.println(e.getMessage() + "     error");
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
       
        
        //JOBS
        try{
            br = new BufferedReader(new FileReader("C:\\DWAndSons\\jobs.csv"));
            while ((line = br.readLine()) != null) {
                if(cnt == 0){
                    cnt++;
                }
                else{
                    String[] table = line.split(",");
                }
            } 
            
            Connection connect = db.connect();

            PreparedStatement delete = connect.prepareStatement("DELETE FROM Jobs");
            delete.executeUpdate();
            System.out.println("Deleted");
            
            
            PreparedStatement stmt =
            connect.prepareStatement("insert into Jobs (jobID, description, dateTimePlace) values (?, ?, ?)");
            br = new BufferedReader(new FileReader("C:\\DWAndSons\\jobs.csv"));
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] table = null;
               
                table = line.trim().split(",");

                if(table[0].equals("FirstName")){
                    System.out.println("Here");
                }
                else{
                    // set values to replace question marks in prepared statement
                    String numA = table[0].trim();
                    Integer numAN = Integer.valueOf(numA.replaceAll("^\"|\"$", ""));
                    stmt.setInt(1,numAN);
                    stmt.setString(2, table[1]);
                    stmt.setString(3, table[2]);

                }
                
                 System.out.println("Statement Finshed, executing now");
           
                stmt.executeUpdate(); // insert data into table       
                System.out.println("populated?");
             }
           
        }
            
           
        catch(Exception e){
            System.out.println(e.getMessage() + "     error");
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        
        
    
    }
    public void exportToCSV(){
        //CSVWriter csvWrite = new CSVWriter(new FileWriter(file));
        DatabaseConnection db = new DatabaseConnection();
        Connection connect = db.connect();
   
        try{

                
                Statement stmt = connect.createStatement();
                ResultSet rs = connect.createStatement().executeQuery("SELECT * FROM Customer");
            //String query = "INSERT INTO Jobs VALUES('"+jobNum+"','"+jobD+"','"+date+"')";
              //  connect.close();


                //CSVWriter writer = new CSVWriter(new FileWriter("customers.csv"), ',');
                PrintWriter csvWriter = new PrintWriter(new File("C:\\DWAndSons\\customers.csv"));
                ResultSetMetaData meta = rs.getMetaData() ; 

                int numberOfColumns = meta.getColumnCount() ; 
                System.out.println(numberOfColumns);
                String dataHeaders = "\"" + meta.getColumnName(1) + "\"" ; 
                for (int i = 2 ; i < numberOfColumns + 1 ; i ++ ) { 
                    dataHeaders += ",\"" + meta.getColumnName(i).replaceAll("\"","\\\"") + "\"" ;
                }
                csvWriter.println(dataHeaders) ;
                while (rs.next()) {
                    String row = "\"" + rs.getString(1).replaceAll("\"","\\\"") + "\""  ; 
                    for (int i = 2 ; i < numberOfColumns + 1 ; i ++ ) {
                        row += ",\"" + rs.getString(i).replaceAll("\"","\\\"") + "\"" ;
                    }  
                    csvWriter.println(row) ;
                }
                csvWriter.flush();
                csvWriter.close(); 

            }



            catch(Exception e){
                System.out.println(e.getMessage() + "   Error");
            }
        
            try{

                Statement stmt = connect.createStatement();
                ResultSet rs = connect.createStatement().executeQuery("SELECT * FROM Jobs");
            //String query = "INSERT INTO Jobs VALUES('"+jobNum+"','"+jobD+"','"+date+"')";
              //  connect.close();


                //CSVWriter writer = new CSVWriter(new FileWriter("customers.csv"), ',');
                PrintWriter csvWriter = new PrintWriter(new File("C:\\DWAndSons\\jobs.csv"));
                ResultSetMetaData meta = rs.getMetaData() ; 

                int numberOfColumns = meta.getColumnCount() ; 
                System.out.println(numberOfColumns);
                String dataHeaders = "\"" + meta.getColumnName(1) + "\"" ; 
                for (int i = 2 ; i < numberOfColumns + 1 ; i ++ ) { 
                    dataHeaders += ",\"" + meta.getColumnName(i).replaceAll("\"","\\\"") + "\"" ;
                }
                csvWriter.println(dataHeaders) ;
                while (rs.next()) {
                    String row = "\"" + rs.getString(1).replaceAll("\"","\\\"") + "\""  ; 
                    for (int i = 2 ; i < numberOfColumns + 1 ; i ++ ) {
                        row += ",\"" + rs.getString(i).replaceAll("\"","\\\"") + "\"" ;
                    }  
                    csvWriter.println(row) ;
                }
                csvWriter.flush();
                csvWriter.close(); 

            }



            catch(Exception e){
                System.out.println(e.getMessage() + "   Error");
            }
        }
        
}
