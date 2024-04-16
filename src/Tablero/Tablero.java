package Tablero;


import Piezas.Pieza;
import Piezas.Tipos.*;

import java.util.Scanner;

public class Tablero {
    private Pieza actual;
    private Pieza[][] table;
    private Peon peon;
    private Torre torre;
    private Alfil alfil;
    private Caballo caballo;
    private Reina dama;
    private Rey rey;

    public Tablero()
    {
        table = new Pieza[8][8];
    }




    public void  StartTablero(){
        table[0][0] = new Torre(true) ;
        table[0][1]=new Caballo(true);
        table[0][2]=new Alfil(true);
        table[0][3] = new Rey(true) ;
        table[0][4]=new Reina(true);
        table[0][5]=new Alfil(true);
        table[0][6]=new Caballo(true);
        table[0][7] = new Torre(true) ;

        for (int i =1;i<2;i++){
            for (int j=0; j<8;j++){
                table[i][j]=new Peon(true);
            }
        }



        for (int i =2;i<6;i++){
            for (int j=0; j<8;j++){
                table[i][j]=null;
            }
        }


        for (int i =6;i<7;i++){
            for (int j=0; j<8;j++){
                table[i][j]=new Peon(false);
            }
        }

        table[7][0] = new Torre(false) ;
        table[7][1]=new Caballo(false);
        table[7][2]=new Alfil(false);
        table[7][3] = new Rey(false) ;
        table[7][4]=new Reina(false);
        table[7][5]=new Alfil(false);
        table[7][6]=new Caballo(false);
        table[7][7] = new Torre(false) ;

    }






    public void imprimirTablero(){
        System.out.print("   ");
        for (int i = 0; i < 8; i++) {
            System.out.print("     " + (i + 1) + "     ");
        }
        System.out.println();
        dibujarLineas();
        diferenciarContenidoTablero();
    }


    public void diferenciarContenidoTablero(){

        for (int i = 0; i < table.length; i++) {
            System.out.print((i + 1) + "  ┃");
            for (int j = 0; j < 8; j++) {
                if (table[i][j]==null){
                    System.out.print("    " + " " + "    "); // cantidad de rayas por numero es 3
                    System.out.print("  ┃");
                }
                if(table[i][j] instanceof Peon){
                    System.out.print( "    ");
                    ((Peon) table[i][j]).imprimirPeon();
                    System.out.print("    ");
                    System.out.print(" ┃");
                }
                else if (table[i][j] instanceof Rey){
                    System.out.print("    " +"♔"+ "    ");
                    System.out.print(" ┃");
                }
                else if (table[i][j] instanceof Reina){
                    System.out.print("    " +"♕"+ "    ");
                    System.out.print(" ┃");
                }
                else if (table[i][j] instanceof Caballo){
                    System.out.print("    " );
                    ((Caballo) table[i][j]).imprimirCaballo();
                    System.out.print("    ");
                    System.out.print(" ┃");
                }
                else if (table [i][j]instanceof  Torre){
                    System.out.print("    ");
                    ((Torre) table[i][j]).imprimirTorre();
                    System.out.print("    " );
                    System.out.print(" ┃");
                }
                else if (table [i][j]instanceof  Alfil){
                    System.out.print("    ");
                    ((Alfil) table[i][j]).imprimirAlfil();
                    System.out.print("    " );
                    System.out.print(" ┃");
                }
            }
            System.out.println();
            dibujarLineas();
        }
    }






    public void elegirPieza(Scanner teclado){
        boolean correcto= false;
        do {
            System.out.println("ingrese las coordenadas de la pieza");


            int posicionX = teclado.nextInt()-1;
            int posicionY = teclado.nextInt()-1;
            if (table[posicionX ][posicionY ] == null) {
                System.out.print(" no hay pieza elegida  "); // cantidad de rayas por numero es 3
                System.out.println("vuelva a ingresar las coordenadas");

            }
            else {

                if (table[posicionX][posicionY] instanceof Peon) {
                    table[posicionX][posicionY].setPosicionX(posicionX);
                    table[posicionX][posicionY].setPosicionY(posicionY);
                    ((Peon) table[posicionX][posicionY]).movimientoPeon(teclado,table);
                    correcto = true;
                }
                else if (table[posicionX][posicionY] instanceof Rey) {

                }
                else if (table[posicionX][posicionY] instanceof Reina) {
                    table[posicionX][posicionY].setPosicionX(posicionX);
                    table[posicionX][posicionY].setPosicionY(posicionY);
                    ((Reina)table[posicionX][posicionY]).movimientoReina(teclado,table);
                    correcto = true;
                }
                else if (table[posicionX][posicionY] instanceof Caballo) {
                    table[posicionX][posicionY].setPosicionX(posicionX);
                    table[posicionX][posicionY].setPosicionY(posicionY);
                    movimientoCaballo(teclado,posicionX,posicionY);
                    correcto = true;
                }
                else if (table[posicionX][posicionY] instanceof Torre) {
                    table[posicionX][posicionY].setPosicionX(posicionX);
                    table[posicionX][posicionY].setPosicionY(posicionY);
                    ((Torre) table[posicionX][posicionY]).movimientoTorre(teclado,table);
                    correcto = true;
                }
                else if (table[posicionX][posicionY] instanceof Alfil) {
                    table[posicionX][posicionY].setPosicionX(posicionX);
                    table[posicionX][posicionY].setPosicionY(posicionY);
                    ((Alfil) table[posicionX][posicionY]).movimientoAlfil(teclado,table);
                    correcto = true;
                }

            }
        }
        while (correcto==false);
    }







    public  void movimientoCaballo (Scanner teclado, int posicionX, int posicionY){
        System.out.println("ingrese a que fila quiere mover el caballo");
        int x = teclado.nextInt()-1;
        System.out.println("ingrese la columna");
        int y = teclado.nextInt()-1;
        int opcionMovimiento= ((Caballo)table[posicionX][posicionY]).movimientoTotalCaballo(table,x,y);
       if (opcionMovimiento==0){
           System.out.println("pieza movida");
       } else if (opcionMovimiento==1) {
           System.out.println("pieza comida");
       }
       else {
           System.out.println("movimiento invalido");
       }
        }













    public void dibujarLineas() {
        int n = ((12) + ((7) * 11));//table.length es 10
        System.out.print("    ");
        for (int k = 1; k <= n; k++) {
            System.out.print("─");
        }
        System.out.println();
    }

}
