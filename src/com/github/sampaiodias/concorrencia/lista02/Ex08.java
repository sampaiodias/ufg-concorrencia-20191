/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.concorrencia.lista02;

/**
 * @author Lucas Sampaio Dias
 */
public class Ex08 {
    public static void main(String[] args) throws InterruptedException {
        ImprimeNoticia noticia = new ImprimeNoticia();
        ImprimeHora hora = new ImprimeHora(5, 10000);
        
        noticia.start();
        hora.start();
        hora.join();
        noticia.parar();
        noticia.interrupt();
    }
}
