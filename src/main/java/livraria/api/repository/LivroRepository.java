package livraria.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import livraria.api.dto.DadosLivroDto;
import livraria.api.modelo.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

	DadosLivroDto findByTitulo(String titulo);

}
