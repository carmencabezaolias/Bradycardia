/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import interf.PatientPrincipalWindow;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carmen
 */
public class ConnectionWithServer {

    public static String[] getDataFromFile() throws IOException {
        File file2 = new File(".");
        String path = file2.getAbsolutePath();
        String goodpath = file2.getAbsolutePath().substring(0, path.length() - 2).concat("/files/DataConnection.txt");
        FileReader br = null;
        String[] datos = {"a", "a", "a", "a"};
        try {
            br = new FileReader(goodpath);

            int caract;
            int i = 0;
            char a;
            String dt = "";
            while ((caract = br.read()) != -1) {
                a = (char) caract;
                if (a != '#') {
                    dt = dt + a;
                } else {
                    datos[i] = dt;
                    i++;
                    dt = "";
                    while (a != ';' || caract == -1) {
                        caract = br.read();
                        a = (char) caract;
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            throw new IOException("File not found");
        } catch (IOException e) {
            throw new IOException("Error");
        }
        //datos[0] ---> IP SERVER SOCKET
        //datos[1] ---> ServerSocket
        //datos[2] ---> IP DB SERVER
        //datos[3] ---> PORT DB SERVER
        System.out.println(datos[1]);
        System.out.println(Utilities.Exceptions.checkFloat(datos[1]));
        return datos;
    }

    public static boolean connectToServer(Socket socket) {
        boolean error = false;
        try {
            String[] datos = getDataFromFile();
            int ip = Utilities.Exceptions.convertInt(datos[1]);
            socket = new Socket(datos[0], ip);
        } catch (IOException ex) {
            error = true;
        }
        return error;
    }

    public static void receiveData(Socket socket) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String[] datos = new String[100];
            System.out.println("Text Received:\n");
            String line = bufferedReader.readLine();
            System.out.println(line);
            int i = 0;
            int j = 0;
            String cap = "";
            switch (line.charAt(0)) {
                case 'p':
                    while (line.charAt(i + 2) != '#') {
                        while (line.charAt(i + 2) != ';') {
                            cap = cap + line.charAt(i + 2);
                            i++;
                        }
                        datos[j] = cap;
                        j++;
                        cap = "";
                    }
                    // return "p#" + ID + ";" + fullName + ";" + username + ";" + address + ";" + phonenumber + ";" +
                    //email + ";" + diagnosis + ";" + docId + ";" + password + ";" + macBitalino + ";" + bitalino + ";#";
                    PatientPrincipalWindow.patient.setID(Exceptions.convertInt(datos[0]));
                    PatientPrincipalWindow.patient.setFullName(datos[1]);
                    PatientPrincipalWindow.patient.setUsername(datos[2]);
                    PatientPrincipalWindow.patient.setAddress(datos[3]);
                    PatientPrincipalWindow.patient.setPhonenumber(datos[4]);
                    PatientPrincipalWindow.patient.setEmail(datos[5]);
                    PatientPrincipalWindow.patient.setDiagnosis(datos[6]);
                    PatientPrincipalWindow.patient.setDocId(Exceptions.convertInt(datos[7]));
                    //PatientPrincipalWindow.patient.setPassword(password);
                    PatientPrincipalWindow.patient.setMacBitalino(datos[9]);
                    PatientPrincipalWindow.patient.setNewBitalino();
                    break;

            }

        } catch (IOException ex) {
            Logger.getLogger(ConnectionWithServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void sendPatient(Socket socket, String username, String password) {
        boolean error = false;
        try {
            OutputStream outputStream = socket.getOutputStream();
            String send = "Patient;" + username + ";" + password;
            int i = 0;
            while (i != send.length()) {
                char character = send.charAt(i);
                i++;
                System.out.println(character);
                outputStream.write(character);
                outputStream.flush();
            }
        } catch (IOException ex) {
            error = true;
        }
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
