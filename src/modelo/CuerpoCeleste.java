
package modelo;

import java.io.Serializable;

/**
 *
 * @author Adrián Arjona
 * @version 1.0 Febrero 2023
 */
public class CuerpoCeleste implements Serializable{
    
    /* Francisco Adrián Arjona Bravo
        UNIDAD 6: almacenando datos.
    */
    
    // DECLARACIÓN DE VARIABLES
    
    private short codigoCuerpo ;
    private String nombre ;
    private String tipoObjeto ;
    private int diametro ;

    
    // CONSTRUCTORES
    
    public CuerpoCeleste() {
        codigoCuerpo = 0 ;
        nombre = "" ;
        tipoObjeto = "" ;
        diametro = 0 ;
    }
    
    public CuerpoCeleste(short codigoCuerpo, String nombre, String tipoObjeto, int diametro) {
        this.codigoCuerpo = codigoCuerpo;
        this.nombre = nombre;
        this.tipoObjeto = tipoObjeto;
        this.diametro = diametro;
    }
    
    
    // GETTERS & SETTERS
    

    public int getDiametro() {
        return diametro;
    }

    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoObjeto() {
        return tipoObjeto;
    }

    public void setTipoObjeto(String tipoObjeto) {
        this.tipoObjeto = tipoObjeto;
    }

    public short getCodigoCuerpo() {
        return codigoCuerpo;
    }

    public void setCodigoCuerpo(short codigoCuerpo) {
        this.codigoCuerpo = codigoCuerpo;
    }

    @Override
    public String toString() {
        return "CuerpoCeleste{" + "codigoCuerpo=" + codigoCuerpo + ", nombre=" + nombre + ", tipoObjeto=" + tipoObjeto + ", diametro=" + diametro + '}';
    }
    
    // MÉTODO TO STRING
    
    public static void main(String[] args) {
        CuerpoCeleste ejemplo = new CuerpoCeleste() ;
        
        System.out.println(ejemplo.toString());
    }
    
}
