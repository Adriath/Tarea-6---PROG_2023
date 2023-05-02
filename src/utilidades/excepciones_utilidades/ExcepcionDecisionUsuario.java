
package utilidades.excepciones_utilidades;

/**
 * Excepción que controla la decisión del usuario/a.
 * 
 * @author Adrián Arjona
 */
public class ExcepcionDecisionUsuario extends Exception{
    
    /**
     * Excepción de la clase Utilidades.
     * 
     * @param msj Mensaje al usuario.
     */
    public ExcepcionDecisionUsuario(String msj){
        
        super(msj) ;
    }
}
