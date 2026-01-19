package livraria.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import livraria.api.dto.DadosPedidoDto;
import livraria.api.modelo.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	DadosPedidoDto findByCompraId(Long idCompra);

}
