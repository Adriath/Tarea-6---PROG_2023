
package programacuerposcelestes;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import modelo.CuerpoCeleste;
import utilidades.Utilidades;

/**
 *
 * @author Adrián Arjona
 */
public class LanzadorCuerpoCeleste {
    
    /* Francisco Adrián Arjona Bravo
    UNIDAD 6: almacenando datos.
    */

//    static BufferedReader dato = new BufferedReader(new InputStreamReader(System.in)) ;
//    private static File fichero = new File("sistemasolar.dat") ;
//    private static List<CuerpoCeleste> cuerposCelestes = new ArrayList<>() ;
    
    
    public static void main(String[] args) {
        int mensajePrueba = Utilidades.leerEnteroBuffer("Introduce un númeor:") ;
        System.out.println(mensajePrueba);
    }
}
