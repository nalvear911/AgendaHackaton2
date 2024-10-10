public class Controlador {
    private Agenda agenda;

    public Controlador(Agenda agenda) {
        this.agenda = agenda;
    }

    public void añadirContacto(String nombre, String apellido, String telefono, String grupo) {
        Contacto contacto = new Contacto(nombre, apellido, telefono, grupo);
        agenda.añadirContacto(contacto);
    }

    public void listarContactos() {
        for (Contacto c : agenda.listarContactos()) {
            System.out.println(c);
        }
    }

    public Contacto buscaContacto(String nombre) {
        Contacto contacto = agenda.buscaContacto(nombre);
        if (contacto != null) {
            System.out.println("Contacto encontrado: " + contacto);
        } else {
            System.out.println("Contacto no encontrado.");
        }
        return contacto;
    }

    public void eliminarContacto(String nombre) {
        if (agenda.eliminarContacto(nombre)) {
            System.out.println("Contacto eliminado.");
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    public void modificarContacto(String nombre, String nuevoTelefono) {
        Contacto contacto = agenda.buscaContacto(nombre);
        if (contacto != null) {
            contacto.setTelefono(nuevoTelefono);
            System.out.println("Contacto modificado: " + contacto);
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    public void contarContactos() {
        System.out.println("Total de contactos: " + agenda.contarContactos());
    }

    public void añadirContactoAGrupo(String nombre, String grupo) {
        Contacto contacto = agenda.buscaContacto(nombre);
        if (contacto != null) {
            contacto.setGrupo(grupo);
            System.out.println("Contacto añadido al grupo: " + grupo);
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    public void guardarAgenda(String nombreArchivo) {
        agenda.guardarAgenda(nombreArchivo);
    }

    public void cargarAgenda(String nombreArchivo) {
        agenda.cargarAgenda(nombreArchivo);
    }
}
