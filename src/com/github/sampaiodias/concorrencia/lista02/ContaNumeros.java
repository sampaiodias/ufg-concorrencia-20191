/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.concorrencia.lista02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author Lucas Sampaio Dias
 */
public class ContaNumeros {
    public static void main(String[] args) {
        Cronometro cronometro = new Cronometro();
        int num = numeroMaisFrequente();
        
        System.out.println(cronometro.resultadoMilisegundos());
        System.out.println("Número mais frequente: " + num);
    }

    private static int numeroMaisFrequente() {
        Map<Integer, Integer> hp = 
               new HashMap<Integer, Integer>(); 
        
        try {
            File f = new File("src/main/resources/numeros.txt");
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";

            while ((readLine = b.readLine()) != null) {
                if (readLine.isEmpty() == false)
                {
                    int key = Integer.parseInt(readLine); 
                    if(hp.containsKey(key)) 
                    { 
                        int freq = hp.get(key); 
                        freq++; 
                        hp.put(key, freq); 
                    } 
                    else
                    { 
                        hp.put(key, 1); 
                    }    
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        int maxCount = 0, res = -1; 
          
        for(Entry<Integer, Integer> val : hp.entrySet()) 
        { 
            if (maxCount < val.getValue()) 
            { 
                res = val.getKey(); 
                maxCount = val.getValue(); 
            } 
        }
        
        return res;
    }
}
