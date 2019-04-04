/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.concorrencia.lista02;

/**
 * Classe que resolve o Exercício 06
 * @author Lucas Sampaio Dias
 */
public class TesteContador {
    public static void main(String[] args) {
        Thread c1 = new Thread(new Contador());
        Thread c2 = new Thread(new Contador());
        c1.start();
        c2.start();
    }
}
