package livraria.api.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import livraria.api.form.AutorForm;
import livraria.api.modelo.Autor;
import livraria.api.service.AutorService;

@Component
public class DadosAutorValidator implements Validator{

	@Autowired
	AutorService autorService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return AutorForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		if(errors.hasErrors()) {
			return ;
		}
		
		AutorForm autorForm = (AutorForm)target;
		
		Autor autor = autorService.findByEmail(autorForm.getEmail());
		
		if(autor != null ) {
			errors.rejectValue("email", null,"Já existe um(a) outro(a) autor(a) com o mesmo e-mail: "+autor.getEmail());
		}
	}

}
