package livraria.api.bean.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DocumentoValidator implements ConstraintValidator<Documento, Long>{

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return true;
	}

}
