/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.multithreaded;

/**
 *
 * @author shamim
 */
import java.net.*;
import java.io.*;
public class MultithreadedSocketServer {
    public static void main(String[] args) throws Exception {
        try{
            ServerSocket server=new ServerSocket(6087);
            int counter=0;
            System.out.println("Server Started ....");
            if (counter<2){
            while(true){
                counter++;
                Socket serverClient=server.accept();  
                System.out.println(" >> " + "Client No:" + counter + " started !");
                ServerClientThread sct = new ServerClientThread(serverClient,counter); //send  the request to a separate thread
                sct.start();
            }
            }
        }catch(Exception e){
            System.out.println("Server busy");
        }
        
    }
}