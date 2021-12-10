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
        }
        return error;
    }
}
