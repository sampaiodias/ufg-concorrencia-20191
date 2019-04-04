/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.concorrencia.lista02;

import java.util.ArrayList;

/**
 *
 * @author Lucas Sampaio Dias
 */
public class Primos {
    public static void main(String[] args) {
        Cronometro cronometro = new Cronometro();
        imprimirPrimos(1, 300000);
        System.out.println(cronometro.resultadoMilisegundos());
    }

    private static void imprimirPrimos(int de, int ate) {
        ArrayList<Integer> primos = encontrarPrimos(de, ate);
        primos.stream().forEach((num) -> {
            System.out.println(num);
        });
    }

    private static ArrayList<Integer> encontrarPrimos(int de, int ate) {
        ArrayList<Integer> primos = new ArrayList<>();
        boolean isPrimo;
        
        for (int i = de; i <= ate; i++) {
            isPrimo = checarPrimo(i);
            if (isPrimo) {
                primos.add(i);
            }
        }
        return primos;
    }
    
    public static boolean checarPrimo(int num) {
        int sobra;
        for (int i = 2; i <= num / 2; i++) {
            sobra = num % i;
            if (sobra == 0) {
                return false;
            }
        }
        return true;
    }
}
