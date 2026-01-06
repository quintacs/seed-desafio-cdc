package livraria.api.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import livraria.api.form.CompraForm;
import livraria.api.service.EstadosService;

@Component
public class EstadoPaisValidator implements Validator{

	@Autowired
	EstadosService estadosService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return CompraForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		if(errors.hasErrors()) {
			return ;
		}
		CompraForm compraForm = (CompraForm)target;
		
		if(!estadosService.contain(compraForm.getIdPais())) {
			errors.rejectValue("idEstado", null, "O estado selecionado não pertece ao país informado");
		}
	}

}
