/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Pojos.Patient;
import interf.PatientPrincipalWindow;

/**
 *
 * @author carmen
 */
public class FunctionsPatient {

    public static boolean[] introducePatient(String name, String username, String email, String adress, String phone, char[] password) {
        boolean[] error = null;

        if (!Exceptions.checkString(name)) {
            error[0] = true;
        } else {
            error[0] = false;
        }

        if (!Exceptions.checkUsername(true, username)) {
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

    public static boolean loginPatient(String username, char[] password) {
        Patient patient = PatientPrincipalWindow.patientManager.getPatientByUsername(username);
        boolean gotPatient = false;
        //comprobar lo de la password
        if (patient == null) {
            gotPatient = false;
            System.out.println("no se ha encontrado el patient");
        } else {
            gotPatient = true;
            PatientPrincipalWindow.patient = patient;
        }
        return gotPatient;
    }
}
