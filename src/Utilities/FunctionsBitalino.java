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
      //  PatientPrincipalWindow.patient.setNewBitalino();
        BITalino bitalino=null;
        try {
            bitalino = new BITalino();
            Vector<RemoteDevice> devices;
            try {
                devices = bitalino.findDevices();
                
            System.out.println(devices);
            } catch (InterruptedException ex) {
                Logger.getLogger(FunctionsBitalino.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("sampling: " + sampling); //por si acaso
            System.out.println("MAC: "+ PatientPrincipalWindow.patient.getMacBitalino());
            String mac = PatientPrincipalWindow.patient.getMacBitalino();
            bitalino.open(mac, sampling);
            System.out.println("ya se ha open");
            error = false;
        } catch (BITalinoException be) {
            System.out.println("Error en configuredBitalino 1");
            bitalino=null;
            error = true;
        }
        try {
            switch (channel) {
                case 0:
                    int[] channelsToAcquire = {1};
                    System.out.println("Intentando start");
                    bitalino.start(channelsToAcquire);
                    System.out.println("estamos configurados");
                 //   getDataBitalino(bitalino); // esto se va a llamar desde la interfaz pero de momento para ver
                    break;
                case 1:
                    int[] channelsToAcquire2 = {4};
                     bitalino.start(channelsToAcquire2);
                   // getDataBitalino(bitalino);
                    break;
                case 2:
                    int[] channelsToAcquire3 = {1, 4};
                     bitalino.start(channelsToAcquire3);
                    //getDataBitalino(bitalino);
                    break;
                // default:
                //    error = true;
                //   break;
            }
        } catch (Throwable ex) {
            System.out.println("Error en configuredBitalino 2");
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
                    
                    ConnectionWithServer.sendSomething(FirstWindow.socket, FirstWindow.printWriter, a);
                  //  PatientGetData.OutputText.text=a;
                }
            }
            finish=true;
            bitalino.stop(); // esto se quita cuando este la interfaz
        } catch (BITalinoException ex) {
            Logger.getLogger(FunctionsBitalino.class.getName()).log(Level.SEVERE, null, ex);
        }
        return finish;
    }

    //probar asi
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
            // se podria devolver este a para imprimirlo por pantalla.

            //PatientPrincipalWindow.patient.getBitalino().stop(); // esto se quita cuando este la interfaz
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
    /*
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
    }*/

}
