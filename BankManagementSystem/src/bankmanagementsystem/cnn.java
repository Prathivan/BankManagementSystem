package bankmanagementsystem;
import java.sql.*;  // import sql package  & add libraary as jconnector jdk
public class cnn{
    Connection c;
    Statement s;
    public cnn(){
        try{
            
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","BAba12!@");//location to store the data in database
            s=c.createStatement();  // statement for update query in mysql
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}