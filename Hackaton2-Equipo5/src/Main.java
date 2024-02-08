import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Agenda agenda = new Agenda();

        Contacto contacto = new Contacto("Rudy", 12345055);
        Contacto contacto2 = new Contacto("Liz", 54321006);
        Contacto contacto3 = new Contacto("Xime",1445263);

        agenda.aniadirContacto(contacto);
        agenda.aniadirContacto(contacto2);
        agenda.aniadirContacto(contacto3);

        Scanner scanner = new Scanner(System.in);

        boolean ciclo = true;

        while (ciclo) {
            System.out.println("---------- Bienvenido a la agenda telefonica del grupo 5 ----------");
            System.out.println("\nPor favor ingresa una de las siguientes opciones: \n 1. Añadir contacto \n 2. verificar que el contacto existe \n 3. lista de contactos \n 4. buscar contacto y mostrar su telefono \n 5. Eliminar contacto \n 6. verificar si la agenda esta llena \n 7. Espacios disponibles en la agenda \n 8. salir \n");
            System.out.print("-------------------------------------------------------------------\n");
            int opcUsuario = scanner.nextInt();
            scanner.nextLine();

            switch (opcUsuario) {
                case 1 -> {
                    System.out.println("Ingrese el nombre del nuevo contacto");
                    String nombreUsuario = scanner.next();
                    System.out.println("Ingrese el telefono del nuevo contacto");
                    int numeroUsuario = scanner.nextInt();
                    agenda.aniadirContacto(new Contacto(nombreUsuario, numeroUsuario));
                }
                case 2 -> {
                    System.out.println("Por favor ingrese el nombre del contacto que quiere verificar");
                    String nombreaBuscar = scanner.next();
                    agenda.existeContacto(nombreaBuscar);
                }
                case 3 -> System.out.println(agenda.listarContactos() + "\n");
                case 4 -> {
                    System.out.println("Ingrese el nombre del contacto que quiere buscar");
                    String nombreBuscarTelefono = scanner.next();
                    System.out.println("El numero de contacto " + nombreBuscarTelefono + " es: " + agenda.buscaContacto(nombreBuscarTelefono) + "\n");
                }
                case 5 -> {
                    System.out.println("Ingrese el nombre del contacto a eliminar");
                    String nombreEliminar = scanner.next();
                    agenda.eliminarContacto(nombreEliminar);
                }
                case 6 -> agenda.agendaLlena();
                case 7 -> agenda.espaciosLibres();
                case 8 -> ciclo = false;
                default -> System.out.println("La opción no es válida");
            }
        }
    }
}