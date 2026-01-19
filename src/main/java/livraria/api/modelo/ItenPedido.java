package livraria.api.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;
import livraria.api.form.ItenPedidoForm;

@Table( name = "itenPedido")
@Entity( name = "ItenPedido")
public class ItenPedido {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@ManyToOne
	private Livro livro;
	
	@Positive
	private int quantidade;
	
	@Positive
	private BigDecimal precoMomento;
	
	
	@ManyToOne
	@JoinColumn(name = "compra_id")	
	private Compra compra;
	
	public ItenPedido() {}

	public ItenPedido(Long id, Livro livro, int quantidade) {
		super();
		this.id = id;
		this.livro = livro;
		this.quantidade = quantidade;
		this.precoMomento = livro.getPreco();
		
	}
	public ItenPedido(ItenPedidoForm itemPedidoForm) {
		super();
		this.livro = new Livro();
		this.livro.setId(itemPedidoForm.getIdLivro());
		this.quantidade = itemPedidoForm.getQuantidade();
		this.compra = new Compra();
		this.compra.setId(itemPedidoForm.getIdCompra());
	}
	
	
	public Livro getILivro() {
		return livro;
	}
	public void setIdLivro(Livro livro) {
		this.livro = livro;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	/*public Pedido getPedidos() {
		return pedidos;
	}
	public void setPedidos(Pedido pedidos) {
		this.pedidos = pedidos;
	}*/
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public BigDecimal total() {
		return precoMomento.multiply(new BigDecimal(quantidade));
	}
	
	public BigDecimal getPrecoMomento() {
		return precoMomento;
	}
	public void setPrecoMomento(BigDecimal precoMomento) {
		this.precoMomento = precoMomento;
	}
}
