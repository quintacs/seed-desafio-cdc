package livraria.api.dto;

import java.time.LocalDateTime;

import livraria.api.modelo.Autor;
import livraria.api.util.DateUtil;

public class DadosAutorDTO {

	private Long id;
	private String nome;
	private String email;
	private String descricao;
	private LocalDateTime dataCadastro;
	private String dataCadastroFormatada;
	
	public DadosAutorDTO() {}
	
	public DadosAutorDTO(Autor autor) {
		parse(autor);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getDataCadastroFormatada() {
		return dataCadastroFormatada;
	}
	public void setDataCadastroFormatada(String dataCadastroFormatada) {
		this.dataCadastroFormatada = dataCadastroFormatada;
	}
	
	private void parse(Autor autor) {
		
		this.id = autor.getId();
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.descricao = autor.getDescricao();
		this.dataCadastro = autor.getDataCadastro();
		this.dataCadastroFormatada = DateUtil.formatDateTimeDMYHHMMSS(autor.getDataCadastro());
	}

	

	
}
