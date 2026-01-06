package livraria.api.dto;

import livraria.api.modelo.Paises;

public class DadosPaisesDto {
	
	private Long id;
	private String nome;

	public DadosPaisesDto() {
	}

	public DadosPaisesDto(Paises paises) {
		parse(paises);
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

	private void parse(Paises paises) {

		this.id = paises.getId();
		this.nome = paises.getNome();
	}
}
