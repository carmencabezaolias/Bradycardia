/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Pojos.Patient;
import interf.PatientPrincipalWindow;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author carmen
 */
public class Exceptions {

    public static boolean checkEmail(String email) {
        boolean isEmail = false;
        /*int index = email.indexOf("@");
        if (index != -1 && index != 0 && index != email.length()) {
            isEmail = false;
        }*/

        String regx = "^(.+)@(.+)$";
        //Compile regular expression to get the pattern  
        Pattern pattern = Pattern.compile(regx);
        //Iterate emails array list  
        Matcher matcher = pattern.matcher(email);
        if( matcher.matches()){
            isEmail = true;
        }
        return isEmail;
        }
    

    public static boolean checkInt(String integer) {
        boolean isInt = true;
        try {
            int a = Integer.parseInt(integer);
        } catch (NumberFormatException ex) {
            isInt = false;
        }
        return isInt;
    }

    public static int convertInt(String integer) {
        int isInt = 0;
        try {
            isInt = Integer.parseInt(integer);
        } catch (NumberFormatException ex) {
        }
        return isInt;
    }

    public static boolean checkString(String integer) {
        boolean isString = false;
        try {
            float a = Float.parseFloat(integer);
        } catch (NumberFormatException ex) {
            isString = true;
        }
        return isString;
    }

    public static boolean checkFloat(String integer) {
        boolean isFloat = true;
        try {
            float a = Float.parseFloat(integer);
        } catch (NumberFormatException ex) {
            isFloat = false;
        }
        return isFloat;
    }

    public static boolean checkPhone(String phone) {
        boolean isPhone = true;
        if (phone.length() != 9) {
            isPhone = false;
        } else if (!checkInt(phone)) {
            isPhone = false;
        } else {
            isPhone = true;
        }
        return isPhone;
    }
      public static String[] takeDiagnosis(String string) {
        int i = 0;
        int contador = 0;
        String[] datos = new String[7];
        String data = "";
        char a;
        for (i = 0; i < string.length(); i++) {
            a=string.charAt(i);
            while (a != '#') {
                data = data + Character.toString(a);
                i++;
                a=string.charAt(i);
            }
            datos[contador] = data;
            contador++;
            data = "";
        }
        return datos;
    }
}
