/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relojConHilos;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karen.Pena
 */
public class RelijDigitalThreads extends Observable implements Runnable {

    private int horas, minutos, segundos;

    public RelijDigitalThreads(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    @Override
    public void run() {

        String tiempo;

        try {
            while (true) {
                
                tiempo = "";

                if (horas < 10) {
                    tiempo += "0" + horas;
                } else {

                    tiempo += horas;
                }

                tiempo += ":";
                if (minutos < 10) {
                    tiempo += "0" + minutos;
                } else {

                    tiempo += minutos;
                }

                tiempo += ":";

                if (segundos < 10) {
                    tiempo += "0" + segundos;
                } else {

                    tiempo += segundos;
                }

                this.setChanged();
                this.notifyObservers(tiempo);
                this.clearChanged();

                Thread.sleep(1000);

                segundos++;

                this.aumentoTiempo();

            }

        } catch (InterruptedException ex) {
            Logger.getLogger(RelijDigitalThreads.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void aumentoTiempo() {

        if (segundos == 60) {

            minutos++;
            segundos = 0;

            if (minutos == 60) {

                horas++;
                minutos = 0;

                if (horas == 24) {

                    horas = 0;
                }

            }

        }
    }

}
