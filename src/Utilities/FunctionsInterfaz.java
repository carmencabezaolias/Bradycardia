/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import BITalino.BITalino;
import BITalino.BITalinoException;
import BITalino.Frame;
import interf.PatientGetData;
import interf.PatientPrincipalWindow;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carmen
 */
public class FunctionsInterfaz {

    /*public static boolean checkBitalino(String macAddress, int sampling) {
        BITalino bitalino = null;
        boolean error;
        try {
            bitalino.open(macAddress, sampling);
            error = false;
        } catch (BITalinoException be) {
            error = true;
        }
        return error;
    }*/
    public static void introducePatient(String name, String username, char[] Pass) {
        PatientPrincipalWindow.patient.setFullName(name);//guardar en base de datos
        PatientPrincipalWindow.patient.setUsername(username);
        //lo del hash con las pass
    }

    public static int getSampling(int i) {
        int sampling = 0;
        System.out.println("El chose: " + i);
        switch (i) {
            case 0:
                sampling = 10;
                break;
            case 1:
                sampling = 100;
                break;
            case 2:
                sampling = 1000;
                break;
        }
        return sampling;
    }

    public static boolean configuredBitalino(String macAddress, int sampling, int channel) {
        boolean error = false;
        try {
            PatientPrincipalWindow.patient.getBitalino().open(macAddress, sampling);
            error = false;
        } catch (BITalinoException be) {
            error = true;
        }
        try {
            switch (channel) {
                case 0:
                    int[] channelsToAcquire = {1};
                    PatientPrincipalWindow.patient.getBitalino().start(channelsToAcquire);
                    break;
                case 1:
                    int[] channelsToAcquire2 = {4};
                    PatientPrincipalWindow.patient.getBitalino().start(channelsToAcquire2);
                    break;
                case 2:
                    int[] channelsToAcquire3 = {1, 4};
                    PatientPrincipalWindow.patient.getBitalino().start(channelsToAcquire3);
                    break;
                default:
                    error = true;
                    break;
            }
        } catch (Throwable ex) {
            error = true;
        }
        return error;
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
                frame = PatientPrincipalWindow.patient.getBitalino().read(100);

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
            PatientPrincipalWindow.patient.getBitalino().stop();
        } catch (BITalinoException ex) {
            Logger.getLogger(PatientGetData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public BITalino createBitalinoPatient() {
        BITalino bitalino = new BITalino();
        return bitalino;
    }

    public static boolean openBitalinoInInterface(String macAddress, int samplingRate) {
        boolean error = false;

        try {
            PatientPrincipalWindow.patient.getBitalino().open(macAddress, samplingRate);
            error = false;
        } catch (BITalinoException ex) {
            error = true;
            Logger.getLogger(FunctionsInterfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        return error;
    }

}
