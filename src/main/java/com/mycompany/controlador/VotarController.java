/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.modelo.Candidatos;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.chart.PieChartModel;

/**
 * declaracion de la clase VotarController
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 1-09-2019 1.0
 */
@ManagedBean
@RequestScoped
public class VotarController implements Serializable{
    //Declaracion de los atributos privados de la clase
    @ManagedProperty("#{indexController}")
    private IndexController index;
    private Candidatos candidatoSeleccionado;
    private PieChartModel pieModel;
    /**
     * Creacion nueva instancia de VotarController
     */
    public VotarController() {
    }
    public IndexController getIndex() {
        pieModel = new PieChartModel();
        return index;
    }

    public void setIndex(IndexController index) {
        this.index = index;
    }

    public Candidatos getCandidatoSeleccionado() {
        return candidatoSeleccionado;
    }

    public void setCandidatoSeleccionado(Candidatos candidatoSeleccionado) {
        this.candidatoSeleccionado = candidatoSeleccionado;
    }
    
    //metodo que trae la lista de candidatos y valida la accion de votar mostrando como mensaje el nombre del candidato por el que voto
    public void onRowSelect(SelectEvent event) {
        for (Candidatos candidato : index.getListaCandidatos()) {
            if(candidato.getDocumento().equals(((Candidatos) event.getObject()).getDocumento())){
                candidato.setVotos(candidato.getVotos()+1);
                FacesMessage msg = new FacesMessage("Votó por el candidato ", ((Candidatos) event.getObject()).getNombres());
                FacesContext.getCurrentInstance().addMessage(null, msg);
                System.out.println(candidato.getVotos());
            }
        }
    }
    //metodo que crea y muestra la grafica con los datos de los votos
    public PieChartModel getPieModel() {
        for (Candidatos candidato : index.getListaCandidatos()) {
            pieModel.set(candidato.getNombres()+" "+candidato.getApellidos(), candidato.getVotos());
        }
        pieModel.setTitle("Votos");
        pieModel.setLegendPosition("c");
        return pieModel;
    }
}
