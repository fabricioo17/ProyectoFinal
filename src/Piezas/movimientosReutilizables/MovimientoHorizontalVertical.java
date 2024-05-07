package Piezas.movimientosReutilizables;

import Piezas.Pieza;
import Piezas.Tipos.Rey;
import Tablero.Tablero;

public interface MovimientoHorizontalVertical {
    default int movimientoVertical(Tablero tablero, int movimientoX, int movimientoY, int posicionX, int posicionY) {
       int posicionOriginalX= posicionX;
       int posicionOriginalY=posicionY;

Pieza piezaComida;
      Pieza  [][] table= tablero.getTable();
        Rey rey = tablero.obtenerPiezaReyBlanco(table[posicionOriginalX][posicionOriginalY].isBlancas());
        //horizontal
        if (tablero.obtenerPieza(posicionX,posicionY)!= tablero.obtenerPieza(movimientoX,movimientoY)) {// esto es para que no elija el mismo sitio de donde ya se encuentra
            if (posicionX == movimientoX) {// si se mueve en la misma fila
                // primero vemos si la pieza esta al extemo derecha y evitar el error de cantidad de arryar
                for (int i = posicionY ; i < 8; i++) {
                    if (i +1== 8 || table[posicionX][i+1] instanceof Pieza) {
                        //hacia la izquierda y derecha//
                        for (int j = posicionY ; j >= 0; j--) {
                            if (j -1== -1 || table[posicionX][j-1] instanceof Pieza) {
                                if ((movimientoY < i+1 && movimientoY > j-1) && table[posicionX][movimientoY] == null) {// al tener los limites de arriba y abajo, el movimiento debe estar entre esos dos valores sino seria error
//------------------------------------------------cambiat de posicion ---------------------------------------------------------//
                                    table[posicionX][posicionY].cambiarPosicion(tablero,movimientoX,movimientoY);

                                    if(table[movimientoX][movimientoY].identificarJacke(tablero,table[movimientoX][movimientoY].isBlancas(),rey.getPosicionX(),rey.getPosicionY())){// si  aun asi sigue en jacke regresaremos todo table como estaba antes
                                        table[posicionX][posicionY].regresarMovimiento(tablero,posicionOriginalX,posicionOriginalY);
                                        return 3;
                                    }

                                    return 0;
                                }

                                //-------------------------------comer pieza--------------//
                                if ((i+1 == movimientoY || j-1 == movimientoY) && table[posicionX][movimientoY] != null) { // si el movimineto conuerda con un lugar donde no sea nulo, identificara el dueño de la pieza y si es de otro se la come
                                    if (table[movimientoX][movimientoY].isBlancas() != table[posicionX][posicionY].isBlancas()) {
                                    // guardamos en una variable la pieza comida ya que si aun seguimos en jacke debemos regresar todo table la normalidad
                                        piezaComida=tablero.obtenerPieza(movimientoX,movimientoY);
//------------------------------------------------cambiar de posicion con una pieza -------------------------------------------------------------------------//
                                        table[movimientoX][movimientoY].cambiarPosicionPieza(tablero,movimientoX,movimientoY);


                                        //----------------------------------verificar jaque-------------------------------------------//
                                        if ( table[movimientoX][movimientoY].identificarJacke(tablero,table[movimientoX][movimientoY].isBlancas(),rey.getPosicionX(),rey.getPosicionY()))//aqui colocamos la nuevaposicion del rey
                                        {// es verdad si luego de mover la pieza aun seguimos en jacke, entonces abajo debemos regresar el movimiento

                                                       //-----------------------------------regresar pieza comida------------------------------------//
                                                        if (table[movimientoX][movimientoY].regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida) == true) {// si el valor es verdadero  habremos anulado el movimiento

                                                            return 3;

                                                        }
                                        }
                                        else {
                                            return 1;// pieza comida
                                        }

                                    }
                                    else {
                                        return 2;// no se puede comer pieza propia
                                    }
                                }

                            }
                        }
                    }
                }
            }
            // movimiento vertical
            if (posicionY == movimientoY) {
                // si la posicion horizontal menos 1 no es menor que 0 ingresa,
                //hacia arriba
                for (int i = posicionX ; i >= 0; i--) {// al ser un for ingresara directamente en el bucle, en caso de que sea i =-1
                    if (i-1 < 0 || ((table[i-1][posicionY]) instanceof Pieza)) { //si la i = -1 ingresa al siguieente for , sino comprueba hasta que encuente una pieza hacia arriba que seria el limitearriba
                        //abajo
                        for (int j = posicionX; j < 8; j++) {
                            if (j+1 == 8 || ((table[j+1][posicionY]) instanceof Pieza)) {// en caso de que j =8 entra al if, sino se pone table buscar una pieza hacia abjao para encontra el limite
                                if ((movimientoX > i-1 && movimientoX < j+1) && table[movimientoX][posicionY] == null) {// al tener los limites de arriba y abajo, el movimiento debe estar entre esos dos valores sino seria error

                                table[posicionX][posicionY].cambiarPosicion(tablero,movimientoX,movimientoY);


                                    if(table[movimientoX][movimientoY].identificarJacke(tablero,table[movimientoX][movimientoY].isBlancas(),rey.getPosicionX(),rey.getPosicionY())){// si  aun asi sigue en jacke regresaremos todo table como estaba antes
                                        table[posicionX][posicionY].regresarMovimiento(tablero,posicionOriginalX,posicionOriginalY);
                                        return 3;// aun ahy jacke, error
                                    }

                                    return 0;// pieza movida

                                }
//---------------------------------------comer pieza envertical-----------------------------------------------------------//
                                if ((i -1== movimientoX || j+1 == movimientoX) && table[movimientoX][posicionY] != null) { // si el movimineto conuerda con un lugar donde no sea nulo, identificara el dueño de la pieza y si es de otro se la come

                                    if (table[movimientoX][movimientoY].isBlancas() != table[posicionX][posicionY].isBlancas()) {
                                        piezaComida=tablero.obtenerPieza(movimientoX,movimientoY);
                                        table[movimientoX][movimientoY].cambiarPosicionPieza(tablero,movimientoX,movimientoY);

                                        if ( table[movimientoX][movimientoY].identificarJacke(tablero,table[movimientoX][movimientoY].isBlancas(),rey.getPosicionX(),rey.getPosicionY()))
                                        {// es verdad si luego de mover la pieza aun seguimos en jacke, entonces abajo debemos regresar el movimiento
                                            if (table[movimientoX][movimientoY].regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida) == true) {// si el valor es verdadero  habremos anulado el movimiento

                                                return 3;

                                            }
                                        }
                                        return 1;
                                    }
                                    else {
                                        return 2;
                                    }
                                }
                                return 3;
                            }
                        }
                    }
                }
            }
        }
        return 3;
    }





}
