package com.company.server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable{

    private Socket client;

    public ClientHandler(Socket socket) {
        this.client = socket;
    }

    @Override
    public void run() {
        try {
            //receive data
            InputStream inputStream = this.client.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            DataOutputStream outputStream = new DataOutputStream(this.client.getOutputStream());

            //continuous reading data from client
            String  inputData;
            while ((inputData = bufferedReader.readLine()) != null){

                System.out.println("Client says: " + inputData);

                if(inputData.equals("exit")){
                    break;
                }else {
                    //send data to the client by providing the text in the console
                    Scanner scanner = new Scanner(System.in);
                    String text = scanner.nextLine();
                    System.out.println("Server says: "+ text);
                    outputStream.writeBytes(text + "\n");
                }
            }

            this.client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
