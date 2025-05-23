package biblioteca;

import java.util.Date;
//CLASE MODELO DE LOS LIBROS EN GENERAL
public class Libro {

    private int id;
    private String titulo;
    private String autor;
    private String categoria;
    private Date fechaPublicacion;
    private int stock;
    private int vecesPrestado;
    public Libro() {

    }

    public Libro(String titulo, String autor, String categoria, Date FechaPublicacion, int stock) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.fechaPublicacion = FechaPublicacion;
        this.stock = stock;
        
    }

    public int getVecesPrestado() {
        return vecesPrestado;
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

    public int getStock() {
        return stock;
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

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setVecesPrestado(int vecesPrestado) {
        this.vecesPrestado = vecesPrestado;
    }
    
    
    

}
