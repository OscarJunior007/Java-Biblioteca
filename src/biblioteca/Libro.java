
package biblioteca;

import java.util.Date;


public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private String categoria;
    private Date fechaPublicacion;
    
    
    public Libro() {
        
    }
    
    public Libro( String titulo, String autor, String categoria,Date FechaPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria=categoria;
        this.fechaPublicacion = fechaPublicacion;
      
        
    }
    
 

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }
 
    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

   
    
}
