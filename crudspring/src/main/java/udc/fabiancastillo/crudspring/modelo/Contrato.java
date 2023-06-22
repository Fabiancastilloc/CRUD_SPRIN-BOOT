package udc.fabiancastillo.crudspring.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Contratos")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fechaFirma")
    private java.sql.Date fechaFirma;

    @Column(name = "fechaInicio")
    private java.sql.Date fechaInicio;

    @Column(name = "fechaFin")
    private java.sql.Date fechaFin;

    @Column(name = "empresa")
    private String empresa;

    @Column(name = "empleado")
    private String empleado;

    @Column(name = "funciones")
    private String funciones;

    @Column(name = "monto")
    private int monto;

    @Column(name = "frecuenciaDePago")
    private String frecuenciaDePago;

    @Column(name = "usuariocc")
    private int usuarioCedula;

    public Contrato() {
        // Constructor vacío necesario para JPA
    }

    public Contrato(java.sql.Date fechaFirma, java.sql.Date fechaInicio, java.sql.Date fechaFin, String empresa,
                    String empleado, String funciones, int monto, String frecuenciaDePago, int usuarioCedula) {
        this.fechaFirma = fechaFirma;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.empresa = empresa;
        this.empleado = empleado;
        this.funciones = funciones;
        this.monto = monto;
        this.frecuenciaDePago = frecuenciaDePago;
        this.usuarioCedula = usuarioCedula;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.sql.Date getFechaFirma() {
        return fechaFirma;
    }

    public void setFechaFirma(java.sql.Date fechaFirma) {
        this.fechaFirma = fechaFirma;
    }

    public java.sql.Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(java.sql.Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public java.sql.Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(java.sql.Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getFunciones() {
        return funciones;
    }

    public void setFunciones(String funciones) {
        this.funciones = funciones;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getFrecuenciaDePago() {
        return frecuenciaDePago;
    }

    public void setFrecuenciaDePago(String frecuenciaDePago) {
        this.frecuenciaDePago = frecuenciaDePago;
    }

    public int getUsuarioCedula() {
        return usuarioCedula;
    }

    public void setUsuarioCedula(int usuarioCedula) {
        this.usuarioCedula = usuarioCedula;
    }
}



