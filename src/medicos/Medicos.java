/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package medicos;

import Clases.Clinica;
import static Clases.Lectura.*;
import Clases.Medico;
import Clases.Medico.TipoMedico;
import java.util.Scanner;

/**
 *
 * @author jnieto
 */
public class Medicos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Medico m;
        Clinica c;
        int op;

        //m=leeMedico(scan);
        //System.out.println(m);
        c = new Clinica("Carballeira", "Plaza de la Legion");
/*
        do {
            op = menuPrincipal(scan);
            switch (op) {
                case 1://listar medicos
                    System.out.println(c.getMedicos());
                    break;

                case 2://insertar medicos
                    if (c.hayEspacio()) {
                        c.insertaMedico(leeMedico(scan));
                    } else {
                        System.out.println("No hay mas espacio");
                    }
                    break;

                case 3://Buscar medico por codigo medico
                    int cod;
                    cod = leeEntero(scan, "Introduce codigo a buscar");
                    if (c.buscarCod(cod) >= 0) {
                        System.out.println(c.getMedico(c.buscarCod(cod)));
                    }
                    break;
        
                case 4://Buscar medico por nombre medico
                    String nombre;
                    nombre = scan.nextLine();
                    if (c.buscarNombre(nombre) >= 0) {
                        System.out.println(c.getMedico(c.buscarNombre(nombre)));
                    }
                    break;
        
                case 5:
                    int codE;
                    codE = leeEntero(scan, "Introduce codigo de medico a eliminar");
                    c.eliminaPos(codE);
                    break;
            }
        
            System.out.println("\n Pulse una tecla para continuar: ");
            scan.nextLine();
        } while (op != ULT);
*/
        //c.insertaMedico(m);
        System.out.println(c);
    }

}
