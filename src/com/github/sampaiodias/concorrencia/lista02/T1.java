/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.concorrencia.lista02;

/**
 * @author Lucas Sampaio Dias
 */
public class T1 extends Thread {
    
    private final int id;
    
    public T1(int id) {
        super("T1 - " + id);
        this.id = id;
    }
    
    @Override
    public void run() {
        while(true) {
            System.out.println("Thread " + id + " executando");
        }
    }
}
