public class Persona {
    private String nombre;
    private int telefono;
    private String dni;
    private String direccion;

    public Persona (String nombre, int telefono, int dni, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.dni = dni;
        this.direccion = direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setDireccion(String direccion) {
        this.dirección = dirección;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public int getDni() {
        return dni;
    }

    public String getDireccion() {
        return dirección;
    }
}
