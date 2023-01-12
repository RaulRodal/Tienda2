/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author jnieto
 */
public class Medico {
    public static enum TipoMedico {PRIVADO,CONCERTADO,PUBLICO};
    private static int NumMedicos=0;
    private String nombre;
    private String especialidad;
    private TipoMedico tipo;
    private String nif;
    private int cod;

    public Medico(String nombre, String especialidad, TipoMedico tipo, String nif) 
            throws IllegalArgumentException {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.tipo = tipo;
        if (Medico.esValidoNif(nif)) this.nif = nif.trim().toUpperCase();
        else throw new IllegalArgumentException("El nif es incorrecto: ");
        cod=++NumMedicos;
        
    }

    public TipoMedico getTipo() {
        return tipo;
    }

    public int getCod() {
        return cod;
    }

    public String getNombre() {
        return nombre;
    }
    
    
    
    public static boolean esValidoNif(String nif) {
        String sDni;
        boolean correcto;
        int num;
        Character letra;
        Character[] letraDNI = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        char[] aLetraD;

        nif = nif.trim().toUpperCase();
        correcto = (nif.length() == 9);
        if (correcto) {
            sDni = nif.substring(0, 8);
            for (int i = 0; i < 8; i++) {
                if (!Character.isDigit(sDni.charAt(i))) {
                    correcto = false;
                }
            }
            if (correcto) {
                correcto =  nif.charAt(8) == letraDNI[Integer.parseInt(sDni) % 23];
            }
        }
        return correcto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("\ncod= ").append(cod);
        sb.append("\n\tnombre= ").append(nombre);
        sb.append("\n\tespecialidad= ").append(especialidad);
        sb.append("\n\ttipo= ").append(tipo);
        sb.append("\n\tnif= ").append(nif);
        sb.append('\n');
        return sb.toString();
    }
    
    
    
}
