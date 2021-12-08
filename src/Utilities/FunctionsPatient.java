/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import interf.PatientPrincipalWindow;

/**
 *
 * @author carmen
 */
public class FunctionsPatient {

    public static boolean[] introducePatient(String name, String username, String email, String adress, String phone, String password) {
        boolean[] error = new boolean[5];

        if (!Exceptions.checkString(name)) {
            error[0] = true;
        } else {
            error[0] = false;
        }

        /* if (!Exceptions.checkUsername(true, username)) {
            error[1] = true;
        } else {
            error[1] = false;
        }*/
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
            PatientPrincipalWindow.patient.setPassword(password);
            //PatientPrincipalWindow.patientManager.createPatient(PatientPrincipalWindow.patient);
            //PatientPrincipalWindow.patient.setPassword(password);
            // PatientPrincipalWindow.patientManager.createPatient(PatientPrincipalWindow.patient);

        }
        return error;
        //lo del hash con las pass
    }

    /*
    public static boolean loginPatient(Socket socket, String username, char[] password) {
        boolean error = false;
        InputStream inputStream = null;
        ObjectInputStream objectInputStream = null;
        // ServerSocket serverSocket = null;
        //Socket socket = null;
        try {
            String[] datos = getDataFromFile();
            int ip = Utilities.Exceptions.convertInt(datos[1]);
            inputStream = socket.getInputStream();
            objectInputStream = new ObjectInputStream(inputStream);
            Object tmp;
            try {
                while ((tmp = objectInputStream.readObject()) != null) {
                    PatientPrincipalWindow.patient = (Patient) tmp;
                }

            } catch (EOFException ex) {
                error = true;
                System.out.println("All data have been correctly read.");

            } catch (IOException ex) {
                error = true;
                System.out.println("It was not possible to start the server. Fatal error.");

            }
        } catch (IOException | ClassNotFoundException ex) {
            error = true;
            System.out.println("Unable to read from the client.");

        }
        return error;
    }

    // Patient patient = PatientPrincipalWindow.patientManager.getPatientByUsername(username);
    //System.out.println("name en funct:"+patient.getFullName());
    // System.out.println(patient.getUsername());
    /*  objectInputStream = new ObjectInputStream(inputStream);
            Object tmp;
            while ((tmp = objectInputStream.readObject()) != null) {
                Client persona = (Client) tmp;
                System.out.println(persona.toString());
            }
        boolean gotPatient = false;
        //comprobar lo de la password
        if (patient == null) {
            gotPatient = false;
            System.out.println("no se ha encontrado el patient");
        } else {
            gotPatient = true;
            patient.setDocId(1);
            System.out.println(patient.getFullName());
            PatientPrincipalWindow.patient = patient;
        }
        return gotPatient;*/
}
