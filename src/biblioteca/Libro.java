
package biblioteca;


public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private String fechaPublicacion;
    private int stock;
    private boolean disponible;
    private boolean perdido;
    private boolean daniado;
    private boolean deshabilitado;
    
    public Libro() {
        
    }
    
    public Libro( String titulo, String autor, String fechaPublicacion, int stock, boolean disponible, boolean perdido, boolean daniado,boolean deshabilitado) {
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.disponible = disponible;
        this.perdido = perdido;
        this.daniado = daniado;
        this.deshabilitado = deshabilitado;
        this.stock = stock;
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

    public String getfechaPublicacion() {
        return fechaPublicacion;
    }
    
    public int getStock(){
        return stock;
    }
    public boolean isDisponible() {
        return disponible;
    }

    public boolean isPerdido() {
        return perdido;
    }

    public boolean isDaniado() {
        return daniado;
    }
    
     public boolean isdeshabilitado() {
        return deshabilitado;
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

    public void setfechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    
    public void setStock(int stock){
        this.stock = stock;
    }
    
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setPerdido(boolean perdido) {
        this.perdido = perdido;
    }

    public void setDaniado(boolean daniado) {
        this.daniado = daniado;
    }
    
    public void setdeshabilitado(boolean deshabilitado) {
        this.deshabilitado = deshabilitado;
    }
    
//    @Override
//    public String toString() {
//        return "ID: " + id + ", Título: " + titulo + ", Autor: " + autor + ", Año: " + fechaPublicacion;
//    }
    
}
