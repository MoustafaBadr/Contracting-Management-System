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
public class storeTest {

    public storeTest() {
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
     * Test of insert method, of class store.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        int id = 1;
        String Proudct_name = "mmmm";
        int amount = 1212121;
        int supplierID = 5;
        int price = 12121212;
        store instance = new store();
        assertTrue(instance.insert(id, Proudct_name, amount, supplierID, price));
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class store.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int id = 0;
        store instance = new store();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of Update method, of class store.
     */
    @Test
    public void testUpdate() {
        System.out.println("Update");
        int id = 1;
        String Proudct_name = "mmmm";
        int amount = 1212121;
        int supplierID = 5;
        int price = 12121212;
        store instance = new store();
        instance.Update(id, Proudct_name, amount, supplierID, price);
        assertTrue(instance.Update(id, Proudct_name, amount, supplierID, price));
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of makeReport method, of class store.
     */
    @Test
    public void testMakeReport() {
        System.out.println("makeReport");
        int id = 1;
        store instance = new store();
        ResultSet expResult = null;
        ResultSet result = instance.makeReport(id);
        assertNotNull(result);
//        fail("The test case is a prototype.");
//        assertEquals(expResult, result);
    }

}
