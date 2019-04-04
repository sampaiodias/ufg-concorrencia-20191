/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.concorrencia.lista02;

/**
 * @author Lucas Sampaio Dias
 */
public class ImprimeMensagem implements Runnable {

    private final String mensagem;
    private final int repeticoes;
    
    public ImprimeMensagem(String mensagem, int repeticoes) {
        this.mensagem = mensagem;
        this.repeticoes = repeticoes;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < repeticoes; i++) {
            System.out.println(mensagem);
        }
    }
    
}
