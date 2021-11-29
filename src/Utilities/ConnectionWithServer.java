/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carmen
 */
public class ConnectionWithServer {

    public static boolean connectToServer() {
        boolean error = false;
        Socket socket;
        // try{
        try {
            socket = new Socket("localhost", 9000);
        } catch (IOException ex) {
            error = true;
            Logger.getLogger(ConnectionWithServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        //}catch (ConnectException e){ //no se porque pone que no lo lanza si me sale

        // }
        return error;
    }

    public static boolean sendDataToServer(Socket socket, String data) {
        //File To Read
        int character;
        int i = 0;
        boolean error = false;
        try {

            OutputStream outputStream = socket.getOutputStream();
            while (i != data.length()) {
                character = data.charAt(i);
                System.out.println(character);
                outputStream.write(character);
                outputStream.flush();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    error = true;
                    //Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException e) {

        }
        return error;
    }

    public static boolean exitFromServer(OutputStream outputStream, Socket socket) {
        boolean error = false;
        try {
            try {
                outputStream.close();
            } catch (IOException ex) {
                error = true;
                //Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            socket.close();
        } catch (IOException ex) {
            error = true;
        }
        return error;
    }

}
