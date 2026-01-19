package livraria.api.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import livraria.api.form.CompraForm;

@Table( name = "compra")
@Entity( name = "Compra")
public class Compra {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private String 	email;
	private String 	nome;
	private String 	sobrenome;
	private String 	documento ; //(cpf/cnpj)
	private String 	endereco;
	private String 	complemento;
	private String 	cidade;
	private Long 	idPais;
	private Long 	idEstado;//(caso aquele pais tenha estado)
	private String 	telefone;
	private String 	cep;
	@OneToOne(mappedBy = "compra")
	private List<ItenPedido> itensPedido;
	
	public Compra() {}
	
	public Compra(String email, String nome, String sobrenome, String documento, String endereco, String complemento,
			String cidade, Long idPais, Long idEstado, String telefone, String cep, List<ItenPedido> itensPedido) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.idEstado = idEstado;
		this.telefone = telefone;
		this.cep = cep;
		this.itensPedido = itensPedido;
	}
	
	public Compra(CompraForm compraForm) {
		super();
		this.email = compraForm.getEmail();
		this.nome = compraForm.getNome();
		this.sobrenome = compraForm.getSobrenome();
		this.documento = compraForm.getDocumento();
		this.endereco = compraForm.getEndereco();
		this.complemento = compraForm.getComplemento();
		this.cidade = compraForm.getCidade();
		this.idPais = compraForm.getIdPais();
		this.idEstado = compraForm.getIdEstado();
		this.telefone = compraForm.getTelefone();
		this.cep = compraForm.getCep();
		/*
		 * this.itensPedido = new ArrayList<ItenPedido>(); List<Long> idItens =
		 * compraForm.getListIdItensPedido(); for(Long id : idItens) { ItenPedido
		 * itenPedido = new ItenPedido(); itenPedido.setId(id);
		 * this.itensPedido.add(itenPedido); }
		 */
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public void setEstado(Long idEstado) {
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

	public List<ItenPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItenPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}
}
