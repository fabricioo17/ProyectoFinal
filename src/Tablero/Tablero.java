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
    private Dama dama;
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
                table[0][4]=new Dama(Jugadores.jugador1);
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

        table[5][5]=new Alfil(Jugadores.jugador1);



               for (int i =6;i<7;i++){
            for (int j=0; j<8;j++){
                table[i][j]=new Peon(Jugadores.jugador2);
              }
             }

                table[7][0] = new Torre(Jugadores.jugador2) ;
                table[7][1]=new Caballo(Jugadores.jugador2);
                table[7][2]=new Alfil(Jugadores.jugador2);
                table[7][3] = new Rey(Jugadores.jugador2) ;
                table[7][4]=new Dama(Jugadores.jugador2);
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
                else if (table[posicionX][posicionY] instanceof Dama) {

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
                        ((Torre) table[posicionX][posicionY]).espaciosDisponibles(table);
                        movimientoTorre(teclado, posicionX, posicionY);
                        correcto = true;
                         }
                else if (table[posicionX][posicionY] instanceof Alfil) {
                    table[posicionX][posicionY].setPosicionX(posicionX);
                    table[posicionX][posicionY].setPosicionY(posicionY);
                    ((Alfil) table[posicionX][posicionY]).espaciosDisponibleAlfil(table);
                    movimientoAlfil(teclado,posicionX,posicionY);
                    correcto = true;
                     }
            }
        }
        while (correcto==false);
}



    public void moviminetoPeon(Scanner teclado, int posicionX, int posicionY){//posicionX y posicionY son las coordenadas ingresadas por el jugador
        System.out.println("ingrese a que fila quiere mover el peon");
        int x = teclado.nextInt()-1;
        System.out.println("ingrese la columna");
        int y = teclado.nextInt()-1;

        if(table[x][y]instanceof Bloqueo || table [x][y]==table[posicionX][posicionY])
        {
            System.out.println("movimiento invalido");
        }
        else if ((table[x][y] == null)) {
            table[x][y]=table[posicionX][posicionY];
            table[posicionX][posicionY]=null;
            System.out.println("movimiento realizado");
        }
        else if ((table[x][y] != null)) {
            Peon actual = (Peon) (table[posicionX][posicionY]);
            if(actual.comerPiezaPeon(x, y, table)){
                System.out.println("pieza comida");
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


public  void movimientoTorre(Scanner teclado, int posicionX, int posicionY) {
    System.out.println("ingrese a que fila quiere mover la torre");
    int x = teclado.nextInt() - 1;
    System.out.println("ingrese la columna");
    int y = teclado.nextInt() - 1;
    if (table[x][y] instanceof Bloqueo || table[x][y] == table[posicionX][posicionY]) {
        System.out.println("movimiento invalido");
    } else if ((table[x][y] == null)) {
        table[x][y] = table[posicionX][posicionY];
        table[posicionX][posicionY] = null;
        vaciarTablero();
    } else if ((table[x][y] != null)) {// si el contenido de esa posicion contiene cualquier tipo de pieza, se puede reemplazar con un else
        Torre actual = (Torre) (table[posicionX][posicionY]);
        actual.comerPiezaTorre(x, y, table);
        vaciarTablero();
    }
}
    public  void movimientoAlfil(Scanner teclado, int posicionX, int posicionY) {
        System.out.println("ingrese a que fila quiere mover el alfil");
        int x = teclado.nextInt() - 1;
        System.out.println("ingrese la columna");
        int y = teclado.nextInt() - 1;
        if (table[x][y] instanceof Bloqueo || table[x][y] == table[posicionX][posicionY]) {
            System.out.println("movimiento invalido");
        } else if ((table[x][y] == null)) {
            table[x][y] = table[posicionX][posicionY];
            table[posicionX][posicionY] = null;
            vaciarTablero();
        } else if ((table[x][y] != null)) {// si el contenido de esa posicion contiene cualquier tipo de pieza, se puede reemplazar con un else
            Alfil actualAlfil = (Alfil) table[posicionX][posicionY];
            actualAlfil.comerPiezaAlfil(x, y, table);
            vaciarTablero();
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
