/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

/**
 *
 * @author Mustafa
 */
public class admin {
    
    
    public static String userName;
    public static String password;
    public static String name;
    
     public void logIn(String user,String password){
        
        this.userName = user;
        this.password = password;
        
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        admin.password = password;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        admin.name = name;
    }

   
    public static void setUserName(String userName) {
        admin.userName = userName;
    }

    public static String getUserName() {
        return userName;
    }

   
    
}
