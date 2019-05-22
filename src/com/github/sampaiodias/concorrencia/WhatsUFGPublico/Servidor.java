/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.concorrencia.WhatsUFGPublico;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Lucas Sampaio Dias, Murillo Nunes
 */
public class Servidor {
    
    //IP : Socket
    private static Map<String, Socket> usuarios = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        ServerSocket chat = new ServerSocket(12366);
        while(true) {
            Socket socketUsuario = chat.accept();
            String ip = socketUsuario.getInetAddress().getHostAddress();
            
            if (usuarios.containsKey(ip) == false) {
                usuarios.put(ip, socketUsuario);
            }
            
            ThreadRequisicaoChat usuario = 
                    new ThreadRequisicaoChat(socketUsuario);
            Thread t = new Thread(usuario);
            t.start();
        }
    }
    
    public static void broadcast(String mensagem, Socket cliente) 
            throws IOException {
        for(Map.Entry<String, Socket> entry : usuarios.entrySet()) {
            Socket value = entry.getValue();

            try {
                PrintStream saidaCliente = new PrintStream(value.getOutputStream());
                saidaCliente.println(mensagem);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
