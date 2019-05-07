/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.sampaiodias.concorrencia.lista03;

/**
 * @author Lucas Sampaio Dias
 */
public class Ex02 {
    public static void main(String[] args) throws InterruptedException {
        int[] a = new int[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        System.out.println("Index: " + parallelSearch(46, a, 4));
    }
    
    public static int parallelSearch(int x, int[] a, int numThreads) 
            throws InterruptedException {
        EncontraValor[] threads = new EncontraValor[numThreads];
        int de = 0;
        int ate = a.length / numThreads;
            
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new EncontraValor(x, a, de, ate);
            threads[i].start();
            
            de += a.length / numThreads;
            ate += a.length / numThreads;
        }
        
        for (int i = 0; i < numThreads; i++) {
            threads[i].join();
        }
        
        for (int i = 0; i < numThreads; i++) {
            int index = threads[i].getIndex();
            if (index != -1)
                return index;
        }
        
        return -1;
    }
}
