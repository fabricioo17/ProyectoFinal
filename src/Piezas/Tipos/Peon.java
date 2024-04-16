package Piezas.Tipos;

import Piezas.Pieza;

import java.util.Scanner;

public class Peon extends Pieza {
        public Peon(Boolean blanca) {
                super(blanca);
        }

        public void movimientoPeon(Scanner teclado , Pieza [][ ] table){//posicionX y posicionY son las coordenadas ingresadas por el jugador
                System.out.println("ingrese a que fila quiere mover el peon");
                int x = teclado.nextInt()-1;
                System.out.println("ingrese la columna");
                int y = teclado.nextInt()-1;
                Peon actual = (Peon) (table[posicionX][posicionY]);

                if(table [x][y]==table[posicionX][posicionY])
                {
                        System.out.println("no puedes mover al mismo sitio");
                }
                else {
                        if (posicionX==1 && posicionX+2==x && table[posicionX][posicionY].isBlancas()){
                                        if ((table[x][y] == null)){
                                                table[x][y]=table[posicionX][posicionY];
                                                table[posicionX][posicionY]=null;
                                                System.out.println("movimiento realizado");
                                        }

                        }
                        else if (posicionX==7 && posicionX-2==x && !table[posicionX][posicionY].isBlancas()){
                                if ((table[x][y] == null)){
                                        table[x][y]=table[posicionX][posicionY];
                                        table[posicionX][posicionY]=null;
                                        System.out.println("movimiento realizado");
                                }
                        }

                        else if ((posicionX+1==x || posicionX-1==x)){
                                if (posicionY==y){
                                        if (table[posicionX][posicionY].isBlancas()){
                                                if (posicionX+1==x){
                                                        if ((table[x][y] == null)){
                                                                table[x][y]=table[posicionX][posicionY];
                                                                table[posicionX][posicionY]=null;
                                                                if (x==7){
                                                                        Pieza nueva= actual.transformarPeon(table,teclado,x,y);
                                                                        table[x][y]=nueva;
                                                                }
                                                                System.out.println("movimiento realizado");
                                                        }
                                                }
                                        }


                                        else
                                        {
                                                if (posicionX-1==x){
                                                        if ((table[x][y] == null)){
                                                                table[x][y]=table[posicionX][posicionY];
                                                                table[posicionX][posicionY]=null;
                                                                if (x==0){
                                                                        Pieza nueva= actual.transformarPeon(table,teclado,x,y);
                                                                        table[x][y]=nueva;
                                                                }
                                                                System.out.println("movimiento realizado");
                                                        }
                                                }
                                        }
                                }

                                else if (posicionY+1==y || posicionY-1==y) {
                                        if (table[x][y] instanceof Pieza ){
                                                if (table[posicionX][posicionY].isBlancas() != table[x][y].isBlancas()){
                                                        table[x][y] = table[posicionX][posicionY];
                                                        table[posicionX][posicionY] = null;

                                                        if (x==0 && !table[posicionX][posicionY].isBlancas() ){
                                                                Pieza nueva= actual.transformarPeon(table,teclado,x,y);
                                                                table[x][y]=nueva;
                                                        }
                                                        else if (x==7 && table[posicionX][posicionY].isBlancas()){
                                                                Pieza nueva= actual.transformarPeon(table,teclado,x,y);
                                                                table[x][y]=nueva;
                                                        }
                                                        System.out.println("movimiento realizado");
                                                }

                                                }



                                        }

                                        else {
                                                System.out.println("movimiento invalido");
                                        }
                                }


                                else {
                                        System.out.println(" error de movimiento");
                                }
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
                                return new Torre(table[movimientoX][moviminetoY].isBlancas());
                        case 2:
                                return new Alfil(table[movimientoX][moviminetoY].isBlancas());

                        case 3:
                                return new Caballo(table[movimientoX][moviminetoY].isBlancas());
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