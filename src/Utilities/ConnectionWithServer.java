/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Pojos.Patient;
import interf.PatientPrincipalWindow;
import java.io.*;
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
        } catch (IOException ex) {
            error = true;
        }
        return socket1;
    }


    public static boolean receiveData(Socket socket, BufferedReader bufferedReader) {
        boolean correct = false;
        try {
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
                            i++;
                        }
                        datos[contador] = data;
                        i++;
                        contador++;
                        data = "";
                    }
                    System.out.println("email:"+datos[5]);
                    if (datos[5].equals("null")) {
                        correct = false;
                    } else {
                        if (Exceptions.checkInt(datos[0])) {
                            PatientPrincipalWindow.patient.setID(Exceptions.convertInt(datos[0]));
                        } else {
                            PatientPrincipalWindow.patient.setID(30);
                        }
                        PatientPrincipalWindow.patient.setFullName(datos[1]);
                        PatientPrincipalWindow.patient.setUsername(datos[2]);
                        PatientPrincipalWindow.patient.setAddress(datos[3]);
                        PatientPrincipalWindow.patient.setPhonenumber(datos[4]);
                        PatientPrincipalWindow.patient.setEmail(datos[5]);
                        PatientPrincipalWindow.patient.setDiagnosis(datos[6]);
                        PatientPrincipalWindow.patient.setPassword(datos[7]);
                        PatientPrincipalWindow.patient.setMacBitalino(datos[8]);
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
        String send = "p#" + username + ";" + password;
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
    
    public static String receiveSomething(Socket socket, BufferedReader bf) {
       String line = "";
        try {
            line = bf.readLine();
        } catch (IOException ex) {
            //Logger.getLogger(ConnectionWithServer.class.getName()).log(Level.SEVERE, null, ex);
            line = "Error";
        }
       return line;            
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
