/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.excepcionproject;

import javax.swing.JOptionPane;

/**
 *
 * @author axter
 */
public class Fechas {
    public static void main(String[] args){
        int dd = 0, mm = 0, aa = 0;
        Fecha F = new Fecha();
        do{
            dd = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite Dia:"));
            mm = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite Mes:"));
            
            do{
                aa = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite Año desde 1963:"));
            } while(aa < 1963);
            
            try{
                F.comprobar(dd, mm, aa);
            }
            catch(ExceptoFecha e){
                JOptionPane.showMessageDialog(null, e.getMessage());
                dd = mm = aa = 0;
            }
            
        }while(dd == 0 && mm == 0 && aa == 0);
        System.exit(0);
    }
}
