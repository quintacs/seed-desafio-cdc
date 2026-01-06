package livraria.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import livraria.api.dto.DadosEstadosDto;
import livraria.api.modelo.Estados;

@Repository
public interface EstadosRepository extends JpaRepository<Estados, Long>{

	DadosEstadosDto findByNome(String nome);

	@Query(value ="SELECT 1 FROM estados WHERE paises_id = :idPais ", nativeQuery = true)
	boolean contain(@Param("idPais") Long idPais);

}
