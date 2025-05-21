
package biblioteca;

import java.util.Date;

//CLASE MODELO DE LOS LIBROS PRESTADOS
public class LibroPrestadoModel {
    
    int idLibro;
    private String idEjemplar,titulo,autor,documento;
    private Date fechaPrestamo;
    
    public LibroPrestadoModel() {
    }
    
    
    
    public LibroPrestadoModel(String idEjemplar, String titulo, String autor, String documento, Date fechaPrestamo) {
        this.idEjemplar = idEjemplar;
        this.titulo = titulo;
        this.autor = autor;
        this.documento = documento;
        this.fechaPrestamo = fechaPrestamo;
    }

    public int getIdLibro(){
        return idLibro;
    }
    public String getIdEjemplar() {
        return idEjemplar;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getDocumento() {
        return documento;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setIdEjemplar(String idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
    
    public void setIdLibro(int idLibro){
        this.idLibro = idLibro;
    }
    
}
