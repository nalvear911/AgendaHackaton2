public class Contacto {
    private String nombre;
    private String apellido;
    private String telefono;
    private String grupo; // Nuevo atributo

    public Contacto(String nombre, String apellido, String telefono, String grupo) {
        if (nombre.isEmpty() || apellido.isEmpty()) {
            throw new IllegalArgumentException("El nombre y apellido no pueden estar vacíos.");
        }
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.grupo = grupo; // Inicializar grupo
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Contacto)) return false;
        Contacto contacto = (Contacto) obj;
        return nombre.equalsIgnoreCase(contacto.nombre) && apellido.equalsIgnoreCase(contacto.apellido);
    }

    @Override
    public int hashCode() {
        return (nombre.toLowerCase() + apellido.toLowerCase()).hashCode();
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " - " + telefono + " [Grupo: " + grupo + "]";
    }
}
