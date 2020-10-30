package src;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String args[]){
        try(ServerSocket serverSocket = new ServerSocket(8184);){
            System.out.println("Server Running on Port 8184");

            while(true){
                
                //Conectando cliente
                Socket socket = serverSocket.accept();
                System.out.println("Cliente connectado!");

                //Output
                OutputStream outputData = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(outputData,true);

                //Input
                InputStream inputData = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputData));

                //Recebendo mensagem do Cliente
                String text = reader.readLine();
                System.out.println("Mensagem do Cliente: " + text);

                //Enviando mensagem todas Maiusculas
                writer.println(text.toUpperCase());
            }




        }catch(IOException e){
            System.err.println("I/O ERROR " + e);
        }
    }
}