package livraria.api.bean.validation;

import java.util.List;

import org.springframework.util.Assert;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ExistIdValidator implements ConstraintValidator<ExistId, Object>{

	private String domainAttribute;
	private Class<?> klass;
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void initialize(ExistId existValue) {
		domainAttribute = existValue.fieldName();
		klass = existValue.domainClass();
		//ConstraintValidator.super.initialize(constraintAnnotation);
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		
		Query query = manager.createQuery("select 1 from "+klass.getName()+" where "+domainAttribute+" = :value");
		query.setParameter("value", value);
		List<?> list = query.getResultList();
		Assert.isTrue(list.size()<=1, "Foi encontrado mais de um "+klass+" com o atributo "+domainAttribute+" = "+value);
		
		return !list.isEmpty();
	}
	

}
