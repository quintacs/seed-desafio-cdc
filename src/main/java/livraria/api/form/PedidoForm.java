package livraria.api.form;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import livraria.api.bean.validation.ExistId;
import livraria.api.modelo.Compra;

public class PedidoForm {


	@Positive
	@NotNull
	private BigDecimal total;
	@Size(min = 1)
	
	@NotNull
	@ExistId(domainClass = Compra.class, fieldName = "id")
	private Long idCompra;
	
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

