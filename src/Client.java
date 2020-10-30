package src;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client{
    public static void main(String args[]){
        boolean keepConnection = true;
        Scanner dataEntrance = new Scanner(System.in);

        try(Socket socket = new Socket("localhost",8184)){
            
            //Input
            InputStream inputData = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputData));

            //Output
            OutputStream outputData = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputData,true);

            while(keepConnection){
                
                System.out.println("Digite uma Mensagem para o Servidor: ");
                String message = dataEntrance.nextLine();

                //Enviando para o Servidor
                writer.println(message);

                //Recebe dado do Servidor
                String receive = reader.readLine();
                System.out.println("Mensagem recebida: " + receive);
            }
            dataEntrance.close();


        }catch(UnknownHostException e){
            System.err.println("Server not Found!");
        }catch(IOException e){
            System.err.println("I/O ERROR! " + e);
        }
    }
}