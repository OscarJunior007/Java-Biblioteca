/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

import java.util.Date;

public class PrestamoModel {
    private int libroId;
    private String idEjemplar,documentoUsuario,estado;
    private Date fechaPrestamo, fechaDevolucion;
   
    public PrestamoModel() {
    }

    public PrestamoModel(String documentoUsuario,int libroId, String idEjemplar, Date fechaPrestamo, Date fechaDevolucion) {
        this.documentoUsuario = documentoUsuario;
        this.libroId = libroId;
        this.idEjemplar = idEjemplar;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

   

    public int getLibroId() {
        return libroId;
    }
    
    public String getEstado(){
        return estado;
    }

    public String getIdEjemplar() {
        return idEjemplar;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public Date getFechaDevolucion() {
            return fechaDevolucion;
    }

    public String getDocumentoUsuario() {
        return documentoUsuario;
    }

    public void setDocumentoUsuario(String documentoUsuario) {
        this.documentoUsuario = documentoUsuario;
    }

   

    public void setLibroId(int libroId) {
        this.libroId = libroId;
    }

    public void setIdEjemplar(String idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    
    public void setEstado(String estado){
        this.estado = estado;
    }
    
}
