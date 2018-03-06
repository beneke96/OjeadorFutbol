package es.formacion.ruben.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Jugadores")
public class Jugadores {
    @Id
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Equipo")
    private String equipo;
    @Column(name = "Categoria")
    private String categoria;
    @Column(name = "Posicion")
    private String posicion;

    public Jugadores(String nombre, String equipo, String categoria, String posicion) {
        this.nombre = nombre;
        this.equipo = equipo;
        this.categoria = categoria;
        this.posicion = posicion;
    }


    public Jugadores() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
    @Override
    public String toString() {
        return "Jugadores{" +
                "nombre=" + nombre + '\'' +
                ", equipo=" + equipo + '\'' +
                ", categoria=" + categoria + '\'' +
                ", posicion=" + posicion + '\'' +
                '}';
    }
}
