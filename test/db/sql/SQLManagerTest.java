/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.sql;

import db.interfaces.DoctorManager;
import db.interfaces.PatientManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class SQLManagerTest {

    public SQLManagerTest() {
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
     * Test of connect method, of class SQLManager.
     */
    @Test
    public void testConnect() {
        System.out.println("connect");
        SQLManager instance = new SQLManager();
        instance.connect();
        Connection c = instance.getConnection();
        String sqlpatient = "select 1";
        Integer expResult = 1;
        try {
            PreparedStatement stm = c.prepareStatement(sqlpatient);
            stm.executeUpdate();
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Integer res = rs.getInt(1);
                //obtener nombre del doctor
                assertEquals(expResult, res);
            }
            rs.close();
            stm.close();

        } catch (SQLException ex) {
            Logger.getLogger(SQLPatientManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of disconnect method, of class SQLManager.
     */
    @Test
    public void testDisconnect() {
        System.out.println("disconnect");
        SQLManager instance = new SQLManager();
        instance.disconnect();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


}
