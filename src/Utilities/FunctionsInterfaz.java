/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import BITalino.BITalino;
import BITalino.BITalinoException;
import BITalino.Frame;
import interf.PatientBitalinoWindow;
import interf.PatientGetData;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carmen
 */
public class FunctionsInterfaz {

    public static boolean checkBitalino(String macAddress, int sampling) {
        BITalino bitalino = null;
        boolean error;
        try {
            bitalino.open(macAddress, sampling);
            error = false;
        } catch (BITalinoException be) {
            error = true;
        }
        return error;
    }

    public static int checkSamping(String sampling) {
        int sam = 0;
        if (Exceptions.checkInt(sampling)) {
            sam = Exceptions.convertInt(sampling);
            System.out.println(sam);
            if (sam != 10 && sam != 100 && sam != 1000) {
                sam = 2;
            }
        } else {
            sam = 1;
        }

        return sam;
    }

    public static boolean checkChannel(int a, BITalino bitalino) {
        boolean err = false;
        System.out.println("a" + a);
        try {
            switch (a) {
                case 0:
                    int[] channelsToAcquire = {1};
                    bitalino.start(channelsToAcquire);
                    break;
                case 1:
                    int[] channelsToAcquire2 = {4};
                    bitalino.start(channelsToAcquire2);
                    break;
                case 2:
                    int[] channelsToAcquire3 = {1, 4};
                    bitalino.start(channelsToAcquire3);
                    break;
                default:
                    err = true;
                    break;
            }
        } catch (Throwable ex) {
            err = true;
        }
        return err;
    }

    public static boolean checkMac(String mac) {
        boolean error = false;
        if (mac.length() == 17) {
            for (int i = 1; i < mac.length(); i++) {
                if (mac.charAt(i) != ':' || (i % 2 == 0)) {
                    error = false;
                } else {
                    error = true;
                    break;
                }
            }
        } else {
            error = true;
        }
        return error;
    }

    public static void getDataBitalino() {
        Frame[] frame;
        for (int j = 0; j < 10000000; j++) {

            try {
                //Read a block of 100 samples
                frame = PatientBitalinoWindow.bitalino.read(100);

                System.out.println("size block: " + frame.length);

                //Print the samples
                for (int i = 0; i < frame.length; i++) {
                    System.out.println((j * 100 + i) + " seq: " + frame[i].seq + " "
                            + frame[i].analog[0] + " "
                            + frame[i].analog[1] + " "
                    );
                    String a = (j * 100 + i) + " seq: " + frame[i].seq + " "
                            + frame[i].analog[0] + " "
                            + frame[i].analog[1] + " ";
                    // se podria devolver este a para imprimirlo por pantalla.

                }
            } catch (BITalinoException ex) {
                Logger.getLogger(FunctionsInterfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void stopDataBitalino() {
        try {
            PatientBitalinoWindow.bitalino.stop();
        } catch (BITalinoException ex) {
            Logger.getLogger(PatientGetData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
