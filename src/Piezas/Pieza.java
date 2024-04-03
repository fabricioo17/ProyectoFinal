package Piezas;

public class Pieza {
    protected int posicionX;
    protected  int posicionY;
    protected  int limitegeneral=0;
    protected int limititeArriba=0;
   protected   int limiteAbajo=0;

    protected   int limiteIzquierda=0;

    protected Jugadores propietario;

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
}
