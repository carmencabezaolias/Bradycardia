/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojos;

/**
 *
 * @author carmen
 */
public class Doctor {

    private int ID;
    String fullName;
    String username;
    private byte[] password;

    public Doctor(String username, String fullname, byte[] password) {
        super();
        this.fullName = fullName;
        this.username = username;
        this.password = password;
    }

    public Doctor(String username, String fullname) {
        super();
        this.fullName = fullName;
        this.username = username;
    }
}
