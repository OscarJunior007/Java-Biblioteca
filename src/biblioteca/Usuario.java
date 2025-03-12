/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

import java.util.ArrayList;
import java.util.List;


public class Usuario {
    private String nombre,id,documento, perfil ="DEFAULT";
    
   

    public Usuario(String nombre, String id, String documento, String perfil) {
        this.nombre = nombre;
        this.id = id;
        this.documento = documento;
        this.perfil = perfil;
      
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public String getDocumento() {
        return documento;
    }

    public String getPerfil() {
        return perfil;
    }

   

    
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    
   
    
    
   

  
   
   
    
}
