/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Yonathan
 */
public class Candidatos implements Serializable{
    private Integer documento;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private String fileNamee;
    private int votos;
    private String descripcion;

    public Candidatos() {
    }

    public Candidatos(Integer documento, String nombres, String apellidos, Date fechaNacimiento, String fileNamee, String descripcion) {
        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.fileNamee = fileNamee;
        this.descripcion = descripcion;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFileName() {
        return fileNamee;
    }

    public void setFileName(String fileNamee) {
        this.fileNamee = fileNamee;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
