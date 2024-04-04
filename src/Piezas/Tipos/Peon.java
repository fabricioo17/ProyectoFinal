package Piezas.Tipos;

import Piezas.Jugadores;
import Piezas.Pieza;

public class Peon extends Pieza {
        public Peon(Jugadores propietario) {
                super(propietario);
        }
        public void espaciosDisponiblePeon(Pieza [][] table){
                if (table[posicionX][posicionY].getPropietario()==Jugadores.jugador1){
                        if (posicionX==1){
                                if (table[posicionX+2][posicionY] instanceof Bloqueo){
                                table[posicionX+2][posicionY]=null;
                                }
                        }
                        //le ponemos un menos 1 al posicionYde abajo puesto que siempre el movimineto valido es en la misma columna la cual es 0.
                        if (table[posicionX+1][posicionY] instanceof Bloqueo){
                                table[posicionX+1][posicionY]=null;//la posicion original del peon es posicionX-1 y posicionY-1, entonces si les quitamos los menos 1 tendriamos la posicion en el array donde se podria mover el peon. osea un espacio adelante
                        }

                }

                else {
                        if (posicionX==7){
                                if ( table[posicionX-2][posicionY] instanceof Bloqueo){
                                        table[posicionX-2][posicionY]=null;
                                }

                        }
                                if (table[posicionX-1][posicionY] instanceof  Bloqueo){
                                        table[posicionX-1][posicionY]=null;
                                }

                }


        }


        public boolean comerPiezaPeon(int movimientoX, int movimientoY,Pieza [][]table){
                if (table[posicionX][posicionY].getPropietario()!=table[movimientoX][movimientoY].getPropietario()){
                        if (table[movimientoX][movimientoY] instanceof Pieza && !(table[movimientoX][movimientoY] instanceof Bloqueo)){
                                if (table[posicionX][posicionY].getPropietario()==Jugadores.jugador1){
                                        //peones que van hacia abajo
                                        if ((movimientoX==posicionX+1 && movimientoY==posicionY+1)||movimientoX==posicionX+1 && movimientoY==posicionY-1){
                                                table[movimientoX][movimientoY]=table[posicionX][posicionY];
                                                table[posicionX][posicionY]=null;
                                                return true;
                                        }
                                }
                                else {
                                        if ((movimientoX==posicionX-1 && movimientoY==posicionY+1)||movimientoX==posicionX-1 && movimientoY==posicionY-1){
                                                table[movimientoX][movimientoY]=table[posicionX][posicionY];
                                                table[posicionX][posicionY]=null;
                                                return true;
                                        }
                                }




                        }


                }

                        return false;
        }






}
