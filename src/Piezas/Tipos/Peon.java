package Piezas.Tipos;

import Piezas.Jugadores;
import Piezas.Pieza;

import java.util.Scanner;

public class Peon extends Pieza {
        public Peon(Jugadores propietario) {
                super(propietario);
        }

        public void espaciosDisponiblePeon(Pieza[][] table) {
                if (table[posicionX][posicionY].getPropietario() == Jugadores.jugador1) {
                        if (posicionX == 1) {
                                if (table[posicionX + 2][posicionY] instanceof Bloqueo) {
                                        table[posicionX + 2][posicionY] = null;
                                }
                        }
                        //le ponemos un menos 1 al posicionYde abajo puesto que siempre el movimineto valido es en la misma columna la cual es 0.
                        if (table[posicionX + 1][posicionY] instanceof Bloqueo) {
                                table[posicionX + 1][posicionY] = null;//la posicion original del peon es posicionX-1 y posicionY-1, entonces si les quitamos los menos 1 tendriamos la posicion en el array donde se podria mover el peon. osea un espacio adelante
                        }

                } else {
                        if (posicionX == 7) {
                                if (table[posicionX - 2][posicionY] instanceof Bloqueo) {
                                        table[posicionX - 2][posicionY] = null;
                                }

                        }
                        if (table[posicionX - 1][posicionY] instanceof Bloqueo) {
                                table[posicionX - 1][posicionY] = null;
                        }

                }


        }

        public void moviminetoPeon(Scanner teclado , Pieza [][ ] table){//posicionX y posicionY son las coordenadas ingresadas por el jugador
                System.out.println("ingrese a que fila quiere mover el peon");
                int x = teclado.nextInt()-1;
                System.out.println("ingrese la columna");
                int y = teclado.nextInt()-1;
                Peon actual = (Peon) (table[posicionX][posicionY]);

                if(/*table[x][y]instanceof Bloqueo ||*/ table [x][y]==table[posicionX][posicionY])
                {
                        System.out.println("no puedes mover al mismo sitio");
                }

                if ((table[x][y] == null)){
                        table[x][y]=table[posicionX][posicionY];
                        table[posicionX][posicionY]=null;

                        if (x==7 || x==0){
                                Pieza nueva= actual.transformarPeon(table,teclado,x,y);
                                table[x][y]=nueva;
                        }
                        System.out.println("movimiento realizado");
                }
                else if ((table[x][y] != null)) {
                        if(actual.comerPiezaPeon(x, y, table)){
                                System.out.println("pieza comida");
                                if (x==7 || x==0){
                                        Pieza nueva= actual.transformarPeon(table,teclado,x,y);
                                        table[x][y]=nueva;

                                }
                        }
                        else {
                                System.out.println("movimiento invalido");
                        }
                }

        }

        public boolean comerPiezaPeon(int movimientoX, int movimientoY, Pieza[][] table) {
                if (table[posicionX][posicionY].getPropietario() != table[movimientoX][movimientoY].getPropietario()) {
                        if (table[movimientoX][movimientoY] instanceof Pieza && !(table[movimientoX][movimientoY] instanceof Bloqueo)) {
                                if (table[posicionX][posicionY].getPropietario() == Jugadores.jugador1) {
                                        //peones que van hacia abajo
                                        if ((movimientoX == posicionX + 1 && movimientoY == posicionY + 1) || movimientoX == posicionX + 1 && movimientoY == posicionY - 1) {
                                                table[movimientoX][movimientoY] = table[posicionX][posicionY];
                                                table[posicionX][posicionY] = null;
                                                return true;
                                        }
                                } else {
                                        if ((movimientoX == posicionX - 1 && movimientoY == posicionY + 1) || movimientoX == posicionX - 1 && movimientoY == posicionY - 1) {
                                                table[movimientoX][movimientoY] = table[posicionX][posicionY];
                                                table[posicionX][posicionY] = null;
                                                return true;
                                        }
                                }


                        }


                }

                return false;
        }


        public Pieza transformarPeon(Pieza[][] table, Scanner teclado, int movimientoX, int moviminetoY) {
                if (movimientoX == 0 || movimientoX == 7) {
                        System.out.println("elige en que quieres transformar tu peon");
                        System.out.println("1 torre");
                        System.out.println("2 alfil");
                        System.out.println("3 caballo");
                        int opcion = teclado.nextInt();
                        switch (opcion) {
                                case 1:
                                        return new Torre(table[movimientoX][moviminetoY].getPropietario());
                                case 2:
                                        return new Alfil(table[movimientoX][moviminetoY].getPropietario());

                                case 3:
                                        return new Caballo(table[movimientoX][moviminetoY].getPropietario());
                                default:
                                        System.out.println("error");
                                        return null;
                        }
                }
                return null;
        }


        public void imprimirPeon(){
                if (this.propietario==Jugadores.jugador1) {
                        System.out.print(red + "♙" + reset);
                }
                else {
                        System.out.print(green + "♙" + reset);
                }
        }





}