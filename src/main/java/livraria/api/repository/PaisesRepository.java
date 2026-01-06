package livraria.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import livraria.api.dto.DadosPaisesDto;
import livraria.api.modelo.Paises;

@Repository
public interface PaisesRepository extends JpaRepository<Paises, Long>{

	DadosPaisesDto findByNome(String nome);

}
