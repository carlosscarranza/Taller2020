/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.excepcionproject;

/**
 *
 * @author axter
 */
public class Fecha {
    int enero = 1, marzo = 1, mayo = 1, julio = 1, agosto = 1, octubre = 1, diciembre = 1, 
            abril = 2, junio = 2, septiembre = 2, noviembre = 2, 
            febrero = 3;
    int grupo = 0;
    
    void comprobar(int dd, int mm, int aa) throws ExceptoFecha{
        switch (mm){
            case 1:
            case 3:    
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                grupo = 2;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                grupo = 3;
                break;
            case 2:
            default:
                throw new ExceptoFecha("Fecha Incorrecta. Mes No Legitimo");
        }
        
        switch(grupo){
            case 1:
                if(dd < 1 || dd > 31){
                    throw new ExceptoFecha("Fecha Incorrecta. Dia del Mes");
                }
                break;
            case 2:
                if(dd < 1 || dd > 30){
                    throw new ExceptoFecha("Fecha Incorrecta. Dia del Mes");
                }
                break;
            case 3:
                if(aa % 4 == 0){
                    if(dd < 1 || dd > 29){
                        throw new ExceptoFecha("Fecha Incorrecta. Dia del Mes Año Bisciesto");
                    }
                }else if(dd < 1 || dd > 29){
                    throw new ExceptoFecha("Fecha Incorrecta. Dia del Mes");
                }
                break;
        }
    }
}
