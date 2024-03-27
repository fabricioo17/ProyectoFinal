package Tablero;


import Piezas.Piezas;
import Piezas.Tipos.*;

import java.util.Scanner;

public class Tablero {
    private  Piezas actual;
    private Piezas[][] table;
    private Peon peon;
    private Torre torre;
    private Alfil alfil;
    private Caballo caballo;
    private Dama dama;
    private Rey rey;
    private  Bloqueo bloqueo;

    public Tablero()
    {
        table = new Piezas[8][8];
    }




    public void  StartTablero(){
                table[0][0] = new Torre() ;
                table[0][1]=new Caballo();
                table[0][2]=new Alfil();
                table[0][3] = new Rey() ;
                table[0][4]=new Dama();
                table[0][5]=new Alfil();
                table[0][6]=new Caballo();
                table[0][7] = new Torre() ;


                for (int i =1;i<2;i++){
                    for (int j=0; j<8;j++){
                        table[i][j]=new Peon();
                    }
                }



        for (int i =2;i<6;i++){
            for (int j=0; j<8;j++){
                table[i][j]=null;
            }
        }

               for (int i =6;i<7;i++){
            for (int j=0; j<8;j++){
                table[i][j]=new Peon();
              }
             }

                table[7][0] = new Torre() ;
                table[7][1]=new Caballo();
                table[7][2]=new Alfil();
                table[7][3] = new Rey() ;
                table[7][4]=new Dama();
                table[7][5]=new Alfil();
                table[7][6]=new Caballo();
                table[7][7] = new Torre() ;

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
            else if (table[i][j] instanceof Peon){
                System.out.print( "    "+"♙"+ "    ");
                System.out.print(" ┃");
            }
            else if (table[i][j] instanceof Rey){
                System.out.print("    " +"♔"+ "    ");
                System.out.print(" ┃");
            }
            else if (table[i][j] instanceof  Dama){
                System.out.print("    " +"♕"+ "    ");
                System.out.print(" ┃");
            }
            else if (table[i][j] instanceof Caballo){
                System.out.print("    " +"♘"+ "    ");
                System.out.print(" ┃");
            }
            else if (table [i][j]instanceof  Torre){
                System.out.print("    " +"♖"+"    " );
                System.out.print(" ┃");
            }
            else if (table [i][j]instanceof  Alfil){
                System.out.print("    " +"♗"+"    " );
                System.out.print(" ┃");
            }
           }
        System.out.println();
        dibujarLineas();
    }
}

//------------------------diferenciarPieza-------------------//

 public void diferenciarPiezas(){
        if (actual instanceof Peon){
            System.out.println("♙");
        }
        else if (actual instanceof Rey){
            System.out.println("♔");

        }
        else if (actual instanceof  Dama){
            System.out.println("♕");
     }
        else if (actual instanceof Caballo){
            System.out.println("♘");

        }
        else if (actual instanceof  Torre){
            System.out.println("♖");
        }
 }




public void elegirMovimiento(Scanner teclado){
        boolean correcto= false;
        do {
            System.out.println("ingrese las coordenadas de la pieza");
            int posicionX = teclado.nextInt();
            ;
            int posicionY = teclado.nextInt();
            if (table[posicionX - 1][posicionY - 1] == null) {
                System.out.print(" no hay pieza elegida  "); // cantidad de rayas por numero es 3
                System.out.println("vuelva a ingresar las coordenadas");

            } else if (table[posicionX - 1][posicionY - 1] instanceof Peon) {
                moviminetoPeonArriba(teclado,posicionX,posicionY);
                correcto=true;
            } else if (table[posicionX - 1][posicionY - 1] instanceof Rey) {
                System.out.print("    " + "♔" + "    ");
                System.out.print(" ┃");
            } else if (table[posicionX - 1][posicionY - 1] instanceof Dama) {
                System.out.print("    " + "♕" + "    ");
                System.out.print(" ┃");
            } else if (table[posicionX - 1][posicionY - 1] instanceof Caballo) {
                System.out.print("    " + "♘" + "    ");
                System.out.print(" ┃");
            } else if (table[posicionX - 1][posicionY - 1] instanceof Torre) {
                System.out.print("    " + "♖" + "    ");
                System.out.print(" ┃");
            } else if (table[posicionX - 1][posicionY - 1] instanceof Alfil) {
                System.out.print("    " + "♗" + "    ");
                System.out.print(" ┃");

            }
        }
        while (correcto==false);
}



public void moviminetoPeonArriba(Scanner teclado, int posicionX, int posicionY){//posicionX y posicionY son las coordenadas ingresadas por el jugador
    System.out.println("ingrese a que fila quiere mover el peon");
       int x = teclado.nextInt();
    System.out.println("ingrese la columna");
       int y = teclado.nextInt();
        for (int i =0;i<8;i++){
            for (int j=0;j<8;j++){
            if(table[i][j]==null){
                   table[i][j]=new Bloqueo();
               }
            }
        }
   table[posicionX][posicionY]=null; //la posicion original del peon es posicionX-1 y posicionY-1, entonces si les quitamos los menos 1 tendriamos la posicion en el array donde se podria mover el peon. osea un espacio adelante
    if(table[x][y]instanceof Bloqueo){
        System.out.println("movimiento invalido");
    }

        else if (table[x][y]==null ) {

    }
    else if (!(table[posicionX][posicionY] instanceof Bloqueo)){
table[posicionX][posicionY]=table[x][y];
table[x][y]=null;
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
