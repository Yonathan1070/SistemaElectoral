/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Declaracion de la clase ValidacionNombres
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 01-09-2019 1.0
 */
//valor que se otorga a la clase para ser llamada como validacion en el campo Nombres del formulario
@FacesValidator(value="validacionNombre")
public class ValidacionNombres implements Validator{
    @Override
    //metodo de validacion del campo nombres que valida mediante los valores ASCII el tipo de dato, el tamaño ingresado y que no sea nulo
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String texto = String.valueOf(value);
        if(texto.isEmpty()){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Nombre erroneo", "Debe ingresar un Nombre");
            throw new ValidatorException(msg);
        }
        for (int i = 0; i < texto.length(); i++)
	{
            char caracter = texto.toUpperCase().charAt(i);
            int valorASCII = (int)caracter;
            if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90)){
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Nombre erroneo", "El Nombre no debe contener Números o Caracteres especiales");
                throw new ValidatorException(msg);
            }
	}
        if(texto.length()>30){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Error", "El Nombre no puede contener más de 30 caracteres");
            throw new ValidatorException(msg);
        }
    }
}
