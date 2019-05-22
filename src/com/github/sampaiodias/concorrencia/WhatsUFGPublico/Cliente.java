/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.concorrencia.WhatsUFGPublico;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Lucas Sampaio Dias, Murillo Nunes
 */
public class Cliente {
    public static void main(String[] args) throws IOException {
        Socket servidor = new Socket("localhost", 12366);
		
		Scanner teclado = new Scanner(System.in);
                
                //Usuario
		System.out.println("Digite seu nome de usuário: ");
                String nomeUsuario = teclado.nextLine();
                
                while(true) {
                    System.out.println("Digite uma mensagem: ");
                    String mensagem = teclado.nextLine();

                    PrintStream saidaServidor = 
                            new PrintStream(servidor.getOutputStream());
                    Scanner ouvirServidor = new Scanner(servidor.getInputStream());

                    saidaServidor.println(nomeUsuario + ": " + mensagem);
                    String resposta = ouvirServidor.nextLine();

                    System.out.println(resposta);
                }
    }
}
