
package Principal;

import org.bson.types.ObjectId;


public class Termino {
    
    private ObjectId id;
    private String termino;
    private String Significado;
    private String categoriaDolor;
    private String categoriaTiempo;

    public Termino(String termino, String Significado) {
        this.termino = termino;
        this.Significado = Significado;
    }

    public Termino(String termino, String Significado, String categoriaDolor, String categoriaTiempo) {
        this.termino = termino;
        this.Significado = Significado;
        this.categoriaDolor = categoriaDolor;
        this.categoriaTiempo = categoriaTiempo;
    }

    

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTermino() {
        return termino;
    }

    public void setTermino(String termino) {
        this.termino = termino;
    }

    public String getSignificado() {
        return Significado;
    }

    public void setSignificado(String Significado) {
        this.Significado = Significado;
    }

    public String getCategoriaDolor() {
        return categoriaDolor;
    }

    public void setCategoriaDolor(String categoriaDolor) {
        this.categoriaDolor = categoriaDolor;
    }

    public String getCategoriaTiempo() {
        return categoriaTiempo;
    }

    public void setCategoriaTiempo(String categoriaTiempo) {
        this.categoriaTiempo = categoriaTiempo;
    }
    
    
    
}
