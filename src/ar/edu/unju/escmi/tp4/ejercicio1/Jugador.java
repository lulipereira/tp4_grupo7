package ar.edu.unju.escmi.tp4.ejercicio1;

public class Jugador {
    private int dni;
    private String nombre;
    private String equipo;
    private String nacionalidad;
    private int estatura;

    public Jugador() {
    }

    public Jugador(int dni, String nombre, String equipo, String nacionalidad, int estatura) {
        this.dni = dni;
        this.nombre = nombre;
        this.equipo = equipo;
        this.nacionalidad = nacionalidad;
        this.estatura = estatura;
    }

    public int getDni() { return dni; }
    public void setDni(int dni) { this.dni = dni; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEquipo() { return equipo; }
    public void setEquipo(String equipo) { this.equipo = equipo; }

    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    public int getEstatura() { return estatura; }
    public void setEstatura(int estatura) { this.estatura = estatura; }

    public void mostrarDatos() {
        System.out.println("---------------------------");
        System.out.println("DNI: " + dni);
        System.out.println("Nombre: " + nombre);
        System.out.println("Equipo: " + equipo);
        System.out.println("Nacionalidad: " + nacionalidad);
        System.out.println("Estatura: " + estatura);
        System.out.println("---------------------------");
    }
}
