package livraria.api.bean.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = {ExistIdValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistId {

	String message() default "Valor não encontrado";
	
	Class<?> [] groups() default {};
	
	Class<? extends Payload>[] payload() default{};
	
	String fieldName();
	
	Class<?> domainClass();
}
