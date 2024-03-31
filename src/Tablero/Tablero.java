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
    private  Bloqueo bloqueo=new Bloqueo();

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
            if(diferenciarPiezas(i,j).equals("p")){
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
            else if (table[i][j] instanceof Bloqueo){
                System.out.print("    " + " " + "    "); // cantidad de rayas por numero es 3
                System.out.print("  ┃");
            }
           }
        System.out.println();
        dibujarLineas();
    }
}

//------------------------diferenciarPieza-------------------//

 public String diferenciarPiezas(int posicionX, int posicionY){
        if (table[posicionX][posicionY] instanceof Peon){
            return "p";
        }
        else if (table[posicionX][posicionY] instanceof Rey){
            return "r";

        }
        else if (table[posicionX][posicionY] instanceof  Dama){
            return "d";
     }
        else if (table[posicionX][posicionY] instanceof Caballo){
            return "c";

        }
        else if (table[posicionX][posicionY] instanceof  Torre){
            return "t";
        }
        return "b";//bloqueo
 }




public void elegirMovimiento(Scanner teclado){
        boolean correcto= false;
        do {
            System.out.println("ingrese las coordenadas de la pieza");
            int posicionX = teclado.nextInt()-1;
            int posicionY = teclado.nextInt()-1;
            if (table[posicionX ][posicionY ] == null) {
                System.out.print(" no hay pieza elegida  "); // cantidad de rayas por numero es 3
                System.out.println("vuelva a ingresar las coordenadas");

            } else if (table[posicionX][posicionY ] instanceof Peon) {
                moviminetoPeonArriba(teclado,posicionX,posicionY);
                correcto=true;
            } else if (table[posicionX][posicionY ] instanceof Rey) {
                System.out.print("    " + "♔" + "    ");
                System.out.print(" ┃");
            } else if (table[posicionX ][posicionY ] instanceof Dama) {
                System.out.print("    " + "♕" + "    ");
                System.out.print(" ┃");
            } else if (table[posicionX ][posicionY ] instanceof Caballo) {
                System.out.print("    " + "♘" + "    ");
                System.out.print(" ┃");
            } else if (table[posicionX][posicionY ] instanceof Torre) {
                movimientoTorre(teclado,posicionX,posicionY);
                correcto=true;
            } else if (table[posicionX ][posicionY ] instanceof Alfil) {
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
       bloquearTablero();


       if (posicionX==1){//inicia siempre el peon con dos movimin¿entos
           table[posicionX+2][posicionY]=null;
       }
       //le ponemos un menos 1 al posicionYde abajo puesto que siempre el movimineto valido es en la misma columna la cual es 0.
   table[posicionX+1][posicionY]=null; //la posicion original del peon es posicionX-1 y posicionY-1, entonces si les quitamos los menos 1 tendriamos la posicion en el array donde se podria mover el peon. osea un espacio adelante
    if(table[x-1][y-1]instanceof Bloqueo || table [x-1][y-1]==table[posicionX][posicionY])
    {
        System.out.println("movimiento invalido");
    }

        //arreglar abajo//
    else {
        table[x-1][y-1]=table[posicionX][posicionY];
        table[posicionX][posicionY]=null;
        vaciarTablero();
    }



}


//---------------bloquear casilleros---------------------//
public  void bloquearTablero(){
    for (int i =0;i<8;i++){
        for (int j=0;j<8;j++){
            if(table[i][j]==null){
                table[i][j]=bloqueo;//usaremos un puntero bloqueo para no crear objetos innecesarios de bloqueo
            }
        }
    }

}
public void disponibleTorre(int posicionX , int posicionY){


        //posiciones disponibles a la derecha de la torre hasta romper cuando enocntramos otra ficha
        for (int i =posicionY+1; i<8;i++)
        {
            if (table[posicionX][i] instanceof  Bloqueo){
                table[posicionX][i]=null;
            }
            else {break;}
            }

        //a la izquierda
    for (int i =posicionY-1; i>=0;i--)
    {
        if (table[posicionX][i] instanceof  Bloqueo){
            table[posicionX][i]=null;
        }
        else {break;}
    }


    //hacia arriba
    for (int i =posicionX-1; i>=0;i--)
    {
        if (table[i][posicionY] instanceof  Bloqueo){
            table[i][posicionY]=null;
        }
        else {break;}

    }

    //hacia abajo
    for (int i =posicionX+1; i<8;i++)
    {
        if (table[i][posicionY] instanceof  Bloqueo){
            table[i][posicionY]=null;
        }
        else {break;}
    }

    /*for (int i =0;i<8;i++){
        for (int j=posicionY;j<8;j++){
            if (posicionX==i && posicionY==j){

            }

            else if(posicionX==i || posicionY ==j){
                if (!(table[i][j] instanceof Bloqueo)) {
                    break;
                }

                table[i][j]=null;
            }

            // else if(table[i][j]==null){
              //  table[i][j]=bloqueo;//usaremos un puntero bloqueo para no crear objetos innecesarios de bloqueo
           // }
        }
    }*/
}





//----------------------vacias casilleros--------------//
public  void vaciarTablero(){
    for (int i =0;i<8;i++){
        for (int j=0;j<8;j++){
            if(table[i][j] instanceof Bloqueo){
                table[i][j]=null;
            }
        }
    }
}






public  void movimientoTorre(Scanner teclado, int posicionX, int posicionY){
    System.out.println("ingrese a que fila quiere mover la torre");
    int x = teclado.nextInt();
    System.out.println("ingrese la columna");
    int y = teclado.nextInt();
    bloquearTablero();
    disponibleTorre(posicionX,posicionY);
    if(table[x-1][y-1]instanceof Bloqueo || table [x-1][y-1]==table[posicionX][posicionY]){
        System.out.println("movimiento invalido");
    }

    else if (!(table[x-1][y-1] instanceof Bloqueo)){// si el contenido de esa posicion contiene cualquier tipo de pieza, se puede reemplazar con un else
        table[x-1][y-1]=table[posicionX][posicionY];
        table[posicionX][posicionY]=null;
        vaciarTablero();
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
