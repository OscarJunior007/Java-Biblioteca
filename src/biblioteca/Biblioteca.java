
package biblioteca;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Biblioteca {
        
      
      Cconexion conexion = new Cconexion();
   
       Libro libro;
      private ArrayList<Libro> libros;
      
      Usuario usuario;
      private ArrayList<Usuario> dbUsers;
      
      

    public Biblioteca() {
    
          this.libros = new ArrayList<>();
          this.dbUsers = new ArrayList<>();
          this.libro =  new Libro();
          
          
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
        
        String SQLquery = "INSERT INTO libros (titulo, autor, fechaPublicacion, stock, disponible, perdido, daniado,deshabilitado) VALUES (?, ?, ?, ?, ?, ?,?,?)";
        
//        System.out.println("Número de libros antes de agregar: " + libros.size());
        
        try{
//            conexion.estableceConexcion();
             PreparedStatement  ps = conexion.estableceConexcion().prepareStatement(SQLquery);
             ps.setString(1, nuevoLibro.getTitulo());
             ps.setString(2,nuevoLibro.getAutor());
             ps.setString(3, nuevoLibro.getfechaPublicacion());
             ps.setInt(4,nuevoLibro.getStock());
             ps.setInt(5,nuevoLibro.isDisponible()?1:0);
             ps.setInt(6,nuevoLibro.isPerdido()?1:0);
             ps.setInt(7,nuevoLibro.isDaniado()?1:0);
             ps.setInt(8,nuevoLibro.isdeshabilitado()?1:0);
             
             
             boolean libroAgregado = ps.execute();
             
             if(libroAgregado){
                 System.out.println("Libro no se guardo");
                 return true;
             }
             System.out.println("Libro guardado con exito");
             return false;
        }catch(Exception e){
            System.out.println("Ocurrio un error"+e);
            return false;
        }
//        



//        for(int i=0; i<libros.size();i++ ){
//            if(libros.get(i).getId().equals(nuevoLibro.getId())){
//                System.out.println("El libro ya existe");
//                return false;
//            }
//        }
//        
//        libros.add(nuevoLibro);
//        System.out.println("Libro registrado con exito!");
//        return true;
      
    }
    
    public void registrarPrestamo(int idLibro) {
     String SQLquery = "INSERT INTO prestamos (fecha_prestamo, idFK_libro, idFk_user) VALUES (NOW(), ?, ?)";
    try {
         PreparedStatement  ps = conexion.estableceConexcion().prepareStatement(SQLquery);
         ps.setInt(1,idLibro);
         ps.setInt(2, Sesion.idUsuario); 
         
         
         ps.execute();
         ps.close();
         
                  
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    
    public  boolean guardarUser(Usuario nuevoUsuario){
        
        String SQLquery = "INSERT INTO users  (nombre, apellido, documento, contrasena, idFK_rol) VALUES (?, ?, ?, ?, ?)";
        

        
        try{
            
             PreparedStatement  ps = conexion.estableceConexcion().prepareStatement(SQLquery);
             
             ps.setString(1, nuevoUsuario.getNombre());
             ps.setString(2, nuevoUsuario.getApellido());
             ps.setString(3, nuevoUsuario.getDocumento());
             ps.setString(4, nuevoUsuario.getContraseña());
             ps.setInt(5,2);
              
             boolean UsuarioaAgregado = ps.execute();
             
             if(UsuarioaAgregado){
                 System.out.println("El usario no se guardo");
                 return true;
             }
             System.out.println("Usuario guardado con exito");
             return false;
        }catch(Exception e){
            System.out.println("Ocurrio un error"+e);
            return false;
        }
    }
    
    public boolean usuarioExiste(String documento) {
    boolean existe = false;
    String SQLquery = "SELECT * FROM users WHERE documento = ?";
    try {
        PreparedStatement  ps = conexion.estableceConexcion().prepareStatement(SQLquery);
        ps.setString(1, documento);
       

        
    } catch (Exception e) {
        e.printStackTrace();
    }
    return existe;
}
    
    
    
    public boolean actualizarEstadoDeshabilitado(int idLibro){
        String SQLquery = "UPDATE libros SET deshabilitado = ? WHERE id = ?";
        
        try {
        PreparedStatement ps = conexion.estableceConexcion().prepareStatement(SQLquery);
        ps.setInt(1,1);
        ps.setInt(2, idLibro);

        int filasAfectadas = ps.executeUpdate();
        
        if (filasAfectadas > 0) {
            System.out.println("Estado 'deshabilitado' actualizado con éxito");
            return true;
        } else {
            System.out.println("No se encontró el libro para actualizar");
            return false;
        }
    } catch (Exception e) {
        System.out.println("Ocurrió un error al actualizar el estado: " + e);
        return false;
    }
        
    }
    
    
     public boolean actualizarEstadoDeshabilitadoFalse(int idLibro){
        String SQLquery = "UPDATE libros SET deshabilitado = ? WHERE id = ?";
        
        try {
        PreparedStatement ps = conexion.estableceConexcion().prepareStatement(SQLquery);
        ps.setInt(1,0);
        ps.setInt(2, idLibro);

        int filasAfectadas = ps.executeUpdate();
        
        if (filasAfectadas > 0) {
            System.out.println("Estado 'deshabilitado' actualizado con éxito");
            return true;
        } else {
            System.out.println("No se encontró el libro para actualizar");
            return false;
        }
    } catch (Exception e) {
        System.out.println("Ocurrió un error al actualizar el estado: " + e);
        return false;
    }
        
    }
    
    
  
    
    
    
  
//    public boolean eliminarLibro(String id){
//        String SQLquery = "";
//    }
    
    
    
    
   public ArrayList<Libro> obtenerLibros() {
    String SQLquery = "SELECT * FROM libros where deshabilitado != 1";
    libros.clear(); 
    
    try (PreparedStatement ps = conexion.estableceConexcion().prepareStatement(SQLquery);
         ResultSet response = ps.executeQuery()) {

        while (response.next()) {
            Libro libro = new Libro(); 
            libro.setId(response.getInt("id"));
            libro.setTitulo(response.getString("titulo"));
            libro.setAutor(response.getString("autor"));
            libro.setfechaPublicacion(response.getString("fechaPublicacion"));
            libro.setStock(response.getInt("stock"));
            libro.setDisponible(response.getBoolean("disponible"));
            libro.setPerdido(response.getBoolean("perdido"));
            libro.setDaniado(response.getBoolean("daniado"));
            libro.setdeshabilitado(response.getBoolean("deshabilitado"));

            libros.add(libro); 
        }
    } catch (Exception e) {
        System.out.println("No se pudo traer los libros: " + e.getMessage());
    }
    return libros;
}
   
   public ArrayList<Libro> obtenerLibrosDeshabilitados() {
    String SQLquery = "SELECT * FROM libros where deshabilitado = 1";
    libros.clear(); 
    
    try (PreparedStatement ps = conexion.estableceConexcion().prepareStatement(SQLquery);
         ResultSet response = ps.executeQuery()) {

        while (response.next()) {
            Libro libro = new Libro(); 
            libro.setId(response.getInt("id"));
            libro.setTitulo(response.getString("titulo"));
            libro.setAutor(response.getString("autor"));
            libro.setfechaPublicacion(response.getString("fechaPublicacion"));
            libro.setDisponible(response.getBoolean("disponible"));
            libro.setPerdido(response.getBoolean("perdido"));
            libro.setDaniado(response.getBoolean("daniado"));
            libro.setdeshabilitado(response.getBoolean("deshabilitado"));

            libros.add(libro); 
        }
    } catch (Exception e) {
        System.out.println("No se pudo traer los libros: " + e.getMessage());
    }
    return libros;
}
   
 

   
}

      





