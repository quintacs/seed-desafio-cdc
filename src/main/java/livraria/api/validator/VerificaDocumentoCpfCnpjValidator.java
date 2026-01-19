package livraria.api.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import livraria.api.form.CompraForm;

@Component
public class VerificaDocumentoCpfCnpjValidator implements Validator{

	
	
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
		if(compraForm.documentoValido()) {
			errors.rejectValue("documento",null,"O documento precisa ser um cpf ou cnpj");
		}
		
	}

}
