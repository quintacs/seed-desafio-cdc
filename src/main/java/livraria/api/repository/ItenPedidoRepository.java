package livraria.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import livraria.api.dto.DadosItenPedidoDto;
import livraria.api.modelo.ItenPedido;


@Repository
public interface ItenPedidoRepository extends JpaRepository<ItenPedido, Long>{

	DadosItenPedidoDto findByIdLivro(Long idLivro);

}
