package Piezas.Tipos;

import Piezas.Pieza;
public class Caballo extends Pieza {


    public Caballo(Boolean blancas) {
        super(blancas);
    }


    public int movimientoTotalCaballo(Pieza[][] table, int movimientoX, int movimientoY) {


         // arriba derecha lejos
            if (posicionX - 2==movimientoX && posicionY+1== movimientoY){
                if (table[movimientoX][movimientoY] ==null) {
                    table[movimientoX][movimientoY] = table[posicionX][posicionY];
                    return 0;
                }
                if (table[movimientoX][movimientoY] instanceof Pieza){
                    table[movimientoX][movimientoY] = table[posicionX][posicionY];
                    table[posicionX][posicionY] = null;
                    return 1;
                }
            }

        //arriba izquierda

            if (posicionX - 2== movimientoX && posicionY - 1== movimientoY) {
                if (table[movimientoX][movimientoY] == null) {
                    table[movimientoX][movimientoY] = table[posicionX][posicionY];
                    return  0;
                }
                if (table[posicionX - 2][posicionY - 1] instanceof Pieza){
                    table[movimientoX][movimientoY] = table[posicionX][posicionY];
                    table[posicionX][posicionY] = null;
                    return 1;
                }
            }





            //  derecha arriba
            if (posicionX - 1== movimientoX && posicionY + 2== movimientoY) {
                if (table[movimientoX][movimientoY] ==null) {
                    table[movimientoX][movimientoY] = table[posicionX][posicionY];
                    return  0;
                }
                if (table[posicionX -1][posicionY + 2] instanceof Pieza){
                    table[movimientoX][movimientoY] = table[posicionX][posicionY];
                    table[posicionX][posicionY] = null;
                    return 1;
                }
            }


        //izquierda arriba

            if (posicionX - 1== movimientoX&&posicionY - 2== movimientoY) {
                if (table[movimientoX][movimientoY] ==null) {
                    table[movimientoX][movimientoY] = table[posicionX][posicionY];
                    return  0;
                }
                if (table[posicionX -1][posicionY - 2] instanceof Pieza){
                    table[movimientoX][movimientoY] = table[posicionX][posicionY];
                    table[posicionX][posicionY] = null;
                    return 1;
                }
            }




            //abajo derecha
            if (posicionX + 2==movimientoX &&posicionY + 1==movimientoY)  {
                if (table[movimientoX][movimientoY] == null) {
                    table[movimientoX][movimientoY] = table[posicionX][posicionY];
                    return  0;
                }
                if (table[posicionX +2][posicionY + 1] instanceof Pieza){
                    table[movimientoX][movimientoY] = table[posicionX][posicionY];
                    table[posicionX][posicionY] = null;
                    return 1;
                }
            }


            //abajo izquierda
            if (posicionX + 2 == movimientoX&& posicionY - 1== movimientoY ) {
                if (table[movimientoX][movimientoY]== null) {
                    table[movimientoX][movimientoY] = table[posicionX][posicionY];
                    return  0;
                }
                if (table[posicionX +2][posicionY -1] instanceof Pieza){
                    table[movimientoX][movimientoY] = table[posicionX][posicionY];
                    table[posicionX][posicionY] = null;
                    return 1;
                }
            }


            // derecha abajo
            if (posicionX + 1== movimientoX &&posicionY + 2== movimientoY) {
                if (table[movimientoX][movimientoY] ==null) {
                    table[movimientoX][movimientoY] = table[posicionX][posicionY];
                    return  0;
                }
                if (table[posicionX +1][posicionY + 2] instanceof Pieza){
                    table[movimientoX][movimientoY] = table[posicionX][posicionY];
                    table[posicionX][posicionY] = null;
                    return 1;
                }
            }



            //izquierda abajo
            if (posicionX + 1== movimientoX && posicionY - 2== movimientoY) {
                if (table[movimientoX][movimientoY] == null) {
                    table[movimientoX][movimientoY] = table[posicionX][posicionY];
                    return  0;
                }
                if (table[posicionX +1][posicionY - 2] instanceof Pieza){
                    table[movimientoX][movimientoY] = table[posicionX][posicionY];
                    table[posicionX][posicionY] = null;
                    return 1;
                }
            }
            return 2;
        }




    public void imprimirCaballo() {
        if (this.blancas) {
            System.out.print(red + "♘" + reset);
        } else {
            System.out.print(green + "♘" + reset);
        }
    }

}













