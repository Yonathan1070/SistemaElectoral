 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.modelo.Candidatos;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * declaracion de la clase GanadorController
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 1-09-2019 1.0
 */
@ManagedBean
@RequestScoped
public class GanadorController implements Serializable{
    //Declaracion de los atributos privados de la clase
    @ManagedProperty("#{indexController}")
    private IndexController index;
    private Candidatos candidato;
    /**
     * Creacion nueva instancia de GanadorController
     */
    public GanadorController() {
        this.candidato=new Candidatos();
    }

    public IndexController getIndex() {
        return index;
    }

    public void setIndex(IndexController index) {
        this.index = index;
    }

    public Candidatos getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidatos candidato) {
        this.candidato = candidato;
    }
    //metodo que trae la lista de candidatos, compara los votos de cada candidato y obtiene el de mayor numero
    public void obtenerGanador(){
        for(Candidatos candidatoL : index.getListaCandidatos()){
            if(this.candidato != null){
                if(this.candidato.getVotos()<candidatoL.getVotos()){
                    this.candidato=candidatoL;
                }
            }else{
                this.candidato = candidatoL;
            }
        }
    }
    //metodo que finaliza la sesion y vuelve al usuario al inicio del programa
    public void volver() throws IOException{
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
            .getExternalContext().getSession(false);
    session.invalidate();
        FacesContext.getCurrentInstance().getExternalContext()
                .redirect("index.xhtml");
    }
}
