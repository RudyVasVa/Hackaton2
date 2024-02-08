import java.util.HashSet;
import java.util.Set;

public class Agenda {

    Set<Contacto> contactos = new HashSet<>();

    int tamanioAgenda = 10;


    public Set<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(Set<Contacto> contactos) {
        this.contactos = contactos;
    }

    /**
     * metodo para agregar un nuevo contacto
     * @param nuevoContacto
     */
    public void aniadirContacto (Contacto nuevoContacto){
        if (contactos.size() <= tamanioAgenda){
            boolean existeContacto = false;
            for (Contacto contacto : contactos) {
                if (contacto.getNombre().equalsIgnoreCase(nuevoContacto.getNombre()) || contacto.getTelefono() == nuevoContacto.getTelefono()) {
                    existeContacto = true;
                    break;
                }
            }
            if (existeContacto){
                System.out.println("El contacto ya existe en la agenda\n");
            }
            else {
                contactos.add(nuevoContacto);
                System.out.println("El contacto se ha añadido exitosamente.\n");

            }
        }
        else {
            System.out.println("La agenda esta llena y no acepta más contactos\n");
        }

    }

    /**
     * verifica que el contacto existe en la agenda
     * @param nombre
     */
    public void existeContacto(String nombre) {
        boolean existeContacto = false;
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                existeContacto = true;
                break;
            }
        }
        if (existeContacto) {
            System.out.println("El usuario ya existe en la agenda\n");
        } else {
            System.out.println("El contacto no existe en la agenda, puede agregarlo!\n");
        }
    }

    /**
     * Devuelve la lista de contactos existentes
     * @return
     */
    public Set<Contacto> listarContactos(){
        return contactos;
    }

    /**
     * Busca un contacto por nombre y devuelve el numero del contacto
     * @param nombre
     * @return
     */
    public int buscaContacto(String nombre){
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)){
                return contacto.getTelefono();
            }
        }
        return 0;
    }

    /**
     * Elimina un contacto existente por nombre
     * @param nombre
     */
    public void eliminarContacto(String nombre){
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)){
                contactos.remove(contacto);
                System.out.println("Se elimino exitosamente.\n");
            }
            else {
                System.out.println("No se pudo eliminar el contacto, intente otra vez\n");
            }
            break;
        }
    }

    /**
     * Verifica si la lista esta llea
     */
    public void agendaLlena(){
        if (contactos.size() > tamanioAgenda){
            System.out.println("La agenda esta llena\n");
        }
        else {
            System.out.println("Puedes ingresar mas usuarios\n");
        }
    }

    /**
     * Informa al usuario cuantos espacios libres tiene la agenda
     */
    public void espaciosLibres(){
        if (contactos.size() < tamanioAgenda){
            System.out.println("La agenda tiene " + (10-contactos.size()) + " espacios\n");
        }
        else {
            System.out.println("La agenda esta llena\n");
        }
    }

}
