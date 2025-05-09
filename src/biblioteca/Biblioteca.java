package biblioteca;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class Biblioteca {

    Cconexion conexion = new Cconexion();
    ArrayList<String> IsbnLibros;

    Libro libro;
    private ArrayList<Libro> libros;

    Usuario usuario;
    private ArrayList<Usuario> dbUsers;

    public Biblioteca() {

        this.libros = new ArrayList<>();
        this.dbUsers = new ArrayList<>();
        this.libro = new Libro();

    }

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

    public boolean guardarLibro(Libro nuevoLibro) {

        String SQLquery = "CALL guardar_libros(?,?,?,?,?,?)";

        try {

            PreparedStatement ps = conexion.estableceConexcion().prepareStatement(SQLquery);
            
            System.out.println("stock "+nuevoLibro.getStock());
            
            for(int i =0; i<nuevoLibro.getStock(); i++){
                    ps.setString(1, nuevoLibro.getTitulo());
                    ps.setString(2, nuevoLibro.getAutor());
                    ps.setString(3, nuevoLibro.getCategoria());
                    ps.setDate(4, new java.sql.Date(nuevoLibro.getFechaPublicacion().getTime()));
                    ps.setInt(5,i);
                    ps.setString(6,UUID.randomUUID().toString().toUpperCase().substring(0,6));
                    ps.execute();
            }
           
            

            System.out.println("Libro guardado con exito");
            return false;
        } catch (Exception e) {
            System.out.println("Ocurrio un error" + e);
            return false;
        }

    }

    public ArrayList<Libro> obtenerLibros() {
        String SQLquery = "CALL mostrar_libros()";
        libros.clear();

        try (PreparedStatement ps = conexion.estableceConexcion().prepareStatement(SQLquery); ResultSet response = ps.executeQuery()) {

            while (response.next()) {
                Libro libro = new Libro();
                libro.setId(response.getInt("id"));
                libro.setTitulo(response.getString("titulo"));
                libro.setAutor(response.getString("autor"));
                libro.setCategoria(response.getString("categoria"));
                libro.setFechaPublicacion(response.getDate("fecha_publicacion"));
                libro.setStock(response.getInt("stock"));

                libros.add(libro);
            }
        } catch (Exception e) {
            System.out.println("No se pudo traer los libros: " + e.getMessage());
        }
        return libros;
    }

 
    
   public ArrayList obtenerLibroById(int idLibro) {
    String SQLquery = "SELECT ISBN FROM ejemplares WHERE libro_id = ?";
    
    try (PreparedStatement ps = conexion.estableceConexcion().prepareStatement(SQLquery)) {
        ps.setInt(1, idLibro);
        try (ResultSet response = ps.executeQuery()) {
            if (response.next()) {
                IsbnLibros = new ArrayList();
                while (response.next()) {
                IsbnLibros.add(response.getString("ISBN"));
                
                    System.out.println("DATOS: "+IsbnLibros);
             
        }
            }
        }
    } catch (Exception e) {
        System.out.println("No se pudo traer el libro: " + e.getMessage());
    }

                   return IsbnLibros;

}

    
    public boolean guardarUser(Usuario nuevoUsuario) {

        String SQLquery = "CALL llenar_usuarios(?,?,?,?,?)";
        try {

            PreparedStatement ps = conexion.estableceConexcion().prepareStatement(SQLquery);
            ps.setString(1, nuevoUsuario.getNombre());
            ps.setString(2, nuevoUsuario.getApellido());
            ps.setString(3, nuevoUsuario.getDocumento());
            ps.setString(4, nuevoUsuario.getContraseña());
            ps.setInt(5, 3);

            boolean UsuarioaAgregado = ps.execute();

            if (UsuarioaAgregado) {
                System.out.println("El usario no se guardo");
                return true;
            }
            System.out.println("Usuario guardado con exito");
            return false;
        } catch (Exception e) {
            System.out.println("Ocurrio un error" + e);
            return false;
        }
    }

    public boolean usuarioExiste(String documento) {
        boolean existe = false;
        String SQLquery = "CALL verificar_usuario(?)";

        try {
            PreparedStatement ps = conexion.estableceConexcion().prepareStatement(SQLquery);
            ps.setString(1, documento);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                existe = true;
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return existe;
    }
        
    
    public boolean prestarLibro(PrestamoModel prestamo){
        String SQLquery = "INSERT INTO prestamos(documento_usuario,libro_id,id_ejemplar,fecha_prestamo,fecha_devolucion,estado) values (?,?,?,?,?,?)";
        
         try {

            PreparedStatement ps = conexion.estableceConexcion().prepareStatement(SQLquery);
            
       
            
            
       
            ps.setString(1, prestamo.getDocumentoUsuario());
            ps.setInt(2, prestamo.getLibroId());
            ps.setString(3, prestamo.getIdEjemplar());
            ps.setDate(4, new java.sql.Date(prestamo.getFechaPrestamo().getTime()));
            ps.setDate(5,null);
            ps.setString(6,"PRESTADO");
            ps.execute();
            
           
            

            System.out.println("Libro PRESTADO con exito");
            return true;
        } catch (Exception e) {
            System.out.println("Ocurrio un error" + e);
            return false;
        }
        
    }
    /*  public boolean actualizarEstadoDeshabilitado(int idLibro){
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
            

            libros.add(libro); 
        }
    } catch (Exception e) {
        System.out.println("No se pudo traer los libros: " + e.getMessage());
    }
    return libros;
}
     */
}
