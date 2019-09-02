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
 * Declaracion de la clase ValidacionDescripcion
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 01-09-2019 1.0
 */
//valor que se otorga a la clase para ser llamada como validacion en el campo descripcion del formulario
@FacesValidator(value="validacionDescripcion")
public class ValidacionDescripcion implements Validator{
    @Override
    //metodo de validacion del campo descripcion que valida mediante los valores ASCII los datos ingresados y que el campo no quede nulo
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String texto = String.valueOf(value);
        if(texto.isEmpty()){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Descripción erroneo", "Debe ingresar una descripcion de la HV");
            throw new ValidatorException(msg);
        }
        for (int i = 0; i < texto.length(); i++)
	{
            char caracter = texto.charAt(i);
            int valorASCII = (int)caracter;
            if (valorASCII != 209 && valorASCII != 241  && (valorASCII < 65 || valorASCII > 90) && (valorASCII < 97 || valorASCII > 122) && (valorASCII < 48 || valorASCII > 57) && valorASCII != 32){
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Descripción erroneo", "La descripción no debe contener Caracteres especiales");
                throw new ValidatorException(msg);
            }
	}
    }
}
