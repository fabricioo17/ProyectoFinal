package Jugadores;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class Jugador {
    String nombre;
    String id;
    LocalDate fecha;
    Boolean blancas;

    public Jugador(String nombre, String id, boolean blancas) {
        this.nombre = nombre;
        this.id = id;
        this.fecha = LocalDate.now();
        blancas=blancas;
    }

    public Jugador(Scanner teclado, boolean blancas) {
        System.out.println("ingrese su nombre");
        this.nombre = teclado.next();
        System.out.println("ingrese un identificador");
        this.id = teclado.next();
        this.fecha = LocalDate.now();
        blancas=blancas;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }




}
