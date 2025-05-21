
package biblioteca;

import java.util.Date;

//CLASE MODELO PARA EL REPORTE DEL INVENTARIO GENERAL DE LA BIBLIOTECA
public class reporteInventarioModel {
    private String titulo,autor,categoria,ISBN,estado;
    private Date fechaPublicacion;

    public reporteInventarioModel() {
    }

    public reporteInventarioModel(String titulo, String autor, String categoria, String ISBN, String estado, Date fechaPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
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

    public String getCategoria() {
        return categoria;
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

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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
