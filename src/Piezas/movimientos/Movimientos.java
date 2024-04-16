package Piezas.movimientos;
import Piezas.Pieza;
public interface Movimientos {
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
                            if (table[movimientoX][movimientoY].isBlancas() != table[posicionX][posicionY].isBlancas()) {
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
                            if (table[movimientoX][movimientoY].isBlancas() != table[posicionX][posicionY].isBlancas()) {
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
                            if (table[movimientoX][movimientoY].isBlancas() != table[posicionX][posicionY].isBlancas()) {
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
                            if (table[movimientoX][movimientoY].isBlancas() != table[posicionX][posicionY].isBlancas()) {
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




//---------------------Movimientos vertical  y horizontak--------------------//

    default int movimientoTotalTorre(Pieza[][] table, int movimientoX, int movimientoY, int posicionX, int posicionY) {
        //horizontal
        if (table[movimientoX][movimientoY] != table[posicionX][posicionY]) {
            if (posicionX == movimientoX) {// si se mueve en la misma fila
                // primero vemos si la pieza esta al extemo derecha y evitar el error de cantidad de arryar
                for (int i = posicionY ; i < 8; i++) {
                    if (i +1== 8 || table[posicionX][i+1] instanceof Pieza) {
                        //hacia la izquierda//
                        for (int j = posicionY ; j >= 0; j--) {
                            if (j -1== -1 || table[posicionX][j-1] instanceof Pieza) {
                                if ((movimientoY < i+1 && movimientoY > j-1) && table[posicionX][movimientoY] == null) {// al tener los limites de arriba y abajo, el movimiento debe estar entre esos dos valores sino seria error
                                    table[movimientoX][movimientoY] = table[posicionX][posicionY];
                                    table[posicionX][posicionY] = null;
                                    return 0;
                                }
                                if ((i+1 == movimientoY || j-1 == movimientoY) && table[posicionX][movimientoY] != null) { // si el movimineto conuerda con un lugar donde no sea nulo, identificara el dueño de la pieza y si es de otro se la come
                                    if (table[movimientoX][movimientoY].isBlancas() != table[posicionX][posicionY].isBlancas()) {
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
                            if (j+1 == 8 || ((table[j+1][posicionY]) instanceof Pieza)) {// en caso de que j =8 entra al if, sino se pone a buscar una pieza hacia abjao para encontra el limite
                                if ((movimientoX > i-1 && movimientoX < j+1) && table[movimientoX][posicionY] == null) {// al tener los limites de arriba y abajo, el movimiento debe estar entre esos dos valores sino seria error
                                    table[movimientoX][movimientoY] = table[posicionX][posicionY];
                                    table[posicionX][posicionY] = null;
                                    return 0;
                                }

                                if ((i -1== movimientoX || j+1 == movimientoX) && table[movimientoX][posicionY] != null) { // si el movimineto conuerda con un lugar donde no sea nulo, identificara el dueño de la pieza y si es de otro se la come
                                    if (table[movimientoX][movimientoY].isBlancas() != table[posicionX][posicionY].isBlancas()) {
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
                }
            }
        }
        return 2;
    }































}
