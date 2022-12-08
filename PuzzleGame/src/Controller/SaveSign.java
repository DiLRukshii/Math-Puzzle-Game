package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import Model.DB;
import Model.SignIn;

public class SaveSign {
    SignIn sign;
public SaveSign(SignIn sSignUp)
{
    this.sign=sSignUp;
}
public void saveSignInToDataBase()
{ // method for add the user registration details to the Database
    try{
        Connection con=DB.createConnection();
        String sql="INSERT INTO signup(sname,smail,spassword)"+"VALUES('"+sign.sname+"','"+sign.smail+"','"+sign.spassword+"')"; 
        PreparedStatement statement=con.prepareStatement(sql);
        statement.executeUpdate();
        con.close(); 
        JOptionPane.showMessageDialog(null, "User Added Successfully");
               
    } 
    catch(Exception e){
           System.out.println("Error"+e.getLocalizedMessage());
           
    }
    
    }
    
}

	