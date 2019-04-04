/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sampaiodias.concorrencia.lista02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Lucas Sampaio Dias
 */
public class ImprimeNoticia extends Thread {
    
    private ArrayList<String> noticias;
    private boolean continuarImprimindo;

    public ImprimeNoticia() {
        noticias = new ArrayList<>();
        carregarArquivo();
        continuarImprimindo = true;
    }

    private void carregarArquivo() {
        try {
            File f = new File("src/main/resources/noticias.txt");
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";

            while ((readLine = b.readLine()) != null) {
                if (readLine.isEmpty() == false)
                {
                     noticias.add(readLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (continuarImprimindo) {
            try {
                sleep(5000);
                System.out.println(noticias.get(
                    ThreadLocalRandom.current().nextInt(0, noticias.size())));
            } catch (InterruptedException ex) {
                
            }
        }
    }
    
    public final void parar() {
        continuarImprimindo = false;
    }
}
