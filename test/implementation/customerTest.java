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
public class customerTest {
    
    public customerTest() {
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
     * Test of insert method, of class customer.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        String name = "ahmed";
        String phone = "12548";
        String email = "mfmdnfd,m";
        String address = "xmcm";
        int payment = 200;
        String tybe = "engineer";
        customer instance = new customer();
        assertTrue(instance.insert(name, phone, email, address, payment, tybe));
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of search method, of class customer.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        customer instance = new customer();
        ResultSet expResult = null ;
        ResultSet result = instance.search();
//        assertEquals(expResult, result);
assertNotNull(result);
// TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class customer.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        int id = 9;
        String name = "ahmed";
        String phone = "21598";
        String email = "ddffmgv";
        String address = "vvffg";
        String tybe = "individual";
        customer instance = new customer();
        assertTrue(instance.update(id, name, phone, email, address, tybe));
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class customer.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int id = 9;
        customer instance = new customer();
        assertTrue(instance.delete(id));
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of searchTybe method, of class customer.
     */
    @Test
    public void testSearchTybe() {
        System.out.println("searchTybe");
        String tybe = "company";
        customer instance = new customer();
        ResultSet expResult = null;
        ResultSet result = instance.searchTybe(tybe);
//        assertEquals(expResult, result);
        assertNotNull(result);
//         TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
