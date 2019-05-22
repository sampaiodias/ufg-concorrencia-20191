/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.concorrencia.WhatsUFGPublico;

import java.net.Socket;
import java.util.Scanner;

/**
 * @author Lucas Sampaio Dias, Murillo Nunes
 */
public class ThreadRequisicaoChat implements Runnable{
    
    private Socket cliente;

    public ThreadRequisicaoChat(Socket cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public void run() {
        while(true) {
            try {
                Scanner ouvirCliente = new Scanner(cliente.getInputStream());
                String mensagemDoCliente = ouvirCliente.nextLine();
                Servidor.broadcast(mensagemDoCliente, cliente);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
