/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.sampaiodias.concorrencia.lista05;

import com.github.sampaiodias.concorrencia.util.Cronometro;

/**
 * @author Lucas Sampaio Dias
 */
public class ThreadMD5 extends Thread {
    
    private final String hash;
    private final ThreadGroup parent;
    private String senha;

    public ThreadMD5(String hash, ThreadGroup parent) {
        this.hash = hash;
        this.parent = parent;
    }
    
    @Override
    public void run() {
        try {
            Cronometro cronometro = new Cronometro();
            senha = Utilitario.quebrarSenhaMD5(hash);
            System.out.println("Senha quebrada: " + senha);
            System.out.println(cronometro.resultadoSegundos());
            parent.stop();
        }
        catch (Exception e) {
            
        }
    }
    
    public String getSenha() {
        return senha;
    }
}
