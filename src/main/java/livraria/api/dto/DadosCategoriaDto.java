package livraria.api.dto;

import livraria.api.modelo.Categoria;

public class DadosCategoriaDto {

	private Long id;
	private String nome;

	public DadosCategoriaDto() {
	}

	public DadosCategoriaDto(Categoria categoria) {
		parse(categoria);
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

	private void parse(Categoria categoria) {

		this.id = categoria.getId();
		this.nome = categoria.getNome();
	}
}
