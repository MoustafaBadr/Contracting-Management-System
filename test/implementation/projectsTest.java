/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
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
public class projectsTest {
    
    public projectsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
        
//        JOptionPane.showMessageDialog(null, "all methods  correct");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insert method, of class projects.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        String name = "ahmedpw";
        String date = "2015-6-4";
        String address = "jfdj";
        int payment = 414;
        String comName = "elabbasy";
        String tybe = "individual";
        projects instance = new projects();
        assertTrue(instance.insert(name, date, address, payment, comName, tybe)); 
//           JOptionPane.showMessageDialog(null, "insert done sucessfully");
    }

    /**
     * Test of update method, of class projects.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        String name = "el mostafa";
        String date = "2016-12-25";
        String address = "sirs";
        int payment = 0;
        String comName = "elabbasy";
        String tybe = "company";
        int id = 11;
        projects instance = new projects();
        instance.update(name, date, address, payment, comName, tybe, id);
        
        assertTrue( instance.update(name, date, address, payment, comName, tybe, id));
//         JOptionPane.showMessageDialog(null, "payment done sucessfully");
    }

    /**
     * Test of search method, of class projects.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        String tybe = "ndividual";
        projects instance = new projects();
       
        ResultSet result = instance.search(tybe);
        
        assertNotNull( result);
        
    }

    /**
     * Test of delete method, of class projects.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int id = 11;
        projects instance = new projects();
        assertTrue(instance.delete(id));
        
    }
    
}
