
package biblioteca;

import java.util.Date;

public class Ejemplares {
    private String titulo, autor, ISBN, estado;
    Date fechaPublicacion;

    public Ejemplares() {
    }

    public Ejemplares(String titulo, String autor, String ISBN, String estado, Date fechaPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.estado = estado;
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getEstado() {
        return estado;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
     
    
    
}
