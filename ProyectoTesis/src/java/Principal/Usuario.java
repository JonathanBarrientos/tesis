

package Principal;

import java.util.List;
import org.bson.types.ObjectId;


public class Usuario {
    private ObjectId id;
    private String nombre;
    private int edad;
    private int dni;

    private String NombreUsuario;
    private String contraseña;
    private String tipoUsuario;

    public Usuario(String nombre, int edad,int dni ,String NombreUsuario, String contraseña, String tipoUsuario) {
        this.nombre = nombre;
        this.edad = edad;
        this.NombreUsuario = NombreUsuario;
        this.contraseña = contraseña;
        this.tipoUsuario = tipoUsuario;
        this.dni= dni;
    }

   

    public Usuario(String nombre, int edad, int dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

 
  
    
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }


    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

   
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }


    

    
    
    
}
