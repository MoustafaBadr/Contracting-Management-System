
package implementation;


import database.connectDataBase;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.geometry.Pos;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;


public class store {
    
    int id;
    String Proudct_name;
    int amount;
    int price;
    int supplierID;

    static int storeprice =0;
    
    
    public boolean insert(int id, String Proudct_name, int amount, int supplierID ,int price){
 try {
            
            connectDataBase c =new connectDataBase() ;
            String Sql = " INSERT INTO `store`(`idstore`, `prodectName`, `amount`, `supplierId`, `price`) VALUES (?,?,?,?,?)";
            PreparedStatement ps = c.conection.prepareStatement(Sql);
            ps.setInt(1, id);
            ps.setString(2,Proudct_name);
            ps.setInt(3,amount );
            ps.setInt(4, supplierID);
            ps.setInt(5, price);
            ps.executeUpdate();
//            
//            Notifications notificationBuildeer = Notifications.create().
//                    title("Sucess").
//                    text("ADD Successfuly").
//                    graphic(null).
//                    hideAfter(Duration.seconds(4)).
//                    position(Pos.TOP_RIGHT).
//                    onAction(e -> {
//                        System.out.println("");
//                    });
//            notificationBuildeer.show();
            } catch (SQLException ex) {
//                 Notifications notificationBuildeer = Notifications.create().
//                    title("Warming").
//                    text("Already exist").
//                    graphic(null).
//                    hideAfter(Duration.seconds(4)).
//                    position(Pos.TOP_RIGHT).
//                    onAction(e -> {
//                        System.out.println("");
//                    });
//            notificationBuildeer.showWarning();
               
            }catch(HeadlessException ex)
            {
               JOptionPane.showMessageDialog(null, " error2 you enter invalid value "); 
            }
       
        return  true;
       
        
    }
    public boolean delete(int id) {
    try {
            
           connectDataBase c =new connectDataBase() ;
            String Sql = "DELETE FROM store where idstore=?";
            PreparedStatement ps = c.conection.prepareStatement(Sql);
            ps.setInt(1,id);
            ps.executeUpdate();
//             Notifications notificationBuildeer = Notifications.create().
//                    title("Success").
//                    text("Delet Successfuly").
//                    graphic(null).
//                    hideAfter(Duration.seconds(4)).
//                    position(Pos.TOP_RIGHT).
//                    onAction(e -> {
//                        System.out.println("");
//                    });
//            notificationBuildeer.show();
            } catch (SQLException ex) {
                //JOptionPane.showMessageDialog(null, "error");
            }catch(Exception ex)
            {
               //JOptionPane.showMessageDialog(null, " error2 you enter invalid value "); 
            }
       return true;
    }
    public boolean Update(int id, String Proudct_name, int amount, int supplierID ,int price){
           try {
            
            connectDataBase c =new connectDataBase() ;
            String Sql = "update store set amount=? ,prodectName=? ,supplierId=?, price=? where idstore=?";
            PreparedStatement ps = c.conection.prepareStatement(Sql);
            ps.setInt(1, amount);
            ps.setString(2, Proudct_name);
            ps.setInt(3, supplierID);
            ps.setInt(4,price);
            ps.setInt(5,id);
            ps.executeUpdate();
//             Notifications notificationBuildeer = Notifications.create().
//                    title("Success").
//                    text("Update Sucessfuly").
//                    graphic(null).
//                    hideAfter(Duration.seconds(4)).
//                    position(Pos.TOP_RIGHT).
//                    onAction(e -> {
//                        System.out.println(" ");
//                    });
//            notificationBuildeer.show();
            } catch (SQLException ex) {
               // JOptionPane.showMessageDialog(null, "error");
              }catch(Exception ex)
               {
               // JOptionPane.showMessageDialog(null, " error2 you enter invalid value "); 
              }
        
        
    return true;
    }
    public ResultSet makeReport(int id ){
        ResultSet rs=null;
         try {
            connectDataBase c =new connectDataBase() ;
            String Sql = "SELECT * FROM store WHERE idstore=?";
            PreparedStatement ps = c.conection.prepareStatement(Sql);
            ps.setInt(1, id);
             rs = ps.executeQuery();
            return rs;
            } 
             catch (SQLException ex) {
             //   JOptionPane.showMessageDialog(null, ex.getMessage());
                return rs;
             }catch(Exception ex)
              {
               // JOptionPane.showMessageDialog(null, " error2 you enter invalid value "); 
               return rs;
              }
   
    }
    
    
}
