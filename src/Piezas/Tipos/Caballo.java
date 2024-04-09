package Piezas.Tipos;

import Piezas.Jugadores;
import Piezas.Pieza;

/*
    public Caballo(Jugadores propietario) {
        super(propietario);
    }


    public void espacioDisponibleCaballo(Pieza[][] table) {


        if (posicionX > 1 && posicionY < 7) {
            // arriba derecha lejos
            if (table[posicionX - 2][posicionY + 1] instanceof Bloqueo) {
                table[posicionX - 2][posicionY + 1] = null;
            }
        }
        //arriba izquierda
        if (posicionX > 1 && posicionY > 0) {
            if (table[posicionX - 2][posicionY - 1] instanceof Bloqueo) {
                table[posicionX - 2][posicionY - 1] = null;
            }
        }

        if (posicionX > 0 && posicionY < 6) {

            //  derecha arriba
            if (table[posicionX - 1][posicionY + 2] instanceof Bloqueo) {
                table[posicionX - 1][posicionY + 2] = null;
            }
        }

        //izquierda arriba
        if (posicionX>0 && posicionY >1){
            if (table[posicionX - 1][posicionY - 2] instanceof Bloqueo) {
                table[posicionX - 1][posicionY - 2] = null;
            }
    }



        if (posicionX <6 && posicionY <7 ) {
            //abajo derecha
            if (table[posicionX + 2][posicionY + 1] instanceof Bloqueo) {
                table[posicionX + 2][posicionY + 1] = null;
            }
        }
        if (posicionX <6 && posicionY >0) {
            //abajo izquierda
            if (table[posicionX + 2][posicionY - 1] instanceof Bloqueo) {
                table[posicionX + 2][posicionY - 1] = null;
            }
        }
        if (posicionX <7 && posicionY <6) {
            // derecha abajo
            if (table[posicionX + 1][posicionY + 2] instanceof Bloqueo) {
                table[posicionX + 1][posicionY + 2] = null;
            }
        }
        if (posicionX <7 && posicionY >1){

            //izquierda abajo
            if (table[posicionX+1][posicionY-2] instanceof  Bloqueo){
                table[posicionX+1][posicionY-2]=null;
            }
        }

    }

    public boolean comerPiezaCaballo(int movimientoX, int movimientoY, Pieza[][]table){
        if (table[posicionX][posicionY].getPropietario()!=table[movimientoX][movimientoY].getPropietario()) {
            if (posicionX != movimientoX && posicionY != movimientoY) {
                if (table[movimientoX][movimientoY] instanceof Pieza && !(table[movimientoX][movimientoY] instanceof Bloqueo)) {
                   //come abajo derecha o izqierda
                    if ((posicionX + 2 == movimientoX && posicionY + 1 == movimientoY)|| (posicionX + 2 == movimientoX && posicionY - 1 == movimientoY) ) {
                                table[movimientoX][movimientoY] = table[posicionX][posicionY];
                                table[posicionX][posicionY] = null;
                    return true;
                    }

                    // come arriba derecha o izquierda
                    if ((posicionX - 2 == movimientoX && posicionY + 1 == movimientoY)|| (posicionX - 2 == movimientoX && posicionY - 1 == movimientoY) ) {
                        table[movimientoX][movimientoY] = table[posicionX][posicionY];
                        table[posicionX][posicionY] = null;
                    return  true;
                    }
                        // come derecha, arriba o abajo
                    if ((posicionX -1 == movimientoX && posicionY + 2 == movimientoY)|| (posicionX +1 == movimientoX && posicionY +2 == movimientoY) ) {
                        table[movimientoX][movimientoY] = table[posicionX][posicionY];
                        table[posicionX][posicionY] = null;
                        return true;
                    }
                    // come izquieda , arriba o abajo
                    if ((posicionX -1 == movimientoX && posicionY -2 == movimientoY)|| (posicionX +1 == movimientoX && posicionY-2 == movimientoY) ) {
                        table[movimientoX][movimientoY] = table[posicionX][posicionY];
                        table[posicionX][posicionY] = null;
                        return true;
                    }

                }
            }
        }
        return false;

    }

    public void imprimirCaballo(){
        if (this.propietario==Jugadores.jugador1) {
            System.out.print(red + "♘" + reset);
        }
        else {
            System.out.print(green + "♘" + reset);
        }
        }
    }













*/