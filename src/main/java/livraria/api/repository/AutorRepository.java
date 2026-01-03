package livraria.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import livraria.api.modelo.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{

}
