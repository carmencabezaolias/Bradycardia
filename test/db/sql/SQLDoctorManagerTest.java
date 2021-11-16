/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.sql;

import Pojos.Doctor;
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
public class SQLDoctorManagerTest {
    
    public SQLDoctorManagerTest() {
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
     * Test of createDoctor method, of class SQLDoctorManager.
     */
    @Test
    public void testCreateDoctor() {
        System.out.println("createDoctor");
        Doctor doc = null;
        SQLDoctorManager instance = null;
        instance.createDoctor(doc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteDoctor method, of class SQLDoctorManager.
     */
    @Test
    public void testDeleteDoctor() {
        System.out.println("deleteDoctor");
        Integer id = null;
        SQLDoctorManager instance = null;
        instance.deleteDoctor(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifyDoctor method, of class SQLDoctorManager.
     */
    @Test
    public void testModifyDoctor() {
        System.out.println("modifyDoctor");
        Doctor doc = null;
        SQLDoctorManager instance = null;
        instance.modifyDoctor(doc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByFullName method, of class SQLDoctorManager.
     */
    @Test
    public void testSearchByFullName() {
        System.out.println("searchByFullName");
        String fullname = "";
        SQLDoctorManager instance = null;
        Integer expResult = null;
        Integer result = instance.searchByFullName(fullname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
