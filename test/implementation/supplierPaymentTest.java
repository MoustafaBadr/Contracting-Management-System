/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import java.sql.ResultSet;
import java.time.LocalDate;
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
public class supplierPaymentTest {
    
    public supplierPaymentTest() {
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
     * Test of payment method, of class supplierPayment.
     */
    @Test
    public void testPayment() {
        System.out.println("payment");
        int cash = 200;
        int supplierId =8;
        String supplierName = "mostafagh";
        supplierPayment instance = new supplierPayment();
        instance.payment(cash, supplierId, supplierName);
        assertTrue( instance.payment(cash, supplierId, supplierName));
       
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of search method, of class supplierPayment.
     */
    @Test
    public void testSearch() {
//        System.out.println("search");
//        LocalDate date = null;
//        supplierPayment instance = new supplierPayment();
//        ResultSet expResult = null;
//        ResultSet result = instance.search(date);
//        assertNotNull(result);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
