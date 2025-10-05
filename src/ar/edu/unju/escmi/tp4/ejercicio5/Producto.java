package ar.edu.unju.escmi.tp4.ejercicio5;

import java.time.LocalDate;

public class Producto {
    private String descripcion;
    private double precio;
    private LocalDate fechaVencimiento;

    // Constructor parametrizado
    public Producto(String descripcion, double precio, LocalDate fechaVencimiento) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public String toString() {
        // Representación legible de los datos del producto
        return "Descripción: " + descripcion + ", Precio: " + precio + ", Vencimiento: " + fechaVencimiento;
    }
}
