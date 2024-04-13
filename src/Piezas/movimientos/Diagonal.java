package Piezas.movimientos;

import Piezas.Pieza;

public interface Diagonal {

    default int  movimientoDiagonal(Pieza[][] table, int movimientoX, int movimientoY, int posicionX, int posicionY){
        if (table[movimientoX][movimientoY] != table[posicionX][posicionY]) {
            //arriba izquierda
            // ARRIBA IZQUIERDA
            if (movimientoX<posicionX && movimientoY<posicionY){
                for (int i = posicionX, j = posicionY  ; i >=0 && j >=0; i--,j--){
                    if ((i-1== -1 || j-1==-1) || table[i-1][j-1] instanceof Pieza) {
                        if ((movimientoX >i-1 && movimientoY>j-1) && table[posicionX][movimientoY] == null) {// al tener los limites de arriba y abajo, el movimiento debe estar entre esos dos valores sino seria error
                            table[movimientoX][movimientoY] = table[posicionX][posicionY];
                            table[posicionX][posicionY] = null;
                            return 0;
                        }
                        if ((i-1 == movimientoX && j-1 == movimientoY) && table[movimientoX][movimientoY] != null) { // si el movimineto conuerda con un lugar donde no sea nulo, identificara el dueño de la pieza y si es de otro se la come
                            if (table[movimientoX][movimientoY].getPropietario() != table[posicionX][posicionY].getPropietario()) {
                                table[movimientoX][movimientoY] = table[posicionX][posicionY];
                                table[posicionX][posicionY] = null;
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
                    if ((i -1== -1 || j+1==8)|| table[i-1][j+1] instanceof Pieza) {
                        if ((movimientoX >i-1 && movimientoY<j+1) && table[movimientoX][movimientoY] == null) {// al tener los limites de arriba y abajo, el movimiento debe estar entre esos dos valores sino seria error
                            table[movimientoX][movimientoY] = table[posicionX][posicionY];
                            table[posicionX][posicionY] = null;
                            return 0;
                        }
                        if ((i-1 == movimientoX && j+1 == movimientoY) && table[movimientoX][movimientoY] != null) { // si el movimineto conuerda con un lugar donde no sea nulo, identificara el dueño de la pieza y si es de otro se la come
                            if (table[movimientoX][movimientoY].getPropietario() != table[posicionX][posicionY].getPropietario()) {
                                table[movimientoX][movimientoY] = table[posicionX][posicionY];
                                table[posicionX][posicionY] = null;
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
                    if ((i +1== 8 || j-1==-1)|| table[i+1][j-1] instanceof Pieza) {
                        if ((movimientoX <i+1 && movimientoY>j-1) && table[movimientoX][movimientoY] == null) {// al tener los limites de arriba y abajo, el movimiento debe estar entre esos dos valores sino seria error
                            table[movimientoX][movimientoY] = table[posicionX][posicionY];
                            table[posicionX][posicionY] = null;
                            return 0;
                        }
                        if ((i+1 == movimientoX && j-1 == movimientoY) && table[movimientoX][movimientoY] != null) { // si el movimineto conuerda con un lugar donde no sea nulo, identificara el dueño de la pieza y si es de otro se la come
                            if (table[movimientoX][movimientoY].getPropietario() != table[posicionX][posicionY].getPropietario()) {
                                table[movimientoX][movimientoY] = table[posicionX][posicionY];
                                table[posicionX][posicionY] = null;
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
                    if ((i +1== 8 || j+1==8)|| table[i+1][j+1] instanceof Pieza) {
                        if ((movimientoX <i+1 && movimientoY<j+1) && table[movimientoX][movimientoY] == null)
                        {// al tener los limites de arriba y abajo, el movimiento debe estar entre esos dos valores sino seria error
                            table[movimientoX][movimientoY] = table[posicionX][posicionY];
                            table[posicionX][posicionY] = null;
                            return 0;
                        }

                        if ((i+1 == movimientoX && j+1 == movimientoY) && table[movimientoX][movimientoY] != null) { // si el movimineto conuerda con un lugar donde no sea nulo, identificara el dueño de la pieza y si es de otro se la come
                            if (table[movimientoX][movimientoY].getPropietario() != table[posicionX][posicionY].getPropietario()) {
                                table[movimientoX][movimientoY] = table[posicionX][posicionY];
                                table[posicionX][posicionY] = null;
                                return 1;
                            } else {
                                return 2;
                            }
                        }
                        return 2;
                    }
                }
            }
        }
        return 2;
    }
}
