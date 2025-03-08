
package biblioteca;


public class Libro {
    private String id;
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private boolean disponible;
    private boolean perdido;
    private boolean daniado;

    public Libro() {
        
    }
    
    public Libro(String id, String titulo, String autor, int anioPublicacion, boolean disponible, boolean perdido, boolean daniado) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.disponible = disponible;
        this.perdido = perdido;
        this.daniado = daniado;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
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

    public void setId(String id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
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
    
//    @Override
//    public String toString() {
//        return "ID: " + id + ", Título: " + titulo + ", Autor: " + autor + ", Año: " + anioPublicacion;
//    }
    
}
