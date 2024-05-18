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
           Rey rey = tablero.obtenerPiezaReyBlanco(this.roja);
            Pieza piezaComida;
        if ((movimientoX == posicionX+1 || movimientoX==posicionX+2 ||movimientoX == posicionX-1 || movimientoX==posicionX-2) && (movimientoY==posicionY || movimientoY== posicionY-1 || movimientoY==posicionY+1)) {// unicos casos posibles de movimiento de peon y si no es ninguno devuelve un 3 (error)
    if (table[movimientoX][movimientoY] == table[posicionX][posicionY]) {
        System.out.println("no puedes mover al mismo sitio");
    } else {


        if (this.isRoja()) {
            //---------------PRIMER MOVIMIENTO DE PEONES------------------------//
             if ((posicionX == 1 && movimientoX == posicionX + 2)&& movimientoY==posicionY) { // si al comenzar quieres saltar dos esapcios el peon
                if ((table[movimientoX][movimientoY] == null)) {
                    cambiarPosicion(tablero,movimientoX,movimientoY);

                    if (table[movimientoX][movimientoY].confirmarJaque(tablero, rey.getPosicionX(), rey.getPosicionY())) {// si  aun asi sigue en jacke regresaremos todo a como estaba antes
                        regresarMovimiento(tablero,posicionOriginalX,posicionOriginalY);
                        return 3;
                    }

                    return 0;
                }

            }
            //---------------MOVIMIENTO SIEMPLE----------------------------------//
            else if (posicionX + 1 == movimientoX && posicionY == movimientoY) {
                if ((table[movimientoX][movimientoY] == null)) {
                   cambiarPosicion(tablero,movimientoX,movimientoY);



                    //--------------------TRANSFORMANDO PEON--------------------------------//
                    if (posicionX == 7 ) {// luego de mover el peon si la nueva posicion es 7 significa que podemos cambiar la pieza
                        table [movimientoX][movimientoY]=transformarPeon(table, teclado, movimientoX, movimientoY);
                        if (confirmarJaque(tablero, rey.getPosicionX(), rey.getPosicionY())){
                            regresarMovimiento(tablero,posicionOriginalX,posicionOriginalY);
                            return 3;
                        }
                        return 0;
                    }

                    if (confirmarJaque(tablero,  rey.getPosicionX(), rey.getPosicionY())) {// si  aun asi sigue en jacke regresaremos todo a como estaba antes
                        regresarMovimiento(tablero,posicionOriginalX,posicionOriginalY);
                        return 3;
                    }

                    return 0;
                }
            }


                        //- ----------------comer peon------------------------------------------------//
            else if (posicionX + 1 == movimientoX && (posicionY + 1 == movimientoY || posicionY - 1 == movimientoY)) {
                if (table[movimientoX][movimientoY] != null) {
                    if (table[posicionX][posicionY].isRoja() != table[movimientoX][movimientoY].isRoja()) {
                        piezaComida = tablero.obtenerPieza(movimientoX, movimientoY);
                        cambiarPosicionPieza(tablero,movimientoX,movimientoY);


                        //--------------------TRANSFORMANDO PEON--------------------------------//
                        if (posicionX == 7 ) {// luego de mover el peon si la nueva posicion es 7 significa que podemos cambiar la pieza
                            table [movimientoX][movimientoY]=transformarPeon(table, teclado, movimientoX, movimientoY);
                            if (confirmarJaque(tablero, rey.getPosicionX(), rey.getPosicionY())){
                                regresarMovimiento(tablero,posicionOriginalX,posicionOriginalY);
                                return 3;
                            }
                            return 0;
                        }
                        //-------------------------------------------------------------------------//
                        if (confirmarJaque(tablero, rey.getPosicionX(), rey.getPosicionY())) {
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
                   cambiarPosicionPieza(tablero,movimientoX,movimientoY);

                    if (table[movimientoX][movimientoY].confirmarJaque(tablero, rey.getPosicionX(), rey.getPosicionY())) {// si  aun asi sigue en jacke regresaremos todo a como estaba antes
                     regresarMovimiento(tablero,posicionOriginalX,posicionOriginalY);
                        return 3;
                    }

                    return 0;
                }

            }
//-------------------------------MOVIMIENTO SIMPLE----------------------------------//
            else if (posicionX - 1 == movimientoX && posicionY == movimientoY) {
                if ((table[movimientoX][movimientoY] == null)) {
                  cambiarPosicion(tablero,movimientoX,movimientoY);

                    if (posicionX == 0 ) {// luego de mover el peon si la nueva posicion es 7 significa que podemos cambiar la pieza
                        table [movimientoX][movimientoY]=transformarPeon(table, teclado, movimientoX, movimientoY);
                        if (confirmarJaque(tablero, rey.getPosicionX(), rey.getPosicionY())){
                            regresarMovimiento(tablero,posicionOriginalX,posicionOriginalY);
                            return 3;
                        }
                        return 0;
                    }
                    if (table[movimientoX][movimientoY].confirmarJaque(tablero, rey.getPosicionX(), rey.getPosicionY())) {// si  aun asi sigue en jacke regresaremos todo a como estaba antes
                        regresarMovimiento(tablero,posicionOriginalX,posicionOriginalY);
                        return 3;
                    }

                    return 0;
                }
            }

       //-----------------COMER PIEZA--------------------------------//
            else if (posicionX - 1 == movimientoX && (posicionY - 1 == movimientoY || posicionY + 1 == movimientoY)) {
                if (table[movimientoX][movimientoY] != null) {
                    if (table[posicionX][posicionY].isRoja() != table[movimientoX][movimientoY].isRoja()) {
                        piezaComida = tablero.obtenerPieza(movimientoX, movimientoY);
                       cambiarPosicionPieza(tablero,movimientoX,movimientoY);

                        if (posicionX == 0 ) {// luego de mover el peon si la nueva posicion es 7 significa que podemos cambiar la pieza
                             table [movimientoX][movimientoY]=transformarPeon(table, teclado, movimientoX, movimientoY);
                            if (confirmarJaque(tablero, rey.getPosicionX(), rey.getPosicionY())){
                                regresarMovimiento(tablero,posicionOriginalX,posicionOriginalY);
                                return 3;
                            }
                            return 0;
                        }
                        if (confirmarJaque(tablero, rey.getPosicionX(), rey.getPosicionY())) {
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
                 System.out.println("4 reina");
                int opcion = teclado.nextInt();
                switch (opcion) {
                        case 1:
                                return new Torre(table[movimientoX][moviminetoY].isRoja(),movimientoX,moviminetoY);
                        case 2:
                                return new Alfil(table[movimientoX][moviminetoY].isRoja(),movimientoX,moviminetoY);

                        case 3:
                                return new Caballo(table[movimientoX][moviminetoY].isRoja(),movimientoX,moviminetoY);

                    case 4:
                        return  new Reina(table[movimientoX][moviminetoY].isRoja(),movimientoX,moviminetoY);
                        default:
                                System.out.println("error");
                                return null;
                }
        }

    @Override
    public boolean protegerRey(Tablero tablero, int posicionX, int posicionY, boolean blanco) {
        Pieza piezaComida;
        Rey rey = tablero.obtenerPiezaReyBlanco(blanco);
        Pieza[][] table = tablero.getTable();
        // obtenemos el rey para que en cada movieminto veamos si podemos proteger al rey
        int posicionOriginalX = posicionX;
        int posicionOriginalY = posicionY;

           //---------------hacia abajo----------------------//
        if (blanco==true) {
            if ((table[posicionX+1][posicionY] == null)) {
                cambiarPosicion(tablero, posicionX + 1, posicionY );
                if (confirmarJaque(tablero, rey.getPosicionX(), rey.getPosicionY()) == false) {
                    regresarMovimiento(tablero, posicionOriginalX, posicionOriginalY);
                    return true;
                }
                regresarMovimiento(tablero, posicionOriginalX, posicionOriginalY);
            }

            //-----------comer hacia izquierda
            if (posicionY!=0 && table[posicionX +1][posicionY-1] != null){
                if (table[posicionX + 1][posicionY - 1].isRoja() != roja) {
                    piezaComida = tablero.obtenerPieza(posicionX+ 1, posicionY - 1);
                    cambiarPosicionPieza(tablero, posicionX + 1, posicionY -1);
                    if (confirmarJaque(tablero, rey.getPosicionX(), rey.getPosicionY())==false) {
                        regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida);
                        return true;
                    }
                    regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida);
                }
            }




            //-----------comer hacia derecha
            if (posicionY!=7 &&table[posicionX +1][posicionY+1] != null){
                if (table[posicionX + 1][posicionY + 1].isRoja() != roja) {
                    piezaComida = tablero.obtenerPieza(posicionX+ 1, posicionY + 1);
                    cambiarPosicionPieza(tablero, posicionX + 1, posicionY +1);
                    if (confirmarJaque(tablero, rey.getPosicionX(), rey.getPosicionY())==false) {
                        regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida);
                        return true;
                    }
                    regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida);
                }
            }

        }
        else {
//--------------------------hacia arriba
            if ((table[posicionX-1][posicionY] == null)) {
                cambiarPosicion(tablero, posicionX - 1, posicionY );
                if (confirmarJaque(tablero, rey.getPosicionX(), rey.getPosicionY()) == false) {
                    regresarMovimiento(tablero, posicionOriginalX, posicionOriginalY);
                    return true;
                }
                regresarMovimiento(tablero, posicionOriginalX, posicionOriginalY);
            }

            //-----------comer hacia izquierda
            if (posicionY!=0 &&table[posicionX -1][posicionY-1] == null){
                if (table[posicionX + 1][posicionY - 1].isRoja() != roja) {
                    piezaComida = tablero.obtenerPieza(posicionX- 1, posicionY - 1);
                    cambiarPosicionPieza(tablero, posicionX - 1, posicionY -1);
                    if (confirmarJaque(tablero, rey.getPosicionX(), rey.getPosicionY())==false) {
                        regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida);
                        return true;
                    }
                    regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida);
                }
            }




            //-----------comer hacia derecha
            if (posicionY!=7 && table[posicionX -1][posicionY+1] == null){
                if (table[posicionX -1][posicionY + 1].isRoja() != roja) {
                    piezaComida = tablero.obtenerPieza(posicionX- 1, posicionY + 1);
                    cambiarPosicionPieza(tablero, posicionX - 1, posicionY +1);
                    if (confirmarJaque(tablero, rey.getPosicionX(), rey.getPosicionY())==false) {
                        regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida);
                        return true;
                    }
                    regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida);
                }
            }




        }

            return false;
    }

    public void imprimirPeon(){
                if (this.roja) {
                        System.out.print(red + "♙" + reset);
                }
                else {
                        System.out.print(green + "♙" + reset);
                }
        }





}