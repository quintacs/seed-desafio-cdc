package livraria.api.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import livraria.api.bean.validation.ExistId;
import livraria.api.modelo.Compra;
import livraria.api.modelo.Livro;

public class ItenPedidoForm {

	@NotNull
	@ExistId(domainClass = Livro.class, fieldName = "id")
	private Long idLivro;
	
	@Positive
	private int quantidade;

	@NotNull
	@ExistId(domainClass = Compra.class, fieldName = "id")
	private Long idCompra;
	
	public Long getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Long idLivro) {
		this.idLivro = idLivro;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Long getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Long idCompra) {
		this.idCompra = idCompra;
	}


}
