package livraria.api.form;

import jakarta.validation.constraints.NotBlank;
import livraria.api.bean.validation.UniqueValue;
import livraria.api.modelo.Paises;

public class PaisesForm {

	public PaisesForm() {}

	@NotBlank
	@UniqueValue(domainClass = Paises.class, fieldName = "nome" , message = "O nome informado já existe no banco de dados")
	private String nome;

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
