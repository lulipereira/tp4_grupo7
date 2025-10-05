package ar.edu.unju.escmi.tp4.ejercicio2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Empleado> mapa = new HashMap<>();
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("\n--- MENU ---");
            System.out.println("1 Alta de empleado.");
            System.out.println("2 Mostrar empleados.");
            System.out.println("3 Eliminar empleado.");
            System.out.println("4 Consultar los datos de un empleado.");
            System.out.println("5 Salir.");
            System.out.print("Seleccione una opción: ");
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida. Intente de nuevo.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese DNI: ");
                    String dni = sc.nextLine().trim();

                    System.out.print("Ingrese categoría (un carácter, ej: A): ");
                    String catStr = sc.nextLine().trim();
                    char categoria = catStr.isEmpty() ? ' ' : catStr.charAt(0);

                    String clave = dni + categoria;

                    if (mapa.containsKey(clave)) {
                        System.out.println("Ya existe un empleado con la clave: " + clave);
                        break;
                    }

                    System.out.print("Ingrese nombre: ");
                    String nombre = sc.nextLine().trim();

                    System.out.print("Ingrese apellido: ");
                    String apellido = sc.nextLine().trim();

                    double sueldo = 0;
                    while (true) {
                        System.out.print("Ingrese sueldo: ");
                        String sueldoStr = sc.nextLine().trim();
                        try {
                            sueldo = Double.parseDouble(sueldoStr);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Sueldo inválido. Ingrese un número (use punto para decimales).");
                        }
                    }

                    Empleado emp = new Empleado(dni, nombre, apellido, sueldo, categoria);
                    mapa.put(clave, emp);
                    System.out.println("Empleado agregado con clave: " + clave);
                    break;

                case 2:
                    if (mapa.isEmpty()) {
                        System.out.println("No hay empleados cargados.");
                        break;
                    }
                    Iterator<Map.Entry<String, Empleado>> it = mapa.entrySet().iterator();
                    System.out.println("\n-- LISTA DE EMPLEADOS --");
                    while (it.hasNext()) {
                        Map.Entry<String, Empleado> entry = it.next();
                        System.out.println("Clave: " + entry.getKey());
                        System.out.println("Valor: ");
                        entry.getValue().mostrarDatos();
                        System.out.println("-----------------------");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese la clave del empleado a eliminar (dni+categoria, ej: 20310458A): ");
                    String claveEliminar = sc.nextLine().trim();
                    if (mapa.containsKey(claveEliminar)) {
                        mapa.remove(claveEliminar);
                        System.out.println("Empleado con clave " + claveEliminar + " eliminado.");
                    } else {
                        System.out.println("No existe la clave: " + claveEliminar);
                    }
                    break;

                case 4:
                    System.out.print("Ingrese la clave a consultar (dni+categoria): ");
                    String claveConsulta = sc.nextLine().trim();
                    if (mapa.containsKey(claveConsulta)) {
                        Empleado encontrado = mapa.get(claveConsulta);
                        System.out.println("Empleado encontrado:");
                        encontrado.mostrarDatos();
                    } else {
                        System.out.println("La clave no se encuentra en el HashMap.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }

        sc.close();
    }
}
