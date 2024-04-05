package Piezas.Tipos;
import Piezas.Tipos.Torre;
import Piezas.Jugadores;
import Piezas.Pieza;

public class Reina extends Pieza {
    private int limitegeneralTorre=0;
    private int limititeArribaTorre=0;
    private   int limiteAbajoTorre=0;

    private    int limiteIzquierdaTorre=0;
    private int limiteAbajoAlfil;
    private int limiteAbajoAlfil2;
    private int limiteArribaAlfil1;
    private int limiteArribaAlfil2;
    private  int limiteDerechaAlfil;
    private int limitederechaAlfil2;
    private int limiteIzquierdaAlfil1;
    private int limiteIzquierdaAlfil2;

    public Reina(Jugadores propietario) {
        super(propietario);
    }
    public void disponibleEspacioDama(Pieza[][]table){
       /* Pieza nuevo =(table[posicionX][posicionY]);
       Alfil nuevoAlfil= (Alfil) nuevo;
       nuevoAlfil.espaciosDisponibleAlfil(table);
        Pieza nuevo2 =(table[posicionX][posicionY]);
        Torre nuevoTorre= (Torre) nuevo2;
        nuevoTorre.espaciosDisponibles(table);*/

            //hacia abajo derecha
            for (int i=posicionX+1,j=posicionY+1;i<8 & j<8;i++,j++){
                if (table[i][j] instanceof Bloqueo) {
                    table[i][j] = null;
                    if(i==7){
                        limiteAbajoAlfil=i;
                        limiteDerechaAlfil=j;
                    }
                    if (j==7) {
                        limiteDerechaAlfil=j;
                        limiteAbajoAlfil=i;
                    }

                }
                else {
                    limiteAbajoAlfil = i;
                    limiteDerechaAlfil=j;
                    break;
                }
            }

            //hacia abajo izquierda
            for (int i=posicionX+1,j=posicionY-1;i<8 & j>=0;i++,j--){
                if (table[i][j] instanceof Bloqueo) {
                    table[i][j] = null;
                    if(i==7){
                        limiteAbajoAlfil2=i;
                        limiteIzquierdaAlfil1=j;
                    }
                    if (j==0) {
                        limiteAbajoAlfil2=i;
                        limiteIzquierdaAlfil1=j;
                    }

                }
                else {
                    limiteAbajoAlfil2=i;
                    limiteIzquierdaAlfil1=j;
                    break;
                }
            }



            //hacia arriba derecha
            for (int i=posicionX-1,j=posicionY+1;i>=0 & j<8;i--,j++){
                if (table[i][j] instanceof Bloqueo) {
                    table[i][j] = null;

                    if(i==0){
                        limiteArribaAlfil1 =i;
                        limitederechaAlfil2=j;
                    }
                    if (j==7) {
                        limitederechaAlfil2=j;
                        limiteArribaAlfil1=i;
                    }
                }
                else {
                    limiteArribaAlfil1=i;
                    limitederechaAlfil2=j;
                    break;
                }
            }

            //hacia arriba izquierda
            for (int i=posicionX-1,j=posicionY-1;i>=0 & j>=0;i--,j--){
                if (table[i][j] instanceof Bloqueo) {
                    table[i][j] = null;
                    if(i==0){
                        limiteArribaAlfil2=i;
                        limiteIzquierdaAlfil2=j;
                    }
                    if (j==0) {
                        limiteIzquierdaAlfil2=j;
                        limiteArribaAlfil2=i;
                    }
                }
                else {
                    limiteArribaAlfil2 = i;
                    limiteIzquierdaAlfil2=j;
                    break;
                }
            }




            //----------movimineto como torre-----------//

        //hacia la derecha
        for (int i =posicionY+1; i<8;i++) {
            if (table[posicionX][i] instanceof Bloqueo) {
                table[posicionX][i] = null;
                if (i == 7) {// igualamos a 7 ya que en la version aterior solo le sumabamos +1 a la ultima casilla disponible,pero cuando la ultima casilla era 7 y si le sumaba 1 se pasaba del array por eso nunca actualizaba valor
                    limitegeneralTorre = 7;
                }
            } else {
                // en los casos anteriores se iniciaba a 1 el limite de derecha porque al moverla pieza hacia abajo  no se actualizaba el limitederecha ya que se iba hasata la columna 7 entonces no ingresaba y se actualizaba con la i
                limitegeneralTorre = i;
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
                    limiteIzquierdaTorre = 0;
                }
            }
            else {limiteIzquierdaTorre=i;
                break;}
        }


        //hacia arriba
        for (int i =posicionX-1; i>=0;i--)
        {
            if (table[i][posicionY] instanceof  Bloqueo){
                table[i][posicionY]=null;
                if (i == 0) {// igualamos a 7 ya que en la version aterior solo le sumabamos +1 a la ultima casilla disponible,pero cuando la ultima casilla era 7 y si le sumaba 1 se pasaba del array por eso nunca actualizaba valor
                    limititeArribaTorre = 0;
                }
            }
            else {limititeArribaTorre=i;
                break;}

        }


        //hacia abajo
        for (int i =posicionX+1; i<8;i++)
        {
            if (table[i][posicionY] instanceof  Bloqueo){
                table[i][posicionY]=null;
                if (i == 7) {// igualamos a 7 ya que en la version aterior solo le sumabamos +1 a la ultima casilla disponible,pero cuando la ultima casilla era 7 y si le sumaba 1 se pasaba del array por eso nunca actualizaba valor
                    limiteAbajoTorre = 7;
                }
            }
            else {limiteAbajoTorre=i; //
                break;}
        }








        }




    public void comerPiezaReina(int movimientoX, int movimientoY, Pieza[][]table){

//comer como un alfil//
        if (table[posicionX][posicionY].getPropietario() != table[movimientoX][movimientoY].getPropietario()) {
            if (table[movimientoX][movimientoY] instanceof Pieza && !(table[movimientoX][movimientoY] instanceof Bloqueo)){
                if (posicionX + 1 == movimientoX || posicionY + 1 == movimientoY && posicionX - 1 == movimientoX || posicionY - 1 == movimientoY) {
                    if (posicionX != movimientoX && posicionY != movimientoY  ) {
//si la pieza que come esta en el cuadrante de arriba a la izquieda
                        if (movimientoX >= limiteArribaAlfil2 && movimientoY >= limiteIzquierdaAlfil2) {
                            table[movimientoX][movimientoY] = table[posicionX][posicionY];
                            table[posicionX][posicionY] = null;
                        }
                        //cuadrante de arriba a la derecha
                        else if (movimientoX >= limiteArribaAlfil1 && movimientoY <= limitederechaAlfil2) {
                            table[movimientoX][movimientoY] = table[posicionX][posicionY];
                            table[posicionX][posicionY] = null;
                        }
                        // abajo derecha
                        else if (movimientoX <= limiteAbajoAlfil && movimientoY <= limiteDerechaAlfil) {
                            table[movimientoX][movimientoY] = table[posicionX][posicionY];
                            table[posicionX][posicionY] = null;
                        } else if (movimientoX <= limiteAbajoAlfil2 && movimientoY >= limiteIzquierdaAlfil1) {
                            table[movimientoX][movimientoY] = table[posicionX][posicionY];
                            table[posicionX][posicionY] = null;
                        }
                    }
                }
                if (posicionX == movimientoX || posicionY == movimientoY) {
                        if (movimientoX >= limititeArribaTorre && movimientoX <= limiteAbajoTorre) { // el limite de arriba debe ser comparado con el movimiento X, ya que para saber en que fila (recta horizontal) estamos contamos de arriba hacia abajo por eso el minomo es el limite de arriba ya que empieza en 0 y el limeteabajo es mayor osea 7
                            if (movimientoY <= limitegeneralTorre && movimientoY >= limiteIzquierdaTorre) {
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
