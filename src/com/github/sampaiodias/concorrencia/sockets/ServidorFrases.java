/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.concorrencia.sockets;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Lucas Sampaio Dias
 */
public class ServidorFrases {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(12345);
        
        while(true) {
            Socket cliente = servidor.accept();
            System.out.println(cliente.getInetAddress().getHostAddress());
        
            int pos = (int) (Math.random()* 160);
            String mensagem = "Frase aleatória " + pos;

            PrintStream enviarDados = new PrintStream(cliente.getOutputStream());
            enviarDados.println(mensagem);
        }
    }
}
