/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import java.sql.ResultSet;
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
public class employeeTest {
    
    public employeeTest() {
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
     * Test of insert method, of class employee.
     */
    

    /**
     * Test of searchemail method, of class employee.
     */
    @Test
    public void testSearchemail() {
        System.out.println("searchemail");
        String n = "badr@gmail.co";
        employee instance = new employee();
       
        ResultSet result = instance.searchemail(n);
        assertNotNull( result );
        
    }

    /**
     * Test of search method, of class employee.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        String jop = "engineer";
        employee instance = new employee();
       
        ResultSet result = instance.search(jop);
         assertNotNull( result );   
        
    }

    /**
     * Test of update method, of class employee.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        String fiName = "mostafa";
        String lasNmae = "badr";
        String phone = "01250840001";
        String salary = "2000";
        String email = "badr@gmail.com";
        String address = "sengrg";
        String state = "busy";
        String job = "engineer";
        employee instance = new employee();
        assertTrue(instance.update(fiName, lasNmae, phone, salary, email, address, state, job));
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of delete method, of class employee.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String email ="badr@gmail.co";

        employee instance = new employee();
        assertTrue( instance.delete(email));  ;
       
    }
    
}
