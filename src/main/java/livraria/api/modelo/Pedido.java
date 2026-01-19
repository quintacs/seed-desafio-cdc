package livraria.api.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import livraria.api.form.PedidoForm;

@Table( name = "pedidos")
@Entity( name = "Pedidos")
public class Pedido {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	private BigDecimal total;
	
	@OneToOne
	@JoinColumn(name = "compra_id")
	private Compra compra;
	
	public Pedido(){
		super();
	}
	
	public Pedido(Long id,Compra compra) {
		super();
		this.id = id;
		this.compra = compra;
	}

	public Pedido(PedidoForm pedidoForm) {
		super();
		parse(pedidoForm);
	}
	
	private void parse(PedidoForm pedidoForm) {
		
		this.total = pedidoForm.getTotal();
		this.compra = new Compra();
		this.compra.setId(pedidoForm.getIdCompra());
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

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	
	private BigDecimal calculaTotal() {
		compra.getItensPedido().forEach( iten -> total = iten.getPrecoMomento().multiply(new BigDecimal(iten.getQuantidade())));
	  return total;
	}
}
