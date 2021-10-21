/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

/**
 *
 * @author carmen
 */
public class Exceptions {

    public static boolean checkUsername(String username) {
        return true;
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
        boolean isInt = false;
        try {
            float a = Float.parseFloat(integer);
        } catch (NumberFormatException ex) {
            isInt = true;
        }
        return isInt;
    }

}
