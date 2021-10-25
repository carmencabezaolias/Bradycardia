/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

/**
 *
 * @author carmen
 */
public class Patient {

    private int ID;
    String fullName;
    String username;
    private byte[] password;

    public Patient(String username, String fullname, byte[] password) {
        super();
        this.fullName = fullName;
        this.username = username;
        this.password = password;
    }

    public Patient(String username, String fullname) {
        super();
        this.fullName = fullName;
        this.username = username;
    }
}
