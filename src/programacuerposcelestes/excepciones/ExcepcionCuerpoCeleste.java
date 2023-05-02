
package programacuerposcelestes.excepciones;

/**
 * Excepción personalizada para la clase CuerpoCeleste.
 * 
 * @author Adrián Arjona
 * @version 1.0 Febrero 2023
 */
public class ExcepcionCuerpoCeleste extends Exception{
    
    /* Francisco Adrián Arjona Bravo
        UNIDAD 6: almacenando datos.
    */
    
   /**
    * Excepción para los cuerspos celestes.
    * 
    * @param msj Mensaje al usuario.
    */
    public ExcepcionCuerpoCeleste (String msj){
        
        super(msj) ;
    }
}
