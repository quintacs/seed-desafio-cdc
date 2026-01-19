package livraria.api.form;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import livraria.api.bean.validation.Documento;
import livraria.api.bean.validation.ExistId;
import livraria.api.modelo.Estados;
import livraria.api.modelo.Paises;

public class CompraForm {

	@Email
	@NotBlank
	private String 	email;
	@NotBlank
	private String 	nome;
	@NotBlank
	private String 	sobrenome;
	@NotBlank
	@Documento(message = "O documento deve ser um CPF ou CNPJ válido")
	private String 	documento ; //(cpf/cnpj)
	@NotBlank
	private String 	endereco;
	@NotBlank
	private String 	complemento;
	@NotBlank
	private String 	cidade;
	@NotNull
	@ExistId(domainClass = Paises.class, fieldName = "id")
	private Long 	idPais;
	@NotNull
	@ExistId(domainClass = Estados.class, fieldName = "id")
	private Long 	idEstado;//(caso aquele pais tenha estado)
	@NotBlank
	private String 	telefone;
	@NotBlank
	private String 	cep;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public Long getIdPais() {
		return idPais;
	}
	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}
	public Long getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public boolean documentoValido() {
		/*Assert.hasLength(documento, "Documento não preenchido");
		
		CPFValidator cpfValidator = new CPFValidator();
		cpfValidator.initialize(null);
		
		CNPJValidator cnpjValidator = new CNPJValidator();
		cnpjValidator.initialize(null);
		
		return cpfValidator.isValid(documento, null) == true ? true : cnpjValidator.isValid(documento, null) == true ? true : false;
		*/
		return false;
	}
}
