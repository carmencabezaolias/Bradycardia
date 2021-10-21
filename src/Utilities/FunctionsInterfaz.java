/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import BITalino.BITalino;
import BITalino.BITalinoException;

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
        } else {
            sam = 1;
        }
        if (sam != 10 || sam != 100 || sam != 1000) {
            sam = 2;
        }
        return sam;
    }

    public static boolean checkChannel(int a, BITalino bitalino) {
        boolean err = false;
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
}
