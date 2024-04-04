package Piezas.Tipos;

import Piezas.Jugadores;
import Piezas.Pieza;

public class Caballo extends Pieza {
    private   int limitederecha1=0;

    private   int limitederecha2=0;
    private int limiteArriba1 =0;
    private  int limititeArriba2=0;
    private    int limiteAbajo1=0;

    private    int limiteAbajo2=0;
    protected   int limiteIzquierda=0;
    protected   int limiteIzquierda2=0;
    public Caballo(Jugadores propietario) {
        super(propietario);
    }



    public void espacioDisponible(Pieza[][] table){

        // arriba derecha lejos
        if (table[posicionX-2][posicionY+1]instanceof Bloqueo){
            table[posicionX-2][posicionY+1]=null;
        }

        //arriba izquierda

        if (table[posicionX-2][posicionY-1] instanceof Bloqueo ){
            table[posicionX-2][posicionY-1]=null;
        }

        //abajo derecha
        if (table[posicionX+2][posicionY+1] instanceof Bloqueo){
            table[posicionX+2][posicionY+1]=null;
        }

        //abajo izquierda
        if (table[posicionX+2][posicionY-1] instanceof  Bloqueo){
            table[posicionX+2][posicionY-1]=null;
        }

    }
}
