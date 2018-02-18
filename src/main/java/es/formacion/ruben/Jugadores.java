package es.formacion.ruben;

public class Jugadores {

    private String nombre;
    private String equipo;
    private String categoria;
    private String observaciones;

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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Jugadores(String nombre, String equipo, String categoria, String observaciones) {
        this.nombre = nombre;
        this.equipo = equipo;
        this.categoria = categoria;

        this.observaciones = observaciones;
    }
    @Override
    public String toString() {
        return "Jugadores{\n" +
                ", nombre= \n" + nombre + '\'' +
                ", equipo=\n" + equipo + '\'' +
                ", categoria=\n" + categoria + '\'' +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }
}
