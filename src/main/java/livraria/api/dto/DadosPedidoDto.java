package livraria.api.dto;

import java.math.BigDecimal;

import livraria.api.modelo.Pedido;

public class DadosPedidoDto {

	
	private Long id;
	private BigDecimal total;
	private Long idCompra;
	
	public DadosPedidoDto() {}
	
	public DadosPedidoDto(Long id, BigDecimal total, Long idCompra) {
		super();
		this.id = id;
		this.total = total;
		this.idCompra = idCompra;
	}
	
	public DadosPedidoDto(Pedido pedido) {
		super();
		this.id = pedido.getId();
		this.total = pedido.getTotal();
		this.idCompra = pedido.getCompra().getId();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public Long getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(Long idCompra) {
		this.idCompra = idCompra;
	}
	
	
	
}
