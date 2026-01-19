package livraria.api.bean.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = {})
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@ConstraintComposition(CompositionType.OR)
@CPF
@CNPJ
public @interface Documento {

	String message() default "O documento deve ser um CPF ou CNPJ válido";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
