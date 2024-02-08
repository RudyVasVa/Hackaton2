// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<Estudiante> estudiantes;

    public Main() {
        estudiantes = new ArrayList<Estudiante>();
    }

    public void registrarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void imprimirPromedios() {
        System.out.println("Promedios de estudiantes:");
        for (int i = 0; i < estudiantes.size(); i++) {
            Estudiante estudiante = estudiantes.get(i);
            double promedio = estudiante.calcularPromedio();
            System.out.println(estudiante.getNombre() + " " + estudiante.getApellido() + ": " + promedio);
        }
    }

    public static void main(String[] args) {
        Main universidad = new Main();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Ingrese el nombre del estudiante (o 'salir' para terminar):");
            String nombre = scanner.nextLine();

            if (nombre.equalsIgnoreCase("salir")) {
                break;
            }

            System.out.println("Ingrese el apellido del estudiante:");
            String apellido = scanner.nextLine();

            Estudiante estudiante = new Estudiante(nombre, apellido);

            boolean continuar = true;

            while (continuar) {
                System.out.println("Ingrese una nota (o -1 para terminar):");
                double nota = scanner.nextDouble();
                scanner.nextLine();

                if (nota == -1) {
                    continuar = false;
                } else {
                    estudiante.agregarNota(nota);
                }
            }

            universidad.registrarEstudiante(estudiante);
        }

        scanner.close();
        universidad.imprimirPromedios();
    }
}

class Estudiante {
    private String nombre;
    private String apellido;
    private ArrayList<Double> notas;

    public Estudiante(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.notas = new ArrayList<Double>();
    }

    public void agregarNota(double nota) {
        notas.add(nota);
    }

    public double calcularPromedio() {
        double suma = 0.0;
        for (int i = 0; i < notas.size(); i++) {
            suma += notas.get(i);
        }
        return suma / notas.size();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}

