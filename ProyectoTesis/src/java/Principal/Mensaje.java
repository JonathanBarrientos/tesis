
package Principal;

import java.sql.Time;
import org.bson.types.ObjectId;

public class Mensaje {
    
    private ObjectId id;
    private String mensaje;
    private String termino;
    private String nombrePaciente;
    private String tiempo;
  

    public Mensaje(ObjectId id, String mensaje, String hora) {
        this.id = id;
        this.mensaje = mensaje;
        this.tiempo = tiempo;
     
    }

    public Mensaje(String mensaje, String termino, String nombrePaciente, String tiempo) {
        this.mensaje = mensaje;
        this.termino = termino;
        this.nombrePaciente = nombrePaciente;
        this.tiempo = tiempo;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    
    

    public String getTermino() {
        return termino;
    }

    public void setTermino(String termino) {
        this.termino = termino;
    }

   
    
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

  
 
    
    
}
