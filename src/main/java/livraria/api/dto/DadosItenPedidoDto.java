package livraria.api.dto;

import livraria.api.modelo.ItenPedido;

public class DadosItenPedidoDto {

	private Long id;
	private Long idLivro;
	private int quantidade;
	private Long idCompra;
	
	public DadosItenPedidoDto(){}
	
	public DadosItenPedidoDto(Long id, Long idLivro, int quantidade , Long idCompra) {
		super();
		this.id = id;
		this.idLivro = idLivro;
		this.quantidade = quantidade;
		this.idCompra = idCompra;
	}
	
	
	public DadosItenPedidoDto(ItenPedido itenPedido) {
		this.id = itenPedido.getId();
		this.idLivro = itenPedido.getLivro().getId();
		this.quantidade = itenPedido.getQuantidade();
		this.idCompra = itenPedido.getCompra().getId();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Long getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Long idLivro) {
		this.idLivro = idLivro;
	}

	public Long getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Long idCompra) {
		this.idCompra = idCompra;
	}
	
}
