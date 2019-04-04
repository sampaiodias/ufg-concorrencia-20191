/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.sampaiodias.concorrencia.lista02;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Lucas Sampaio Dias
 */
public class ImprimeHora extends Thread {

    private int repeticoes;
    private final long intervaloMilisegundos;

    public ImprimeHora(int repeticoes, long intervaloMilisegundos) {
        this.repeticoes = repeticoes;
        this.intervaloMilisegundos = intervaloMilisegundos;
    }

    @Override
    public void run() {
        while(repeticoes > 0) {
            try {
                sleep(intervaloMilisegundos);
            } catch (InterruptedException ex) {
                Logger.getLogger(ImprimeHora.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
            repeticoes--;
            imprimirHora();
        }
    }

    private void imprimirHora() {
        Date date = new Date();   // given date
        Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
        calendar.setTime(date);   // assigns calendar to given date
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY) + ":" +
                calendar.get(Calendar.MINUTE) + ":" +
                calendar.get(Calendar.SECOND));
    }
    
}
