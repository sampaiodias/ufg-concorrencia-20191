/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.concorrencia.lista02;

/**
 * @author Lucas Sampaio Dias
 */
public class Ex05 {
    public static void main(String[] args) {
        T1[] threads = new T1[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new T1(i);
            threads[i].start();
        }
    }
}
