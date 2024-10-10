import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Agenda {
    private List<Contacto> contactos;
    private final int capacidadMaxima = 50; // Límite de contactos

    public Agenda() {
        this.contactos = new ArrayList<>();
    }

    public boolean añadirContacto(Contacto c) {
        if (agendaLlena()) {
            System.out.println("La agenda está llena. No se puede añadir más contactos.");
            return false;
        }
        if (existeContacto(c)) {
            System.out.println("El contacto ya existe.");
            return false;
        }
        contactos.add(c);

        // Advertencia si se llega al 80% de la capacidad
        if (contactos.size() >= 0.8 * capacidadMaxima) {
            System.out.println("Advertencia: La agenda está al 80% de su capacidad.");
        }

        return true;
    }

    public boolean existeContacto(Contacto c) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(c.getNombre()) &&
                    contacto.getApellido().equalsIgnoreCase(c.getApellido())) {
                return true; // Considera nombre y apellido para verificar duplicados
            }
        }
        return false;
    }

    public boolean agendaLlena() {
        return contactos.size() >= capacidadMaxima;
    }

    public List<Contacto> listarContactos() {
        Collections.sort(contactos, Comparator.comparing(Contacto::getNombre));
        return contactos;
    }

    public Contacto buscaContacto(String nombre) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }

    public boolean eliminarContacto(String nombre) {
        Contacto contacto = buscaContacto(nombre);
        if (contacto != null) {
            contactos.remove(contacto);
            return true;
        }
        return false;
    }

    public int contarContactos() {
        return contactos.size();
    }

    public void guardarAgenda(String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Contacto c : contactos) {
                writer.write(c.getNombre() + "," + c.getApellido() + "," + c.getTelefono() + "," + c.getGrupo());
                writer.newLine();
            }
            System.out.println("Agenda guardada correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar la agenda: " + e.getMessage());
        }
    }
    public List<Contacto> listarContactosPorGrupo(String grupo) {
        List<Contacto> contactosFiltrados = new ArrayList<>();
        for (Contacto c : contactos) {
            if (c.getGrupo().equalsIgnoreCase(grupo)) {
                contactosFiltrados.add(c);
            }
        }
        return contactosFiltrados;
    }

    public void cargarAgenda(String nombreArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 4) {
                    Contacto contacto = new Contacto(partes[0], partes[1], partes[2], partes[3]);
                    añadirContacto(contacto); // Añade el contacto, verificando si ya existe
                }
            }
            System.out.println("Agenda cargada correctamente.");
        } catch (IOException e) {
            System.out.println("Error al cargar la agenda: " + e.getMessage());
        }
    }
}
