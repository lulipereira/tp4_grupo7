package ar.edu.unju.escmi.tp4.ejercicio4;

public class Cliente {
    private String dni;
    private String nombre;
    private String tipoCliente;

    public Cliente(String dni, String nombre, String tipoCliente) {
        this.dni = dni;
        this.nombre = nombre;
        this.tipoCliente = tipoCliente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", tipoCliente='" + tipoCliente + '\'' +
                '}';
    }

    // Para que no duplique clientes con mismo DNI
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Cliente)) return false;
        Cliente other = (Cliente) obj;
        return this.dni != null && this.dni.equals(other.dni);
    }

    @Override
    public int hashCode() {
        return dni == null ? 0 : dni.hashCode();
    }
}
