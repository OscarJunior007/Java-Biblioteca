/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

import java.util.Date;


public class LibroPrestadoModel {
    
    private String idEjemplar,titulo,autor,documento;
    private Date fechaPrestamo;

    public LibroPrestadoModel() {
    }

    public LibroPrestadoModel(String idEjemplar, String titulo, String autor, String documento, Date fechaPrestamo) {
        this.idEjemplar = idEjemplar;
        this.titulo = titulo;
        this.autor = autor;
        this.documento = documento;
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getIdEjemplar() {
        return idEjemplar;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getDocumento() {
        return documento;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setIdEjemplar(String idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
    
    
    
}
