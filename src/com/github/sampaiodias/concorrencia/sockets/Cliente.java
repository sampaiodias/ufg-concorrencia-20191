/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.concorrencia.sockets;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Lucas Sampaio Dias
 */
public class Cliente {
    public static void main(String[] args) throws IOException {
        //Socket server = new Socket("localhost", 12345);
        Socket server = new Socket("192.168.40.247", 23456);
        
        String mensagem = "*";
        
        PrintStream saidaServidor = new PrintStream(server.getOutputStream());
        Scanner ouvirServidor = new Scanner(server.getInputStream());
        
        saidaServidor.println(mensagem);
        String texto = ouvirServidor.nextLine();
        
        System.out.println(texto);
    }
}
