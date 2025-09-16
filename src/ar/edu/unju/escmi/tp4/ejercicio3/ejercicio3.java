package ar.edu.unju.escmi.tp4.ejercicio3;

import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ejercicio3 {
    public static final String ROSA = "\u001B[95m";
    public static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<paciente> pacientes = new TreeSet<>();
        int opcion;

        do {
            System.out.println(ROSA + "\n********** MENÚ PACIENTES **********" + RESET);
            System.out.println(ROSA + "1 Alta de paciente" + RESET);
            System.out.println(ROSA + "2 Mostrar todos los pacientes" + RESET);
            System.out.println(ROSA + "3 Mostrar paciente en la mitad de la lista" + RESET);
            System.out.println(ROSA + "4 Mostrar primer paciente" + RESET);
            System.out.println(ROSA + "5 Mostrar último paciente" + RESET);
            System.out.println(ROSA + "6 Filtrar por historia clínica" + RESET);
            System.out.println(ROSA + "7 Salir" + RESET);
            System.out.print(ROSA + "Ingrese opción: " + RESET);
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    paciente p = new paciente();
                    System.out.print("DNI: ");
                    p.setDni(sc.nextLine());
                    System.out.print("Nombre: ");
                    p.setNombre(sc.nextLine());
                    System.out.print("Apellido: ");
                    p.setApellido(sc.nextLine());
                    System.out.print("Número de historia clínica: ");
                    p.setNumeroHistoriaClinica(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Obra social: ");
                    p.setObraSocial(sc.nextLine());
                    pacientes.add(p);
                    System.out.println(ROSA + "Paciente agregado." + RESET);
                    break;

                case 2:
                    System.out.println(ROSA + "\n--- LISTA DE PACIENTES ---" + RESET);
                    pacientes.stream().forEach(System.out::println);
                    break;

                case 3:
                    if (!pacientes.isEmpty()) {
                        int mitad = pacientes.size() / 2;
                        paciente pacienteMitad = pacientes.stream()
                                .collect(Collectors.toList())
                                .get(mitad);
                        System.out.println(ROSA + "Paciente en la mitad: " + RESET + pacienteMitad);
                    } else {
                        System.out.println("No hay pacientes.");
                    }
                    break;

                case 4:
                    if (!pacientes.isEmpty())
                        System.out.println(ROSA + "Primer paciente: " + RESET + pacientes.first());
                    else
                        System.out.println("No hay pacientes.");
                    break;

                case 5:
                    if (!pacientes.isEmpty())
                        System.out.println(ROSA + "Último paciente: " + RESET + pacientes.last());
                    else
                        System.out.println("No hay pacientes.");
                    break;

                case 6:
                    System.out.print("Ingrese un número de historia clínica: ");
                    int hc = sc.nextInt();
                    sc.nextLine();
                    System.out.println(ROSA + "Pacientes con historia clínica mayor a " + hc + ":" + RESET);
                    pacientes.stream()
                            .filter(pa -> pa.getNumeroHistoriaClinica() > hc)
                            .forEach(System.out::println);
                    break;

                case 7:
                    System.out.println(ROSA + "Saliendo..." + RESET);
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 7);

        sc.close();
    }
}
