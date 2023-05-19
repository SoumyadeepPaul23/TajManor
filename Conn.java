
package hotelmanagementsystem;
import java.sql.*;

public class Conn {
    Connection c; // Step 2: Creating the Connection
    Statement s; // Step 3: Creating Statement (through which we can execute the mysql queries) 
                 // Step 4: In login Class that is to write the query.
    Conn(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver"); // Step 1: Registering the Driver
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem","root","Paul123@#"); // Step 2: Creating the connection string
        s = c.createStatement();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]){
        new Conn();
    }
    
}
