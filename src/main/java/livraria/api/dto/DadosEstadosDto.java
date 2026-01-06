package livraria.api.dto;

import livraria.api.modelo.Estados;

public class DadosEstadosDto {

	private Long id;
	private String nome;
	private Long idPaises;
	private String nmPaises;
	
public DadosEstadosDto() {}
	
	public DadosEstadosDto(Estados estados) {
		parse(estados);
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

	public Long getIdPaises() {
		return idPaises;
	}

	public void setIdPaises(Long idPaises) {
		this.idPaises = idPaises;
	}

	public String getNmPaises() {
		return nmPaises;
	}

	public void setNmPaises(String nmPaises) {
		this.nmPaises = nmPaises;
	}

	private void parse(Estados estados) {
		this.id = estados.getId();
		this.nome = estados.getNome();
		this.idPaises = estados.getPaises().getId();
		this.nmPaises = estados.getPaises().getNome();
	}
}
