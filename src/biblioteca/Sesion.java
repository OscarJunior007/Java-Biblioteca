
package biblioteca;

//CLASE MODELO EN LA CUAL EL PROGRAMA NOS INDICA EL USUARIO QUE ESTA USANDO LA APLICACION EN EL MOMENTO
public class Sesion {
    
    static int idUsuario; 

    public Sesion() {
    }

    public static int getIdUsuario() {
        return idUsuario;
    }

    public static void setIdUsuario(int idUsuario) {
        Sesion.idUsuario = idUsuario;
    }

   
    
    
}
