/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.concorrencia.lista02;

/**
 *
 * @author Lucas Sampaio Dias
 */
public final class Cronometro {
    private long tempoInicial;
    private long tempoFinal;
    
    public Cronometro() {
        iniciarContagem();
    }
    
    public void iniciarContagem() {
        tempoInicial = System.currentTimeMillis();
    }
    
    public void finalizarContagem() {
        tempoFinal = System.currentTimeMillis();
    }
    
    public long totalMilisegundos() {
        if (tempoFinal == 0) {
            return System.currentTimeMillis() - tempoInicial;
        }
        return tempoFinal - tempoInicial;
    }
    
    public String resultadoMilisegundos() {
        return "Tempo gasto: " + totalMilisegundos() + " milisegundos";
    }
    
    public String resultadoSegundos() {
        return "Tempo gasto: " + totalSegundos()+ " segundos";
    }
    
    public long totalSegundos() {
        return totalMilisegundos() / 1000;
    }
}
