package Piezas.Tipos;

import Piezas.Pieza;
import Tablero.Tablero;

import java.util.Scanner;

public class Caballo extends Pieza {


    public Caballo(Boolean blancas, int posicionX, int posicionY) {
        super(blancas,posicionX,posicionY);
    }


    public  int movimientoCaballo (Scanner teclado,Tablero tablero){
        System.out.println("ingrese a que fila quiere mover el caballo");
        int x = teclado.nextInt()-1;
        System.out.println("ingrese la columna");
        int y = teclado.nextInt()-1;
        int opcionMovimiento= movimientoTotalCaballo(tablero,x,y);
        if (opcionMovimiento==0){
            System.out.println("pieza movida");
            return 0;
        } else if (opcionMovimiento==1) {
            System.out.println("pieza comida");
            return 0;
        }
        else {
            System.out.println("movimiento invalido");
            return 1;
        }
    }


    public int movimientoTotalCaballo( Tablero tablero, int movimientoX, int movimientoY) {
        Pieza[][] table = tablero.getTable();
        int posicionOriginalX= posicionX;
        int posicionOriginalY=posicionY;
        Rey rey = tablero.obtenerPiezaReyBlanco(table[posicionOriginalX][posicionOriginalY].isBlancas());
        Pieza piezaComida;

         // arriba derecha lejos
            if (posicionX - 2==movimientoX && posicionY+1== movimientoY){
                if (table[movimientoX][movimientoY] ==null) {
                    cambiarPosicion(tablero,movimientoX,movimientoY);
                    if (confirmarJaque(tablero,rey.getPosicionX(),rey.getPosicionY())){
                        regresarMovimiento(tablero,posicionOriginalX,posicionOriginalY);
                        return 3;
                    }
                    return  0;
                }
                if (table[movimientoX][movimientoY] != null &&table[movimientoX][movimientoY].isBlancas()!=blancas){
                    piezaComida=tablero.obtenerPieza(movimientoX,movimientoY);
                    cambiarPosicionPieza(tablero,movimientoX,movimientoY);
                    if (confirmarJaque(tablero,rey.getPosicionX(),rey.getPosicionY())){
                        regresarPiezaComida(tablero,posicionOriginalX,posicionOriginalY,piezaComida);
                        return 3;
                    }
                    return 1;
                }
            }

        //arriba izquierda

            if (posicionX - 2== movimientoX && posicionY - 1== movimientoY) {
                if (table[movimientoX][movimientoY] == null) {
                    cambiarPosicion(tablero,movimientoX,movimientoY);
                    if (confirmarJaque(tablero,rey.getPosicionX(),rey.getPosicionY())){
                        regresarMovimiento(tablero,posicionOriginalX,posicionOriginalY);
                        return 3;
                    }
                    return  0;
                }
                if (table[posicionX - 2][posicionY - 1] instanceof Pieza  &&table[movimientoX][movimientoY].isBlancas()!=blancas){
                    piezaComida=tablero.obtenerPieza(movimientoX,movimientoY);
                    cambiarPosicionPieza(tablero,movimientoX,movimientoY);
                    if (confirmarJaque(tablero,rey.getPosicionX(),rey.getPosicionY())){
                        regresarPiezaComida(tablero,posicionOriginalX,posicionOriginalY,piezaComida);
                        return 3;
                    }
                    return 1;
                }
            }





            //  derecha arriba
            if (posicionX - 1== movimientoX && posicionY + 2== movimientoY) {
                if (table[movimientoX][movimientoY] ==null) {
                    cambiarPosicion(tablero,movimientoX,movimientoY);
                    if (confirmarJaque(tablero,rey.getPosicionX(),rey.getPosicionY())){
                        regresarMovimiento(tablero,posicionOriginalX,posicionOriginalY);
                        return 3;
                    }
                    return  0;
                }
                if (table[posicionX -1][posicionY + 2] instanceof Pieza  &&table[movimientoX][movimientoY].isBlancas()!=blancas){
                    piezaComida=tablero.obtenerPieza(movimientoX,movimientoY);
                    cambiarPosicionPieza(tablero,movimientoX,movimientoY);
                    if (confirmarJaque(tablero,rey.getPosicionX(),rey.getPosicionY())){
                        regresarPiezaComida(tablero,posicionOriginalX,posicionOriginalY,piezaComida);
                        return 3;
                    }
                    return 1;
                }
            }


        //izquierda arriba

            if (posicionX - 1== movimientoX&&posicionY - 2== movimientoY) {
                if (table[movimientoX][movimientoY] ==null) {
                    cambiarPosicion(tablero,movimientoX,movimientoY);
                    if (confirmarJaque(tablero,rey.getPosicionX(),rey.getPosicionY())){
                        regresarMovimiento(tablero,posicionOriginalX,posicionOriginalY);
                        return 3;
                    }
                    return  0;
                }
                if (table[posicionX -1][posicionY - 2] instanceof Pieza  &&table[movimientoX][movimientoY].isBlancas()!=blancas){
                    piezaComida=tablero.obtenerPieza(movimientoX,movimientoY);
                    cambiarPosicionPieza(tablero,movimientoX,movimientoY);
                    if (confirmarJaque(tablero,rey.getPosicionX(),rey.getPosicionY())){
                        regresarPiezaComida(tablero,posicionOriginalX,posicionOriginalY,piezaComida);
                        return 3;
                    }
                    return 1;
                }
            }




            //abajo derecha
            if (posicionX + 2==movimientoX &&posicionY + 1==movimientoY)  {
                if (table[movimientoX][movimientoY] == null) {
                    cambiarPosicion(tablero,movimientoX,movimientoY);
                    if (confirmarJaque(tablero,rey.getPosicionX(),rey.getPosicionY())){
                        regresarMovimiento(tablero,posicionOriginalX,posicionOriginalY);
                        return 3;
                    }
                    return  0;
                }
                if (table[posicionX + 2][posicionY + 1] != null  &&table[movimientoX][movimientoY].isBlancas()!=blancas){
                    piezaComida=tablero.obtenerPieza(movimientoX,movimientoY);
                   cambiarPosicionPieza(tablero,movimientoX,movimientoY);
                   if (confirmarJaque(tablero,rey.getPosicionX(),rey.getPosicionY())){
                       regresarPiezaComida(tablero,posicionOriginalX,posicionOriginalY,piezaComida);
                       return 3;
                   }
                    return 1;
                }
            }


            //abajo izquierda
            if (posicionX + 2 == movimientoX&& posicionY - 1== movimientoY ) {
                if (table[movimientoX][movimientoY]== null) {
                    cambiarPosicion(tablero,movimientoX,movimientoY);
                    if (confirmarJaque(tablero,rey.getPosicionX(),rey.getPosicionY())){
                        regresarMovimiento(tablero,posicionOriginalX,posicionOriginalY);
                        return 3;
                    }
                    return  0;
                }
                if (table[posicionX + 2][posicionY - 1] != null  &&table[movimientoX][movimientoY].isBlancas()!=blancas){
                    piezaComida=tablero.obtenerPieza(movimientoX,movimientoY);
                    cambiarPosicionPieza(tablero,movimientoX,movimientoY);
                    if (confirmarJaque(tablero,rey.getPosicionX(),rey.getPosicionY())){
                        regresarPiezaComida(tablero,posicionOriginalX,posicionOriginalY,piezaComida);
                        return 3;
                    }
                    return 1;
                }
            }


            // derecha abajo
            if (posicionX + 1== movimientoX &&posicionY + 2== movimientoY) {
                if (table[movimientoX][movimientoY] ==null) {
                    cambiarPosicion(tablero,movimientoX,movimientoY);
                    if (confirmarJaque(tablero,rey.getPosicionX(),rey.getPosicionY())){
                        regresarMovimiento(tablero,posicionOriginalX,posicionOriginalY);
                        return 3;
                    }
                    return  0;
                }


                if (table[posicionX +1][posicionY + 2] instanceof Pieza  && table[movimientoX][movimientoY].isBlancas()!=blancas){
                    piezaComida=tablero.obtenerPieza(movimientoX,movimientoY);
                    cambiarPosicionPieza(tablero,movimientoX,movimientoY);
                    if (confirmarJaque(tablero,rey.getPosicionX(),rey.getPosicionY())){
                        regresarPiezaComida(tablero,posicionOriginalX,posicionOriginalY,piezaComida);
                        return 3;
                    }
                    return 1;
                }
            }



            //izquierda abajo
            if (posicionX + 1== movimientoX && posicionY - 2== movimientoY) {
                if (table[movimientoX][movimientoY] == null) {
                    cambiarPosicion(tablero,movimientoX,movimientoY);
                    if (confirmarJaque(tablero,rey.getPosicionX(),rey.getPosicionY())){
                        regresarMovimiento(tablero,posicionOriginalX,posicionOriginalY);
                        return 3;
                    }
                    return  0;
                }
                if (table[posicionX +1][posicionY - 2] instanceof Pieza &&table[movimientoX][movimientoY].isBlancas()!=blancas){
                    piezaComida=tablero.obtenerPieza(movimientoX,movimientoY);
                    cambiarPosicionPieza(tablero,movimientoX,movimientoY);
                    if (confirmarJaque(tablero,rey.getPosicionX(),rey.getPosicionY())){
                        regresarPiezaComida(tablero,posicionOriginalX,posicionOriginalY,piezaComida);
                        return 3;
                    }
                    return 1;
                }
            }
            return 2;
        }

    @Override
    public boolean protegerRey(Tablero tablero, int posicionX, int posicionY, boolean blanco) {
        Pieza piezaComida;
        Rey rey = tablero.obtenerPiezaReyBlanco(blanco);
        Pieza[][] table = tablero.getTable();
        // obtenemos el rey para que en cada movieminto veamos si podemos proteger al rey
        int posicionOriginalX = posicionX;
        int posicionOriginalY = posicionY;
        // arriba lejos derecha
if (posicionX - 2 >=0 && posicionY+1<=7) {
    if ((table[posicionX - 2][posicionY + 1] == null)) {
        cambiarPosicion(tablero, posicionX - 2, posicionY + 1);
        if (confirmarJaque(tablero, rey.getPosicionX(), rey.getPosicionY()) == false) {
            regresarMovimiento(tablero, posicionOriginalX, posicionOriginalY);
            return true;
        }
        regresarMovimiento(tablero, posicionOriginalX, posicionOriginalY);
    } else {
        if (table[posicionX - 2][posicionY + 1].isBlancas() != blancas) {
            piezaComida = tablero.obtenerPieza(posicionX - 2, posicionY + 1);
            cambiarPosicionPieza(tablero, posicionX - 2, posicionY + 1);
            if (confirmarJaque(tablero, rey.getPosicionX(), rey.getPosicionY())==false) {
                regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida);
                return true;
            }
            regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida);
        }
    }

}
        //arriba lejos izquierda

        if ((posicionX-2>=0 && posicionY-1>=0)) {
                        if (table[posicionX - 2][posicionY - 1] == null) {
                            cambiarPosicion(tablero, posicionX - 2, posicionY - 1);
                            if (confirmarJaque(tablero, rey.getPosicionX(), rey.getPosicionY())==false) {
                                regresarMovimiento(tablero, posicionOriginalX, posicionOriginalY);
                                return true;
                            }
                            regresarMovimiento(tablero, posicionOriginalX, posicionOriginalY);
                        } else {
                            if (table[posicionX - 2][posicionY - 1].isBlancas() != blancas) {
                                piezaComida = tablero.obtenerPieza(posicionX - 2, posicionY - 1);
                                cambiarPosicionPieza(tablero, posicionX - 2, posicionY - 1);
                                if (confirmarJaque(tablero, rey.getPosicionX(), rey.getPosicionY())==false) {
                                    regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida);
                                    return true;
                                }
                                regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida);
                            }
                        }
            }


        //  derecha lejos arriba
        if ((posicionX - 1 >=0 && posicionY+2<=7)) {
            if (table[posicionX - 1][posicionY + 2] == null) {
                cambiarPosicion(tablero, posicionX - 1, posicionY + 2);
                if (confirmarJaque(tablero, rey.getPosicionX(), rey.getPosicionY())==false) {
                    regresarMovimiento(tablero, posicionOriginalX, posicionOriginalY);
                    return true;
                }
                regresarMovimiento(tablero, posicionOriginalX, posicionOriginalY);
            } else {
                if (table[posicionX - 1][posicionY + 2].isBlancas() != blancas) {
                    piezaComida = tablero.obtenerPieza(posicionX - 1, posicionY + 2);
                    cambiarPosicionPieza(tablero, posicionX - 1, posicionY + 2);
                    if (confirmarJaque(tablero, rey.getPosicionX(), rey.getPosicionY())==false) {
                        regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida);
                        return true;
                    }
                    regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida);
                }
            }

        }
        //izquierda lejos arriba

        if ((posicionX - 1 >=0 && posicionY-2>=0)) {
            if (table[posicionX - 1][posicionY - 2] == null) {
                cambiarPosicion(tablero, posicionX - 1, posicionY - 2);
                if (confirmarJaque(tablero, rey.getPosicionX(), rey.getPosicionY())==false) {
                    regresarMovimiento(tablero, posicionOriginalX, posicionOriginalY);
                    return true;
                }
                regresarMovimiento(tablero, posicionOriginalX, posicionOriginalY);

            } else {
                if (table[posicionX - 1][posicionY - 2].isBlancas() != blancas) {
                    piezaComida = tablero.obtenerPieza(posicionX - 1, posicionY - 2);
                    cambiarPosicionPieza(tablero, posicionX - 1, posicionY - 2);
                    if (confirmarJaque(tablero, rey.getPosicionX(), rey.getPosicionY())==false) {
                        regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida);
                        return true;
                    }
                    regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida);
                }
            }

        }


        //abajo lejos derecha
        if ((posicionX +2<=7 && posicionY+1<=7)) {
            if (table[posicionX + 2][posicionY + 1] == null) {
                cambiarPosicion(tablero, posicionX + 2, posicionY + 1);
                if (confirmarJaque(tablero, rey.getPosicionX(), rey.getPosicionY())==false) {
                    regresarMovimiento(tablero, posicionOriginalX, posicionOriginalY);
                    return true;
                }
                regresarMovimiento(tablero, posicionOriginalX, posicionOriginalY);
            } else {
                if (table[posicionX + 2][posicionY + 1].isBlancas() != blancas) {
                    piezaComida = tablero.obtenerPieza(posicionX + 2, posicionY + 1);
                    cambiarPosicionPieza(tablero, posicionX + 2, posicionY + 1);
                    if (confirmarJaque(tablero, rey.getPosicionX(), rey.getPosicionY())==false) {
                        regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida);
                        return true;
                    }
                    regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida);
                }
            }
        }

        //abajo lejos izquierda
        if ((posicionX +2 <=7 && posicionY-1>=0)) {
            if (table[posicionX + 2][posicionY - 1] == null) {
                cambiarPosicion(tablero, posicionX + 2, posicionY - 1);
                if (confirmarJaque(tablero, rey.getPosicionX(), rey.getPosicionY())==false) {
                    regresarMovimiento(tablero, posicionOriginalX, posicionOriginalY);
                    return true;
                }
                regresarMovimiento(tablero, posicionOriginalX, posicionOriginalY);
            } else {
                if (table[posicionX + 2][posicionY - 1].isBlancas() != blancas) {
                    piezaComida = tablero.obtenerPieza(posicionX + 2, posicionY - 1);
                    cambiarPosicionPieza(tablero, posicionX + 2, posicionY - 1);
                    if (confirmarJaque(tablero, rey.getPosicionX(), rey.getPosicionY())==false) {
                        regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida);
                        return true;
                    }
                    regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida);
                }
            }

        }

        // derecha lejos abajo
        if ((posicionX + 1 <=7 && posicionY+2<=7)) {
            if (table[posicionX + 1][posicionY + 2] == null) {
                cambiarPosicion(tablero, posicionX + 1, posicionY + 2);
                if (confirmarJaque(tablero, rey.getPosicionX(), rey.getPosicionY())==false) {
                    regresarMovimiento(tablero, posicionOriginalX, posicionOriginalY);
                    return true;
                }
                regresarMovimiento(tablero, posicionOriginalX, posicionOriginalY);
            } else {
                if (table[posicionX + 1][posicionY + 2].isBlancas() != blancas) {
                    piezaComida = tablero.obtenerPieza(posicionX + 1, posicionY + 2);
                    cambiarPosicionPieza(tablero, posicionX + 1, posicionY + 2);
                    if (confirmarJaque(tablero, rey.getPosicionX(), rey.getPosicionY())==false) {
                        regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida);
                        return true;
                    }
                    regresarPiezaComida(tablero, posicionOriginalX, posicionOriginalY, piezaComida);
                }
            }


        }
        //izquierda lejos abajo
        if ((posicionX + 1 <=7 && posicionY-2>=0)) {
            if (table[posicionX + 1][posicionY - 2] == null) {
                cambiarPosicion(tablero, posicionX + 1, posicionY - 2);
                if (confirmarJaque(tablero, rey.getPosicionX(), rey.getPosicionY())==false) {
                    regresarMovimiento(tablero, posicionOriginalX, posicionOriginalY);
                    return true;
                }
                regresarMovimiento(tablero, posicionOriginalX, posicionOriginalY);
            } else {
                if (table[posicionX + 1][posicionY - 2].isBlancas() != blancas) {
                    piezaComida = tablero.obtenerPieza(posicionX + 1, posicionY - 2);
                    cambiarPosicionPieza(tablero, posicionX + 1, posicionY - 2);
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

    public void imprimirCaballo() {
        if (this.blancas) {
            System.out.print(red + "♘" + reset);
        } else {
            System.out.print(green + "♘" + reset);
        }
    }

}













