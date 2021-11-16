/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.sql;

import Pojos.Patient;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cristina
 */
public class SQLPatientManagerTest {
    
    public SQLPatientManagerTest() {
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
     * Test of createPatient method, of class SQLPatientManager.
     */
    @Test
    public void testCreatePatient() {
        System.out.println("createPatient");
        Patient pat = null;
        SQLPatientManager instance = null;
        instance.createPatient(pat);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletePatient method, of class SQLPatientManager.
     */
    @Test
    public void testDeletePatient() {
        System.out.println("deletePatient");
        Integer id = null;
        SQLPatientManager instance = null;
        instance.deletePatient(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifyPatient method, of class SQLPatientManager.
     */
    @Test
    public void testModifyPatient() {
        System.out.println("modifyPatient");
        Patient pat = null;
        SQLPatientManager instance = null;
        instance.modifyPatient(pat);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readPatient method, of class SQLPatientManager.
     */
    @Test
    public void testReadPatient() {
        System.out.println("readPatient");
        Integer id = null;
        SQLPatientManager instance = null;
        instance.readPatient(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
