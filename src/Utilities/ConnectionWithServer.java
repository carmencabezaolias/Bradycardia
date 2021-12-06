/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Pojos.Patient;
import interf.PatientPrincipalWindow;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author carmen
 */
public class ConnectionWithServer {

    public static String[] getDataFromFile() throws IOException {
        File file2 = new File(".");
        String path = file2.getAbsolutePath();
        //we want to extract the information of the file DattaConnection.txt
        String goodpath = file2.getAbsolutePath().substring(0, path.length() - 2).concat("/files/DataConnection.txt");
        FileReader br = null;
        String[] datos = new String[5];
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
        //datos[1] ---> PORT SERVER SOCKET
        //datos[2] ---> IP DB SERVER
        //datos[3] ---> PORT DB SERVER
        System.out.println(datos[1]);
        System.out.println(Utilities.Exceptions.checkFloat(datos[1]));
        return datos;
    }

    public static Socket connectToServer() {
        boolean error = false;
        Socket socket1 = new Socket();
        try {
            String[] datos = getDataFromFile();
            //in datos[1] we have the number of the port whereas in datos[0] the ip address
            int ip = Utilities.Exceptions.convertInt(datos[1]);
            socket1 = new Socket(datos[0], ip);
            System.out.println("socket info1: " + socket1.getLocalPort());
        } catch (IOException ex) {
            error = true;
        }
        return socket1;
    }
//public static PrintWi

    public static boolean receiveData(Socket socket, BufferedReader bufferedReader) {
        boolean correct = false;
        try {
            // bufferedReader = new BufferedReader(
            //  new InputStreamReader(socket.getInputStream()));
            String[] datos = new String[100];
            //vamos a leer toda la información que pasa el server del paciente
            String line = bufferedReader.readLine();
            int i = 0;
            int contador = 0;
            String data = "";
            switch (line.charAt(0)) {
                case 'p':
                    while (line.charAt(i + 2) != '#') {
                        while (line.charAt(i + 2) != ';') {
                            data = data.concat(Character.toString(line.charAt(i + 2)));
                            //System.out.println("El contador de chars en con: " + i + " el string: " + cap);
                            i++;
                        }
                        //System.out.println("Con es:" + con);
                        datos[contador] = data;
                        i++;
                        contador++;
                        data = "";
                    }
                    /*System.out.println("1: " + datos[0]);
                    System.out.println("2: " + datos[1]);
                    System.out.println("3: " + datos[2]);
                    System.out.println("4: " + datos[3]);
                    System.out.println("5: " + datos[4]);
                    System.out.println("6: " + datos[5]);
                    System.out.println("7: " + datos[7]);
                    System.out.println("Error despues de esto");*/
                    // return "p#" + ID + ";" + fullName + ";" + username + ";" + address + ";" + phonenumber + ";" +
                    //email + ";" + diagnosis + ";" + docId + ";" + password + ";" + macBitalino + ";" + bitalino + ";#";
                    if (datos[5].equals("null")) {
                        correct = false;
                    } else {
                        if (Exceptions.checkInt(datos[0])) {
                            PatientPrincipalWindow.patient.setID(Exceptions.convertInt(datos[0]));
                        } else {
                            System.out.println("no se puede pasar");
                            PatientPrincipalWindow.patient.setID(30);
                        }
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
                        correct = true;
                    }
                    break;
            }
        } catch (IOException ex) {
            correct = false;
        }
        return correct;
    }

    public static void sendPatient(Socket socket, PrintWriter printWriter, String username, String password) {
        boolean error = false;
        //try {
        //OutputStream outputStream = new OutputStream();
        //outputStream = socket.getOutputStream();+
        System.out.println("socket info: " + socket.getLocalPort());
        String send = "p#" + username + ";" + password;
        //se manda al server un String que contiene el usuario y el password
        System.out.println("Se vuelve a enviar datos");
        printWriter.println(send);
        int i = 0;
    }

    public static void sendNewPatient(Socket socket, PrintWriter printWriter, Patient patient) {
        boolean error = false;
        printWriter.println(patient.toString());
    }

    public static void sendSomething(Socket socket, PrintWriter printWriter, String mes) {
        printWriter.println(mes);
    }

    /* public static boolean sendDataToServer(Socket socket, String data) {
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
    }*/
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
