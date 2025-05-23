package biblioteca;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class Biblioteca {
//EN ESTA CLASE ESTAN LA GRAN MAYORIA DE LOS METODOS PARA TOMAR E INSERTAR DATOS DE LA BASE DE DATOS

    Cconexion conexion = new Cconexion();
    ArrayList<String> IsbnLibros;
    ArrayList<PrestamoModel> prestamo;
    Libro libro;
    private ArrayList<Libro> libros;
    private ArrayList<reporteInventarioModel> librosInventario;
    private ArrayList<LibroPrestadoModel> libroPrestado;
    Usuario usuario;
    private ArrayList<Usuario> dbUsers;
    private ArrayList<Ejemplares> ejemplares;

    public Biblioteca() {

        this.libros = new ArrayList<>();
        this.dbUsers = new ArrayList<>();
        this.libro = new Libro();
        this.libroPrestado = new ArrayList<>();
        this.prestamo = new ArrayList<>();
        this.librosInventario = new ArrayList<>();
        this.ejemplares = new ArrayList<>();

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

    //AQUI GUARDAMOS LOS LIBROS INGRESADOS DIRECTAMENTE A LA BASE DE DATOS
    public boolean guardarLibro(Libro nuevoLibro) {

        String SQLquery = "CALL guardar_libros(?,?,?,?,?,?)";

        try {

            PreparedStatement ps = conexion.estableceConexcion().prepareStatement(SQLquery);

            System.out.println("stock " + nuevoLibro.getStock());

            for (int i = 0; i < nuevoLibro.getStock(); i++) {
                ps.setString(1, nuevoLibro.getTitulo());
                ps.setString(2, nuevoLibro.getAutor());
                ps.setString(3, nuevoLibro.getCategoria());
                ps.setDate(4, new java.sql.Date(nuevoLibro.getFechaPublicacion().getTime()));
                ps.setInt(5, i);
                ps.setString(6, UUID.randomUUID().toString().toUpperCase().substring(0, 6));
                ps.execute();
            }

            System.out.println("Libro guardado con exito");
            return false;
        } catch (Exception e) {
            System.out.println("Ocurrio un error" + e);
            return false;
        }

    }

    //VERIFICAR SI EL ISBN DE UN LIBRO EXISTE BIEN SEA PARA REALIZAR UN PRESTAMO A UNA DEVOLUCION
    public int verificarExistencia(String isbn) {
        String SQLquery = "SELECT existe_isbn(?);";
        int existe = 0;
        try (PreparedStatement ps = conexion.estableceConexcion().prepareStatement(SQLquery)) {
            ps.setString(1, isbn);

            try (ResultSet response = ps.executeQuery()) {
                if (response.next()) {
                    existe = response.getInt(1);
                }
            }
        } catch (Exception e) {
            System.out.println("No se pudo traer los libros: " + e.getMessage());
        }
        return existe;
    }
    //LOGICA PARA REALIZAR LA DEVOLUCION DE UN LIBRO PRESTADO POR UN USUARIO

    public boolean deVolverLibro(DevolucionModel model) {
        String SQLquery = "CALL actualizar_estado_ejemplar(?,?,?)";
        try {

            PreparedStatement ps = conexion.estableceConexcion().prepareStatement(SQLquery);
            ps.setString(1, model.getIsbn());
            ps.setDate(2, new java.sql.Date(model.getFechaDevolucion().getTime()));
            ps.setString(3, model.getDocumentoUsuario());
            System.out.println("Ejecutando procedimiento con parámetros:");
            System.out.println("ISBN: " + model.getIsbn());
            System.out.println("Fecha Devolución: " + new java.sql.Date(model.getFechaDevolucion().getTime()));
            System.out.println("Documento Usuario: " + model.getDocumentoUsuario());

            ps.execute();
            System.out.println("Estado editado con exito");
            return true;
        } catch (Exception e) {
            System.out.println("Ocurrio un   error" + e);
            return false;
        }

    }
    //LOGICA PARA OBTENER LOS REPORTES DE LOS PRESTAMO

    public ArrayList<PrestamoModel> reporteTablePrestamos() {
        String SQLquery = "CALL select_table_prestamo()";

        try (PreparedStatement ps = conexion.estableceConexcion().prepareStatement(SQLquery); ResultSet response = ps.executeQuery()) {

            while (response.next()) {
                PrestamoModel modelo = new PrestamoModel();
                modelo.setDocumentoUsuario(response.getString("documento_usuario"));
                modelo.setLibroId(response.getInt("libro_id"));
                modelo.setIdEjemplar(response.getString("id_ejemplar"));
                modelo.setFechaPrestamo(response.getDate("fecha_prestamo"));
                modelo.setFechaDevolucion(response.getDate("fecha_devolucion"));
                modelo.setEstado(response.getString("estado"));

                prestamo.add(modelo);
            }
        } catch (Exception e) {
            System.out.println("No se pudo traer los libros: " + e.getMessage());
        }

        return prestamo;

    }
    //LOGICA PARA OBTENER EL REPORTE DE LOS LIBROS MAS PRESTADOS

    public ArrayList<LibroPrestadoModel> obtenerLibrosPrestados(String documento) {
        String SQLquery = "CALL libros_prestados_by_user(?)";

        try (PreparedStatement ps = conexion.estableceConexcion().prepareStatement(SQLquery)) {
            ps.setString(1, documento);

            try (ResultSet response = ps.executeQuery()) {
                while (response.next()) {
                    LibroPrestadoModel modelo = new LibroPrestadoModel();
                    modelo.setIdLibro(response.getInt("libro_id"));
                    modelo.setIdEjemplar(response.getString("id_ejemplar"));
                    modelo.setTitulo(response.getString("titulo"));
                    modelo.setAutor(response.getString("autor"));
                    modelo.setDocumento(response.getString("documento"));
                    modelo.setFechaPrestamo(response.getDate("fecha_prestamo"));
                    libroPrestado.add(modelo);
                }
            }
        } catch (Exception e) {
            System.out.println("No se pudo traer los libros: " + e.getMessage());
        }
        System.out.println("libros: " + libroPrestado);

        return libroPrestado;
    }
//LOGICA PARA OBTENER LOS LIBROS MAS PRESTADOS Y MOSTRARLO EN UN REPORTE

    public ArrayList<Libro> librosMasPrestados() {
        String SQLquery = "CALL libros_mas_prestados()";
        libros.clear();

        try (PreparedStatement ps = conexion.estableceConexcion().prepareStatement(SQLquery); ResultSet response = ps.executeQuery()) {

            while (response.next()) {
                Libro libro = new Libro();
                libro.setId(response.getInt("id"));
                libro.setTitulo(response.getString("titulo"));
                libro.setVecesPrestado(response.getInt("total_prestamos"));

                libros.add(libro);
            }
        } catch (Exception e) {
            System.out.println("No se pudo traer los libros: " + e.getMessage());
        }
        return libros;

    }

    //OBTENEMOS LOS DATOS DE TODOS LOS LIRBOS EN LA BASE DE DATOS PARA MOSTRARLO EN UN REPORTE DE INVENTARIO COMPLETO
    public ArrayList<reporteInventarioModel> reporteInventario() {
        String SQLquery = "call reporte_inventario() ";
        librosInventario.clear();
        try (PreparedStatement ps = conexion.estableceConexcion().prepareStatement(SQLquery); ResultSet response = ps.executeQuery()) {

            while (response.next()) {
                reporteInventarioModel libro = new reporteInventarioModel();

                libro.setTitulo(response.getString("titulo"));
                libro.setAutor(response.getString("autor"));
                libro.setCategoria(response.getString("categoria"));
                libro.setFechaPublicacion(response.getDate("fecha_publicacion"));
                libro.setISBN(response.getString("ISBN"));
                libro.setEstado(response.getString("estado"));
                librosInventario.add(libro);
            }
        } catch (Exception e) {
            System.out.println("No se pudo traer los libros: " + e.getMessage());
        }
        return librosInventario;

    }
//OBTENER LOS LIBROS PARA MOSTRARLOS

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
//OBTENEMOS LOS LIBROS POR SU ID UNICO PARA DIFERENCIAR EL LIBRO A PRESTAR O A DEVOLVER

    public ArrayList<String> obtenerLibroById(int idLibro) {
        ArrayList<String> IsbnLibros = new ArrayList<>();
        libroPrestado.clear();
        String SQLquery = "{CALL mostrar_ejemplares_disponibles_por_libro(?)}";

        try (CallableStatement cs = conexion.estableceConexcion().prepareCall(SQLquery)) {
            cs.setInt(1, idLibro);
            try (ResultSet response = cs.executeQuery()) {
                while (response.next()) {
                    IsbnLibros.add(response.getString("ISBN"));
                }
            }
        } catch (Exception e) {
            System.out.println("No se pudo traer el libro: " + e.getMessage());
        }

        return IsbnLibros;
    }
    //GUARDAMOS LOS USUARIOS QUE SE REGISTRAN EN LA BIBLIOTECA

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
//AQUI VERIFICAMOS LA EXISTENCIA DE LOS USUARIOS PARA VALIDAR SU INGRESO

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
    //REALIZMOS LA LOGICA PARA QUE EL USUARIO PUEDA PRESTAR UN LIBRO

    public boolean prestarLibro(PrestamoModel prestamo) {
        String SQLquery = "{CALL registrar_prestamo(?,?,?,?,?,?)}";

        try (CallableStatement cs = conexion.estableceConexcion().prepareCall(SQLquery)) {

            cs.setString(1, prestamo.getDocumentoUsuario());
            cs.setInt(2, prestamo.getLibroId());
            cs.setString(3, prestamo.getIdEjemplar());
            cs.setDate(4, new java.sql.Date(prestamo.getFechaPrestamo().getTime()));
            cs.setDate(5, null); // o puedes poner una fecha estimada
            cs.setString(6, "PRESTADO");
            cs.execute();

            System.out.println("Libro PRESTADO con éxito");
            return true;
        } catch (SQLException e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            return false;
        }
    }
  //OBTENEMOS LOS EJEMPLARES JUNTO CON SU ESTADO
    public ArrayList<Ejemplares> obtenerEstadoLibros() {
        String SQLquery = "{CALL llamar_ejemplares_por_titulo()}";
        ArrayList<Ejemplares> listaEjemplares = new ArrayList<>();

        try (PreparedStatement ps = conexion.estableceConexcion().prepareStatement(SQLquery); ResultSet response = ps.executeQuery()) {

            while (response.next()) {
                Ejemplares ejemplar = new Ejemplares();

                ejemplar.setTitulo(response.getString("titulo"));
                ejemplar.setAutor(response.getString("autor"));
                ejemplar.setFechaPublicacion(response.getDate("fecha_publicacion"));
                ejemplar.setISBN(response.getString("ISBN"));
                ejemplar.setEstado(response.getString("estado"));

                listaEjemplares.add(ejemplar);
            }

        } catch (Exception e) {
            System.out.println("No se pudo traer los ejemplares: " + e.getMessage());
        }

        return listaEjemplares;
    }
//ACTUALIZAMOS EL ESTADP DEÑ EJEMPLAR A DESHABILITADO
    public boolean actualizarEstadoDeshabilitado(String ISBN) {
        String SQLquery = "CALL deshabilitar_ejemplar_por_isbn(?)";
        
        try {
            PreparedStatement ps = conexion.estableceConexcion().prepareStatement(SQLquery);
            ps.setString(1, ISBN); // Parámetro correcto

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Estado 'deshabilitado' actualizado con éxito");
                return true;
            } else {
                System.out.println("No se encontró el ejemplar para actualizar");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error al actualizar el estado: " + e.getMessage());
            return false;
        }
    }
 //ACTUALIZAMOS EL ESTADP DEÑ EJEMPLAR A DISPONIBLE
    public boolean actualizarEstadoDisponible(String ISBN) {
        String SQLquery = "{CALL habilitar_ejemplar_por_isbn(?)}";

        try (CallableStatement cs = conexion.estableceConexcion().prepareCall(SQLquery)) {
            cs.setString(1, ISBN);
            int filasAfectadas = cs.executeUpdate();

            return filasAfectadas > 0;
        } catch (Exception e) {
            System.out.println("Error al actualizar estado a disponible: " + e.getMessage());
            return false;
        }
    }
//ACTUALIZAMOS EL ESTADP DEÑ EJEMPLAR A DAÑADO
    public boolean actualizarEstadoDaniado(String ISBN) {
        String SQLquery = "{CALL daniar_ejemplar_por_isbn(?)}";

        try (CallableStatement cs = conexion.estableceConexcion().prepareCall(SQLquery)) {
            cs.setString(1, ISBN);
            int filasAfectadas = cs.executeUpdate();

            return filasAfectadas > 0;
        } catch (Exception e) {
            System.out.println("Error al actualizar estado a dañado: " + e.getMessage());
            return false;
        }
    }

}
