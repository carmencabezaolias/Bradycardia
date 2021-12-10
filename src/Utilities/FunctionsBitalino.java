/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import BITalino.BITalino;
import BITalino.BITalinoException;
import BITalino.Frame;
import interf.FirstWindow;
import interf.PatientChooseSignal;
import interf.PatientGetData;
import interf.PatientPrincipalWindow;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.bluetooth.RemoteDevice;

/**
 *
 * @author carmen
 */
public class FunctionsBitalino {

    public static int getSampling(int i) {
        int sampling = 0;
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

    public static BITalino configuredBitalino(String macAddress, int sampling, int channel) {
        boolean error = false;
        BITalino bitalino=null;
        try {
            bitalino = new BITalino();
            Vector<RemoteDevice> devices;
            try {
                devices = bitalino.findDevices();
            } catch (InterruptedException ex) {
                Logger.getLogger(FunctionsBitalino.class.getName()).log(Level.SEVERE, null, ex);
            }
            String mac = PatientPrincipalWindow.patient.getMacBitalino();
            bitalino.open(mac, sampling);
            error = false;
        } catch (BITalinoException be) {
            bitalino=null;
            error = true;
        }
        try {
            switch (channel) {
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
            }
        } catch (Throwable ex) {
            bitalino=null;
            error = true;
        }
        return bitalino;
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

    public static boolean getDataBitalino(BITalino bitalino, int  num) {
        Frame[] frame;
        boolean finish= false;
        try {
            for (int j = 0; j < num; j++) {
                //Read a block of 100 samples
                frame = bitalino.read(10);
                //Print the samples
                for (int i = 0; i < frame.length; i++) {
                    String a = (j * 100 + i) + " seq: " + frame[i].seq + " "
                            + frame[i].analog[0] + " "
                            + frame[i].analog[1] + " ";
                    ConnectionWithServer.sendSomething(FirstWindow.socket, FirstWindow.printWriter, a);
                }
            }
            finish=true;
            bitalino.stop(); // esto se quita cuando este la interfaz
        } catch (BITalinoException ex) {
            Logger.getLogger(FunctionsBitalino.class.getName()).log(Level.SEVERE, null, ex);
        }
        return finish;
    }

    public static String getDataBitalino2(BITalino bitalino, int i) {
        Frame[] frame;
        String a;
        try {
            //Read a block of 100 samples
            frame = bitalino.read(1);
            a = frame[i].seq + " "
                    + frame[i].analog[0] + " "
                    + frame[i].analog[1] + " ";
            ConnectionWithServer.sendSomething(FirstWindow.socket, FirstWindow.printWriter, a);
        } catch (BITalinoException ex) {
            a = "Error";
            Logger.getLogger(FunctionsBitalino.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    public static void stopDataBitalino(BITalino bitalino) {
        try {
            bitalino.stop();
        } catch (BITalinoException ex) {
            Logger.getLogger(PatientGetData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
