/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.concorrencia.lista02;

/**
 * Classe que calcula o valor de Pi.
 * @author Lucas Sampaio Dias
 */
public class Pi {
    public static void main(String[] args) {
        Cronometro cronometro = new Cronometro();
        double pi = calcularPi(10000);
        
        System.out.println(cronometro.resultadoMilisegundos());
        System.out.println("Pi: " + pi);
    }

    private static double calcularPi(int termos) {
        double pi = 1;
        double numerador = 1;
        double denominador = 3;
        boolean soma = false;
        
        for (int i = 0; i < termos; i++) {
            if (soma == true) {
                pi += (numerador / denominador);
            }
            else {
                pi -= (numerador / denominador);
            }
            denominador += 2;
            soma = !soma;
        }
        return pi * 4;
    }
}
