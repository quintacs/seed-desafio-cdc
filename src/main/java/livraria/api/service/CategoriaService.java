package livraria.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import livraria.api.dto.DadosAutorDTO;
import livraria.api.dto.DadosCategoriaDto;
import livraria.api.form.CategoriaForm;
import livraria.api.modelo.Autor;
import livraria.api.modelo.Categoria;
import livraria.api.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public void save(@Valid CategoriaForm categoriaForm) {
		
		categoriaRepository.save(new Categoria(categoriaForm));
	}
	
	public List<DadosCategoriaDto> findAll() {
		
		List<DadosCategoriaDto> listDadosCategoria = new ArrayList<DadosCategoriaDto>();
		
		categoriaRepository.findAll().forEach(categoria -> listDadosCategoria.add(new DadosCategoriaDto(categoria)));
		
		
		return listDadosCategoria;
	}

	public DadosCategoriaDto consultar(CategoriaForm categoriaForm) throws IllegalArgumentException {
		
		DadosCategoriaDto categoriaDto = categoriaRepository.findByNome(categoriaForm.getNome());
		
		return categoriaDto;
	}
	
	public DadosCategoriaDto consultar(Long id) {
		
		Optional<Categoria> optional = categoriaRepository.findById(id);
		
		if(optional.isPresent()) {
			Categoria categoria = optional.get();
			return new DadosCategoriaDto(categoria);
		}
		return null;
	}

}
