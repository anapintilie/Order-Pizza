package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnection {
 
 public static Connection conectare(){
  
   try {
    Class.forName("org.sqlite.JDBC");
    Connection conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/Ana-Maria/Desktop/seminarii java zamfi/PizzaItaliano/PizzaBD.sqlite");
   System.out.println("Conectat!");
   return conn;
   
   } catch (ClassNotFoundException | SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
   
  return null;
 }
}