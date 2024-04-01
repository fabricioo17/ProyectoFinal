package Piezas;

import Piezas.Tipos.Bloqueo;
import Piezas.Tipos.Jugadores;
import Piezas.Tipos.Torre;

public class Piezas {
    protected String nombreJugador;
    private final Bloqueo a =new Bloqueo();
    private Torre ae = new Torre(Jugadores.jugador1);
    public void bloquearespacios(Piezas [][] table){
        for (int i =0;i<8;i++){
            for (int j=0;j<8;j++){
                if(table[i][j]==null){
                    table[i][j]= a;//usaremos un puntero bloqueo para no crear objetos innecesarios de bloqueo
                }
            }
        }
    }

    public void liberarEspacios(Piezas [][] table){
        for (int i =0;i<8;i++){
            for (int j=0;j<8;j++){
                if(table[i][j]instanceof Bloqueo){
                    table[i][j]=null;//usaremos un puntero bloqueo para no crear objetos innecesarios de bloqueo
                }
            }
        }
    }
    }


