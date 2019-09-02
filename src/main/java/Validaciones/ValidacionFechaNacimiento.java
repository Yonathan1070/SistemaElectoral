/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Declaracion de la clase ValidacionFechaNacimiento
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 01-09-2019 1.0
 */
//valor que se otorga a la clase para ser llamada como validacion en el campo FechaNacimiento del formulario
@FacesValidator(value = "validacionFechaNacimiento")
public class ValidacionFechaNacimiento implements Validator {

    @Override
    //metodo de validacion del campo FechaNacimiento que valida que la fecha no sea mayor a la actual, que la edad sea mayor a 18 años y que el campo no quede nulo
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value == null) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Edad incorrecta", "Debe ingresar una fecha");
            throw new ValidatorException(msg);
        }
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date actual = new Date();
        Date dtNacimiento = (Date) value;
        String fecha = formato.format(actual);
        String nacimiento = formato.format(dtNacimiento);
        String[] fechaActual = fecha.split("/");
        Integer anioActual = Integer.parseInt(fechaActual[2]);
        String[] fechaNacimiento = nacimiento.split("/");
        Integer anioNacimiento = Integer.parseInt(fechaNacimiento[2]);
        Integer edad = (anioActual - anioNacimiento);
        if(actual.compareTo(dtNacimiento) == -1){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Edad incorrecta", "Debe una fecha en el pasado.");
            throw new ValidatorException(msg);
        }
        if (edad < 18) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Edad incorrecta", "Debe ser mayor a 18");
            throw new ValidatorException(msg);
        }
    }

}
