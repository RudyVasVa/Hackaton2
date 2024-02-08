public class Contacto {

    private String nombre;
    private int telefono;


    public Contacto(String nombre, int telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * Metodo para mostrar informacion del contacto
     * @return
     */
    @Override
    public String toString() {
        return "{ Nombre: " + this.nombre + " , " + "Telefono: " + this.telefono + " }" ;
    }
}