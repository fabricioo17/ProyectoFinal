package Piezas;

public class Pieza {
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
}
