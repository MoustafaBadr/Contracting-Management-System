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
public class companyTest {
    
    public companyTest() {
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
     * Test of computeDiscount method, of class company.
     */
    @Test
    public void testComputeDiscount() {
        System.out.println("computeDiscount");
        int percent = 0;
        int payment1 = 0;
        company instance = new company();
        int expResult = 0;
        int result = instance.computeDiscount(percent, payment1);
        assertEquals(expResult, result);
        
    }
    
}
