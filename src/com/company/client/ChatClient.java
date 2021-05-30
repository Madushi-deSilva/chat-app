package com.company.client;

import java.io.*;
import java.util.Scanner;

public class ChatClient {

    public static void main(String[] args) throws IOException {

        Client client = new Client();
        client.start();


        /*client.sendMessage("Hello from the client.");
        client.sendMessage("How are you?");
        client.sendMessage("I'm fine");
        client.sendMessage("Thank you.");
        client.sendMessage("exit");*/

        //send data to server by providing the text in the console
        Scanner scanner = new Scanner(System.in);
        String text = " ";
        while (!text.equals("exit")){
            text = scanner.nextLine();
            client.sendMessage(text);
        }
        System.out.println("Client finished the execution...");

    }
}
