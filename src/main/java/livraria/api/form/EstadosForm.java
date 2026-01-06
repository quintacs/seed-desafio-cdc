package livraria.api.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import livraria.api.bean.validation.UniqueValue;
import livraria.api.modelo.Estados;

public class EstadosForm {

	@NotBlank
	@UniqueValue(domainClass = Estados.class, fieldName = "nome" , message = "O nome informado já existe no banco de dados")
	private String nome;
	@NotNull
	private Long idPaises;
	
	public EstadosForm() {}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getIdPaises() {
		return idPaises;
	}
	public void setIdPaises(Long idPaises) {
		this.idPaises = idPaises;
	}
}
