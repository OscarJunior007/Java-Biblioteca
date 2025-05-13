/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;


public class DevolucionModel {
    private String isbn;

    public DevolucionModel() {
    }

    public DevolucionModel( String isbn) {

        this.isbn = isbn;
        
        
    }
//
//    public String getDocumentoUsuario() {
//        return documentoUsuario;
//    }

    public String getIsbn() {
        return isbn;
    }

//    public void setDocumentoUsuario(String documentoUsuario) {
//        this.documentoUsuario = documentoUsuario;
//    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    
   
}
