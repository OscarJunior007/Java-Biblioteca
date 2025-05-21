
package biblioteca;

//CLASE MODELO DE LOS USUARIOS EN JAVA
public class Usuario {
    private String nombre,documento, perfil ="DEFAULT", contraseña, apellido;
    int id;
   

    public Usuario(String nombre,String apellido, String documento, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;    
        this.documento = documento;
        this.contraseña = contraseña;
        this.perfil = perfil;
      
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public String getDocumento() {
        return documento;
    }

    public String getPerfil() {
        return perfil;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getApellido() {
        return apellido;
    }
    
    

   

    
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    

    
   
    
    
   

  
   
   
    
}
