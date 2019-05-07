/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.sampaiodias.concorrencia.lista03;

/**
 * @author Lucas Sampaio Dias
 */
public class EncontraValor extends Thread{
    
    private int resultado;
    public int[] a;
    public int de;
    public int ate;
    public int x;

    public EncontraValor(int x, int[] a, int de, int ate) {
        this.a = a;
        this.de = de;
        this.ate = ate;
        this.x = x;
    }
    
    @Override
    public void run() {
        resultado = -1;
        for (int i = de; i < ate; i++) {
            if (a[i] == x) {
                resultado = i;
                return;
            }
        }
    }
    
    private static int encontraValor(int x, int[] a, int de, int ate) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x)
                return i;
        }
        return -1;
    }
    
    public int getIndex() {
        return resultado;
    }
}
