package com.mycompany.controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mycompany.modelo.Candidatos;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.event.FileUploadEvent;

/**
 * declaracion de la clase IndexController
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 1-09-2019 1.0
 */
@ManagedBean
@SessionScoped
public class IndexController implements Serializable {
    //Declaracion de los atributos privados de la clase
    private static List<Candidatos> listaCandidatos;
    private Candidatos candidato;
    //constructor de la clase
    public IndexController() {
        listaCandidatos=new ArrayList();
        candidato = new Candidatos();
    }

    public List<Candidatos> getListaCandidatos() {
        return listaCandidatos;
    }

    public static void setListaCandidatos(List<Candidatos> listaCandidatos) {
        IndexController.listaCandidatos = listaCandidatos;
    }

    public Candidatos getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidatos candidato) {
        this.candidato = candidato;
    }
    /**
     * Creacion nueva instancia de indexController
     * @param event
     */
    //metodo que captura el evento del fileUPload y carga la imagen
    public void handleFileUpload(FileUploadEvent event) {
        try {
            candidato.setFileName(copyFile(event.getFile().getFileName(), event.getFile().getInputstream()));
            System.out.println("El archivo se ha creado con éxito! Ruta Final: "+ candidato.getFileName());
        } catch (IOException e) {
        }
    }
    //metodo que guarda la imagen en la carpeta resources
    public String copyFile(String fileName, InputStream in) {
        String nombreA="";
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            ServletContext scontext = (ServletContext)context.getExternalContext().getContext();
            System.out.println("Ruta Path: "+scontext.getRealPath("/"));
            String ruta = scontext.getRealPath("\\")+"/resources/";
            try (OutputStream out = new FileOutputStream(new File(ruta + fileName))) {
                int read = 0;
                byte[] bytes = new byte[1024];
                while ((read = in.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                in.close();
                out.flush();
            }
            System.out.println("El archivo se ha creado con éxito!");

            DateFormat dateFormat = new SimpleDateFormat("HH_mm_ss");
            Date date = new Date();
            String ruta1 = ruta + fileName;
            System.err.println("Ruta Inicial: "+ruta1);
            String ruta2 = ruta + dateFormat.format(date) + fileName;
            System.out.println("Archivo: " + ruta1 + "\nRenombrado a: " + ruta2);
            File archivo = new File(ruta1);
            archivo.renameTo(new File(ruta2));
            nombreA = dateFormat.format(date) + fileName;
            FacesMessage msg = new FacesMessage("Imagen Cargada");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return nombreA;
    }
    //metodo que agrega cada candidato con todos los datos solicitados
    public void agregarCandidato(){
        System.out.println("Documento: "+candidato.getDocumento()+"\nNombres: "+candidato.getNombres()+" "+candidato.getApellidos()+"\nFecha Nacimiento: "+candidato.getFechaNacimiento()+"\nRuta Foto: "+candidato.getFileName());
        
        listaCandidatos.add(new Candidatos(candidato.getDocumento(), candidato.getNombres(), candidato.getApellidos(), candidato.getFechaNacimiento(), candidato.getFileName(), candidato.getDescripcion()));
        FacesMessage msg = new FacesMessage("Candidato", candidato.getNombres()+" "+candidato.getApellidos() + " agregado.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
