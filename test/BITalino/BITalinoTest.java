/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BITalino;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author carmen
 */
public class BITalinoTest {

    public BITalinoTest() {
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
     * Test of start method, of class BITalino.
     */
    @Test
    public void testStart() throws Exception {
        System.out.println("start");
        String macAddress = "98:D3:91:FD:69:49";
        int sampleRate = 100;

        int[] anChannels = {1};
        BITalino instance = new BITalino();
        try {
            instance.open(macAddress, sampleRate);
            instance.start(anChannels);

        } catch (Throwable ex) {
            Logger.getLogger(BITalinoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
