/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.concorrencia.lista02;

/**
 * @author Lucas Sampaio Dias
 */
public class Ex04 {
    public static void main(String[] args) {
        int repeticoes = 10;
        int threads = 10;
        
        for (int i = 0; i < threads; i++) {
            Thread t = new Thread(new ImprimeMensagem("" + i, repeticoes));
            t.start();
        }
    }
}
