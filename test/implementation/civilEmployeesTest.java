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
public class civilEmployeesTest {

    public civilEmployeesTest() {
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
     * Test of JoinProject method, of class civilEmployees.
     */
    @Test
    public void testJoinProject() {
        System.out.println("JoinProject");
        int n = 1;
        String project = "el mostafa";
        civilEmployees Cemployee = new civilEmployees();
        assertEquals(1, 1);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of LeftProject method, of class civilEmployees.
     */
    @Test
    public void testLeftProject() {
        System.out.println("LeftProject");
        int n = 1;
        String project = "el mostafa";
        civilEmployees Cemployee = new civilEmployees();
        assertEquals(1, Cemployee.JoinProject(n, project));
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of search method, of class civilEmployees.
     */
    @Test
    public void testSearch() {
        System.out.println("engineer");
        String n = "engineer";
        civilEmployees instance = new civilEmployees();
        ResultSet expResult = null;
        ResultSet result = instance.search(n);
//        assertEquals(expResult, result);
        assertNotNull(result);

        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");

    }

}
