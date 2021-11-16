/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

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
    public static boolean[] introducePatient(String name, String username, String email, String adress, String phone, char[] password) {
        boolean[] error = null;

        if (!Exceptions.checkString(name)) {
            error[0] = true;
        } else {
            error[0] = false;
        }

        if (!Exceptions.checkUsername(username)) {
            error[1] = true;
        } else {
            error[1] = false;
        }

        if (!Exceptions.checkEmail(email)) {
            error[2] = true;
        } else {
            error[2] = false;
        }
        if (!Exceptions.checkPhone(phone)) {
            error[3] = true;
        } else {
            error[3] = false;
        }
        if (!error[0] && !error[1] && !error[2] && !error[3]) {
            PatientPrincipalWindow.patient.setFullName(name);//guardar en base de datos
            PatientPrincipalWindow.patient.setUsername(username);
            PatientPrincipalWindow.patient.setAddress(adress);
            PatientPrincipalWindow.patient.setEmail(email);
            PatientPrincipalWindow.patient.setPhonenumber(phone);
            //PatientPrincipalWindow.patient.setPassword(password);
            PatientPrincipalWindow.patientManager.createPatient(PatientPrincipalWindow.patient);

        }
        return error;
        //lo del hash con las pass
    }

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

    public static boolean configuredBitalino(String macAddress, int sampling, int channel) {
        boolean error = false;
        PatientPrincipalWindow.patient.setNewBitalino();
        try {
            System.out.println("samping: " + sampling); //por si acaso
            PatientPrincipalWindow.patient.getBitalino().open(macAddress, sampling);
            error = false;
        } catch (BITalinoException be) {
            System.out.println("Error en configuredBitalino 1");
            error = true;
        }
        try {
            switch (channel) {
                case 0:
                    int[] channelsToAcquire = {1};
                    PatientPrincipalWindow.patient.getBitalino().start(channelsToAcquire);
                    System.out.println("estamos configurados");
                    // getDataBitalino(); // esto se va a llamar desde la interfaz pero de momento para ver
                    break;
                case 1:
                    int[] channelsToAcquire2 = {4};
                    PatientPrincipalWindow.patient.getBitalino().start(channelsToAcquire2);
                    getDataBitalino();
                    break;
                case 2:
                    int[] channelsToAcquire3 = {1, 4};
                    PatientPrincipalWindow.patient.getBitalino().start(channelsToAcquire3);
                    getDataBitalino();
                    break;
                // default:
                //    error = true;
                //   break;
            }
        } catch (Throwable ex) {
            System.out.println("Error en configuredBitalino 2");
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
        try {
            for (int j = 0; j < 10000000; j++) {
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
            }
            PatientPrincipalWindow.patient.getBitalino().stop(); // esto se quita cuando este la interfaz
        } catch (BITalinoException ex) {
            Logger.getLogger(FunctionsBitalino.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //probar asi
    public static String getDataBitalino2() {
        Frame[] frame;
        String a;
        try {
            //Read a block of 100 samples
            frame = PatientPrincipalWindow.patient.getBitalino().read(1);
            a = frame[0].seq + " "
                    + frame[0].analog[0] + " "
                    + frame[0].analog[1] + " ";
            // se podria devolver este a para imprimirlo por pantalla.

            //PatientPrincipalWindow.patient.getBitalino().stop(); // esto se quita cuando este la interfaz
        } catch (BITalinoException ex) {
            a = "Error";
            Logger.getLogger(FunctionsBitalino.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    public static void stopDataBitalino() {
        try {
            PatientPrincipalWindow.patient.getBitalino().stop();
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
