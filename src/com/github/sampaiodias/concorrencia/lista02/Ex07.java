/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.concorrencia.lista02;

import com.github.sampaiodias.concorrencia.util.Cronometro;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Lucas Sampaio Dias
 */
public class Ex07 {
    
    public static void main(String[] args) throws IOException, 
            InterruptedException {
        int x, y;
        BufferedReader br = 
                new BufferedReader(new InputStreamReader(System.in));
        Cronometro tempoGerarValores = new Cronometro();
        Cronometro tempoCalculo = new Cronometro();
        
        System.out.println("Insira a dimensão X da matriz");
        x = Integer.parseInt(br.readLine());
        System.out.println("Insira a dimensão Y da matriz");
        y = Integer.parseInt(br.readLine());
        
        tempoGerarValores.iniciarContagem();
        int m[][] = inicializarMatriz(x, y);
        tempoGerarValores.finalizarContagem();

        tempoCalculo.iniciarContagem();
        int resultado = calcular(m, x, y);
        tempoCalculo.finalizarContagem();
        
        imprimirResultados(tempoGerarValores, tempoCalculo, resultado);
    }

    private static int calcular(int[][] m, int x, int y) 
            throws InterruptedException {
        SomaNumeros[] nums = new SomaNumeros[y];
        Thread[] threads = new Thread[y];
        
        for (int j = 0; j < y; j++) {
            int[] vetor = new int[x];
            for (int i = 0; i < vetor.length; i++) {
                vetor[i] = m[i][j];
            }
            
            nums[j] = new SomaNumeros(vetor);
            threads[j] = new Thread(nums[j]);
            threads[j].start();
        }
        
        for (int i = 0; i < y; i++) {
            threads[i].join();
        }
        
        int resultado = 0;
        for (int i = 0; i < y; i++) {
            resultado += nums[i].getResultado();
        }
        
        return resultado;
    }

    private static void imprimirResultados(Cronometro tempoGerarValores, 
            Cronometro tempoCalculo, int resultado) {
        System.out.println("");
        System.out.println("Milisegundos gastos na geração de valores: " + 
                tempoGerarValores.totalMilisegundos());
        System.out.println("Milisegundos gastos no cálculo: " + 
                tempoCalculo.totalMilisegundos());
        System.out.println("Soma: " + resultado);
    }

    private static int[][] inicializarMatriz(int x, int y) {
        int[][] m = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                m[i][j] = ThreadLocalRandom.current().nextInt(0, 5);
            }
        }
        return m;
    }
}
