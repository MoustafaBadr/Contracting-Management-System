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
public class supplierTest {
    
    public supplierTest() {
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
     * Test of insert method, of class supplier.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        String name = "mostafagh";
        int Payment = 600;
        String timeline = "2016-12-01";
        String Address = "20ghhjchjks";
        String email = "gfghj@";
        String phone = "0125058";
        supplier instance = new supplier();
        assertTrue(instance.insert(name, Payment, timeline, Address, email, phone));
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of search method, of class supplier.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        int id = 0;
        supplier instance = new supplier();
        ResultSet expResult = null;
        ResultSet result = instance.search(id);
        assertNotNull(result);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class supplier.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        int id = 8;
        String name = "mostafagh";
        String timeline = "2016-12-01";
        String Address = "20ghhjchjks";
        String email = "gfghj@";
        String phone = "0125058";
        supplier instance = new supplier();
//        instance.update(id, name, timeline, Address, email, phone);
        assertTrue(instance.update(id, name, timeline, Address, email, phone));
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class supplier.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int id = 0;
        supplier instance = new supplier();
        assertTrue(instance.delete(id));
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
