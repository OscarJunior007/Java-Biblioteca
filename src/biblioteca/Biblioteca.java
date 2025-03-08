
package biblioteca;

import java.util.ArrayList;

public class Biblioteca {
    
      
      private ArrayList<Libro> libros;
      
      private ArrayList<Usuario> dbUsers;

    public Biblioteca() {
    
          this.libros = new ArrayList<>();
          this.dbUsers = new ArrayList<>();
    }
      
    
//    public Biblioteca(ArrayList<Libro> libros, ArrayList<Usuario> dbUsers) {
//        this.libros = new ArrayList<>();
//        this.dbUsers = new ArrayList<>();
//    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public ArrayList<Usuario> getDbUsers() {
        return dbUsers;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public void setDbUsers(ArrayList<Usuario> dbUsers) {
        this.dbUsers = dbUsers;
    }
    
    
    
    public  boolean guardarLibro(Libro nuevoLibro){
        

        
        System.out.println("Número de libros antes de agregar: " + libros.size());
        
        for(int i=0; i<libros.size();i++ ){
            if(libros.get(i).getId().equals(nuevoLibro.getId())){
                System.out.println("El libro ya existe");
                return false;
            }
        }
        
        libros.add(nuevoLibro);
        System.out.println("Libro registrado con exito!");
        return true;
    }
    
    
    public boolean eliminarLibro(String id){
        System.out.println("Número de libros antes de eliminar: " + libros.size());
        
        for(int i=0; i<libros.size();i++ ){
            if(libros.get(i).getId().equals(id)){
                System.out.println("Libro Encontrado.");
                libros.remove(libros.get(i));
                System.out.println("Libro Eliminado.");
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Libro> listarLibros(){
        return libros;
    }
      
}


