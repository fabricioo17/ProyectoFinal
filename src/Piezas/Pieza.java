package Piezas;

import Piezas.Tipos.*;
import Tablero.Tablero;

import java.util.Scanner;

public abstract  class Pieza {
    protected boolean blancas;
    protected int posicionX;
    protected int posicionY;

    protected final String red = "\u001B[31m";
    protected final String green = "\u001B[32m";
    protected final String reset = "\u001B[0m";

    public boolean isBlancas() {
        return blancas;
    }

    public void setBlancas(boolean blancas) {
        this.blancas = blancas;
    }

    public Pieza(Boolean blancas, int posicionX, int posicionY) {
        this.blancas = blancas;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public Pieza(boolean blancas) {
        this.blancas = blancas;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }


    public void movimientoRey(Scanner teclado) {
        System.out.println("ingrese a que fila quiere mover el rey ");
        int x = teclado.nextInt();
        System.out.println("ingresa la columna");
        int y = teclado.nextInt();


    }

    public boolean confirmarJaque(Tablero tablero, int posicionReyX, int posicionReyY) {
        Pieza[][] table = tablero.getTable();
        //hacia arriba
        for (int i = posicionReyX - 1; i >= 0; i--) {
            if ((table[i][posicionReyY] instanceof Torre || table[i][posicionReyY] instanceof Reina)) {
                if (table[i][posicionReyY].isBlancas() != table[posicionReyX][posicionReyY].isBlancas()) {// si el color de la torre en la recta vertical es diferente al  color del rey devuelve un true
                    return true;
                } else {
                    break;
                }
                //un else if mas cuando es pieza enemiga pero que no puede comernos
            }

            if (table[i][posicionReyY] instanceof Pieza ){
                break;
            }
        }


        // hacia abajo
        for (int i = posicionReyX + 1; i < 8; i++) {
            if (table[i][posicionReyY] instanceof Torre || table[i][posicionReyY] instanceof Reina) {
                if (table[i][posicionReyY].isBlancas() != table[posicionReyX][posicionReyY].isBlancas()) {
                    return true;
                }
                else {
                    break;
                }
            }
            if (table[i][posicionReyY] instanceof Pieza ) {
                break;
            }
        }


        //hacia la derecha
        for (int i = posicionReyY + 1; i < 8; i++) {
            if (table[posicionReyX][i] instanceof Torre || table[posicionReyX][i] instanceof Reina) {
                if (table[posicionReyX][i].isBlancas() != table[posicionReyX][posicionReyY].isBlancas()) {
                    return true;
                }

                else {
                    break;
                }
            }
            if (table[posicionReyX][i] instanceof Pieza) {

                break;
            }
        }


        //hacia la izquierda
        for (int i = posicionReyY - 1; i >= 0; i--) {
            if (table[posicionReyX][i] instanceof Torre || table[posicionReyX][i] instanceof Reina) {
                if (table[posicionReyX][i].isBlancas() != table[posicionReyX][posicionReyY].isBlancas()) {
                    return true;
                } else {
                    break;
                }
            }
            if (table[posicionReyX][i] instanceof Pieza ) {

                break;
            }
        }


        //------------------------diagonal----------------------------------------------//
        for (int i = posicionReyX - 1, j = posicionReyY - 1; i >= 0 && j >= 0; i--, j--) {
            //arriba izquierda
            if (table[i][j] instanceof Reina || table[i][j] instanceof Alfil || table[i][j] instanceof Peon) {

                if (table[i][j].isBlancas() != table[posicionReyX][posicionReyY].isBlancas()) {
                    return true;
                }
                else {
                    break;
                }
            }

             if (table[i][j] instanceof Pieza) {
                break;
            }


        }

        //arriba a la derecha
        for (int i = posicionReyX - 1, j = posicionReyY + 1; i >= 0 && j < 8; i--, j++) {
            //arriba izquierda
            if (table[i][j] instanceof Reina || table[i][j] instanceof Alfil || table[i][j] instanceof Peon) {
                if (table[i][j].isBlancas() != table[posicionReyX][posicionReyY].isBlancas()) {
                    return true;
                }
                else {
                    break;
                }

            }
            if (table[i][j] instanceof Pieza && table[i][j].isBlancas() == table[posicionReyX][posicionReyY].isBlancas()) {
                break;
            }
        }


        //abajo a la izquierda

        for (int i = posicionReyX + 1, j = posicionReyY - 1; i < 8 && j >= 0; i++, j--) {
            //arriba izquierda
            if (table[i][j] instanceof Reina || table[i][j] instanceof Alfil || table[i][j] instanceof Peon) {
                if (table[i][j].isBlancas() != table[posicionReyX][posicionReyY].isBlancas()) {
                    return true;
                }
                else {
                    break;
                }
            }
            if (table[i][j] instanceof Pieza) { // cambiar a cualquier pieza , ya que al no ser ni alfil o reina no hay eligro alguno
                break;
            }
        }


        for (int i = posicionReyX + 1, j = posicionReyY + 1; i < 8 && j < 8; i++, j++) {
            //abajo derecha
            if (table[i][j] instanceof Reina || table[i][j] instanceof Alfil || table[i][j] instanceof Peon) {
                if (table[i][j].isBlancas() != table[posicionReyX][posicionReyY].isBlancas()) {
                    return true;
                }
                else {
                    break;
                }
            }
            if (table[i][j] instanceof Pieza) {
                break;
            }

        }


        //------------------------------------------------------------------------------------//


//----------------------------evitar caballo-----------------------//


        // hacia arriba derecha
        if (posicionReyX - 2 >= 0 && posicionReyY + 1 <= 7) {// por si al querer identificar el caballo en un lugar que este fuera del tablero usamos un if
            if (table[posicionReyX - 2][posicionReyY + 1] instanceof Caballo) {
                if (table[posicionReyX - 2][posicionReyY + 1].isBlancas() != table[posicionReyX][posicionReyY].isBlancas()) {
                    return true;
                }
            }
        }


        //arriba izquierda
        if (posicionReyX - 2 >= 0 && posicionReyY - 1 >= 0) {
            if (table[posicionReyX - 2][posicionReyY - 1] instanceof Caballo) {
                if (table[posicionReyX - 2][posicionReyY - 1].isBlancas() != table[posicionReyX][posicionReyY].isBlancas()) {
                    return true;
                }
            }
        }


// derecha arriba
        if (posicionReyX - 1 >= 0 && posicionReyY + 2 <= 7) {
            if (table[posicionReyX - 1][posicionReyY + 2] instanceof Caballo) {
                if (table[posicionReyX - 1][posicionReyY + 2].isBlancas() != table[posicionReyX][posicionReyY].isBlancas()) {
                    return true;
                }
            }
        }


        //derecha abajo
        if (posicionReyX + 1 <= 7 && posicionReyY + 2 <= 7) {
            if (table[posicionReyX + 1][posicionReyY + 2] instanceof Caballo) {
                if (table[posicionReyX + 1][posicionReyY + 2].isBlancas() != table[posicionReyX][posicionReyY].isBlancas()) {
                    return true;
                }
            }
        }


        //abajo derecha
        if (posicionReyX + 2 <= 7 && posicionReyY + 1 <= 7) {
            if (table[posicionReyX + 2][posicionReyY + 1] instanceof Caballo) {
                if (table[posicionReyX + 2][posicionReyY + 1].isBlancas() != table[posicionReyX][posicionReyY].isBlancas()) {
                    return true;
                }
            }
        }

//abajo izquierda
        if (posicionReyX + 2 <= 7 && posicionReyY - 1 >= 0) {
            if (table[posicionReyX + 2][posicionReyY - 1] instanceof Caballo) {
                if (table[posicionReyX + 2][posicionReyY - 1].isBlancas() != table[posicionReyX][posicionReyY].isBlancas()) {
                    return true;
                }
            }

        }


// izquierda arriba
        if (posicionReyX - 1 >= 0 && posicionReyY - 2 >= 0) {
            if (table[posicionReyX - 1][posicionReyY - 2] instanceof Caballo) {
                if (table[posicionReyX - 1][posicionReyY - 2].isBlancas() != table[posicionReyX][posicionReyY].isBlancas()) {
                    return true;
                }
            }
        }

//izquierda abajo
        if (posicionReyX + 1 <= 7 && posicionReyY - 2 >= 0) {
            if (table[posicionReyX + 1][posicionReyY - 2] instanceof Caballo) {
                if (table[posicionReyX + 1][posicionReyY - 2].isBlancas() != table[posicionReyX][posicionReyY].isBlancas()) {
                    return true;
                }
            }
        }

//---------------------------------------------------------------------------------------------------------------------//


        return false;


    }


    public boolean regresarPiezaComida(Tablero tablero, int posicionOriginalX, int posicionOriginalY, Pieza piezaComida) {
        Pieza[][] table = tablero.getTable();
        table[posicionOriginalX][posicionOriginalY] = table[posicionX][posicionY];
        table[posicionX][posicionY] = piezaComida;
        table[posicionX][posicionY].setPosicionX(posicionX);
        table[posicionX][posicionY].setPosicionY(posicionY);
        table[posicionOriginalX][posicionOriginalY].setPosicionX(posicionOriginalX);
        table[posicionOriginalX][posicionOriginalY].setPosicionY(posicionOriginalY);
        return true;

    }

    public boolean regresarMovimiento(Tablero tablero, int posicionOriginalX, int posicionOriginalY) {
        Pieza[][] table = tablero.getTable();
        table[posicionOriginalX][posicionOriginalY] = table[posicionX][posicionY];// al confirmar que se puede mover table esa posicion,
        //igualamos el contenido de la ubicacion orignal de la pieza al nuevo lugar

        table[posicionX][posicionY] = null;// la ubicacion original la dejamos en nulo
       table[posicionOriginalX][posicionOriginalY].setPosicionX(posicionOriginalX);//cambiamos la posicion de la nueva pieza movida, ya que aun mantenia la posicion anteiro
        table[posicionOriginalX][posicionOriginalY].setPosicionY(posicionOriginalY);

        return true;

    }
        public  void cambiarPosicion(Tablero tablero, int movimientoX, int movimientoY){
            Pieza[][] table = tablero.getTable();
            table[movimientoX][movimientoY] = table[posicionX][posicionY];
           table[posicionX][posicionY] = null;
            table[movimientoX][movimientoY].setPosicionX(movimientoX); //cambiamos la posicion de la nueva pieza movida, ya que aun mantenia la posicion anteiro
            table[movimientoX][movimientoY].setPosicionY(movimientoY);

        }

        public  void cambiarPosicionPieza(Tablero tablero, int movimientoX, int movimientoY){
            Pieza[][] table = tablero.getTable();
            table[movimientoX][movimientoY] = table[posicionX][posicionY];
            table[posicionX][posicionY] = null;
            table[movimientoX][movimientoY].setPosicionX(movimientoX); //cambiamos la posicion de la nueva pieza movida, ya que aun mantenia la posicion anteiro
            table[movimientoX][movimientoY].setPosicionY(movimientoY);
        }

public  abstract  boolean protegerRey(Tablero tablero, int posicionX, int posicionY, boolean blanco);



}






