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
public class Patient {

    private int ID;
    String fullName;

    String username;
    private byte[] password;
    private String macBitalino;

    public Patient(String username, String fullname, byte[] password) {
        super();
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.macBitalino = null;
    }

    public Patient() {
        super();
        this.fullName = "";
        this.username = "";
        this.macBitalino = null;
    }

    public Patient(String username, String fullname) {
        super();
        this.fullName = fullName;
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public int getID() {
        return ID;
    }

    public void setMacBitalino(String macBitalino) {
        this.macBitalino = macBitalino;
    }

    public String getMacBitalino() {
        return macBitalino;
    }

}
