/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.sampaiodias.concorrencia.lista03;

import com.github.sampaiodias.concorrencia.util.Cronometro;
import java.util.ArrayList;

/**
 * @author Lucas Sampaio Dias
 */
public class Ex01 {
    public static void main(String[] args) {
        Cronometro cronometro = new Cronometro();
        System.out.println("Calculando primos...\n");
        
        ArrayList<Integer> numsA = encontrarPrimos(1_000_000, 30_000_000);
        ArrayList<Integer> numsB = encontrarPrimos(90_000_000, 120_000_000);
        
        System.out.println("Primos entre 1.000.000 e 30.000.000");
        imprimirNumeros(numsA);
        System.out.println("Quantidade total: " + numsA.size());
        
        System.out.println("\nPrimos entre 90.000.000 e 120.000.000");
        imprimirNumeros(numsB);
        System.out.println("Quantidade total: " + numsB.size());
        
        System.out.println("");
        System.out.println(cronometro.resultadoMilisegundos());
    }
    
    private static void imprimirNumeros(ArrayList<Integer> nums) {
        nums.stream().forEach((num) -> {
            System.out.print(num + " ");
        });
        System.out.println("");
    }
    
    public static ArrayList<Integer> encontrarPrimos(int de, int ate) {
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
