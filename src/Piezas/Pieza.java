package Piezas;

import Piezas.Tipos.Bloqueo;

public abstract  class Pieza {
    protected int limiteAbajo1, limiteAbajo2, limitederecha1, limitederecha2, limiteIzquierda, limiteIzquierda2, limiteArriba1, limititeArriba2;

    protected int posicionX;
    protected  int posicionY;

    protected Jugadores propietario;
    protected final String red ="\u001B[31m";
    protected final String green ="\u001B[32m";
    protected final String reset = "\u001B[0m";

    public Pieza(Jugadores propietario) {
        this.propietario = propietario;
    }

    public Jugadores getPropietario() {
        return propietario;
    }

    public void setPropietario(Jugadores propietario) {
        this.propietario = propietario;
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



    public void espaciosDiagonal(Pieza[][]table) {
        for (int i = posicionX + 1, j = posicionY + 1; i < 8 & j < 8; i++, j++) {
            if (table[i][j] instanceof Bloqueo) {
                table[i][j] = null;
                if (i == 7) {
                    limiteAbajo1 = i;
                    limitederecha1 = j;
                }
                if (j == 7) {
                    limitederecha1 = j;
                    limiteAbajo1 = i;
                }

            } else {
                limiteAbajo1 = i;
                limitederecha1 = j;
                break;
            }
        }

        //hacia abajo izquierda
        for (int i = posicionX + 1, j = posicionY - 1; i < 8 & j >= 0; i++, j--) {
            if (table[i][j] instanceof Bloqueo) {
                table[i][j] = null;
                if (i == 7) {
                    limiteAbajo2 = i;
                    limiteIzquierda = j;
                }
                if (j == 0) {
                    limiteAbajo2 = i;
                    limiteIzquierda = j;
                }

            } else {
                limiteAbajo2 = i;
                limiteIzquierda = j;
                break;
            }
        }


        //hacia arriba derecha
        for (int i = posicionX - 1, j = posicionY + 1; i >= 0 & j < 8; i--, j++) {
            if (table[i][j] instanceof Bloqueo) {
                table[i][j] = null;

                if (i == 0) {
                    limiteArriba1 = i;
                    limitederecha2 = j;
                }
                if (j == 7) {
                    limitederecha2 = j;
                    limiteArriba1 = i;
                }
            } else {
                limiteArriba1 = i;
                limitederecha2 = j;
                break;
            }
        }

        //hacia arriba izquierda
        for (int i = posicionX - 1, j = posicionY - 1; i >= 0 & j >= 0; i--, j--) {
            if (table[i][j] instanceof Bloqueo) {
                table[i][j] = null;
                if (i == 0) {
                    limititeArriba2 = i;
                    limiteIzquierda2 = j;
                }
                if (j == 0) {
                    limiteIzquierda2 = j;
                    limititeArriba2 = i;
                }
            } else {
                limititeArriba2 = i;
                limiteIzquierda2 = j;
                break;
            }
        }
    }



    public void comerDiagonal(int movimientoX, int movimientoY, Pieza[][]table) {
        if (table[posicionX][posicionY].getPropietario() != table[movimientoX][movimientoY].getPropietario()) {
            if (posicionX != movimientoX && posicionY != movimientoY){
                if (posicionX + 1 == movimientoX || posicionY + 1 == movimientoY && posicionX - 1 == movimientoX || posicionY - 1 == movimientoY) {
                    if (table[movimientoX][movimientoY] instanceof Pieza && !(table[movimientoX][movimientoY] instanceof Bloqueo)) {
//si la pieza que come esta en el cuadrante de arriba a la izquieda
                        if (movimientoX >= limititeArriba2 && movimientoY >= limiteIzquierda2) {
                            table[movimientoX][movimientoY] = table[posicionX][posicionY];
                            table[posicionX][posicionY] = null;
                        }
                        //cuadrante de arriba a la derecha
                        else if (movimientoX >= limiteArriba1 && movimientoY <= limitederecha2) {
                            table[movimientoX][movimientoY] = table[posicionX][posicionY];
                            table[posicionX][posicionY] = null;
                        }
                        // abajo derecha
                        else if (movimientoX <= limiteAbajo1 && movimientoY <= limitederecha1) {
                            table[movimientoX][movimientoY] = table[posicionX][posicionY];
                            table[posicionX][posicionY] = null;
                        } else if (movimientoX <= limiteAbajo2 && movimientoY >= limiteIzquierda) {
                            table[movimientoX][movimientoY] = table[posicionX][posicionY];
                            table[posicionX][posicionY] = null;
                        }


                    }
                }
            }
        }
        else {
            System.out.println("no puedes comer una pieza propia");
        }

    }








    protected  int limiteDerechaHorizontal =0;
    protected int limiteArribaVertical =0;
    protected   int limiteAbajoVertical =0;

    protected   int limiteIzquierdaHorizontal=0;

    public  void espaciosDisponiblesVerticalHorinzotal(Pieza[][]table){
        //hacia la derecha
        for (int i =posicionY+1; i<8;i++) {
            if (table[posicionX][i] instanceof Bloqueo) {
                table[posicionX][i] = null;
                if (i == 7) {// igualamos a 7 ya que en la version aterior solo le sumabamos +1 a la ultima casilla disponible,pero cuando la ultima casilla era 7 y si le sumaba 1 se pasaba del array por eso nunca actualizaba valor
                    limiteDerechaHorizontal = 7;
                }
            } else {
                // en los casos anteriores se iniciaba a 1 el limite de derecha porque al moverla pieza hacia abajo  no se actualizaba el limitederecha ya que se iba hasata la columna 7 entonces no ingresaba y se actualizaba con la i
                limiteDerechaHorizontal = i;
                break;
            }
        }

       /* if (super.limitegeneral ==0){
           super.limitegeneral =7;
        }*/

        //a la izquierda
        for (int i =posicionY-1; i>=0;i--)
        {
            if (table[posicionX][i] instanceof  Bloqueo){
                table[posicionX][i]=null;
                if (i == 0) {// igualamos a 7 ya que en la version aterior solo le sumabamos +1 a la ultima casilla disponible,pero cuando la ultima casilla era 7 y si le sumaba 1 se pasaba del array por eso nunca actualizaba valor
                    limiteIzquierdaHorizontal = 0;
                }
            }
            else {limiteIzquierdaHorizontal=i;
                break;}
        }


        //hacia arriba
        for (int i =posicionX-1; i>=0;i--)
        {
            if (table[i][posicionY] instanceof  Bloqueo){
                table[i][posicionY]=null;
                if (i == 0) {// igualamos a 7 ya que en la version aterior solo le sumabamos +1 a la ultima casilla disponible,pero cuando la ultima casilla era 7 y si le sumaba 1 se pasaba del array por eso nunca actualizaba valor
                    limiteArribaVertical = 0;
                }
            }
            else {
                limiteArribaVertical =i;
                break;}

        }


        //hacia abajo
        for (int i =posicionX+1; i<8;i++)
        {
            if (table[i][posicionY] instanceof  Bloqueo){
                table[i][posicionY]=null;
                if (i == 7) {// igualamos a 7 ya que en la version aterior solo le sumabamos +1 a la ultima casilla disponible,pero cuando la ultima casilla era 7 y si le sumaba 1 se pasaba del array por eso nunca actualizaba valor
                    limiteAbajoVertical = 7;
                }
            }
            else {
                limiteAbajoVertical =i; //
                break;}
        }
    }


    /**
     *
     * @param movimientoX es la variable que indica en que fila queremos mover la pieza
     * @param movimientoY es la variable que indica en que columna queremos mover la pieza
     * @param table necesitamos llamar al array para identificar el valor de cada elemento del array
     */
    public void comerHorizontalVertical(int movimientoX, int movimientoY, Pieza[][]table){
        if (table[posicionX][posicionY].getPropietario()!=table[movimientoX][movimientoY].getPropietario()) {
            if (posicionX == movimientoX || posicionY == movimientoY) {
                if (table[movimientoX][movimientoY] instanceof Pieza && !(table[movimientoX][movimientoY] instanceof Bloqueo)) {
                    if (movimientoX >= limiteArribaVertical && movimientoX <= limiteAbajoVertical) { // el limite de arriba debe ser comparado con el movimiento X, ya que para saber en que fila (recta horizontal) estamos contamos de arriba hacia abajo por eso el minomo es el limite de arriba ya que empieza en 0 y el limeteabajo es mayor osea 7
                        if (movimientoY <= limiteDerechaHorizontal && movimientoY >= limiteIzquierdaHorizontal) {
                            table[movimientoX][movimientoY] = table[posicionX][posicionY];
                            table[posicionX][posicionY] = null;
                        }
                    }


                }
            }
        }
        else {
            System.out.println("no puedes comer una pieza propia");
        }

    }










}
