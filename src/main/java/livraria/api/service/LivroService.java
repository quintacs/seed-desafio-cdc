package livraria.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import livraria.api.dto.DadosLivroDto;
import livraria.api.form.LivroForm;
import livraria.api.modelo.Livro;
import livraria.api.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;

public void save(LivroForm livroForm) {
		
		//LocalDateTime instante = LocalDateTime.now();
		
		Livro autor = new Livro(livroForm);
		
		livroRepository.save(autor);
	}
	
	public List<DadosLivroDto> findAll() {
		
		List<DadosLivroDto> dadosLivroDtos = new ArrayList<DadosLivroDto>();
		
		livroRepository.findAll().forEach(livro -> dadosLivroDtos.add(new DadosLivroDto(livro)));
		
		
		return dadosLivroDtos;
	}

	public DadosLivroDto consultar( LivroForm livroForm) throws IllegalArgumentException {
		
		DadosLivroDto dadosLivroDto = livroRepository.findByTitulo(livroForm.getTitulo());
		
		return dadosLivroDto;
		
	}
	
	public DadosLivroDto consultar(Long id) {
		
		Optional<Livro> optional = livroRepository.findById(id);
		
		if(optional.isPresent()) {
			Livro livro = optional.get();
			return new DadosLivroDto(livro);
		}
		return null;
	}
	
}
