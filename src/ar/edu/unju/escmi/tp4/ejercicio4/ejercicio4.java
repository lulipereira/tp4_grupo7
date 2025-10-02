package ar.edu.unju.escmi.tp4.ejercicio4;

import java.util.HashSet;
import java.util.Scanner;

public class ejercicio4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Cliente> clientes = new HashSet<>();
        int opcion = 0;

        while (opcion != 6) {
            System.out.println("\n--- MENU ---");
            System.out.println("1 Crear cliente");
            System.out.println("2 Mostrar los datos de un cliente");
            System.out.println("3 Mostrar todos los clientes");
            System.out.println("4 Mostrar todos los clientes ocasionales y la cantidad");
            System.out.println("5 Mostrar todos los clientes frecuentes y la cantidad");
            System.out.println("6 Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida");
                continue;
            }

            switch (opcion) {
                case 1:
                       System.out.print("Ingrese DNI: ");
                       String dni = sc.nextLine().trim();
                       System.out.print("Ingrese nombre: ");
                       String nombre = sc.nextLine().trim();
                       System.out.print("Ingrese tipo de cliente (ocasional o frecuente): ");
                       String tipo = sc.nextLine().trim().toLowerCase();
                       if (!tipo.equals("ocasional") && !tipo.equals("frecuente")) {
                        System.out.println("Tipo de cliente inválido. Debe ser 'ocasional' o 'frecuente'.");
                        break;
    }

    Cliente nuevo = new Cliente(dni, nombre, tipo);
    if (clientes.add(nuevo)) {
        System.out.println("Cliente agregado.");
    } else {
        System.out.println("Ya existe un cliente con ese DNI.");
    }
    break;

                case 2:
                    System.out.print("Ingrese el DNI del cliente a buscar: ");
                    String dniBuscar = sc.nextLine().trim();
                    clientes.stream()
                            .filter(c -> c.getDni().equals(dniBuscar))
                            .findFirst()
                            .ifPresentOrElse(
                                    c -> System.out.println(c),
                                    () -> System.out.println("No se encontró el dni.")
                            );
                    break;

                case 3:
                    System.out.println("\n-- LISTA DE CLIENTES --");
                    clientes.stream().forEach(System.out::println);
                    break;

                case 4:
                    System.out.println("\n-- CLIENTES OCASIONALES --");
                    long cantOcasionales = clientes.stream()
                            .filter(c -> c.getTipoCliente().equalsIgnoreCase("ocasional"))
                            .peek(System.out::println)
                            .count();
                    System.out.println("Cantidad de clientes ocasionales: " + cantOcasionales);
                    break;

                case 5:
                    System.out.println("\n-- CLIENTES FRECUENTES --");
                    long cantFrecuentes = clientes.stream()
                            .filter(c -> c.getTipoCliente().equalsIgnoreCase("frecuente"))
                            .peek(System.out::println)
                            .count();
                    System.out.println("Cantidad de clientes frecuentes: " + cantFrecuentes);
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }
        }

        sc.close();
    }
}
