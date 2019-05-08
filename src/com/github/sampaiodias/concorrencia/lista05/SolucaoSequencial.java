/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.sampaiodias.concorrencia.lista05;

import com.github.sampaiodias.concorrencia.util.Cronometro;

/**
 * @author Lucas Sampaio Dias
 */
public class SolucaoSequencial {
    public static void main(String[] args) {
        Cronometro cronometro = new Cronometro();
        for (String hash : Utilitario.SENHAS) {
            Cronometro cronometroSenha = new Cronometro();
            System.out.println("Senha quebrada: " + 
                    Utilitario.quebrarSenhaMD5(hash));
            System.out.println(cronometroSenha.resultadoSegundos());
        }
        System.out.println("--- FIM DO PROGRAMA ---\n");
        System.out.println(cronometro.resultadoSegundos());
    }
}
