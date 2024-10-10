import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de Agenda ---");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Exportar contactos a CSV");
            System.out.println("6. Importar contactos desde CSV");
            System.out.println("7. Mostrar estado de la agenda");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Ingrese el teléfono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Ingrese el grupo: ");
                    String grupo = scanner.nextLine();
                    Contacto contacto = new Contacto(nombre, apellido, telefono, grupo);
                    agenda.añadirContacto(contacto);
                    break;

                case 2:
                    System.out.println("Lista de contactos:");
                    for (Contacto c : agenda.listarContactos()) {
                        System.out.println(c);
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el nombre del contacto a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    Contacto contactoEncontrado = agenda.buscaContacto(nombreBuscar);
                    if (contactoEncontrado != null) {
                        System.out.println("Contacto encontrado: " + contactoEncontrado);
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el nombre del contacto a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    if (agenda.eliminarContacto(nombreEliminar)) {
                        System.out.println("Contacto eliminado.");
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Ingrese la ruta del archivo para exportar (ejemplo: contactos.csv): ");
                    String archivoExportar = scanner.nextLine();
                    agenda.guardarAgenda(archivoExportar);
                    break;

                case 6:
                    System.out.print("Ingrese la ruta del archivo para importar (ejemplo: contactos.csv): ");
                    String archivoImportar = scanner.nextLine();
                    agenda.cargarAgenda(archivoImportar);
                    break;

                case 7:
                    agenda.mostrarEstadoAgenda(); // Mostrar estado de la agenda
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
