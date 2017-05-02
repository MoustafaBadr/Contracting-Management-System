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
public class employeesSalaryTest {
    
    public employeesSalaryTest() {
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
     * Test of computeBouns method, of class employeesSalary.
     */
    @Test
    public void testComputeBouns() {
        System.out.println("computeBouns");
        String bouns = "10% bouns";
        employeesSalary instance = new employeesSalary();
        
        ResultSet result = instance.computeBouns(bouns);
        assertNotNull( result);
        
        
    }

    /**
     * Test of computeTotal method, of class employeesSalary.
     */
    @Test
    public void testComputeTotal() {
//        System.out.println("computeTotal");
//        employeesSalary instance = new employeesSalary();
//        int expResult = 2000;
//        int result = instance.computeTotal();
//        assertEquals(expResult, result);
//       
    }
    
}
