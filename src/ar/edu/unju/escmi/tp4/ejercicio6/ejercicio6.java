package ar.edu.unju.escmi.tp4.ejercicio6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ejercicio6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<libro> libros = new ArrayList<>();
        int opcion;
final String ROSA = "\u001B[38;5;205m";// color rosa para el menu :)
        do {
            System.out.println(ROSA +"\n************ LIBROS ************");
            System.out.println("1 - Alta de libro");
            System.out.println("2 - Mostrar libros");
            System.out.println("3 - Buscar libro");
            System.out.println("4 - Ordenar libros");
            System.out.println("5 - Modificar libro");
            System.out.println("6 - Eliminar libro");
            System.out.println("7 - Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    // Alta utilizando el constructor por defecto y setters
                    libro l = new libro();
                    System.out.print("ISBN: ");
                    l.setIsbn(sc.nextLine());
                    System.out.print("Título: ");
                    l.setTitulo(sc.nextLine());
                    System.out.print("Cantidad de páginas: ");
                    l.setCantPaginas(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Autor: ");
                    l.setAutor(sc.nextLine());
                    libros.add(l);
                    System.out.println("Libro agregado.");
                    break;

                case 2:
                    // Muestra de libros utilizando el método mostrarDatos()
                    for (libro libro : libros) {
                        libro.mostrarDatos();
                    }
                    break;

                case 3:
                    // Búsqueda controlada por ISBN
                    System.out.print("Ingrese ISBN a buscar: ");
                    String isbnBuscar = sc.nextLine();
                    boolean encontrado = false;
                    for (libro libro : libros) {
                        if (libro.getIsbn().equals(isbnBuscar)) {
                            libro.mostrarDatos();
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Libro no encontrado.");
                    }
                    break;

                case 4:
                    // Ordenamiento de la lista utilizando Comparable y Collections.sort()
                    Collections.sort(libros);
                    System.out.println("Libros ordenados por título.");
                    break;

                case 5:
                    // Modificación de datos excepto el ISBN
                    System.out.print("Ingrese ISBN a modificar: ");
                    String isbnModificar = sc.nextLine();
                    boolean modificado = false;
                    for (libro libro : libros) {
                        if (libro.getIsbn().equals(isbnModificar)) {
                            libro.mostrarDatos();
                            System.out.print("Nuevo título: ");
                            libro.setTitulo(sc.nextLine());
                            System.out.print("Nueva cantidad de páginas: ");
                            libro.setCantPaginas(sc.nextInt());
                            sc.nextLine();
                            System.out.print("Nuevo autor: ");
                            libro.setAutor(sc.nextLine());
                            modificado = true;
                            System.out.println("Datos actualizados.");
                            break;
                        }
                    }
                    if (!modificado) {
                        System.out.println("ISBN no encontrado.");
                    }
                    break;

                case 6:
                    // Eliminación de libro mediante ISBN
                    System.out.print("Ingrese ISBN a eliminar: ");
                    String isbnEliminar = sc.nextLine();
                    boolean eliminado = libros.removeIf(libro -> libro.getIsbn().equals(isbnEliminar));
                    if (eliminado) {
                        System.out.println("Libro eliminado.");
                    } else {
                        System.out.println("ISBN no encontrado.");
                    }
                    break;
            }
        } while (opcion != 7);

        sc.close();
    }
}
