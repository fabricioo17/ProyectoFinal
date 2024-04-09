package Tablero;


import Piezas.Jugadores;
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

    private  Bloqueo bloqueo=new Bloqueo(Jugadores.jugador1);

    public Tablero()
    {
        table = new Pieza[8][8];
    }




    public void  StartTablero(){
        table[0][0] = new Torre(Jugadores.jugador1) ;
        table[0][1]=new Caballo(Jugadores.jugador1);
        table[0][2]=new Alfil(Jugadores.jugador1);
        table[0][3] = new Rey(Jugadores.jugador1) ;
        table[0][4]=new Reina(Jugadores.jugador1);
        table[0][5]=new Alfil(Jugadores.jugador1);
        table[0][6]=new Caballo(Jugadores.jugador1);
        table[0][7] = new Torre(Jugadores.jugador1) ;

        for (int i =1;i<2;i++){
            for (int j=0; j<8;j++){
                table[i][j]=new Peon(Jugadores.jugador1);
            }
        }



        for (int i =2;i<6;i++){
            for (int j=0; j<8;j++){
                table[i][j]=null;
            }
        }




        for (int i =6;i<7;i++){
            for (int j=0; j<8;j++){
                table[i][j]=new Peon(Jugadores.jugador2);
            }
        }

        table[7][0] = new Torre(Jugadores.jugador2) ;
        table[7][1]=new Caballo(Jugadores.jugador2);
        table[7][2]=new Alfil(Jugadores.jugador2);
        table[7][3] = new Rey(Jugadores.jugador2) ;
        table[7][4]=new Reina(Jugadores.jugador2);
        table[7][5]=new Alfil(Jugadores.jugador2);
        table[7][6]=new Caballo(Jugadores.jugador2);
        table[7][7] = new Torre(Jugadores.jugador2) ;

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
                else if (table[i][j] instanceof Bloqueo){
                    System.out.print("    " + " " + "    "); // cantidad de rayas por numero es 3
                    System.out.print("  ┃");
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
                bloquearTablero();
                if (table[posicionX][posicionY] instanceof Peon) {
                    table[posicionX][posicionY].setPosicionX(posicionX);
                    table[posicionX][posicionY].setPosicionY(posicionY);
                    ((Peon) table[posicionX][posicionY]).espaciosDisponiblePeon(table);
                    moviminetoPeon(teclado,posicionX,posicionY);
                    correcto = true;
                }
                else if (table[posicionX][posicionY] instanceof Rey) {

                }
                else if (table[posicionX][posicionY] instanceof Reina) {
                    table[posicionX][posicionY].setPosicionX(posicionX);
                    table[posicionX][posicionY].setPosicionY(posicionY);
                    table[posicionX][posicionY].espaciosDiagonal(table);
                    table[posicionX][posicionY].espaciosDisponiblesVerticalHorinzotal(table);
                    ((Reina)table[posicionX][posicionY]).movimientoReina(teclado,table);
                    correcto = true;
                }
                else if (table[posicionX][posicionY] instanceof Caballo) {
                    table[posicionX][posicionY].setPosicionX(posicionX);
                    table[posicionX][posicionY].setPosicionY(posicionY);
                    ((Caballo) table[posicionX][posicionY]).espacioDisponibleCaballo(table);
                    movimientoCaballo(teclado,posicionX,posicionY);
                    correcto = true;
                }
                else if (table[posicionX][posicionY] instanceof Torre) {
                    table[posicionX][posicionY].setPosicionX(posicionX);
                    table[posicionX][posicionY].setPosicionY(posicionY);
                    table[posicionX][posicionY].espaciosDisponiblesVerticalHorinzotal(table);
                    ((Torre) table[posicionX][posicionY]).movimientoTorre(teclado,table);
                    correcto = true;
                }
                else if (table[posicionX][posicionY] instanceof Alfil) {
                    table[posicionX][posicionY].setPosicionX(posicionX);
                    table[posicionX][posicionY].setPosicionY(posicionY);
                    table[posicionX][posicionY].espaciosDiagonal(table);
                    ((Alfil) table[posicionX][posicionY]).movimientoAlfil(teclado,table);
                    correcto = true;
                }
                vaciarTablero();
            }
        }
        while (correcto==false);
    }



    public void moviminetoPeon(Scanner teclado, int posicionX, int posicionY){//posicionX y posicionY son las coordenadas ingresadas por el jugador
        System.out.println("ingrese a que fila quiere mover el peon");
        int x = teclado.nextInt()-1;
        System.out.println("ingrese la columna");
        int y = teclado.nextInt()-1;
        Peon actual = (Peon) (table[posicionX][posicionY]);

        if(/*table[x][y]instanceof Bloqueo ||*/ table [x][y]==table[posicionX][posicionY])
        {
            System.out.println("movimiento invalido");
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
        vaciarTablero();
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





    public  void movimientoCaballo (Scanner teclado, int posicionX, int posicionY){
        System.out.println("ingrese a que fila quiere mover el caballo");
        int x = teclado.nextInt()-1;
        System.out.println("ingrese la columna");
        int y = teclado.nextInt()-1;
        if(table[x][y]instanceof Bloqueo || table [x][y]==table[posicionX][posicionY]){
            System.out.println("movimiento invalido");
        }
        else if ((table[x][y]==null)){
            table[x][y]=table[posicionX][posicionY];
            table[posicionX][posicionY]=null;
            vaciarTablero();
            System.out.println("pieza movida");
        }
        else if ((table[x][y] != null)){// si el contenido de esa posicion contiene cualquier tipo de pieza, se puede reemplazar con un else
            Caballo caballo= (Caballo) table[posicionX][posicionY];
            if (caballo.comerPiezaCaballo(x,y,table)== true){
                System.out.println("pieza comida");
            }
            else {
                System.out.println("no puedes comer esa pieza");
            }
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
