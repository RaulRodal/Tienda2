/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import Clases.Medico.TipoMedico;
/**
 *
 * @author jnieto
 */
public class Clinica {

    private String nombre;
    private String direccion;
    private Medico[] medicos;
    private static final int MAX = 100;
    private int libre;

    public Clinica(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        medicos = new Medico[MAX];
        libre = 0;
    }

    public int getContratosRestantes() {
        return (MAX - libre);
    }

    public boolean hayMedicos() {
        return (libre > 0);
    }

    public boolean hayEspacio() {
        return (!estaLlena());
    }

    public boolean estaVacia() {
        return (libre == 0);
    }

    public boolean estaLlena() {
        return (libre == MAX);
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que devuelve el objeto de tipo medico que esta en la posicion que
     * se le pasa como parametro
     *
     * @param pos
     * @return
     */
    public Medico getMedico(int pos) {
        Medico ret;
        ret = null;

        if (pos >= 0 && pos < libre) {
            ret = medicos[pos];
        }
        return ret;
    }

    public int buscarCod(int cod) {
        int ret = -1;
        int cont = 0;
        while (cod >= 0 && cod < libre) {
            if (getMedico(cont).getCod() == cod) {
                ret = cont;
            }
            cont++;
        }
        return ret;
    }

    public int buscarNombre(String nombre) {
        int ret = -1;
        for (int i = 0; i < libre; i++) {
            if (nombre.compareToIgnoreCase(medicos[i].getNombre()) == 0) {
                ret = i;
            }
        }
        return ret;
    }

    public void eliminaPos(int cod) {
        int pos = buscarCod(cod);
        medicos[pos] = medicos[libre - 1];
        libre--;
    }

    public String getMedicos() {
        StringBuilder ret = new StringBuilder();

        if (hayMedicos()) {
            for (int i = 0; i < libre; i++) {
                ret.append(medicos[i]);
            }
        } else {
            ret.append("No hay personal medico dado de alta por el momento");
        }

        return ret.toString();
    }
    
    public String getMedicosPriv() {
        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < libre; i++) {
            if (medicos[i].getTipo()==TipoMedico.PRIVADO) {
                ret.append(medicos[i]);
            }
        }
        if (estaVacia()) ret.append("No hay medicos en la clinica");
        else if (ret.isEmpty()) ret.append("No hay medicos privados");
        
            return ret.toString();
    }

    public void insertaMedico(Medico m) throws ArrayIndexOutOfBoundsException {
        if (hayEspacio()) {
            medicos[libre] = m;
            ++libre;
        } else {
            throw new ArrayIndexOutOfBoundsException("Se han sobrepasado la capacidad de contratación.");
        }
    }

    @Override
    public String toString() {
        return "Clinica: " + "nombre=" + nombre + ", direccion=" + direccion
                + "\nCuadro Médico " + getMedicos();
    }

}
