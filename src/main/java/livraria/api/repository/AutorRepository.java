package livraria.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import livraria.api.dto.DadosAutorDTO;
import livraria.api.modelo.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{

	Optional<Autor> findByEmail(String email);

	DadosAutorDTO findByEmailAndNome(String email, String nome);

	
}
