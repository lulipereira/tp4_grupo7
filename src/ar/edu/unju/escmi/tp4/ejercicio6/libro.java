package ar.edu.unju.escmi.tp4.ejercicio6;

public class Libro implements Comparable<Libro> {
    private String isbn;
    private String titulo;
    private int cantPaginas;
    private String autor;

    // Constructor por defecto requerido en la consigna
    public Libro() {
    }

    // Método solicitado para mostrar los datos del libro
    public void mostrarDatos() {
        System.out.println("ISBN: " + isbn + ", Título: " + titulo + ", Páginas: " + cantPaginas + ", Autor: " + autor);
    }

    // Implementación de la interfaz Comparable para ordenar por título
    @Override
    public int compareTo(Libro otro) {
        return this.titulo.compareToIgnoreCase(otro.titulo);
    }

    // Getters y Setters
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getCantPaginas() { return cantPaginas; }
    public void setCantPaginas(int cantPaginas) { this.cantPaginas = cantPaginas; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
}
