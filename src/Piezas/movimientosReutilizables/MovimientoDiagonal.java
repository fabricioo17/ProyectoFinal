package Piezas.movimientosReutilizables;

import Piezas.Pieza;
import Tablero.Tablero;

public interface MovimientoDiagonal {
    default int  movimientoDiagonal(Tablero tablero, int movimientoX, int movimientoY, int posicionX, int posicionY){
        Pieza  [][] a= tablero.getTable();
        if (tablero.obtenerPieza(posicionX,posicionY)!= tablero.obtenerPieza(movimientoX,movimientoY)) {
            //arriba izquierda
            // ARRIBA IZQUIERDA
            if (movimientoX<posicionX && movimientoY<posicionY){
                for (int i = posicionX, j = posicionY  ; i >=0 && j >=0; i--,j--){
                    if ((i-1== -1 || j-1==-1) || a[i-1][j-1] instanceof Pieza) {
                        if ((movimientoX >i-1 && movimientoY>j-1) && a[posicionX][movimientoY] == null) {// al tener los limites de arriba y abajo, el movimiento debe estar entre esos dos valores sino seria error
                            a[movimientoX][movimientoY] = a[posicionX][posicionY];
                            a[posicionX][posicionY] = null;
                            return 0;
                        }
                        if ((i-1 == movimientoX && j-1 == movimientoY) && a[movimientoX][movimientoY] != null) { // si el movimineto conuerda con un lugar donde no sea nulo, identificara el dueño de la pieza y si es de otro se la come
                            if (a[movimientoX][movimientoY].isBlancas() != a[posicionX][posicionY].isBlancas()) {
                                a[movimientoX][movimientoY] = a[posicionX][posicionY];
                                a[posicionX][posicionY] = null;
                                return 1;
                            } else {
                                return 2;
                            }
                        }
                    }
                }
            }

            //ARRIBA DERECHA
            if (movimientoX<posicionX && movimientoY>posicionY) {
                //arriba
                for (int i = posicionX, j = posicionY  ; i >=0 && j<8; i--,j++){
                    if ((i -1== -1 || j+1==8)|| a[i-1][j+1] instanceof Pieza) {
                        if ((movimientoX >i-1 && movimientoY<j+1) && a[movimientoX][movimientoY] == null) {// al tener los limites de arriba y abajo, el movimiento debe estar entre esos dos valores sino seria error
                            a[movimientoX][movimientoY] = a[posicionX][posicionY];
                            a[posicionX][posicionY] = null;
                            return 0;
                        }
                        if ((i-1 == movimientoX && j+1 == movimientoY) && a[movimientoX][movimientoY] != null) { // si el movimineto conuerda con un lugar donde no sea nulo, identificara el dueño de la pieza y si es de otro se la come
                            if (a[movimientoX][movimientoY].isBlancas() != a[posicionX][posicionY].isBlancas()) {
                                a[movimientoX][movimientoY] = a[posicionX][posicionY];
                                a[posicionX][posicionY] = null;
                                return 1;
                            } else {
                                return 2;
                            }
                        }

                    }
                }
            }






            // ABAJO IZQUIERDA
            if (movimientoX>posicionX && movimientoY<posicionY) {
                for (int i = posicionX, j = posicionY  ; i <8 && j>=0; i++,j--){
                    if ((i +1== 8 || j-1==-1)|| a[i+1][j-1] instanceof Pieza) {
                        if ((movimientoX <i+1 && movimientoY>j-1) && a[movimientoX][movimientoY] == null) {// al tener los limites de arriba y abajo, el movimiento debe estar entre esos dos valores sino seria error
                            a[movimientoX][movimientoY] = a[posicionX][posicionY];
                            a[posicionX][posicionY] = null;
                            return 0;
                        }
                        if ((i+1 == movimientoX && j-1 == movimientoY) && a[movimientoX][movimientoY] != null) { // si el movimineto conuerda con un lugar donde no sea nulo, identificara el dueño de la pieza y si es de otro se la come
                            if (a[movimientoX][movimientoY].isBlancas() != a[posicionX][posicionY].isBlancas()) {
                                a[movimientoX][movimientoY] = a[posicionX][posicionY];
                                a[posicionX][posicionY] = null;
                                return 1;
                            } else {
                                return 2;
                            }
                        }

                    }
                }
            }





            //ABAJO DERECHA
            if (movimientoX>posicionX && movimientoY>posicionY) {
                for (int i = posicionX, j = posicionY  ; i <8 && j < 8; i++,j++){
                    if ((i +1== 8 || j+1==8)|| a[i+1][j+1] instanceof Pieza) {
                        if ((movimientoX <i+1 && movimientoY<j+1) && a[movimientoX][movimientoY] == null)
                        {// al tener los limites de arriba y abajo, el movimiento debe estar entre esos dos valores sino seria error
                            a[movimientoX][movimientoY] = a[posicionX][posicionY];
                            a[posicionX][posicionY] = null;
                            return 0;
                        }

                        if ((i+1 == movimientoX && j+1 == movimientoY) && a[movimientoX][movimientoY] != null) { // si el movimineto conuerda con un lugar donde no sea nulo, identificara el dueño de la pieza y si es de otro se la come
                            if (a[movimientoX][movimientoY].isBlancas() != a[posicionX][posicionY].isBlancas()) {
                                a[movimientoX][movimientoY] = a[posicionX][posicionY];
                                a[posicionX][posicionY] = null;
                                return 1;
                            } else {
                                return 2;
                            }
                        }

                    }
                }
            }
        }
        return 3;
    }


}
