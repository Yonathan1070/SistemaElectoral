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
 *
 * @author Yonathan
 */
@ManagedBean
@RequestScoped
public class GanadorController implements Serializable{
    
    @ManagedProperty("#{indexController}")
    private IndexController index;
    private Candidatos candidato;
    /**
     * Creates a new instance of GanadorController
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
    
    public void volver() throws IOException{
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
            .getExternalContext().getSession(false);
    session.invalidate();
        FacesContext.getCurrentInstance().getExternalContext()
                .redirect("index.xhtml");
    }
}
