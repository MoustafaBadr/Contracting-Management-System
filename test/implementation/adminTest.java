/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Smart
 */
public class adminTest {
    
    public adminTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of logIn method, of class admin.
     */
    @Test
    public void testLogIn() {
        System.out.println("logIn");
        String user = "";
        String password = "";
        admin instance = new admin();
        instance.logIn(user, password);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

//    /**
//     * Test of logOut method, of class admin.
//     */
//    @Test
//    public void testLogOut() {
//        System.out.println("logOut");
//        admin instance = new admin();
//        instance.logOut();
//        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of regestrate method, of class admin.
//     */
//    @Test
//    public void testRegestrate() {
//        System.out.println("regestrate");
//        admin instance = new admin();
//        instance.regestrate();
//        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//    }

    /**
     * Test of setUserName method, of class admin.
     */
    @Test
    public void testSetUserName() {
        System.out.println("setUserName");
        String userName = "";
        admin.setUserName(userName);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
