 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Declaracion de la calse Candidatos
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 1-09-2019 1.0
 */
public class Candidatos implements Serializable{
    //Declaracion de los atributos privados de la Clase
    private Integer documento;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private String fileNamee;
    private int votos;
    private String descripcion;
    //Constructor vacio de la clase
    public Candidatos() {
    }
    //Constructor de los atributos de la clase  
    public Candidatos(Integer documento, String nombres, String apellidos, Date fechaNacimiento, String fileNamee, String descripcion) {
        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.fileNamee = fileNamee;
        this.descripcion = descripcion;
    }
    //Metodo que obtiene el valor del atributo Documento
    public Integer getDocumento() {
        return documento;
    }
    //Metodo que asigna el valor del atributo documento al parametro documento
    public void setDocumento(Integer documento) {
        this.documento = documento;
    }
    //Metodo que obtiene el valor del atributo Nombres
    public String getNombres() {
        return nombres;
    }
    //Metodo que asigna el valor del atributo nombres al parametro nombres
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    //Metodo que obtiene el valor del atributo Apellidos
    public String getApellidos() {
        return apellidos;
    }
    //Metodo que asigna el valor del atributo apellidos al parametro apellidos
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    //Metodo que obtiene el valor del atributo FechaNacimiento
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    //Metodo que asigna el valor del atributo fechaNacimineto al parametro fechaNacimiento
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    //Metodo que obtiene el valor del atributo FileName
    public String getFileName() {
        return fileNamee;
    }
    //Metodo que asigna el valor del atributo fileNamee al parametro fileNamee
    public void setFileName(String fileNamee) {
        this.fileNamee = fileNamee;
    }
    //Metodo que obtiene el valor del atributo Votos
    public int getVotos() {
        return votos;
    }
    //Metodo que asigna el valor del atributo votos al parametro votos
    public void setVotos(int votos) {
        this.votos = votos;
    }
    //Metodo que obtiene el valor del atributo Descripcion
    public String getDescripcion() {
        return descripcion;
    }
    //Metodo que asigna el valor del atributo descripcion al parametro descripcion
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
