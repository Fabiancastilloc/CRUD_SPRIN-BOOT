package udc.fabiancastillo.crudspring.modelo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @Column(name = "cc")
    private int cc;

    @Column(name = "pass")
    private String pass;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "genero")
    private String genero;

    @Column(name = "email")
    private String email;

    public Usuario() {
        
    }

    public Usuario(int cc, String pass, String nombre, String apellido, String genero, String email) {
        this.cc = cc;
        this.pass = pass;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.email = email;
    }

    // Getters y Setters

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

