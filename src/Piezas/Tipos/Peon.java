package Piezas.Tipos;

import Piezas.Pieza;
import Tablero.Tablero;

import java.util.Scanner;

public class Peon extends Pieza {
        public Peon(Boolean blanca, int posicionX, int posicionY) {
                super(blanca,posicionX,posicionY);
        }


        public  int  verificarMovimientoPeon(Tablero tablero,int movimientoX, int movimientoY, Scanner teclado) {

            Pieza[][] table = tablero.getTable();
            int posicionOriginalX= posicionX;
            int posicionOriginalY=posicionY;
           Rey rey = tablero.obtenerPiezaReyBlanco(this.blancas);
            Pieza piezaComida;
        if ((movimientoX == posicionX+1 || movimientoX==posicionX+2 ||movimientoX == posicionX-1 || movimientoX==posicionX-2) && (movimientoY==posicionY || movimientoY== posicionY-1 || movimientoY==posicionY+1)) {// unicos casos posibles de movimiento de peon y si no es ninguno devuelve un 3 (error)
    if (table[movimientoX][movimientoY] == table[posicionX][posicionY]) {
        System.out.println("no puedes mover al mismo sitio");
    } else {


        if (this.isBlancas()) {
            //---------------PRIMER MOVIMIENTO DE PEONES------------------------//
             if ((posicionX == 1 && movimientoX == posicionX + 2)&& movimientoY==posicionY) { // si al comenzar quieres saltar dos esapcios el peon
                if ((table[movimientoX][movimientoY] == null)) {
                    table[movimientoX][movimientoY] = table[posicionX][posicionY];
                    table[posicionX][posicionY] = null;
                    table[movimientoX][movimientoY].setPosicionX(movimientoX); //cambiamos la posicion de la nueva pieza movida, ya que aun mantenia la posicion anteiro
                    table[movimientoX][movimientoY].setPosicionY(movimientoY);

                    if (table[movimientoX][movimientoY].identificarJacke(tablero, table[movimientoX][movimientoY].isBlancas(), rey.getPosicionX(), rey.getPosicionY())) {// si  aun asi sigue en jacke regresaremos todo a como estaba antes
                        table[posicionX][posicionY] = table[movimientoX][movimientoY];
                        table[movimientoX][movimientoY] = null;
                        table[posicionX][posicionY].setPosicionX(posicionX);
                        table[posicionX][posicionY].setPosicionY(posicionY);
                        return 3;
                    }

                    return 0;
                }

            }
            //---------------MOVIMIENTO SIEMPLE----------------------------------//
            else if (posicionX + 1 == movimientoX && posicionY == movimientoY) {
                if ((table[movimientoX][movimientoY] == null)) {
                    table[movimientoX][movimientoY] = table[posicionX][posicionY];
                    table[posicionX][posicionY] = null;
                    table[movimientoX][movimientoY].setPosicionX(movimientoX); //cambiamos la posicion de la nueva pieza movida, ya que aun mantenia la posicion anteiro
                    table[movimientoX][movimientoY].setPosicionY(movimientoY);



                    //--------------------TRANSFORMANDO PEON--------------------------------//
                    if (posicionX == 7 ) {// luego de mover el peon si la nueva posicion es 7 significa que podemos cambiar la pieza
                        table [movimientoX][movimientoY]=transformarPeon(table, teclado, movimientoX, movimientoY);
                        if (identificarJacke(tablero,true, rey.getPosicionX(), rey.getPosicionY())){
                            regresarMovimiento(tablero,posicionOriginalX,posicionOriginalY);
                            return 3;
                        }
                        return 0;
                    }

                    if (identificarJacke(tablero, true, rey.getPosicionX(), rey.getPosicionY())) {// si  aun asi sigue en jacke regresaremos todo a como estaba antes
                        table[posicionX][posicionY] = table[movimientoX][movimientoY];
                        table[movimientoX][movimientoY] = null;
                        table[posicionX][posicionY].setPosicionX(posicionX);
                        table[posicionX][posicionY].setPosicionY(posicionY);
                        return 3;
                    }

                    return 0;
                }
            }


                        //- ----------------comer peon------------------------------------------------//
            else if (posicionX + 1 == movimientoX && (posicionY + 1 == movimientoY || posicionY - 1 == movimientoY)) {
                if (table[movimientoX][movimientoY] != null) {
                    if (table[posicionX][posicionY].isBlancas() != table[movimientoX][movimientoY].isBlancas()) {
                        piezaComida = tablero.obtenerPieza(movimientoX, movimientoY);
                        table[movimientoX][movimientoY] = table[posicionX][posicionY];
                        table[posicionX][posicionY] = null;
                        table[movimientoX][movimientoY].setPosicionX(movimientoX); //cambiamos la posicion de la nueva pieza movida, ya que aun mantenia la posicion anteiro
                        table[movimientoX][movimientoY].setPosicionY(movimientoY);


                        //--------------------TRANSFORMANDO PEON--------------------------------//
                        if (posicionX == 7 ) {// luego de mover el peon si la nueva posicion es 7 significa que podemos cambiar la pieza
                            table [movimientoX][movimientoY]=transformarPeon(table, teclado, movimientoX, movimientoY);
                            if (identificarJacke(tablero,true, rey.getPosicionX(), rey.getPosicionY())){
                                regresarMovimiento(tablero,posicionOriginalX,posicionOriginalY);
                                return 3;
                            }
                            return 0;
                        }
                        //-------------------------------------------------------------------------//
                        if (identificarJacke(tablero, table[movimientoX][movimientoY].isBlancas(), rey.getPosicionX(), rey.getPosicionY())) {
                            if (regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida) == true) {// si el valor es verdadero  habremos anulado el movimiento
                                return 3;
                            }
                        }
                        return 1;

                    } else {
                        return 2;
                    }

                }


            }

        }


//----------------------------------------NEGRAS----------------------------------------------------------------//
        else {

            //----------------------MOVIMIENTO DOBLE-------------------------------//
            if ((posicionX == 6 && posicionX - 2 == movimientoX) && movimientoY==posicionY) { // si al comenzar quieres saltar dos esapcios el peon

                if ((table[movimientoX][movimientoY] == null)) {
                    table[movimientoX][movimientoY] = table[posicionX][posicionY];
                    table[posicionX][posicionY] = null;
                    table[movimientoX][movimientoY].setPosicionX(movimientoX); //cambiamos la posicion de la nueva pieza movida, ya que aun mantenia la posicion anteiro
                    table[movimientoX][movimientoY].setPosicionY(movimientoY);

                    if (table[movimientoX][movimientoY].identificarJacke(tablero, table[movimientoX][movimientoY].isBlancas(), rey.getPosicionX(), rey.getPosicionY())) {// si  aun asi sigue en jacke regresaremos todo a como estaba antes
                        table[posicionX][posicionY] = table[movimientoX][movimientoY];
                        table[movimientoX][movimientoY] = null;
                        table[posicionX][posicionY].setPosicionX(posicionX);
                        table[posicionX][posicionY].setPosicionY(posicionY);
                        return 3;
                    }

                    return 0;
                }

            }
//-------------------------------MOVIMIENTO SIMPLE----------------------------------//
            else if (posicionX - 1 == movimientoX && posicionY == movimientoY) {
                if ((table[movimientoX][movimientoY] == null)) {
                    table[movimientoX][movimientoY] = table[posicionX][posicionY];
                    table[posicionX][posicionY] = null;
                    table[movimientoX][movimientoY].setPosicionX(movimientoX); //cambiamos la posicion de la nueva pieza movida, ya que aun mantenia la posicion anteiro
                    table[movimientoX][movimientoY].setPosicionY(movimientoY);
                    if (posicionX == 0 ) {// luego de mover el peon si la nueva posicion es 7 significa que podemos cambiar la pieza
                        table [movimientoX][movimientoY]=transformarPeon(table, teclado, movimientoX, movimientoY);
                        if (identificarJacke(tablero,false, rey.getPosicionX(), rey.getPosicionY())){
                            regresarMovimiento(tablero,posicionOriginalX,posicionOriginalY);
                            return 3;
                        }
                        return 0;
                    }
                    if (table[movimientoX][movimientoY].identificarJacke(tablero, table[movimientoX][movimientoY].isBlancas(), rey.getPosicionX(), rey.getPosicionY())) {// si  aun asi sigue en jacke regresaremos todo a como estaba antes
                        table[posicionX][posicionY] = table[movimientoX][movimientoY];
                        table[movimientoX][movimientoY] = null;
                        table[posicionX][posicionY].setPosicionX(posicionX);
                        table[posicionX][posicionY].setPosicionY(posicionY);
                        return 3;
                    }

                    return 0;
                }
            }

       //-----------------COMER PIEZA--------------------------------//
            else if (posicionX - 1 == movimientoX && (posicionY - 1 == movimientoY || posicionY + 1 == movimientoY)) {
                if (table[movimientoX][movimientoY] != null) {
                    if (table[posicionX][posicionY].isBlancas() != table[movimientoX][movimientoY].isBlancas()) {
                        piezaComida = tablero.obtenerPieza(movimientoX, movimientoY);
                        table[movimientoX][movimientoY] = table[posicionX][posicionY];
                        table[posicionX][posicionY] = null;
                        table[movimientoX][movimientoY].setPosicionX(movimientoX); //cambiamos la posicion de la nueva pieza movida, ya que aun mantenia la posicion anteiro
                        table[movimientoX][movimientoY].setPosicionY(movimientoY);
                        if (posicionX == 0 ) {// luego de mover el peon si la nueva posicion es 7 significa que podemos cambiar la pieza
                             table [movimientoX][movimientoY]=transformarPeon(table, teclado, movimientoX, movimientoY);
                            if (identificarJacke(tablero,false, rey.getPosicionX(), rey.getPosicionY())){
                                regresarMovimiento(tablero,posicionOriginalX,posicionOriginalY);
                                return 3;
                            }
                            return 0;
                        }
                        if (identificarJacke(tablero, table[movimientoX][movimientoY].isBlancas(), rey.getPosicionX(), rey.getPosicionY())) {
                            if (regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida) == true) {// si el valor es verdadero  habremos anulado el movimiento
                                return 3;
                            }
                        }
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

        public int movimientoPeon(Scanner teclado , Tablero tablero) {//posicionX y posicionY son las coordenadas ingresadas por el jugador
            System.out.println("ingrese a que fila quiere mover el peon");
            int movimientoX = teclado.nextInt() - 1;
            System.out.println("ingrese la columna");
            int movimientoY = teclado.nextInt() - 1;
            int opcionMovimiento=      verificarMovimientoPeon(tablero,movimientoX,movimientoY,teclado);
            if (opcionMovimiento==0){
                System.out.println("pieza movida");
                return 0;
            }
            else if (opcionMovimiento==1) {
                System.out.println("pieza comida");
                return 0;
            }
            else if (opcionMovimiento==2){
                System.out.println("no puedes comer tu propia pieza");
                return 1;
            }
            else {
                System.out.println("movimiento invalido");
                return 1;
            }


                        }

        public Pieza transformarPeon(Pieza[][] table, Scanner teclado, int movimientoX, int moviminetoY) {
                System.out.println("elige en que quieres transformar tu peon");
                System.out.println("1 torre");
                System.out.println("2 alfil");
                System.out.println("3 caballo");
                int opcion = teclado.nextInt();
                switch (opcion) {
                        case 1:
                                return new Torre(table[movimientoX][moviminetoY].isBlancas(),movimientoX,moviminetoY);
                        case 2:
                                return new Alfil(table[movimientoX][moviminetoY].isBlancas());

                        case 3:
                                return new Caballo(table[movimientoX][moviminetoY].isBlancas(),movimientoX,moviminetoY);
                        default:
                                System.out.println("error");
                                return null;
                }
        }


        public void imprimirPeon(){
                if (this.blancas) {
                        System.out.print(red + "♙" + reset);
                }
                else {
                        System.out.print(green + "♙" + reset);
                }
        }





}