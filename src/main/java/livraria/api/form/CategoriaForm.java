package livraria.api.form;

import jakarta.validation.constraints.NotBlank;
import livraria.api.bean.validation.UniqueValue;
import livraria.api.modelo.Categoria;

public class CategoriaForm {

	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome" , message = "O nome informado já existe no banco de dados")
	private String nome;
	
	public CategoriaForm() {}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "CategoriaForm [nome=" + nome + "]";
	}
}
