package tienda.Clases;

/**
 *
 * @author damdu112
 */
public class Productos {
        public static enum Categoria {
        ORDENADOR, TELEFONOS, LAVADORAS, FRIGORIFICOS, COCINAS, TELEVISIONES 
    };
    
    private String nombre;
    private String numSerie;
    private String marca;
    

    public Productos(String nombre, String numSerie, String marca) {
        this.nombre = nombre;
        this.numSerie = numSerie;
        this.marca = marca;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Productos{");
        sb.append("nombre=").append(nombre);
        sb.append(", numSerie=").append(numSerie);
        sb.append(", marca=").append(marca);
        sb.append('}');
        return sb.toString();
    }
    
}
