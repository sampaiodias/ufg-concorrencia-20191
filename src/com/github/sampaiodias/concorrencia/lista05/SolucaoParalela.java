/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.sampaiodias.concorrencia.lista05;

/**
 * @author Lucas Sampaio Dias
 */
public class SolucaoParalela {    
    public static void main(String[] args) {
        for (String hash : Utilitario.SENHAS) {
            quebrarHashComThreads(hash);
        }
    }

    private static void quebrarHashComThreads(String hash) {
        ThreadGroup group = new ThreadGroup("ThreadGroup " + hash);
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(group, new ThreadMD5(hash, group));
            t.start();
        }
    }
}
