package livraria.api.dto;

import java.util.ArrayList;
import java.util.List;

import livraria.api.modelo.Compra;

public class DadosCompraDto {

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
	//private List<DadosItenPedidoDto> itensPedidodDto;
	
	public DadosCompraDto() {}
	
	public DadosCompraDto(Long id, String email, String nome, String sobrenome, String documento, String endereco,
			String complemento, String cidade, Long idPais, Long idEstado, String telefone, String cep) {//, List<DadosItenPedidoDto> itensPedidodDto
		super();
		this.id = id;
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
		//this.itensPedidodDto = itensPedidodDto;
	}
	
	public DadosCompraDto(Compra compra) {
		super();
		this.id = compra.getId();
		this.email = compra.getEmail();
		this.nome = compra.getNome();
		this.sobrenome = compra.getSobrenome();
		this.documento = compra.getDocumento();
		this.endereco = compra.getEndereco();
		this.complemento = compra.getComplemento();
		this.cidade = compra.getCidade();
		this.idPais = compra.getIdPais();
		this.idEstado = compra.getIdEstado();
		this.telefone = compra.getTelefone();
		this.cep = compra.getCep();
		//this.itensPedidodDto = new ArrayList<DadosItenPedidoDto>();
		//compra.getItensPedido().forEach(iten -> this.itensPedidodDto.add(new DadosItenPedidoDto(iten)));
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

	/*
	 * public List<DadosItenPedidoDto> getItensPedidodDto() { return
	 * itensPedidodDto; }
	 * 
	 * public void setItensPedidodDto(List<DadosItenPedidoDto> itensPedidodDto) {
	 * this.itensPedidodDto = itensPedidodDto; }
	 */
}
