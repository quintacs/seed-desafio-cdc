package livraria.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import livraria.api.dto.DadosCategoriaDto;
import livraria.api.modelo.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	DadosCategoriaDto findByNome(String nome);

}
