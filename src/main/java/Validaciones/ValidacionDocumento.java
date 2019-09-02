/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;

import com.mycompany.controlador.IndexController;
import com.mycompany.modelo.Candidatos;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Declaracion de la clase ValidacionDocumento
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 01-09-2019 1.0
 */
//valor que se otorga a la clase para ser llamada como validacion en el campo documento del formulario
@FacesValidator(value = "validacionDocumento")
public class ValidacionDocumento implements Validator {

    @Override
    //metodo de validacion del campo documento que valida que el tipo de dato sea numerico y que el campo no quede nulo
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String texto = String.valueOf(value);
        if (value == null) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Documento erroneo", "Debe ingresar un Documento");
            throw new ValidatorException(msg);
        }
        Integer documento = Integer.parseInt(texto);
        if (documento < 10000 || documento > 2147483647) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Documento erroneo", "El documento debe estar entre el rango de 10.000 y 2.147.483.647");
            throw new ValidatorException(msg);
        }
    }

}
