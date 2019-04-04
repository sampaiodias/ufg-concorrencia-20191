/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.concorrencia.lista02;

/**
 * @author Lucas Sampaio Dias
 */
public class SomaNumeros implements Runnable {

    private final int[] numeros;
    private int resultado;
    
    public SomaNumeros(int[] numeros) {
        this.numeros = numeros;
    }

    @Override
    public void run() {
        resultado = 0;
        for (int i = 0; i < numeros.length; i++) {
            resultado += numeros[i];
        }
    }

    public int getResultado() {
        return resultado;
    }
}
