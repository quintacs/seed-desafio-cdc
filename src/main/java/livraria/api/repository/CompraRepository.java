package livraria.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import livraria.api.dto.DadosCompraDto;
import livraria.api.modelo.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long>{

	DadosCompraDto findByNome(String nome);

	
}
